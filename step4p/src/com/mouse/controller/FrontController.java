package com.mouse.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.subcontroller.MouseInsertController;
import com.mouse.controller.subcontroller.MouseListController;
import com.mouse.controller.subcontroller.MouseReadController;

@WebServlet("/board")
public class FrontController extends HttpServlet{ //리스트냐 업데이트냐 그런것만 구분을하고 하위컴포넌트로 구분해줌

	//이 클래스를 서블릿으로 바꿀려면 뭐를 상속바당야하나? extends HttpServlet 이렇게 직접만들수도있다 임포트해주고
	//어노테이션도 경로 적어주고
	//인덱스html 실행하면 여기로 올것
	//알트 쉬프트 S로 오버라이드 해줌 (여기에 doget dopost도 있다!!)
	
	HashMap<String, Controller> list = null;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {//서블릿 초기화 기능 담당
		list = new HashMap<String, Controller>();
		list.put("list", new MouseListController());
		list.put("insert", new MouseInsertController());
		list.put("read", new MouseReadController());
	}

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getParameter("command"); //커맨드의 파라미터에 들어있는값이 리스트면 마우스 리스트컨트롤러에 들어가는거고
		System.out.println("command는" + command);
		if (command == null) {
			command = "list";
		}
		
		// command가 "list"일 경우  HashMap의 "list"라는 key의 인스턴스를 얻어옴 (list.get())
//		Controller subController = new MouseListController();로 치환됨
		Controller subController = list.get(command);
		subController.execute(request, response);
	}
	
	
}
