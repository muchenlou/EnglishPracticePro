package cn.muchenlou.practicepro.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/20 10:29
 */
@Controller
public class IndexController {

    /*
    * 登录页面
    */
    @GetMapping(value = "/login")
    public String index(){
        return "/users/login";
    }

    /**
     * 错误页面
     */
    @GetMapping(value = "/notRole")
    public String error_hrml(){
        return "error";
    }

    /**
     * 登录成功页面
     */
    @GetMapping(value = "/word")
    public String queryClassify(){
        return "/users/hello";
    }
}
