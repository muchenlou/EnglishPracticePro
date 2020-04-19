package cn.muchenlou.practicepro.mapper;

import cn.muchenlou.practicepro.entity.TbUser;
import cn.muchenlou.practicepro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface TbUserMapper{

    TbUser selectUser(@Param("id") String id, @Param("phone") String phone, @Param("password") String password);

    int add(TbUser user);
}