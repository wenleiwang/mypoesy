package ink.poesy.my.pojo;

import lombok.Data;

import java.sql.Date;

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
    private String show;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", img='" + img + '\'' +
                ", birthday=" + birthday +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", show='" + show + '\'' +
                '}';
    }
}
