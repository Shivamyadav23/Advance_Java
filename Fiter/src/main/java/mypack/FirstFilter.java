package mypack;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class FirstFilter implements Filter {

    public void init(FilterConfig conf) throws ServletException {
       
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            String name = req.getParameter("nm");
            String age = req.getParameter("ag");

            // Specify encoding when writing to the file
            try (FileWriter fw = new FileWriter("d:\\loginfile.txt", true); 
                 BufferedWriter bw = new BufferedWriter(fw); 
                 PrintWriter out = new PrintWriter(bw)) {
                out.println("Name: " + name);
                out.println("Age: " + age);
            }

            // Properly set content type before writing response
            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();
            pw.println("<br>Data saved in a file<br>");

            // Proceed with the next filter in the chain
            chain.doFilter(req, res);
        } catch (IOException e) {
            // Handle file writing specific exceptions
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
        }
    }

    public void destroy() {
        // Cleanup code, if needed
    }
}
