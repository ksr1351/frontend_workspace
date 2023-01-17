package part02.controlloer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import part02.dto.MemDTO;
import part02.service.MemService;

//http://localhost:8090/mybatisdemo/memList

@WebServlet("/memList")
public class MemController extends HttpServlet {
	private MemService service;

	public MemController() {
		service = new MemService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("aList", service.getAllListProcess());
		String path = "/part02/memList.jsp";
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp);

	}

}
