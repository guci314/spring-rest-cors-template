package web.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	public PickupMsg RequestPickup(String phoneNumber){
		PickupMsg pm=new PickupMsg();
		pm.setPlate("粤A11111");
		pm.setCarPlace("南山公园停车场");
		pm.setGarage("二号车库");
		pm.setLot("七号车位");
		pm.setEntrance("二十五号出入口");
		pm.setPickupTime("2016-11-13 11:11:11");
		return pm;
	}
	
	public QueryFeeMsg QueryFee(String phoneNumber){
		QueryFeeMsg q=new QueryFeeMsg();
		q.setPlate("粤A11111");
		q.setCarPlace("南山公园停车场");
		q.setGarage("二号车库");
		q.setEntrance("二十五号出入口");
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = format1.format(new Date());
		q.setParkingTime(s);
		q.setResidenceTime("1.23.45");
		q.setFee((float) 23.5);
		return q;
	}
	
	public List<ParkingRecord> GetParkingRecords(String phoneNumber){
		List<ParkingRecord> pl=new ArrayList<ParkingRecord>();
		
		ParkingRecord q=new ParkingRecord();
		q.setPlate("粤A11111");
		q.setCarPlace("南山公园停车场");
		q.setGarage("二号车库");
		q.setFee((float)13.4);
		q.setParkingEntrance("三号出入口");
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = format1.format(new Date(2017,1,23,6,23));
		q.setParkingTime(s);
		q.setResidenceTime("2小时34分");
		q.setPickupEntrance("四号出入口");
		pl.add(q);
		
		q=new ParkingRecord();
		q.setPlate("粤A11111");
		q.setCarPlace("南山公园停车场");
		q.setGarage("三号车库");
		q.setFee((float)232.4);
		q.setParkingEntrance("六号出入口");
		format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        s = format1.format(new Date(2017,4,2,6,23));
		q.setParkingTime(s);
		q.setResidenceTime("3小时3分");
		q.setPickupEntrance("五号出入口");
		pl.add(q);
		
		q=new ParkingRecord();
		q.setPlate("粤A11111");
		q.setCarPlace("南山公园停车场");
		q.setGarage("七号车库");
		q.setFee((float)43.4);
		q.setParkingEntrance("十六号出入口");
		format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        s = format1.format(new Date(2017,8,12,6,23));
		q.setParkingTime(s);
		q.setResidenceTime("5小时38分");
		q.setPickupEntrance("一号出入口");
		pl.add(q);
		
		
		return pl;
	}
}
