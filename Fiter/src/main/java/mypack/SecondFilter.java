package mypack;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class SecondFilter implements Filter {

    public void init(FilterConfig conf) throws ServletException {
      
    } 

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            int age = Integer.parseInt(req.getParameter("ag"));
            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();
            if (age < 18) {
                pw.println("voting not allowed<br>");
            } else {
                pw.println("voting allowed<br>");
            }

            chain.doFilter(req, res);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format: " + e);
            throw new ServletException("Invalid age format", e);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
            throw new ServletException("An error occurred", e);
        }
    }

    public void destroy() {
        // Cleanup code, if needed
    }
}
