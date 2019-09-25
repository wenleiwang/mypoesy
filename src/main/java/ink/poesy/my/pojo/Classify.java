package ink.poesy.my.pojo;

import lombok.Data;

@Data
public class Classify {
    //自增id
    private int classifyId;
    //分类名
    private String classifyName;
    //分类别称
    private String classifyAlias;
    //分类描述
    private String classifyContent;
    //分类父类
    private int classifyFather;
}
