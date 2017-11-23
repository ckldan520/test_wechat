package org.liufeng.weixin.main;

import org.liufeng.course.menu.Button;
import org.liufeng.course.menu.ClickButton;
import org.liufeng.course.menu.ComplexButton;
import org.liufeng.course.menu.Menu;
import org.liufeng.course.menu.ViewButton;
import org.liufeng.course.pojo.Token;
import org.liufeng.course.util.CommonUtil;
import org.liufeng.course.util.MenuUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * �˵���������
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	/**
	 * ����˵��ṹ
	 * 
	 * @return
	 */
	private static Menu getMenu() {


		ClickButton btn11 = new ClickButton();
		btn11.setName("ʹ��˵��");
		btn11.setType("click");
		btn11.setKey("instructions");
		
		ViewButton btn12 = new ViewButton();
		btn12.setName("�豸����");
		btn12.setType("view");
		btn12.setUrl("http://zhuomuyixianji.applinzi.com/html/src/mod_home.html");

		ClickButton btn21 = new ClickButton();
		btn21.setName("������Ѷ");
		btn21.setType("click");
		btn21.setKey("industry_news");

		ClickButton btn22 = new ClickButton();
		btn22.setName("׿Ŀ���ơ������");
		btn22.setType("click");
		btn22.setKey("zhuomu_machine");
		
		ClickButton btn31 = new ClickButton();
		btn31.setName("��˾���");
		btn31.setType("click");
		btn31.setKey("comy_profile");

		ClickButton btn32 = new ClickButton();
		btn32.setName("��ϵ����");
		btn32.setType("click");
		btn32.setKey("contact_us");


		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("�ҵ��豸");
		mainBtn1.setSub_button(new Button[] {  btn11,btn12 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("��������");
		mainBtn2.setSub_button(new Button[] { btn21, btn22 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("����׿Ŀ");
		mainBtn3.setSub_button(new Button[] { btn31, btn32 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}

	public static void main(String[] args) {
		// �������û�Ψһƾ֤
		String appId = "wx02763ede79a413c5";
		// �������û�Ψһƾ֤��Կ
		String appSecret = "85c23e50187b127873d084511e1cdc01";

		// ���ýӿڻ�ȡƾ֤
		Token token = CommonUtil.getToken(appId, appSecret);

		if (null != token) {
			// �����˵�
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());

			// �жϲ˵��������
			if (result)
				log.info("�˵������ɹ���");
			else
				log.info("�˵�����ʧ�ܣ�");
		}
	}
}
