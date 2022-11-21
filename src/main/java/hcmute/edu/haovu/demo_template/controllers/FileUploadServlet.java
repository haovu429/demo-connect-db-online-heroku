package hcmute.edu.haovu.demo_template.controllers;

import hcmute.edu.haovu.demo_template.util.Constant;
import hcmute.edu.haovu.demo_template.util.UploadImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FileUploadServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
        /* Receive file uploaded to the Servlet from the HTML5 form */
        Collection<Part> fileParts = request.getParts();
        for (Part part : fileParts) {
            String fileName = part.getSubmittedFileName();
            Map result = UploadImage.uploadAvatarImage(fileName, Constant.STORAGE_IMAGE_LOCATION, part);

            // Lấy url từ response
            String url = String.valueOf(result.get("url"));

            System.out.println(url);
            if (result == null) {
                throw new RuntimeException("Loi upload");
            }
        }
        PrintWriter out = response.getWriter();
        out.println("Upload success");

    //        for (Part part : request.getParts()) {
    //            part.write("C:\\upload\\" + fileName);
    //        }
    //        response.getWriter().print("The file uploaded sucessfully.");
  }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/upload_image.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }
}