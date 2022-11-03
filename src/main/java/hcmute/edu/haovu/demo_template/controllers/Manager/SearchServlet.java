package hcmute.edu.haovu.demo_template.controllers.Manager;

import hcmute.edu.haovu.demo_template.dao.ProductDAO;
import hcmute.edu.haovu.demo_template.entities.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/manager/index.jsp";

        List<ProductEntity> products = new ArrayList<>();
        String search_txt = request.getParameter("search_txt");
        ProductDAO productDAO = new ProductDAO();
        products = productDAO.searchProduct(search_txt);
        for(ProductEntity product : products) {
            System.out.println(product);
        }
        request.setAttribute("productList",products);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
