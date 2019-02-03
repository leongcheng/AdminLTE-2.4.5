package com.db.ssm.common.shiro;

import com.db.ssm.dao.MenuDao;
import com.db.ssm.dao.RoleMenuDao;
import com.db.ssm.dao.UserDao;
import com.db.ssm.dao.UserRoleDao;
import com.db.ssm.pojo.User;
import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户认证
 * Created by Administrator on 2019/1/31 0031 下午 8:17
 */
@Service
public class ShiroUserRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleMenuDao roleMenuDao;

    /**
     * 设置认证管理器
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher){
        //构建认证匹配对象
        HashedCredentialsMatcher credentialsMatcher1 = new HashedCredentialsMatcher();
       //设置加密算法
        credentialsMatcher1.setHashAlgorithmName("MD5");
        //设置加密次数
        credentialsMatcher1.setHashIterations(1);
        super.setCredentialsMatcher(credentialsMatcher1);
    }
    /**
     *此方法是获取用户的信息认证
     * @param token 用户身份认证
     * @return  身份信息认证
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取客户端提交的用户信息
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();
        //验证客户端登入信息
        User user = userDao.findUserByUserName(username);
        //验证用户信息是否存在
        if(user == null){
            throw new UnknownAccountException();
        }
        //验证用户权限是否被禁用
        if(user.getValid() == 0){
            throw new LockedAccountException("用户已被禁用,无法访问");
        }
        //对用户信息进行封装
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(user, user.getPassword(),credentialsSalt, this.getName());
        //返回认证管理器
        return authenticationInfo;
    }
    /**
     * 执行授权,此方法用于获取用户权限信息
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("==AuthorizationInfo==");
        //1.获取用户对象
        User user = (User) principals.getPrimaryPrincipal();
        //2.基于用户id获取用户拥有的角色(sys_user_roles)
        List<Integer> roleIds = userRoleDao.findRoleIdsByUserId(user.getId());
        if(roleIds == null||roleIds.size()==0){
            throw new AuthenticationException();
        }
        //3.基于角色ID查找菜单ID(sys_role_menus)
        Integer[] array = {};
        List<Integer> menuIds = roleMenuDao.findRoleMenuIds(roleIds.toArray(array));
        if(menuIds == null||menuIds.size() == 0){
            throw new AuthenticationException();
        }
        //4.基于菜单ID查找权限标识
        List<String> permissions = menuDao.findPermissions(menuIds.toArray(array));
        //5.封装权限信息
        HashSet<String> hashSet = new HashSet<>();
        for(String permission:permissions){
            if(!StringUtils.isEmpty(permission)){
                hashSet.add(permission);
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(hashSet);
        //返回授权管理器
        return info;
    }


}
