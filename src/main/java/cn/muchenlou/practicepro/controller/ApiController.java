package cn.muchenlou.practicepro.controller;

import cn.muchenlou.practicepro.common.Result;
import cn.muchenlou.practicepro.common.StatusCode;
import cn.muchenlou.practicepro.entity.TbUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/17 11:42
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/hello")
    public Result hello(HttpServletRequest request){
        HttpSession session = request.getSession();
        TbUser user = (TbUser) session.getAttribute("user");
        return new Result(true, StatusCode.OK,"查询session内容",user);
    }
}
