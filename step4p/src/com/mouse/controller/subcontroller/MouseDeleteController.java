package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.model.Mouse;
import com.mouse.service.MouseService;

public class MouseDeleteController {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		
		Mouse mouse = new Mouse();
		
		mouse.setName(name);
		mouse.setCountry(country);
		mouse.setAddress(address);
		
		
		MouseService service = MouseService.getInstance();
		
		int result = service.mouseInsert(mouse);
		
		String path = "board?command=list";
		
		response.sendRedirect(path); 
		
		
		
	}
		
}
