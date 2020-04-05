package cn.edu.upc.dzh.controller;

import cn.edu.upc.dzh.service.LoginService;
import cn.edu.upc.dzh.until.MD5Util;
import cn.edu.upc.dzh.until.SendEmailUtil;
import cn.edu.upc.dzh.until.SysUser;
import cn.edu.upc.dzh.until.exception.BusinessException;
import cn.edu.upc.dzh.until.exception.EmBusinessError;
import cn.edu.upc.ljh.service.UserService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@CrossOrigin
@Controller
@RequestMapping(value="/web",method = {RequestMethod.POST,RequestMethod.GET})
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
//    @Autowired
//    private SysUser sysUser;
    @Autowired
    private SendEmailUtil sendEmailUtil;



//    @RequestMapping("/aa")
//    @ResponseBody
//    public CommonReturnType select(){
//
////        Integer userId=sysUser.getCurrentUserId();
////        System.out.println("当前用户的ID是"+userId);
//        List<User> userList = userService.select();
//        System.out.println(userList.size());
//        return CommonReturnType.create(userList);
//        //return CommonReturnType.create("123");
//    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonReturnType login(@RequestBody JSONObject user){
        String loginName=user.getString("loginName");
        String password= MD5Util.md5(user.getString("password"));
        //String password=MD5Util.md5(password2);
        System.out.println("1用户名和密码："+loginName+password);
        Subject subject = SecurityUtils.getSubject();
        System.out.println("2用户名和密码："+loginName+password);
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
        Map<String,Object> returnMsg = new HashMap<String, Object>();
        try {

            subject.login(token);
            SecurityUtils.getSubject().getSession().setTimeout(10000);
            returnMsg.put("loginTips","登陆成功");
            System.out.println("返回权限1");
            returnMsg.put("userType",SysUser.getCurrentUserRole());
            return CommonReturnType.create(returnMsg);
        } catch (UnknownAccountException e) {
            //用户不存在
            throw new BusinessException(EmBusinessError.STUDENT_LOGIN_FAIL);
        } catch (IncorrectCredentialsException e) {
            //密码不正确
            throw new BusinessException(EmBusinessError.STUDENT_LOGIN_FAIL);
        } catch (Exception e) {
            //未知异常UNKNOWN_ERROR
            throw new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public CommonReturnType logout(){


        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return CommonReturnType.create("退出成功");

    }

    @RequestMapping("/pleaseLogin")
    @ResponseBody
    public CommonReturnType pleaseLogin(){

        throw new BusinessException(EmBusinessError.PLEASE_LOGIN);
    }

    @RequestMapping("/noAuth")
    @ResponseBody
    public CommonReturnType noAuth(){
        throw new BusinessException(EmBusinessError.NO_PERMISSSION);
    }

    /**
     * 发送验证码
     * @param jsonObject
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/sendCode")
    @ResponseBody
    public CommonReturnType sendCode(@RequestBody JSONObject jsonObject,final HttpServletRequest request) throws Exception {
        final String email=jsonObject.getString("email");
        String realName=jsonObject.getString("realName");

//        User user=userService.selectByEmail(email);
        User user=loginService.selectByEmail(email);

        if(user!=null){
            if(user.getRealName().equals(realName)){
                String code2=smsCode();
                System.out.println(code2);
                sendEmailUtil.sendEMail(email,code2);

                final HttpSession session = request.getSession();
                session.setAttribute("code",code2);
                return CommonReturnType.create("发送成功");
            }else {
                return CommonReturnType.create("真实姓名不正确");
            }

        }else {
            return CommonReturnType.create("邮箱没有注册");
        }

    }


    /**
     * 匹配验证码并修改密码
     * @param jsonObject
     * @param request
     * @return
     */
    @RequestMapping("/codeMaching")
    @ResponseBody
    public CommonReturnType codeMaching(@RequestBody JSONObject jsonObject, final HttpServletRequest request){
        String email=jsonObject.getString("email");
        String code=jsonObject.getString("code");
        String newPassword= MD5Util.md5(jsonObject.getString("password"));
        HttpSession session=request.getSession();
        String rightCode=session.getAttribute("code").toString();
        System.out.println(code+"   "+rightCode);

        if(rightCode.equals(code)){
            loginService.changePasswordByEmail(newPassword,email);
            return CommonReturnType.create("验证成功");
        }else {
            return CommonReturnType.create("验证失败");
        }


    }



    /**
     * 创建验证码
     * @return
     */
    public static String smsCode(){
        //创建一个6位的随机数字
        String ran = new Random().nextInt(1000000)+"";
        if(ran.length()!=6){
            smsCode();
        }
        return ran;
    }
}
