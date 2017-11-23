package org.tiansheng.scs.sdk;

import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Show_data {
	public Basic_data user_data=new Basic_data();
	
	
	public void read_data(String user_id) throws DocumentException
	{
		SampleSDK sample = new SampleSDK();
		URL urlString=sample.generateUrl("wechat-package1-image","zmyqj_status.xml");
		SAXReader reader = new SAXReader();
		Document document = reader.read(urlString);
		Element root = document.getRootElement();
		
		
		Element device_temperature = (Element)root.selectSingleNode("//STATUS/DeviceTemperature"); 
		user_data.setDeviceTemperature(device_temperature.attributeValue("value"));
		
		Element cotton_speed = (Element)root.selectSingleNode("//STATUS/SprayCottonSpeed"); 
		user_data.setSprayCottonSpeed(cotton_speed.attributeValue("value"));
		
		Element fcc_total = (Element)root.selectSingleNode("//STATUS/DeviceTemperature"); 
		user_data.setFCCTotal(fcc_total.attributeValue("value"));
		
		System.out.println(user_data.getDeviceTemperature());
		System.out.println(user_data.getFCCTotal());
		System.out.println(user_data.getSprayCottonSpeed());
	}
	
}
