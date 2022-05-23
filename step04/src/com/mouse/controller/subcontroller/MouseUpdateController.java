package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;

public class MouseUpdateController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update check");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		
		Mouse mouse = new Mouse();
		

		
		
		MouseService service = MouseService.getInstance();
		
		
		Mouse result = service.mouseUpdate(mouse);
		
		
		try {
			request.setAttribute(name, result);
		}finally {}
		
		String path = "board";
		
		response.sendRedirect(path); 
		
		System.out.println(mouse);
		
	}
		
}
