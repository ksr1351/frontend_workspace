package servletdemo.part04;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8090/webdemo/memlist

@WebServlet("/memlist")
public class ListMemController extends HttpServlet {
	private MemService service;

	public ListMemController() {
		service = new MemService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("aList", service.getMemList());

		String path = "/servletview/part04/list.jsp";
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp);
	}

}
