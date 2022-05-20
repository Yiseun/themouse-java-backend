package com.mouse.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mouse.dao.MouseDAO;
import com.mouse.model.Mouse;

public class MouseService {

	// singleton 패턴 빌더패턴처럼 싱글톤패턴이 있다 //인스턴스가 하나만 생성되는걸 보장
	//singleton 패턴, 해당 프로그램에서 인스턴스(객체)가 하나만 생성됨을 보장
	
	//다른주소에서 뉴 마우스를 해도 같은주소값으로 생성되게 하는거다 ??뭔말이지 제대로 못들음
	
	//필드 생성
	private static MouseService service = new MouseService();
	//보통 필드생성하면 아래에 있는것처럼 했는데 아래꺼는 값이 초기화가 안되있는거다 위는 필드만들면서 값을 초기화한거고
//	private String name;
//	private String address;
	private MouseDAO dao = MouseDAO.getInstance(); //얘는 싱글톤이 아닌데 필드끼리 묶어높으신것 MouseService getInstance밑에다 두면 싱글톤을 구분할수있을것
	
	//기본 생성자
	private MouseService() {}
	
	//생성자도 메서드다
	//근데 private으로 생성되는걸 막으면 어떻게 생성할거야?
	//별도의 메서드를 통해서 이미 생성된 인스턴스를 반환하면 된다!
	//별도의 메서드를 통해서 이미 생성된 인스턴스를 반환
	public static MouseService getInstance(){
		return service;
	}

	// service-> dao(Data Access Object)
	public ArrayList<Mouse> mouseList() throws SQLException {
		ArrayList<Mouse> mouseList = dao.mouseList();
		return mouseList;
	}

	public int mouseInsert(Mouse mouse) {
		// TODO Auto-generated method stub
		int result = dao.mouseInsert(mouse);
		return result;
	}

	public Mouse mouseRead(String id) {
		return dao.mouseRead(id);
	}
	
	public Mouse mouseUpdate(Mouse mouse, String id) {
		return dao.mouseUpdate(mouse, id);
	}
	
	
	public Mouse mouseDelete(Mouse mouse, String id) {
		return dao.mouseDelete(mouse, id); 
	}
	
	
}
