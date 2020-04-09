package cn.edu.upc.wjb.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Report;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public CommonReturnType pictureUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException{
        String name = uploadFile(file,"picture",request);
        return CommonReturnType.create(name);
    }
    //实现视频上传
    @RequestMapping(value = "/uploadVideo",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType videoUpload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException{
        String name = uploadFile(file,"video",request);
        return CommonReturnType.create(name);
    }

    //实现报告上传
    @RequestMapping(value = "/uploadReport",method = {RequestMethod.POST} )
    @ResponseBody
    public CommonReturnType reportUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        String name = uploadFile(file,"report",request);
        return CommonReturnType.create(name);
    }

    public String uploadFile(MultipartFile file,String type,HttpServletRequest request) throws IOException{
        String fileName = file.getOriginalFilename();
        String path=request.getSession().getServletContext().getRealPath("/upload");
        File filed = new File(path);
        if(!filed.exists()){
            filed.mkdir();
        }
        File files = new File(path+"/"+type);
        if(!files.exists()){
            files.mkdir();
        }
        String filename = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
        file.transferTo(new File(files.getAbsolutePath(),filename));
        return filename;
    }
    //实现文件下载
    @RequestMapping(value = "/downloadFileEx",method ={RequestMethod.POST,RequestMethod.GET})
    public static void downloadExcelModle(HttpServletResponse response,HttpServletRequest request, @RequestBody Report report) {
        //下载
        String path=request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(path+"\\report\\"+report.getDocument());//   1.获取要下载的文件的绝对路径
//        File file = new File(fileName);//   1.获取要下载的文件的绝对路径
        String newDname = report.getDocument();     //2.获取要下载的文件名
        System.out.println(path+"\\report\\"+report.getDocument());
        if (file.exists()) {  //判断文件是否存在
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/xlsx");
            try {
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(newDname
                        .getBytes("UTF-8"), "ISO8859-1"));  //3.设置content-disposition响应头控制浏览器以下载的形式打开文件.特别注意，在swagger中会练吗，
                // 但是其实不会乱码。
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            byte[] buff = new byte[1024];    //5.创建数据缓冲区
            BufferedInputStream bis = null;
            OutputStream os = null;
            OutputStream outputStream = null;
            try {
                FileInputStream inputStream = new FileInputStream(file);
                outputStream = response.getOutputStream();
                IOUtils.copy(inputStream, outputStream);
                response.flushBuffer();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else
        {
            System.out.println("1");
        }
    }
}
