package com.mouse.controller.subcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouse.controller.Controller;
import com.mouse.model.Mouse;
import com.mouse.service.MouseService;

public class MouseDeleteController implements Controller {


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete check");
		
		String id = request.getParameter("id");
		MouseService service = MouseService.getInstance();
		int result = service.mouseDelete(id);
		String path = "mouseListView.jsp";
		response.sendRedirect(path);
	}
		
}
