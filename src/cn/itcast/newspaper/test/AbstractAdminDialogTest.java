package cn.itcast.newspaper.test;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cn.itcast.newspaper.view.AbstractAdminDialog;

/*
 *  管理界面测试类
*/
@SuppressWarnings("serial")

public class AbstractAdminDialogTest extends AbstractAdminDialog{
	//定义构造函数初始化数据
	public AbstractAdminDialogTest(){
			super();
			queryNewspaperItem(); //测试数据
		}	
	//加入测试table数据
	public void queryNewspaperItem(){
		 String[] thead = new String[] {"报纸编号","报纸名称","报纸单价(/元)","计价单位"};
		 String[][] tbody=new String [][]{
				 {"001","华商晨报","2.0","张"},
				 {"002","人民日报","3.0","张"},
				 {"003","华商报","5.0","张"},
				 {"004","大众文摘","2.0","张"},
				 {"005","大众生活报","1.0","张"},
				 {"006","新文化报","4.0","张"},
		 };
		 TableModel data = new DefaultTableModel(tbody,thead);
		 table.setModel(data);
	}
	
	@Override
	public void addNewspaperItem(){
		
	}
	@Override
	public void updateNewspaperItem(){
		
	}
	@Override
	public void delNewspaperItem(){
		
	}
	//定义主函数运行程序
	public static void main(String[] args){
		//创建界面并显示
		new AbstractAdminDialogTest().setVisible(true);
	}
	
}
