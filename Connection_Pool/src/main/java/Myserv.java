
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

/**
 * Servlet implementation class Myserv
 */
public class Myserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
private Connection con;
	
	@Resource(lookup="java:/comp/env/mypool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.println("With Connection Pool");
			con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from students");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				out.println(rs.getInt(1) + "\t");
				out.println(rs.getString(2) + "\t");
				out.println(rs.getInt(3));
			}
			con.close();
		} catch (Exception ex) {
			System.out.println("In Service\t" + ex);
		}
	}

}
