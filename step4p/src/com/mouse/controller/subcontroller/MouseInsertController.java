package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUtil;

public class MouseInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 프론트에서 입력한 데이터 받기(mouseInsert.jsp에서 mouse 등록 폼에 입력한 mouse 정보 추출)
//		내 추측 : mouseInsert.jsp에 있는 value="insert"를 가져와야할듯 어떻게?
//		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");

		// 입력받은 값을 Mouse 객체에 binding
//		내 추측 : mouseListView.jsp에 있는 ${requestScope.list} 여기에 추가가 되는게 맞는것같은데
//		내 추측2 : 아니다 일단 먼저 Mouse 객체에 binding 시키는거니깐
		Mouse mouse = new Mouse();
		//id는 오토인크리먼트로 올릴수있으니깐 뺀다고하심
		mouse.setName(name);
		mouse.setCountry(country);
		mouse.setAddress(address);
		
		// 비즈니스 로직을 담당하는 Service 객체 생성
		MouseService service = MouseService.getInstance();
		
		
		// 등록 처리용 메서드 int mouseInsert(Mouse mouse) 호출
//		int result = "DB 등록 처리(INSERT) 결과 작성 부분";
		int result = service.mouseInsert(mouse);
		
		// 리스트 화면으로 이동하기 위한 경로 작성
//		String url = "리스트 화면 경로 작성";
		String path = "board?command=list"; //프론트컨트롤러의 url ?뒤는 스트링어쩌고 제대로 못들음 안써도 상관없다고하심 
		
		// 실제 이동
		//1. forward (Bad case)
		// 어떤 요청으로 DB에 변화가 생기는 경우에는 요청을 새롭게 지정하는 redirect 방식을 사용해야함
		// forward의 경우에는 request가 유지(공유)되고 있기때문에 중복등록됨
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		
//		dispatcher.forward(request, response);
		
//		HttpUtil.forward(request, response, path);
		
		// 2. redirect(Recommended)
		response.sendRedirect(path); //HttpUtil로 분리
		
		//리다이렉트는 새로고침해도 리퀘스트객체가 다시 공유가안되서 그냥 새로고침만됨
		
		//500에러는 문법에러
	}

}
