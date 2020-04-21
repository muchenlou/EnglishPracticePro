package cn.muchenlou.practicepro.controller;

import cn.muchenlou.practicepro.common.Result;
import cn.muchenlou.practicepro.common.StatusCode;
import cn.muchenlou.practicepro.entity.TbUser;
import cn.muchenlou.practicepro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/17 9:41
 */

@RestController
public class HomeIndexController {

    private Logger logger = LoggerFactory.getLogger(HomeIndexController.class);

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    @PostMapping("/userLogin")
    public Result selectUser(@RequestParam String phone, @RequestParam String password, HttpServletRequest request){
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return new Result(false, StatusCode.LOGINERROR,"未知账号");
        } catch (IncorrectCredentialsException ice) {
            return new Result(false, StatusCode.LOGINERROR,"密码错误");
        } catch (LockedAccountException lae) {
            return new Result(false, StatusCode.LOGINERROR,"账户被锁定");
        } catch (ExcessiveAttemptsException eae) {
            return new Result(false, StatusCode.LOGINERROR,"用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return new Result(false, StatusCode.LOGINERROR,"用户名或密码不正确");
        }
        if (subject.isAuthenticated()) {
            TbUser tbUser = userService.selectUserByPhoneAndPassword(phone, password);
            HttpSession session = request.getSession();
            session.setAttribute("user",tbUser);
            return new Result(true, StatusCode.OK,"登录成功",tbUser);
        } else {
            token.clear();
            return new Result(false, StatusCode.LOGINERROR,"登录失败");
        }
    }

    /**
     * 注册
     * @param username  用户名称
     * @param phone  手机号
     * @param password  密码
     * @return
     */
    @PostMapping("/signIn")
    public Result signIn(@RequestParam String username,@RequestParam String phone,@RequestParam String password){
        //判断是否已存在一样的手机
        TbUser user = userService.selectUserByPhoneAndPassword(phone, password);
        if (user != null){
            return new Result(false,StatusCode.SIGNINERROR,"该手机号已存在");
        }
        try {
            userService.addUser(username,phone,password);
        }catch (Exception e){
            logger.info(e.getMessage());
            return new Result(false,StatusCode.SIGNINERROR,"注册失败");
        }
        return new Result(true,StatusCode.OK,"注册成功");
    }
}
