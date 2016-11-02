package web.value;

public class QueryFeeMsg {
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
	private String entrance	;
	
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

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
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
