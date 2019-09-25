package ink.poesy.my.pojo;

import lombok.Data;

@Data
public class ArticleShow extends Article {
    //用户名
    private String name;
    //分类名
    private String classifyName;
    //用户头像
    private String img;
}
