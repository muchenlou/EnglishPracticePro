package cn.muchenlou.practicepro.controller;

import cn.muchenlou.practicepro.common.Result;
import cn.muchenlou.practicepro.common.StatusCode;
import cn.muchenlou.practicepro.entity.User;
import cn.muchenlou.practicepro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/17 10:54
 */
@RequestMapping("/user")
@RestController
public class UserController {

}
