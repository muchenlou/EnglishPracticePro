package cn.muchenlou.practicepro.service;

import cn.muchenlou.practicepro.entity.TbUser;
import cn.muchenlou.practicepro.entity.User;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/16 10:40
 */
public interface UserService {
    TbUser selectUserByPhoneAndPassword(String phone, String password);

    int addUser(String username, String phone, String password);
}
