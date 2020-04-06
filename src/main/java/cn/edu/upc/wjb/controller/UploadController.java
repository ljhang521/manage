package cn.edu.upc.wjb.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

/**
 * @author zcc
 * @date 2019/5/14 21:20
 */
@Controller("upload")
@RequestMapping("/upload")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UploadController {

//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation("/tmp/tomcat");
//        return factory.createMultipartConfig();
//    }
    //实现图片上传
    @RequestMapping(value = "/uploadPicture",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType pictureUpload(@RequestParam("file") MultipartFile file) throws IOException{
        String name = uploadFile(file,"picture");
        return CommonReturnType.create(name);
    }
    //实现视频上传
    @RequestMapping(value = "/uploadVideo",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType videoUpload(@RequestParam("file")MultipartFile file) throws IOException{
        String name = uploadFile(file,"video");
        return CommonReturnType.create(name);
    }

    //实现报告上传
    @RequestMapping(value = "/uploadReport",method = {RequestMethod.POST} )
    @ResponseBody
    public CommonReturnType reportUpload(@RequestParam("file")MultipartFile file) throws IOException {
        String name = uploadFile(file,"report");
        return CommonReturnType.create(name);
    }

    public String uploadFile(MultipartFile file,String type) throws IOException{
        String fileName = file.getOriginalFilename();
        File filed = new File("upload");
        if(!filed.exists()){
            filed.mkdir();
        }
        File files = new File("upload/"+type);
        if(!files.exists()){
            files.mkdir();
        }
        String filename = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
        file.transferTo(new File(files.getAbsolutePath(),filename));
        return filename;
    }
    //实现文件下载
}
