package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;
import com.mouse.util.HttpUtil;

public class MouseReadController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("read check");
		String path = null;
		
		String id = request.getParameter("id");
		
		MouseService service = MouseService.getInstance();
		
		try {
		Mouse mouse = service.mouseRead(id);
		// mouse 인스턴스를 request 객체에 담아서 공유하도록 해주는 코드
		request.setAttribute("mouse", mouse);
		
//		// mouseUpdate.jsp로 이동
		path = "mouseUpdate.jsp";
		} catch(Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			path = "error.jsp";
		}
		
		
		//실제 페이지 코딩
		HttpUtil.forward(request, response, path);	
			
	}

}