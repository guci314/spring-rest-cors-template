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

import web.services.ParkingService;
import web.value.ParkingMsg;

@Controller
@RequestMapping("/api/parkingService")
public class ParkingController {
	@Autowired
	private ParkingService parkingService;
	
	@RequestMapping(value = "/requestParking", method = { RequestMethod.POST })
	public @ResponseBody ParkingMsg requestParking(@RequestBody String params,
			HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			return parkingService.RequestParking(phoneNumber);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

}
