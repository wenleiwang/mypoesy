package ink.poesy.my.service.Impl;

import ink.poesy.my.mapper.UserMapper;
import ink.poesy.my.pojo.User;
import ink.poesy.my.service.UserServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServletImpl implements UserServlet {
    Logger LOGGER = LoggerFactory.getLogger(UserServletImpl.class);
    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(String userName, String userPassword){
        List<User> list = null;
        User user =null;
        //list = userMapper.userLogin(userName, userPassword);
        user = userMapper.selectLibrarian();
        LOGGER.debug("list",user);
        //list.get(0);
        return user;
    }

    public User selectLibrarian() {
        return userMapper.selectLibrarian();
    }

}
