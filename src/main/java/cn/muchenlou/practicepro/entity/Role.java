package cn.muchenlou.practicepro.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/16 10:50
 */
@Data
public class Role {
    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;

    public Role(String id, String roleName, Set<Permissions> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public Role(String id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}
