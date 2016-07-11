package com.mbk.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import Untils.BaseTest;
import Untils.DBUtils;
import Untils.ExcelReader;
import mbk.page.object.ElementsLoginActivity;

/*
 *   登录测试
 */
public class MBKLogin extends BaseTest {
	private ElementsLoginActivity loginObject;

	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void login(String username) {
		loginObject.getVerifyCode(username);
		String password = DBUtils.redisGetCode(username);
		loginObject.dologin(password);
		solo.sleep(1000);
		exitlogin();
		uihelper.getElementsPersonActivity().pressLoginButton();

	}

	private void exitlogin() {
		uihelper.getElementsPersonActivity().pressSettingButton();
		uihelper.getElementsQuitLogin().clickQuitButton();
		uihelper.getElementsQuitLogin().opsAlert(true);
		uihelper.getElementsPersonActivity().swipeTop();

	}

	/*
	 * 通过个人中心登录 测试正确号码段
	 */
	public void testexecutor() {
		// solo.sleep(1000);
		// homeexit();
		// uihelper.getElementsHomeInfo().info();
		// solo.sleep(1000);
		// // 判断是否是登录状态
		// if (!uihelper.getElementsPersonActivity().isnotlogin()) {
		// // 是－－> 退出登录
		// exitlogin();
		// }
		// uihelper.getElementsPersonActivity().pressLoginButton();
		// solo.sleep(1000);
		// String info[] = new String[] { "18001000002", "18501039991" };
		// for (int i = 0; i < info.length; i++) {
		// String phone = info[i];
		// loginObject = uihelper.getElementsLoginActivity();
		// login(phone);
		// }
		ExcelReader reader = new ExcelReader();
		// String path =
		// Environment.getDataDirectory().getAbsolutePath()+"/loginCase.xls";
		// Log.e("========", path);
//		try {
//			getInstrumentation().getContext().getAssets().open("file:///android_asset/loginCase.xls");
//			InputStream is = getInstrumentation().getContext().getAssets().open("file:///android_asset/loginCase.xls");;
//			reader.readExcelTitle(is);

//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// List<LoginCaseModle> logincaseList = new ArrayList<LoginCaseModle>();
		// LoginCaseModle logincase = new LoginCaseModle("1880103999",
		// ExpectEnum.failedByPhone);
		// LoginCaseModle logincase1 = new LoginCaseModle("18801039991",
		// ExpectEnum.success);
		// logincaseList.add(logincase);
		// logincaseList.add(logincase1);
		// for (int i = 0; i < logincaseList.size(); i++) {
		// LoginCaseModle item = logincaseList.get(i);
		// item.getExpect();
		// switch (item.getExpect()) {
		// case success:
		// break;
		// case failedByPhone:
		// break;
		//
		// case failedByVerify:
		// break;
		//
		// case failedByNetWork:
		// break;
		//
		// default:
		// break;
		// }
		//
		// }

	}

	/*
	 * 语音获取验证码
	 */
	// public void test_verifyByphone() {
	// homeexit();
	// uihelper.getElementsHomeInfo().info();
	// uihelper.getElementsPersonActivity().pressLoginButton();
	// uihelper.getElementsLoginActivity().getVerifyPhone("18501039991");
	// solo.sleep(2000);
	// }

	/*
	 * 通过首页mobike说明登录
	 */
	// public void test_login_by_introduce() {
	// homeexit();
	// uihelper.getElementsHomeInfo().clickGuideButton();
	// solo.sleep(10000);
	// assertTrue(uihelper.getElementsPersonActivity().isnotlogin());
	// }

	/*
	 * 通过预约车辆登录
	 */
	// public void test_login_by_comfirm() {
	// homeexit();
	//
	// }

	/*
	 * 通过扫码开锁入口
	 */
	// public void test_login_by_scan() {
	// homeexit();
	// uihelper.getElementsHomeInfo().pressloginFromScan();
	// solo.sleep(1000);
	// assertEquals("手机验证", uihelper.getElementsLoginActivity().title());
	// }

	/*
	 * 主页判断登录状态，且退出登录
	 */
	public void homeexit() {
		solo.sleep(1000);
		// 判断是否是登录状态
		if (!uihelper.getElementsHomeInfo().isLogin()) {
			// 没有既是登录状态－－> 退出登录
			uihelper.getElementsHomeInfo().info();
			exitlogin();
			solo.goBack();
		}
	}

	/*
	 *
	 * @see Untils.BaseTest#tearDown()
	 */
	public void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
}
