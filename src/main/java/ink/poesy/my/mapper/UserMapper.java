package ink.poesy.my.mapper;

import ink.poesy.my.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名和密码查询用户，进行用户登录
     * @return User
     */
    List<User> userLogin(String userName, String userPassword);

}
