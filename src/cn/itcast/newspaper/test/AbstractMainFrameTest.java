package cn.itcast.newspaper.test;

import cn.itcast.newspaper.view.AbstractMainFrame;

/**
 * 主窗口测试类
 */
public class AbstractMainFrameTest extends AbstractMainFrame {

    //定义主函数
    public static void main(String[] args) {
        new AbstractMainFrameTest().setVisible(true);
    }

    //覆盖父类中展示管理员界面的方法
    @Override
    public void showAdminDialog() {
        System.out.println("进入管理界面");
    }
}
