package servletdemo.part01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
/*
 * HttpServlet을 못 찾는 경우
 * 프로젝트 단축메뉴 > Properties > Targeted Runtimes > Apache Tomcat9.0 체크
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8090/webdemo/basic01

@WebServlet("/basic01")
public class Basic extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//현재페이지의 환경설정 값 설정 : HTML로 변경하고 UTF-8로 인코딩
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head><title>home page</title></head>");
		out.write("<body>");
		out.write("<p> sevlet page</p>");
		out.write("<p>홈 페이지</p>");
		out.write("</body>");
		out.write("</html>");
	}//end doGet()
	
}//end class
