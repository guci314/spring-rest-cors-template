package web.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.models.User;
import web.models.Vehicle;
import web.repositories.UserRepository;

@Service
public class RegisterService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private WalletService walletService;

	public boolean Register(String phoneNumber, String validCode, String password) {
		try {
			User u = new User();
			u.setPassword(password);
			u.setPhoneNumber(phoneNumber);
			userRepository.saveAndFlush(u);
			walletService.create(phoneNumber);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
			System.out.println(e.getMessage());
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
	
	public String GetUserByPhoneNumber(String phoneNumber){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		JSONObject obj = new JSONObject();
		obj.put("id", user.getId());
		obj.put("name", user.getName());
		obj.put("phoneNumber", user.getPhoneNumber());
		obj.put("password", user.getPassword());
		org.json.JSONArray ja=new org.json.JSONArray();
		for(Vehicle v:user.getVehicles()){
			JSONObject o = new JSONObject();
			o.put("id", v.getId());
			o.put("plate", v.getPlate());
			o.put("autoCharge", v.isAutoCharge());
			ja.put(o);
		}
		obj.put("vehicles", ja);
		return obj.toString();
	}
}
