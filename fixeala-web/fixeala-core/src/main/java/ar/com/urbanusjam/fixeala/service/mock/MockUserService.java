package ar.com.urbanusjam.fixeala.service.mock;

import ar.com.urbanusjam.fixeala.model.Authority;
import ar.com.urbanusjam.fixeala.model.User;
import ar.com.urbanusjam.fixeala.service.UserService;
import ar.com.urbanusjam.fixeala.service.impl.UserServiceImpl;

public class MockUserService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserService usersrv = new UserServiceImpl();
		
		//USER
	
		
		//ADMIN
		User user2 = new User();
		user2.setUsername("coripel");
		user2.setPassword("c7589745dd1841655ac79a8f6fbb8e63b01b1e00");
		user2.setApellido("Reyes Calens");
		user2.setNombre("Cora");
		
		
		
		
		//EDITOR

	}

}
