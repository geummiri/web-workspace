package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifecycleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public int count=0;

	//클래스명과 이름이 동일한 메서드 생성은 => 생성자 생성
    public LifecycleServlet2() {
    	System.out.println("1. LifecycleServlet 생성자..");
    }
    
    //서블릿이 처음으로 생성되거나 컨테이너에 의해 초기화될 때 호출
    //계속 호출되면 안될때 init이 사용됨
    //예를 들어 유튜브으 목록 같은 경우
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2. init...호출..");
	}
	//종료될 때 호출
	public void destroy() {
		System.out.println("4. destroy...호출..");
	}

	//비지니스로직이 구현되는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service...호출..");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<a href=life2.jsp?count=" + ++count + ">life2.jsp로 이동</a>");
		
		
		out.close();
		
		}
	}


