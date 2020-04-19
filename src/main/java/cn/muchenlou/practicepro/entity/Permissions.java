package cn.muchenlou.practicepro.entity;

import lombok.Data;

/**
 * @author h_baojian
 * @version 1.0
 * @date 2020/4/16 10:50
 */
@Data
public class Permissions {
    private String id;
    private String permissionsName;

    public Permissions(String id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }

}
