package co.micol.prj;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.command.AjaxMemberIdCheck;
import co.micol.prj.member.command.MemberInsert;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberSelect;
import co.micol.prj.member.command.MemberSelectList;

/**
 * Servlet implementation class FrontController
 * 모든 .do요청을 분석하고 처리한다.
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>(); // 요청한 값을 저장하기 위해

    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 모든 요청을 등록하는 곳
		map.put("/main.do", new MainCommand()); // 처음 시작하는 페이지
		map.put("/memberSelectList.do", new MemberSelectList()); // 멤버목록보기
		map.put("/memberSelect.do", new  MemberSelect()); // 멤버 상세 정보
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 멤버입력화면
		map.put("/memberInsert.do", new MemberInsert()); // 멤버 입력 처리
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); // 아이디 중복체크
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청을 분석하고, 처리하고, 결과를 돌려주는 곳
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지를 위해.
		String uri = request.getRequestURI(); //도메인을 제외한 실제 요청정보
		String contextPath = request.getContextPath(); // ContextPath 구함
		String page = uri.substring(contextPath.length());//처리한 요청명 구함
		System.out.println(request.getRequestURL());
		System.out.println(uri);
		System.out.println(contextPath);
		System.out.println(page);
		System.out.println(request.getRemoteUser());
		
		Command command = map.get(page); // 처리한 command를 찾음
		String viewPage = command.exec(request, response); //command를 실행하고 돌려줄페이지를 받음.

		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) { //ajax를 처리하기 위한 view Resolve
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}else { //리턴값이 보여줄 페이지를 가지고 올때 
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect(viewPage); //리턴값이 *.do로 올때 처리
		}
	}

}
