package web.services;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.models.User;
import web.models.Vehicle;
import web.repositories.UserRepository;
import web.repositories.VehicleRepository;

@Service
public class RegisterService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private WalletService walletService;
	@Autowired
	private VehicleRepository vehicleRepository;

	public enum ResponseCode{
		
		ok("成功",0),fail("失败",1),wrongValidCode("验证码错误",2),phoneExist("电话号码已存在",3)
		,wrongPassword("密码错误",4),systemError("系统错误",5),phoneNotExist("电话号码不存在",6),
		noPermission("无权限",7);
		
	    private String name;
	    private int index;

	    private ResponseCode(String name, int index) {
	      this.name = name;
	      this.index = index;
	    }
		
	}
	
	public ResponseCode Register(String phoneNumber, String validCode, String password) {
		try {
			User u = new User();
			u.setPassword(password);
			u.setPhoneNumber(phoneNumber);
			userRepository.saveAndFlush(u);
			walletService.create(phoneNumber);
			return ResponseCode.ok;
		}
		catch (org.springframework.dao.DataIntegrityViolationException e){
			return ResponseCode.phoneExist;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseCode.systemError;
		}
	}

	public ResponseCode Login(String phoneNumber,String password){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		if (user==null) return ResponseCode.phoneNotExist;
		if (user.getPassword().equals(password)){
			return ResponseCode.ok;
		}else{
			return ResponseCode.wrongPassword;
		}
	}
	
	public ResponseCode ResetPassword(String phoneNumber, String validCode, String password) {
		try {
			User u = userRepository.findUserByPhoneNumber(phoneNumber);
			if (u==null) return ResponseCode.phoneNotExist;
			u.setPassword(password);
			userRepository.saveAndFlush(u);
			return ResponseCode.ok;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseCode.systemError;
		}
	}
	
	public ResponseCode ChangeUserName(String phoneNumber,String newName){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		if (user==null) return ResponseCode.phoneNotExist;
		try{
			user.setName(newName);
			userRepository.saveAndFlush(user);
			return ResponseCode.ok;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ResponseCode.systemError;
		}
	}
	
	public ResponseCode ChangePassword(String phoneNumber,String oldPassword,String newPassword){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		if (user==null) return ResponseCode.phoneNotExist;
		try{
			if (!user.getPassword().equals(oldPassword)) return ResponseCode.wrongPassword;
			user.setPassword(newPassword);
			userRepository.saveAndFlush(user);
			return ResponseCode.ok;
		}catch(Exception e){
			return ResponseCode.systemError;
		}
	}
	
	public String GetUserByPhoneNumber(String phoneNumber){
		User user=userRepository.findUserByPhoneNumber(phoneNumber);
		if (user==null) return null;
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
