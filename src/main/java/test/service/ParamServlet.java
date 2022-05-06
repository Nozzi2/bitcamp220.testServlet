package test.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init() throws ServletException {
		System.out.println("init()...");
		System.out.println("생성자처럼 단 한번만 실행됩니다.");
	}


	public void destroy() {
		System.out.println("destroy()...");
		System.out.println("톰캣이 끝날때만 실행되기 때문에");
		System.out.println("중단시키면 출력되지만, 그 순간에 콘솔창에서 볼 수 없다.");
		System.out.println("java 소스코드를 수정하고 저장하면 (한 10초 있다가)");
		System.out.println("톰캣은 자동으로 종료되기 떄문에");
		System.out.println("그 때에 destroy()가 실행된 것들 볼 수 있다.");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()...");
		System.out.println("페이지에 연결될 때마다 doGet이 실행됩니다.");
		
		//데이터
		//action의 url로 넘겨주는걸 받을거임
		//http://localhost:8080/testServlet/ParamServlet?name=hong&age=25
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		response.setContentType("text/html;charset=UTF-8"); //지금부터 주는 모든 파일은 HTML인걸로 인식
		//setContentType()의 문자열 파라미터에서 오타나면 웹페이지에서 자꾸 다운로드가 뜨고 그럼
		PrintWriter out = response.getWriter();
		//PrintWriter는 추상클래스이므로 웹브라우저로 보내는 역할을 하는 메소드(getWriter)로 객체 생성함
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("안녕하세요 서블릿!<br>");
		
		out.println("나의 이름은 "+name+"이고");
		out.println("내 나이는 "+age+"살 이므로");
		if(age>19) {
			out.println("성인");
		} else {
			out.println("청소년");
		}
		out.println("입니다.<br>");
		
		
		//입력화면으로 다시 가기
		out.println("<A href = http://localhost:8080/testServlet/exam/parameter.html target = top > 다시 입력하기 </A>");
		
		out.println("<br>");
		out.println("<input type = 'button' value='뒤로' onclick='history.go(-1)'>");
		//onclick= 클릭했을때
		//location.href= 어떤 주소로 이동
		//history.go(-1) 이전(-1) 페이지
		
		
		out.println("</body>");
		out.println("</html>");
	}
}
