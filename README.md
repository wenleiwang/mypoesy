# 诗意生活
简介：  
- 日志使用sl4j+logback
- spring boot搭建项目
- stymeleaf作为前端解析代替jsp
- 模式使用MVC模式
    * controller作为控制层
    * service作为服务层
    * mapper作为数据层
    * pojo所有的bean数据
    * util存放工具类
        + QiniuCloudUtil往七牛对象服务器发送照片
    * config作为配置spring boot对MVC的兼容，个性化设置
- 数据库持久性框架使用Mybatis
- Markdown是用editormd.js
- 
## 1、首页改造  
* &emsp;插入个人信息但没有做监听判断  
* &emsp;插入文章展示列表（没有做分页）  
* &emsp;插入最新文章（9个）
## 2、文章跳转详细信息
* 修改show界面信息（未完成）
* makedown文章解析

# My poesy life
## 1. I alert Index
* insert user information
* insert all article list
* insert new article show list, number 9.