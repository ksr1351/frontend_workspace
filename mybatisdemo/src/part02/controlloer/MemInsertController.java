package part02.controlloer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import part02.dto.MemDTO;
import part02.service.MemService;

// http://localhost:8090/mybatisdemo/memInsert

@WebServlet("/memInsert")
public class MemInsertController extends HttpServlet {
	
	private MemService service;
	
	public MemInsertController() {
		service = new MemService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/part02/memInsert.jsp";
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp);
	}//end doGet()
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int chk = 0;
		String name = req.getParameter("name");
		System.out.println("name:" + name);
		
		int age = Integer.parseInt(req.getParameter("age"));
		String loc = req.getParameter("loc");
		
		MemDTO dto = new MemDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setLoc(loc);
		
		
		chk = service.setInsertProcess(dto);
		
		//alert발생 후 redirect 하는 방법
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<script>alert('" + chk + "개 삽입'); location.href='memList';</script>");
		out.flush();
		
		//↓ 서버에서 클라이언트에 다시 요청할 페이지 정보를 응답함
		//resp.sendRedirect("memList");  
	}//end doPost()
	
}//end class












