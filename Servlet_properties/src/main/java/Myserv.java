import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.SingletonCon;

/**
 * Servlet implementation class myServ
 */
public class Myserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	public void init(ServletConfig config) throws ServletException {
		try {
			con = SingletonCon.getCon();
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("Using properties");
			pw.println("<br>");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from students");
			while (rs.next()) {
				pw.println(rs.getInt(1));
				pw.println(rs.getString(2));
				pw.println(rs.getInt(3));
			}
		} catch (Exception ee) {
			System.out.println(ee);
		}

	}

}
