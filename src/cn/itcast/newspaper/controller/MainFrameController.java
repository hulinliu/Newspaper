package cn.itcast.newspaper.controller;
import cn.itcast.newspaper.view.AbstractMainFrame;
/*
 * �����������
 */
@SuppressWarnings("serial")
public class MainFrameController extends AbstractMainFrame{
	@Override
	public void showAdminDialog() {
		//�ڸ÷����д�������Ա���沢��ʾ
		//thisΪ�����ڣ������棩   true������Ϊģ̬����չʾ
		new AdminDialogController(this,true).setVisible(true);
	}
}
