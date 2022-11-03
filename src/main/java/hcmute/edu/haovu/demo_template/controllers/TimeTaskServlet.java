package hcmute.edu.haovu.demo_template.controllers;

import hcmute.edu.haovu.demo_template.time_task.DemoTaskRepeat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TimeTaskServlet", value = "/TimeTaskServlet")
public class TimeTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receiveEmail = request.getParameter("email_time_task");
        DemoTaskRepeat.timeTaskRepeat(receiveEmail);
        response.setHeader("Content-Type", "text/plain");
        response.setHeader("success", "yes");
        PrintWriter writer = response.getWriter();
        writer.write("Da thuc hien!\n");
        writer.close();
    }
}
