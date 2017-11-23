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
 * ���ķ�����
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class CoreService {
	/**
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return xml
	 */
	public static String processRequest(HttpServletRequest request) {
		// xml��ʽ����Ϣ����
		String respXml = null;
		try {
			// ����parseXml��������������Ϣ
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// ���ͷ��ʺ�
			String fromUserName = requestMap.get("FromUserName");
			// ������΢�ź�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");
			//��Ϣ����
			String keySet = requestMap.get("Content");

			//�ı��ظ�
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			
			//ͼ����Ϣ�ظ�
			NewsMessage newsMessage = new NewsMessage();
			newsMessage.setToUserName(fromUserName);
			newsMessage.setFromUserName(toUserName);
			newsMessage.setCreateTime(new Date().getTime());
			newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
							
			// �¼�����
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ����
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {					
					Article article = new Article();
					article.setTitle("��ӭ����ע׿Ŀ�޻����ˡ��ơ��������");
					article.setDescription("�״���������ʵʱ���ٵĶ�̬�������ƣ����о��ȸߣ��绨����С��"
							+ "�����ܡ��Ƽ�ء�����ϣ�Ϊ�û��ṩ��ʱ���쳣��Ϻ��ۺ��Ϸ���");
					article.setPicUrl("http://zhuomuyixianji.applinzi.com/html/image/ad.jpg");
					article.setUrl("http://zhuomuyixianji.applinzi.com/html/image/ad.jpg");
					List<Article> articleList = new ArrayList<Article>();
					articleList.add(article);
					// ����Ϣ����ת����xml
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respXml = MessageUtil.messageToXml(newsMessage);
				}
				// ȡ������
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO �ݲ�������
				}
				// �Զ���˵�����¼�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// �¼�KEYֵ���봴���˵�ʱ��keyֵ��Ӧ
					String eventKey = requestMap.get("EventKey");
					// ����keyֵ�ж��û�����İ�ť
					if (eventKey.equals("instructions")) 
					{
						// TODO   �û�ע��
						textMessage.setContent("ʹ��˵��,���������");
						respXml = MessageUtil.messageToXml(textMessage);
					}
//					else if(eventKey.equals("equ_registration"))
//					{
//						// TODO   �豸ע��
//						textMessage.setContent("�豸ע��");
//						respXml = MessageUtil.messageToXml(textMessage);
//					}
//					else if(eventKey.equals("equ_link"))
//					{
//						// TODO   �豸����
//						SampleSDK sample = new SampleSDK();
//						URL urlString=sample.generateUrl("wechat-package1-image","equip_status.txt");
//						String[] url_data=sample.getDocumentAt(urlString.toString()).split(" ");
//						String  User_name=" ";
//						String  Equip_num=" ";
//						String 	Equip_temper=" ";//�¶�
//						String 	Cotton_speed=" ";//����
//						String  Day_count=" ";//��ͳ�����˸���
//						String  Lamp_time=" ";//�ƹ�����
//						
//						User_name=url_data[0];
//						Equip_num=url_data[1];
//						Equip_temper=url_data[2];
//						Cotton_speed=url_data[3];
//						Day_count=url_data[4];
//						Lamp_time=url_data[5];
//										
//						String out="�˻�����"+User_name+"\n";
//						out=out+"�豸�ţ�"+Equip_num+"\n";
//						out=out+"�豸�¶ȣ�"+Equip_temper+"��\n";
//						out=out+"�޻����٣�"+Cotton_speed+"m/s\n";
//						out=out+"��ͳ�ƣ�"+Day_count+"\n";
//						out=out+"�ƹ�������"+Lamp_time+"/20000(Сʱ)\n";
//						out=out+"ÿСʱ���˸�����\n";
//						out=out+"0:00~1:00��"+url_data[6]+"��\n";
//						out=out+"1:00~2:00��"+url_data[7]+"��\n";
//						out=out+"2:00~3:00��"+url_data[8]+"��\n";
//						out=out+"3:00~4:00��"+url_data[9]+"��\n";
//						out=out+"4:00~5:00��"+url_data[10]+"��\n";
//						out=out+"5:00~6:00��"+url_data[11]+"��\n";
//						out=out+"6:00~7:00��"+url_data[12]+"��\n";
//						out=out+"7:00~8:00��"+url_data[13]+"��\n";
//						
//						textMessage.setContent(out);
//						// ����Ϣ����ת����xml
//						respXml = MessageUtil.messageToXml(textMessage);
						
					
//					}
					else if(eventKey.equals("industry_news"))
					{
						// TODO    ��ҵ����
						Article article = new Article();
						article.setTitle("��ο͹�ȫ�������һ̨���˻����ۺ�����");
						article.setDescription("���������Ŷӽ��15�����˻����з���ʹ�þ��������Դ����˻�������ܡ��ȶ��ԡ������Լ��ۺ��Ϻ��������ĸ���������͹�ȫ�������һ̨���˻����ۺ�����");
						article.setPicUrl("http://zhuomuyixianji-image.stor.sinaapp.com/advertise/1.jpg");
						article.setUrl("http://mp.weixin.qq.com/s/CzPHxQooPOxE6rLnBGu3ow");
						List<Article> articleList = new ArrayList<Article>();
						articleList.add(article);
						// ����Ϣ����ת����xml
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respXml = MessageUtil.messageToXml(newsMessage);

					}
					else if(eventKey.equals("zhuomu_machine"))
					{
						// TODO		׿Ŀ���ơ������
						Article article = new Article();
						article.setTitle("׿Ŀ���ơ���������");
						article.setDescription("����������£����ܳ�Խ����");
						article.setPicUrl("http://zhuomuyixianji-image.stor.sinaapp.com/advertise/introduction.jpg");
						article.setUrl("https://mp.weixin.qq.com/s/f6hTxpPwRaY5GSlJRktrig");
						List<Article> articleList = new ArrayList<Article>();
						articleList.add(article);
						// ����Ϣ����ת����xml
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respXml = MessageUtil.messageToXml(newsMessage);
					}
					else if(eventKey.equals("comy_profile"))
					{
						// TODO     ��˾���
						Article article = new Article();
						article.setTitle("��˾���");
						article.setDescription("׷���һ����Զ�ÿͻ����⣡");
						article.setPicUrl("http://zhuomuyixianji-image.stor.sinaapp.com/advertise/company.jpg");
						article.setUrl("https://mp.weixin.qq.com/s/Y9j6ek6S7d_QGqCPPx9B2Q");
						List<Article> articleList = new ArrayList<Article>();
						articleList.add(article);
						// ����Ϣ����ת����xml
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respXml = MessageUtil.messageToXml(newsMessage);
					}
					else if(eventKey.equals("contact_us"))
					{ 
						// TODO    ��ϵ����										
						textMessage.setContent("�绰��027-87526592\n���棺027-68778696ת808\n�ֻ���13971628989\n���䣺tctzf138@sina.com\n��ַ������ʡ�人��������人��ѧ����ѧ���������¥G��2¥");
						respXml =respXml+ MessageUtil.messageToXml(textMessage);
					}
				}
			}
			// ���û�����Ϣʱ
//			else {
//				textMessage.setContent("��ͨ���˵�ʹ����ַ��������");
//				respXml = MessageUtil.messageToXml(textMessage);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
