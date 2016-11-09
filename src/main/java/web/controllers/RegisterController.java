package web.controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.models.User;
import web.services.HelloService;
import web.services.RegisterService;

@RestController
@RequestMapping("/api/registerService")
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	public boolean register(@RequestBody String params) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			String password=j.getString("password");
			String validCode=j.getString("validCode");
			return registerService.Register(phoneNumber, validCode, password);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public boolean login(@RequestBody String params) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			String password=j.getString("password");
			return registerService.Login(phoneNumber, password);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	//produces="application/json"
	@RequestMapping(value = "/getUserByPhoneNumber", method = { RequestMethod.GET },produces="application/json;charset=UTF-8")
	public String getUserByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
		return registerService.GetUserByPhoneNumber(phoneNumber);
	}

	@RequestMapping(value = "/changeUserName", method = { RequestMethod.POST })
	public boolean changeUserName(@RequestBody String params,HttpServletResponse response) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			String name=j.getString("name");
			if (!username.equals(phoneNumber)){
				response.setStatus(403);
				return false;
			}
			return registerService.ChangeUserName(phoneNumber, name);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	@RequestMapping(value = "/changePassword", method = { RequestMethod.POST })
	public boolean changePassword(@RequestBody String params, HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			String oldPassword=j.getString("oldPassword");
			String newPassword=j.getString("newPassword");
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			if (!username.equals(phoneNumber)){
				response.setStatus(403);
				return false;
			}
			return registerService.ChangePassword(phoneNumber,oldPassword,newPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
