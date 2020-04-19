package cn.muchenlou.practicepro.service.impl;

import cn.muchenlou.practicepro.entity.TbUser;
import cn.muchenlou.practicepro.entity.User;
import cn.muchenlou.practicepro.mapper.TbUserMapper;
import cn.muchenlou.practicepro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/19 13:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public TbUser selectUserByPhoneAndPassword(String phone, String password) {
        return tbUserMapper.selectUser(null,phone,password);
    }

    @Override
    public int addUser(String username, String phone, String password) {
        TbUser user = new TbUser();
        user.setNewTime(new Date());
        user.setUserName(username);
        user.setPassword(password);
        user.setPhone(phone);
        return tbUserMapper.add(user);
    }
}
