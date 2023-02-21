package cn.itcast.web.download;

import cn.itcast.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取文件名称
        String filename = request.getParameter("filename");
        //2. 使用字节输入流加载文件进内存
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/img/"+filename);
        FileInputStream fis = new FileInputStream(path);


        //3. 指定response的响应头： content-disposition:attachment;filename=xxx
        String mimeType = context.getMimeType(filename);
        response.setHeader("content-type",mimeType);

        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);

        response.setHeader("content-disposition","attachment;filename="+filename);

        //4. 将数据写出到response输出流
        ServletOutputStream sos = response.getOutputStream();
        byte[] bytes =new byte[1024*8];
        int len = 0;
        while ((len = fis.read(bytes) )!= -1){
            sos.write(bytes,0,len);
        }
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
