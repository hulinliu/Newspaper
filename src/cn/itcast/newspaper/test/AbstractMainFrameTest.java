package cn.itcast.newspaper.test;

import cn.itcast.newspaper.view.AbstractMainFrame;

/**
 * �����ڲ�����
 */
public class AbstractMainFrameTest extends AbstractMainFrame {

    //����������
    public static void main(String[] args) {
        new AbstractMainFrameTest().setVisible(true);
    }

    //���Ǹ�����չʾ����Ա����ķ���
    @Override
    public void showAdminDialog() {
        System.out.println("����������");
    }
}
