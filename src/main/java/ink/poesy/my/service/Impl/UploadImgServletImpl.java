package ink.poesy.my.service.Impl;

import ink.poesy.my.service.UploadImgServlet;
import ink.poesy.my.util.QiniuCloudUtil;
import net.coobird.thumbnailator.Thumbnailator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

@Service
public class UploadImgServletImpl implements UploadImgServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadImgServletImpl.class);



    /**
     * 添加一张照片到七牛上，如果图片过大，则压缩后上传
     * @param image 图片数据
     * @return
     */
    @Override
    public String addOneImg(MultipartFile image) throws Exception {
        //获取图片名称
        String fileName = image.getOriginalFilename();
        //调用上传文件
        //QiniuCloudUtil.upload(image,fileName);
        long size = image.getSize();
        BufferedImage thumbnail = Thumbnailator.createThumbnail((File) image, 300, 300);

        LOGGER.info(String.valueOf(size));
        return "true";
    }


}
