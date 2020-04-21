package cn.muchenlou.practicepro.config;

import cn.muchenlou.practicepro.entity.TbUser;
import cn.muchenlou.practicepro.entity.User;
import cn.muchenlou.practicepro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/17 9:27
 */
public class CustomRealm  extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("我进入权限这边了");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
//        stringSet.add("user:show");
//        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) token.getPrincipal();
        String userPwd = new String((char[]) token.getCredentials());
        TbUser user = userService.selectUserByPhoneAndPassword(userName, userPwd);

        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(user.getPassword() )) {
            throw new AccountException("密码不正确");
        }

        return new SimpleAuthenticationInfo(userName, user.getPassword(),getName());
    }


}
