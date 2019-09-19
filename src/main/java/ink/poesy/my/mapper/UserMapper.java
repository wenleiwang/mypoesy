package ink.poesy.my.mapper;

import ink.poesy.my.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {
    List<User> userLogin(String userName, String userPassword);

    User selectLibrarian();
}
