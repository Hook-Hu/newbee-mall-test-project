package ltd.newbee.mall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 项目全局配置
 */
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {

    /**
     * 项目名称
     */
    private static String name;
    /**
     * 上传文件路径
     */
    private static String fileUploadPath;
    /**
     * 订单超期未支付时间，单位秒
     */
    private static Integer orderUnpaidOverTime;

    /**
     * 服务端访问路径
     */
    private static String serverUrl;

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        ProjectConfig.name = name;
    }

    public static String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        Path uploadPath = Paths.get(fileUploadPath);
        if (!uploadPath.isAbsolute()) {
            uploadPath = Paths.get(System.getProperty("user.dir")).resolve(uploadPath);
        }
        String normalizedPath = uploadPath.normalize().toString();
        if (!normalizedPath.endsWith(File.separator)) {
            normalizedPath = normalizedPath + File.separator;
        }
        ProjectConfig.fileUploadPath = normalizedPath;
    }

    public static Integer getOrderUnpaidOverTime() {
        return orderUnpaidOverTime;
    }

    public void setOrderUnpaidOverTime(Integer orderUnpaidOverTime) {
        ProjectConfig.orderUnpaidOverTime = orderUnpaidOverTime;
    }

    public static String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        ProjectConfig.serverUrl = serverUrl;
    }
}
