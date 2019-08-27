package com.baidu.ssm45.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UploadAndDown {

    //上传
    public static String upload(MultipartFile file) {
        /* 获取项目路径 */
        String property = System.getProperty("user.dir");
        File file3 = new File(property);
        file3 = new File(file3 + "/target/classes/static");
        String filePath = file3.getParent() + File.separator + "static";
        // 自定义的文件名称
        String trueFileName = UUID.randomUUID().toString();
        // 文件原名称
        String fileName = file.getOriginalFilename();
        // 文件类型
        String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
                : null;
        // 设置存放图片文件的路径
        String path = null == type ? filePath + File.separator + trueFileName
                : filePath + File.separator + trueFileName + "." + type;
        File file2 = new File(filePath);
        //截取路径
        String imgPath = "static/" + trueFileName + "." + type;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        // 转存文件到指定的路径
        try {
            file.transferTo(new File(path));
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("path", null == type ? trueFileName : trueFileName + "." + type);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        return imgPath;
    }


    //下载
    public static void down(String fileName, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        OutputStream os = null;
        if (fileName != null) {
            //设置文件路径
            //获取跟目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) path = new File("");
            //获取static文件夹
            String realPath = path.getAbsolutePath() + "//static";
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (os != null) {
                        try {
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }
}
