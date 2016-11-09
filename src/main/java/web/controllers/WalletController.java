package web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.models.Vehicle;
import web.services.WalletService;

@RestController
@RequestMapping("/api/walletService")
public class WalletController {
	@Autowired
	private WalletService walletService;
	
	@RequestMapping(value = "/create", method = { RequestMethod.POST })
	public boolean create(@RequestBody String params,
			HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			return walletService.create(phoneNumber);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = "/deposit", method = { RequestMethod.POST })
	public boolean deposit(@RequestBody String params,
			HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			float amount=(float)j.getDouble("amount");
			return walletService.deposit(phoneNumber,amount);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = "/withdraw", method = { RequestMethod.POST })
	public boolean withdraw(@RequestBody String params,
			HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			float amount=(float)j.getDouble("amount");
			return walletService.withdraw(phoneNumber,amount);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = "/getBalance", method = { RequestMethod.POST })
	public float getBalance(@RequestBody String params,
			HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			return walletService.getBalance(phoneNumber);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
