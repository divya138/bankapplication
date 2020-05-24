package com.account.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.account.dao.UserLoginRepositroy;
import com.account.model.Login;

@Service
public class UserService {
	@Autowired
	UserLoginRepositroy userloginRepositroy;
	public boolean loginValidation(long customerId) {
		Login login = userloginRepositroy.getOne(customerId);	
			if (login.isLogin() == false) {
				return false;
			}
			if (login.isLogin() == true) {
				return true;
			}
		
		return true;
	}
	public Login loginuser(Login login) {
		Login option = userloginRepositroy.getOne(login.getCustomerId());
		Login user1 = null;
		if (option.isLogin()) {
			//user1 = option.getClass();
			user1.setLogin(true);
			userloginRepositroy.save(user1);
		}
		return user1;

	}
    public Login addUser(Login login) {
		
		return userloginRepositroy.save(login);
	}
	

	}



