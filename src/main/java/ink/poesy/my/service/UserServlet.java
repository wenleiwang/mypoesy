package ink.poesy.my.service;

import ink.poesy.my.pojo.User;

import java.util.List;


public interface UserServlet {
    public User getUserInfo(String userName, String userPassword);

}
