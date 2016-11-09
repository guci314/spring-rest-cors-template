package web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.models.Vehicle;
import web.services.VehicleService;

@RestController
@RequestMapping("/api/vehicleService")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/bindPlate", method = { RequestMethod.POST })
	public Vehicle bindPlate(@RequestBody String params,
			HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			String plate=j.getString("plate");
			boolean autoCharge=j.getBoolean("autoCharge");
			return vehicleService.bindPlate(phoneNumber, plate, autoCharge);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/findVehiclesByPhoneNumber", method = { RequestMethod.GET })
	public List<Vehicle> findVehiclesByPhoneNumber(@RequestParam String phoneNumber,
			HttpServletResponse response) {
		try {
			return vehicleService.findVehiclesByPhoneNumber(phoneNumber);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/deleteVehicle", method = { RequestMethod.POST })
	public boolean deleteVehicle(@RequestBody String params,
			HttpServletResponse response) {
		try {
			JSONObject j=new JSONObject(params);
			Long id=j.getLong("id");
			return vehicleService.deleteVehicle(id);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
