package web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.services.HelloService;
import web.services.RegisterService;

@Controller
@RequestMapping("/api/registerService")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value = "/register", method = {RequestMethod.POST})
	public
	@ResponseBody
	boolean sayHello(@RequestParam("phoneNumber") String phoneNumber,@RequestParam("validCode") String validCode,@RequestParam("password") String password,HttpServletResponse response)
	{
		response.addHeader("Access-Control-Allow-Origin", "*");
		return registerService.Register(phoneNumber, validCode, password);
	}
}
