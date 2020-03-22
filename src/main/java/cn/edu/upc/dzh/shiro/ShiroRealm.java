package cn.edu.upc.dzh.shiro;

import cn.edu.upc.manage.dao.UserMapper;
import cn.edu.upc.manage.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 授权认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = String.valueOf(usernamePasswordToken.getPassword());
        System.out.println(username+password);
        User user = userMapper.selectByUsername(username);
//        if(user == null) {
//            throw new AccountException("账号或密码错误");
//        }
//        if(!password.equals(user.getPassword())){
//            throw new AccountException("账号或密码错误");
//        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user, user.getPassword(), user.getRealName());
        return simpleAuthenticationInfo;
    }

}
