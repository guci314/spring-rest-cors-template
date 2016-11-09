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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.services.ParkingService;
import web.value.ParkingMsg;
import web.value.ParkingRecord;
import web.value.PickupMsg;
import web.value.QueryFeeMsg;

@RestController
@RequestMapping("/api/parkingService")
public class ParkingController {
	@Autowired
	private ParkingService parkingService;
	
	@RequestMapping(value = "/requestParking", method = { RequestMethod.POST })
	public ParkingMsg requestParking(@RequestBody String params) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			return parkingService.RequestParking(phoneNumber);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/requestPickup", method = { RequestMethod.POST })
	public PickupMsg requestPickup(@RequestBody String params) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			return parkingService.RequestPickup(phoneNumber);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/queryFee", method = { RequestMethod.POST })
	public QueryFeeMsg queryFee(@RequestBody String params) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			return parkingService.QueryFee(phoneNumber);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	//getParkingRecord
	@RequestMapping(value = "/getParkingRecords", method = { RequestMethod.POST })
	public List<ParkingRecord> getParkingRecords(@RequestBody String params) {
		try {
			JSONObject j=new JSONObject(params);
			String phoneNumber=j.getString("phoneNumber");
			return parkingService.GetParkingRecords(phoneNumber);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
