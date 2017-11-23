package org.liufeng.course.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.liufeng.course.message.resp.Article;
import org.liufeng.course.message.resp.NewsMessage;
import org.liufeng.course.message.resp.TextMessage;
import org.liufeng.course.util.MessageUtil;
/**
 * 核心服务类
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class CoreService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return xml
	 */
	public static String processRequest(HttpServletRequest request) {
		// xml格式的消息数据
		String respXml = null;
		try {
			// 调用parseXml方法解析请求消息
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号
			String fromUserName = requestMap.get("FromUserName");
			// 开发者微信号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			//消息内容
			String keySet = requestMap.get("Content");

			//文本回复
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			
			//图文消息回复
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
							
			// 事件推送
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {					
					Article article = new Article();
					article.setTitle("欢迎您关注卓目棉花异纤“云”清除机！");
					article.setDescription("首创基于异纤实时测速的动态开阀机制，命中精度高，喷花量更小。"
							+ "云智能、云监控、云诊断，为用户提供及时的异常诊断和售后保障服务。");
					article.setPicUrl("http://zhuomuyixianji.applinzi.com/html/image/ad.jpg");
					article.setUrl("http://zhuomuyixianji.applinzi.com/html/image/ad.jpg");
					List<Article> articleList = new ArrayList<Article>();
					articleList.add(article);
					// 将消息对象转换成xml
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respXml = MessageUtil.messageToXml(newsMessage);
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 暂不做处理
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建菜单时的key值对应
					String eventKey = requestMap.get("EventKey");
					// 根据key值判断用户点击的按钮
					if (eventKey.equals("instructions")) 
					{
						// TODO   用户注册
						textMessage.setContent("使用说明,待开发完成");
						respXml = MessageUtil.messageToXml(textMessage);
					}
//					else if(eventKey.equals("equ_registration"))
//					{
//						// TODO   设备注册
//						textMessage.setContent("设备注册");
//						respXml = MessageUtil.messageToXml(textMessage);
//					}
//					else if(eventKey.equals("equ_link"))
//					{
//						// TODO   设备连接
//						SampleSDK sample = new SampleSDK();
//						URL urlString=sample.generateUrl("wechat-package1-image","equip_status.txt");
//						String[] url_data=sample.getDocumentAt(urlString.toString()).split(" ");
//						String  User_name=" ";
//						String  Equip_num=" ";
//						String 	Equip_temper=" ";//温度
//						String 	Cotton_speed=" ";//流速
//						String  Day_count=" ";//日统计异纤个数
//						String  Lamp_time=" ";//灯管寿命
//						
//						User_name=url_data[0];
//						Equip_num=url_data[1];
//						Equip_temper=url_data[2];
//						Cotton_speed=url_data[3];
//						Day_count=url_data[4];
//						Lamp_time=url_data[5];
//										
//						String out="账户名："+User_name+"\n";
//						out=out+"设备号："+Equip_num+"\n";
//						out=out+"设备温度："+Equip_temper+"℃\n";
//						out=out+"棉花流速："+Cotton_speed+"m/s\n";
//						out=out+"日统计："+Day_count+"\n";
//						out=out+"灯管寿命："+Lamp_time+"/20000(小时)\n";
//						out=out+"每小时异纤个数：\n";
//						out=out+"0:00~1:00："+url_data[6]+"个\n";
//						out=out+"1:00~2:00："+url_data[7]+"个\n";
//						out=out+"2:00~3:00："+url_data[8]+"个\n";
//						out=out+"3:00~4:00："+url_data[9]+"个\n";
//						out=out+"4:00~5:00："+url_data[10]+"个\n";
//						out=out+"5:00~6:00："+url_data[11]+"个\n";
//						out=out+"6:00~7:00："+url_data[12]+"个\n";
//						out=out+"7:00~8:00："+url_data[13]+"个\n";
//						
//						textMessage.setContent(out);
//						// 将消息对象转换成xml
//						respXml = MessageUtil.messageToXml(textMessage);
						
					
//					}
					else if(eventKey.equals("industry_news"))
					{
						// TODO    行业新闻
						Article article = new Article();
						article.setTitle("如何客观全面的评价一台异纤机的综合性能");
						article.setDescription("笔者所在团队结合15年异纤机的研发和使用经历，尝试从异纤机检出性能、稳定性、易用性及售后保障和升级等四个方面力求客观全面的评价一台异纤机的综合性能");
						article.setPicUrl("http://zhuomuyixianji-image.stor.sinaapp.com/advertise/1.jpg");
						article.setUrl("http://mp.weixin.qq.com/s/CzPHxQooPOxE6rLnBGu3ow");
						List<Article> articleList = new ArrayList<Article>();
						articleList.add(article);
						// 将消息对象转换成xml
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respXml = MessageUtil.messageToXml(newsMessage);

					}
					else if(eventKey.equals("zhuomu_machine"))
					{
						// TODO		卓目“云”清除机
						Article article = new Article();
						article.setTitle("卓目“云”清除机简介");
						article.setDescription("技术引领革新，性能超越想象。");
						article.setPicUrl("http://zhuomuyixianji-image.stor.sinaapp.com/advertise/introduction.jpg");
						article.setUrl("https://mp.weixin.qq.com/s/f6hTxpPwRaY5GSlJRktrig");
						List<Article> articleList = new ArrayList<Article>();
						articleList.add(article);
						// 将消息对象转换成xml
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respXml = MessageUtil.messageToXml(newsMessage);
					}
					else if(eventKey.equals("comy_profile"))
					{
						// TODO     公司简介
						Article article = new Article();
						article.setTitle("公司简介");
						article.setDescription("追求第一，永远让客户满意！");
						article.setPicUrl("http://zhuomuyixianji-image.stor.sinaapp.com/advertise/company.jpg");
						article.setUrl("https://mp.weixin.qq.com/s/Y9j6ek6S7d_QGqCPPx9B2Q");
						List<Article> articleList = new ArrayList<Article>();
						articleList.add(article);
						// 将消息对象转换成xml
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respXml = MessageUtil.messageToXml(newsMessage);
					}
					else if(eventKey.equals("contact_us"))
					{ 
						// TODO    联系我们										
						textMessage.setContent("电话：027-87526592\n传真：027-68778696转808\n手机：13971628989\n邮箱：tctzf138@sina.com\n地址：湖北省武汉市武昌区武汉大学文理学部计算机大楼G区2楼");
						respXml =respXml+ MessageUtil.messageToXml(textMessage);
					}
				}
			}
			// 当用户发消息时
//			else {
//				textMessage.setContent("请通过菜单使用网址导航服务！");
//				respXml = MessageUtil.messageToXml(textMessage);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
