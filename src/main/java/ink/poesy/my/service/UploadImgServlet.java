package ink.poesy.my.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImgServlet {
    /**
     * 添加一张照片
     * @param image 上传的图片数据
     * @return 返回上传状态码
     */
    String addOneImg(MultipartFile image) throws Exception;
}
