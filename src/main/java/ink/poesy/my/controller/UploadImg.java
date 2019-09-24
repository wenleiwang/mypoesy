package ink.poesy.my.controller;

import ink.poesy.my.util.QiniuCloudUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.UUID;

@Controller
@RequestMapping("/blogs")
@ResponseBody
public class UploadImg {
    Logger LOGGER = LoggerFactory.getLogger(UploadImg.class);

    /**
     * 往7牛添加图片使用byte
     * @param image
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/uploadImg", method= RequestMethod.POST)
    public String uploadImg(@RequestParam("image") MultipartFile image, HttpServletRequest request)throws Exception {
        LOGGER.info(image.getContentType());
        String fileName = image.getOriginalFilename();
        QiniuCloudUtil.upload(image,fileName);

        return "";
    }

}
