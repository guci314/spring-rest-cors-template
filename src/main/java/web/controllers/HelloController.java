package web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import web.services.HelloService;


@Controller
@RequestMapping("/api/helloService")
public class HelloController {
	
	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/sayHello", method = {RequestMethod.POST})
	public
	@ResponseBody
	String sayHello(HttpServletResponse response)
	{
		response.addHeader("Access-Control-Allow-Origin", "*");
		return this.helloService.sayHello();
	}
}
