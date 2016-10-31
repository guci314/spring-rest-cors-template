package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.models.User;
import web.repositories.UserRepository;

@Service
public class RegisterService {
	@Autowired
	private UserRepository userRepository;

	public boolean Register(String phoneNumber, String validCode, String password) {
		try {
			User u = new User();
			u.setPassword(password);
			u.setPhoneNumber(phoneNumber);
			userRepository.save(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean Login(String phoneNumber,String password){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		if (user==null) return false;
		if (user.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	public void ResetPassword() {

	}
	
	public boolean ChangeUserName(String phoneNumber,String newName){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		if (user==null) return false;
		try{
			user.setName(newName);
			userRepository.saveAndFlush(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean ChangePassword(String phoneNumber,String oldPassword,String newPassword){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		if (user==null) return false;
		try{
			if (!user.getPassword().equals(oldPassword)) return false;
			user.setPassword(newPassword);
			userRepository.saveAndFlush(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public User GetUserByPhoneNumber(String phoneNumber){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		return user;
	}
}
