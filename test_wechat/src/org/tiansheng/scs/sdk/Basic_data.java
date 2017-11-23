package org.tiansheng.scs.sdk;

public class Basic_data {
	private String  user_name;
	private String  equip_num;
	String 	DeviceTemperature;//温度
	String 	SprayCottonSpeed;//流速
	String  FCCTotal;//从本次开机到现在，打击的异纤总个数。
	String  lamp_time=" ";//灯管寿命

	
	public Basic_data()
	{
					
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getEquip_num() {
		return equip_num;
	}


	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}


	public String getDeviceTemperature() {
		return DeviceTemperature;
	}


	public void setDeviceTemperature(String deviceTemperature) {
		DeviceTemperature = deviceTemperature;
	}


	public String getSprayCottonSpeed() {
		return SprayCottonSpeed;
	}


	public void setSprayCottonSpeed(String sprayCottonSpeed) {
		SprayCottonSpeed = sprayCottonSpeed;
	}


	public String getFCCTotal() {
		return FCCTotal;
	}


	public void setFCCTotal(String fCCTotal) {
		FCCTotal = fCCTotal;
	}


	public String getLamp_time() {
		return lamp_time;
	}


	public void setLamp_time(String lamp_time) {
		this.lamp_time = lamp_time;
	}
	
	
}
