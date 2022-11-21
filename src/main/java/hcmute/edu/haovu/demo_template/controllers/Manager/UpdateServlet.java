package hcmute.edu.haovu.demo_template.controllers.Manager;

import hcmute.edu.haovu.demo_template.dao.ProductDAO;
import hcmute.edu.haovu.demo_template.entities.ProductEntity;
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
import java.util.Map;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String masv = request.getParameter("masv");
//        ProductDAO dao = new ProductDAO();
//        System.out.println(masv);
//        ProductEntity product = dao.getByMaSv(masv);
//        request.setAttribute("product", product);
//        request.getRequestDispatcher("updateProduct.jsp")
//                .forward(request, response);
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String url = "/ViewServlet";
        ProductDAO ProductDAO = new ProductDAO();
        ProductEntity product = new ProductEntity();
        product.setId(Long.parseLong(request.getParameter("id")));
        product.setTitle(request.getParameter("title"));
        /*boolean phai = true;
        if (request.getParameter("phai").equals(false)) {
            phai = false;
        }*/

        product.setPrice(Long.parseLong(request.getParameter("price")));
        /*Date date;
        if (request.getParameter("birthday")!=null) {
            date = Util.stringToDate(request.getParameter("birthday"));
            product.setBirthday(date);
        }*/
        product.setSize(request.getParameter("size"));
        product.setColor(request.getParameter("color"));
        product.setDescription(request.getParameter("description"));
        product.setImage(request.getParameter("image"));

        Part part = request.getPart("file");
        System.out.println(part.getSize());
        if (part.getSize() >0 ) {
            // String fileName = part.getSubmittedFileName(); // Lay ten mac dinh cua file de luu
            String fileName =
                    "product_" + product.getTitle(); // dat ten file theo quy tac -> dung ten nay xoa file
            Map result = UploadImage.uploadAvatarImage(fileName, Constant.PRODUCT_IMAGE_LOCATION, part);

            // Lấy url từ response
            String urlImage = String.valueOf(result.get("url"));

            System.out.println(urlImage);
            if (result == null) {
                throw new RuntimeException("Loi upload");
            } else {
                product.setImage(urlImage);
            }
        }

        ProductDAO.updateProduct(product);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        //response.sendRedirect("/ViewServlet");
    }
}
