package cn.itcast.newspaper.test;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cn.itcast.newspaper.view.AbstractAdminDialog;

/*
 *  ������������
*/
@SuppressWarnings("serial")

public class AbstractAdminDialogTest extends AbstractAdminDialog{
	//���幹�캯����ʼ������
	public AbstractAdminDialogTest(){
			super();
			queryNewspaperItem(); //��������
		}	
	//�������table����
	public void queryNewspaperItem(){
		 String[] thead = new String[] {"��ֽ���","��ֽ����","��ֽ����(/Ԫ)","�Ƽ۵�λ"};
		 String[][] tbody=new String [][]{
				 {"001","���̳���","2.0","��"},
				 {"002","�����ձ�","3.0","��"},
				 {"003","���̱�","5.0","��"},
				 {"004","������ժ","2.0","��"},
				 {"005","�������","1.0","��"},
				 {"006","���Ļ���","4.0","��"},
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
	//�������������г���
	public static void main(String[] args){
		//�������沢��ʾ
		new AbstractAdminDialogTest().setVisible(true);
	}
	
}
