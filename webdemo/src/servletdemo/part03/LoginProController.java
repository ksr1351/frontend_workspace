package servletdemo.part03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginPro")
public class LoginProController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fid = req.getParameter("fid"); //아이디값
		String fpass = req.getParameter("fpass"); //비밀번호
		
		//System.out.printf("%s %s\n", fid, fpass);
		
		MemberDTO dto = new MemberDTO();
		dto.setFid(fid);
		dto.setFpass(fpass);
		
		req.setAttribute("dto", dto); //dto이름으로 dto를 저장(4 scope)
		//setAttribute의 값을 /servletview/part03/loginResult.jsp에 사용함
		
		String path = "/servletview/part03/loginResult.jsp";
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp); 
		//forward => 페이지 이동
	}
}
