package web.value;

/*
 * 取车请求的返回消息
 */
public class PickupMsg {
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
	 * 车位
	 */
	private String lot;
	
	/*
	 * 取车口
	 */
	private String entrance	;
	
	/*
	 * 取车时间
	 */
	private String pickupTime;

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

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

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}
	
}
