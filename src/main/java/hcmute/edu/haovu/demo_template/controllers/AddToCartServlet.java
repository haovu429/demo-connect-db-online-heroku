package hcmute.edu.haovu.demo_template.controllers;

import hcmute.edu.haovu.demo_template.dao.ProductDAO;
import hcmute.edu.haovu.demo_template.entities.ProductEntity;
import hcmute.edu.haovu.demo_template.model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/cart";

        Long id = Long.parseLong(request.getParameter("productId"));
        Long quantity = Long.parseLong(request.getParameter("quantity"));
        if (id == null) {
            // throw exception
        }

        ProductDAO productDAO = new ProductDAO();

        ProductEntity product = productDAO.getProductById(id);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.addLineItem(product, quantity);

        request.setAttribute("cart", cart);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
