package web.services;

import java.util.Date;

import org.springframework.stereotype.Service;
import web.value.*;

@Service
public class ParkingService {
	public ParkingMsg RequestParking(String phoneNumber){
		ParkingMsg pm=new ParkingMsg();
		pm.setPlate("粤A11111");
		pm.setCarPlace("南山公园停车场");
		pm.setGarage("二号车库");
		pm.setLot("七号车位");
		pm.setEntrance("二十五号出入口");
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = format1.format(new Date());
		pm.setParkingTime(s);
		return pm;
	}
	
	public void RequestPickup(String phoneNumber,String plate){
		
	}
	
	public void QueryFee(String phoneNumber,String plate){
		
	}
}
