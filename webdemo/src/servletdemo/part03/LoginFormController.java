package servletdemo.part03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8090/webdemo/loginForm ->요청하는 주소

//↓어노테이션
@WebServlet("/loginForm")
public class LoginFormController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/servletview/part03/loginForm.jsp"; //응답되는 주소

		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp);
	}
}


//주소를 통해서 =>get방식