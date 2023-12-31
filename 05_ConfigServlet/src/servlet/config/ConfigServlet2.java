package servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigServlet2
 */
public class ConfigServlet2 extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	private int count=0;
	private String path;
	//path 값은 web.xml 파일에 init-param 값으로 넘겨줌
	//구동하기 시작하면 xml 부터 자동으로 시작됨
	
	//1. ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다. -> web.xml 36,37번째줄
	//2. BufferedReader, FileWriter를 사용해서 파일을 읽어들인다.
	//3. count값으로 필드 초기화
	
	public void init(ServletConfig config) throws ServletException {
		
		//1. ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다.
		path = config.getInitParameter("path");
		
		try {
			//2. BufferedReader, FileWriter를 사용해서 파일을 읽어들인다.
			//BufferedReader : 입력 스트림은 외부 데이터 소스로부터 데이터를 읽어오는데 사용되는 객체
			BufferedReader br = new BufferedReader(new FileReader(path));
			//3. count값으로 필드 초기화
			count = Integer.parseInt(br.readLine()); 
			//count는 숫자이고 readLine은 문자열을 읽어주는것이기 때문에 Integer 사용
			br.close();
			System.out.println("count2.txt 파일의 내용을 읽어들임.. count ::" + count);
		} catch (IOException e) {
			System.out.println("파일 읽기 실패ㅠㅠ");
		}
	}
		
		public void destroy() {
			//4. PrintWriter, FileWriter 사용해서 count값 저장
			File file = new File(path);
			file.getParentFile().mkdirs();
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(file));
				pw.println(count);
				pw.close();
				System.out.println("경로 : " + path + ", count 값 :: " + count + ", 파일에 영구적으로 저장");
			} catch (IOException e) {
				System.out.println("경로실패");
			}
			
		}
			
	//5. 폼에 입력된 값을 받아서 ~~ 아무개 님은 ~몇번째 입장하신 고객입니다.
	//를 브라우저로 출력 (이때 출력은 config2.jsp에서)
		
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("userName");
	
		out.println("<a href=config2.jsp?name=" + name +  "&count=" + ++count + ">config2.jsp로 이동</a>");
	
		out.close();
		
	}
	
	
}
