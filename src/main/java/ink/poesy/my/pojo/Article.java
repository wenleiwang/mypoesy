package ink.poesy.my.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class Article {
    private int articleId;
    private int userId;
    private int classifyId;
    private String articleTitle;
    private String articleImg;
    private String articleAbstract;
    private String articleContent;
    private int articleLike;
    private int articleComment;
    private int articleLook;
    private Date articleTime;
    private int labelId;
}
