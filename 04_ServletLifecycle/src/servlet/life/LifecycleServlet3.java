package servlet.life;

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

/*
 * - 서버가 stop 되는 순간 destroy() callback 함수가 자동으로 호출되어 
 * count 값이 영구정으로 보관 X
 * - 보관하려는 DB or 파일로 서버가 내려가도 서비스를 수행한 후 필드에 저장시킨 값을 저장
 * 
 *  
 * 이때 서블릿 라이프사이클 메소드가 중요하게 사용됨!
 * 1) 해당 필드값을 파일로 출력 --destroy()  
 * 서비스 메서드처럼 매번 호출할때 값을 넣을 필요없음 
 * 2) 파일에 저장된 값을 불러(읽어들임)와야 한다. -- init()
 * */

public class LifecycleServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public int count=0;
	private String path = "d:\\test\\count.txt";
	//클래스명과 이름이 동일한 메서드 생성은 => 생성자 생성
    public LifecycleServlet3() {
    	System.out.println("1. LifecycleServlet 생성자..");
    }
    
    //서블릿이 처음으로 생성되거나 컨테이너에 의해 초기화될 때 호출
    //계속 호출하면 안되는 경우일 때 init이 사용됨
    //예를 들어 유튜브 목록 같은 경우
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2. init...호출..");
		//서버가 다시 시작될 때 init에서 파일에 저장된 내용을 읽어서 count에 다시 할당
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);
			br.close();
			
			System.out.println("count.txt 파일의 내용을 읽어들임.. count ::" + count);
		} catch (IOException e) {
			System.out.println("파일을 읽어들이는데 실패...");
		}
	}
	
	//종료될 때 호출
	public void destroy() {
		System.out.println("4. destroy...호출..");
		
		// 필드에 저장된 값을 파일로 저장하고 서버가 내려질 것
		File file = new File(path); //io에 있는 File 생성하기 , path값 지정해서 넣어주기
		//출력용 파일을 출력스트림에서 자동적으로 생성되려면 그전에 반드시 디렉토리는 만들어져 있어야 한다.
		file.getParentFile().mkdirs(); //하나든 여러개든 디렉토리를 만들어줌
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			pw.close();
			System.out.println(path + "count 값 ::" + count + "파일에 영구적으로 저장");
		} catch (IOException e) {
			System.out.println("경로실패");
		}
		
	}

	//비지니스로직이 구현되는 곳
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service...호출..");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>LifeCycle CallBack Method...</h2>");
		out.println("<p>Count :: " + ++count + "</p>");
		
		out.close();
		
	}

}
