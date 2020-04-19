package cn.muchenlou.practicepro.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/16 10:49
 */
@Data
public class User {
    private String id;
    private String userName;
    private String password;
    private Set<Role> roles;

    public User(String id, String userName, String password, Set<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public User(String id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
