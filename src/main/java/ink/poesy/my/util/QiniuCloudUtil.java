package ink.poesy.my.util;

import java.io.IOException;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 七牛云上传文件工具类
 */
public class QiniuCloudUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(QiniuCloudUtil.class);

    // 设置需要操作的账号的AK和SK
    private static final String ACCESS_KEY = "62knrQrpddGoaHNkPuYZT35tzsQCTd12vFxm9kmT";
    private static final String SECRET_KEY = "mbRKLiJ1RjdhU-uo0_7vhyN0jtukq8-GtSnrweAv";

    // 要上传的空间
    private static final String bucketname = "poesy";

    // 密钥
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private static final String DOMAIN = "img.poesy.ink";


    //构造一个带指定Region对象的配置类
    private static final Configuration cfg = new Configuration(getRegion());
    // 创建上传对象
    private static final UploadManager uploadManager = new UploadManager(cfg);

    public static String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    /**
     * 普通上传
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return 返回的文件名
     * @throws IOException
     */
    public static String upload(String filePath, String fileName) throws IOException {
                try {
            // 调用put方法上传
            String token = auth.uploadToken(bucketname);
            if(StringUtils.isEmpty(token)) {
                LOGGER.error("未获取到token，请重试！");
                return null;
            }
            Response res = uploadManager.put(filePath, fileName, token);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
            LOGGER.info("key:");
            LOGGER.info(putRet.key);
            LOGGER.info("hash:");
            LOGGER.info(putRet.hash);
            if (res.isOK()) {
                //如果不需要对图片进行样式处理，则使用以下方式即可
                return DOMAIN + putRet.key;
            }
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            LOGGER.info(r.toString());
            try {
                // 响应的文本信息
                LOGGER.info(r.bodyString());
            } catch (QiniuException e1) {
                // ignore
            }
        }
        return null;
    }

    public static String upload(MultipartFile image , String fileName) throws Exception{
        Response response = null;
        try {
            byte[] uploadBytes = image.getBytes();
            response = uploadManager.put(uploadBytes, fileName, getUpToken());
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            LOGGER.info("key是");
            LOGGER.info(putRet.key);
            LOGGER.info("hash是");
            LOGGER.info(putRet.hash);
            if (response.isOK()) {
                //如果不需要对图片进行样式处理，则使用以下方式即可
                return DOMAIN + putRet.key;
            }
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            LOGGER.info(r.toString());
            try {
                // 响应的文本信息
                LOGGER.info(r.bodyString());
            } catch (QiniuException e1) {
                // ignore
            }
        }
        return null;
    }
    private static Region getRegion(){
        return Region.region2();
    }
}
