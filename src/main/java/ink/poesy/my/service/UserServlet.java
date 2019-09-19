package ink.poesy.my.service;

import ink.poesy.my.pojo.User;


public interface UserServlet {
    public User getUserInfo(String userName, String userPassword);

    public User selectLibrarian();
}
