package hcmute.edu.haovu.demo_template.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CommonFilter", urlPatterns = "/*")
public class CommonFilter implements Filter {
  public void init(FilterConfig config) throws ServletException {}

  public void destroy() {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    // Hello
    //        PrintWriter out = response.getWriter();
    //        out.println("<html><body>");
    //        out.println("<h1>" + "Hao day" + "</h1>");
    //        out.println("</body></html>");
    chain.doFilter(request, response);
  }
}
