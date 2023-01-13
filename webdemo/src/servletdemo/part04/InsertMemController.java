package servletdemo.part04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8090/webdemo/meminsert

@WebServlet("/meminsert")
public class InsertMemController extends HttpServlet{
	private MemService service;
	
	public InsertMemController() {
		service = new MemService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/servletview/part04/insert.jsp"; //insert.jsp 페이지를 만들어야함 (insert.jsp파일)
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//post방식 한글깨짐 해결
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String loc = req.getParameter("loc");
		MemDTO dto = new MemDTO(name, age, loc);
		int chk = service.getInsert(dto);
		
		if(chk>0) {
			resp.sendRedirect("memlist"); //서버에서 클라이언트에 memlist를 요청하도록 응답
		}else {
			System.out.println("삽입 실패");
		}
		
		
	}
}











