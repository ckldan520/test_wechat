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
 * 菜单管理器类
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	/**
	 * 定义菜单结构
	 * 
	 * @return
	 */
	private static Menu getMenu() {


		ClickButton btn11 = new ClickButton();
		btn11.setName("使用说明");
		btn11.setType("click");
		btn11.setKey("instructions");
		
		ViewButton btn12 = new ViewButton();
		btn12.setName("设备连接");
		btn12.setType("view");
		btn12.setUrl("http://zhuomuyixianji.applinzi.com/html/src/mod_home.html");

		ClickButton btn21 = new ClickButton();
		btn21.setName("异纤资讯");
		btn21.setType("click");
		btn21.setKey("industry_news");

		ClickButton btn22 = new ClickButton();
		btn22.setName("卓目“云”清除机");
		btn22.setType("click");
		btn22.setKey("zhuomu_machine");
		
		ClickButton btn31 = new ClickButton();
		btn31.setName("公司简介");
		btn31.setType("click");
		btn31.setKey("comy_profile");

		ClickButton btn32 = new ClickButton();
		btn32.setName("联系我们");
		btn32.setType("click");
		btn32.setKey("contact_us");


		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("我的设备");
		mainBtn1.setSub_button(new Button[] {  btn11,btn12 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("异纤资料");
		mainBtn2.setSub_button(new Button[] { btn21, btn22 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("关于卓目");
		mainBtn3.setSub_button(new Button[] { btn31, btn32 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx02763ede79a413c5";
		// 第三方用户唯一凭证密钥
		String appSecret = "85c23e50187b127873d084511e1cdc01";

		// 调用接口获取凭证
		Token token = CommonUtil.getToken(appId, appSecret);

		if (null != token) {
			// 创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());

			// 判断菜单创建结果
			if (result)
				log.info("菜单创建成功！");
			else
				log.info("菜单创建失败！");
		}
	}
}
