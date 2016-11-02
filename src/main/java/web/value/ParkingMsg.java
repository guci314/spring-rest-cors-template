package web.value;

import java.util.Date;

public class ParkingMsg {
	
	/*
	 * 车牌号
	 */
	private String plate;
	
	/*
	 * 车场
	 */
	private String carPlace;
	
	/*
	 * 车库
	 */
	private String garage;
	
	/*
	 * 出入口
	 */
	private String entrance	;
	
	/*
	 * 车位
	 */
	private String lot;
	
	/*
	 * 停车时间
	 */
	private String parkingTime;

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public String getCarPlace() {
		return carPlace;
	}

	public void setCarPlace(String carPlace) {
		this.carPlace = carPlace;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getParkingTime() {
		return parkingTime;
	}

	public void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}
	
}
	