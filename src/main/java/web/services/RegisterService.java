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

	public void ResetPassword() {

	}
}
