package web.value;

/*
 * 停车记录
 */	
public class ParkingRecord {
	
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
	 * 存车口
	 */
	private String parkingEntrance	;
	
	/*
	 * 取车口
	 */
	private String pickupEntrance	;
	
	/*
	 * 停车时间
	 */
	private String parkingTime;
	
	/*
	 * 停留时间
	 */
	private String residenceTime;
	
	/*
	 * 费用
	 */
	private float fee;

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

	public String getParkingEntrance() {
		return parkingEntrance;
	}

	public void setParkingEntrance(String parkingEntrance) {
		this.parkingEntrance = parkingEntrance;
	}

	public String getPickupEntrance() {
		return pickupEntrance;
	}

	public void setPickupEntrance(String pickupEntrance) {
		this.pickupEntrance = pickupEntrance;
	}

	public String getParkingTime() {
		return parkingTime;
	}

	public void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}

	public String getResidenceTime() {
		return residenceTime;
	}

	public void setResidenceTime(String residenceTime) {
		this.residenceTime = residenceTime;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

}
