package web.controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.models.User;
import web.services.HelloService;
import web.services.RegisterService;

@Controller
@RequestMapping("/api/registerService")
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = "/register", method = { RequestMethod.POST })
	public @ResponseBody boolean register(@RequestBody String params,
			HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			String password=j.getString("password");
			String validCode=j.getString("validCode");
			response.addHeader("Access-Control-Allow-Origin", "*");
			return registerService.Register(phoneNumber, validCode, password);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public @ResponseBody boolean login(@RequestBody String params, HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			String password=j.getString("password");
			response.addHeader("Access-Control-Allow-Origin", "*");
			return registerService.Login(phoneNumber, password);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/getUserByPhoneNumber", method = { RequestMethod.GET })
	public @ResponseBody User getUserByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber,
			HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		return registerService.GetUserByPhoneNumber(phoneNumber);
	}

	@RequestMapping(value = "/changeUserName", method = { RequestMethod.POST })
	public @ResponseBody boolean changeUserName(@RequestBody String params, HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			String name=j.getString("name");
			//name = java.net.URLDecoder.decode(name, "utf-8");
			response.addHeader("Access-Control-Allow-Origin", "*");
			return registerService.ChangeUserName(phoneNumber, name);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
