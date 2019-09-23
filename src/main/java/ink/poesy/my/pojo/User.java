package ink.poesy.my.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String name;
    private Integer age;
    private String sex;
    private String img;
    private Date birthday;
    private String tel;
    private String email;
    private Date created;
    private Date updated;
}
