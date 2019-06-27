package cn.itcast.newspaper.controller;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cn.itcast.newspaper.domain.NewspaperItem;
import cn.itcast.newspaper.service.AdminService;
import cn.itcast.newspaper.view.AbstractAdminDialog;
/*
 * ����Ա���������
 */
@SuppressWarnings("serial")
public class AdminDialogController extends AbstractAdminDialog{
	//��������࣬�ṩ�������ܷ���
	private AdminService adminService = new AdminService();
	//���췽��
	public AdminDialogController() {
		super();
	}
	public AdminDialogController(Frame owner,boolean model) {
		super(owner,model);
		//��������ʱչʾ����
		queryNewspaperItem();
	}
	//��ѯ����
	@Override
	public void queryNewspaperItem() {
		//������ͷ
		String[] thead= {"��ֽ���","��ֽ����","��ֽ���ۣ�/Ԫ��","�Ƽ۵�λ"};
		//����adminService�Ĳ�ѯ����
		ArrayList<NewspaperItem> dataList=adminService.queryNewspaperItem();
		//����ѯ���ļ���תΪ���飬����ΪJTable��ֵ
		String[][] tbody=list2Array(dataList);
		//����ѯ���Ϊtable��ֵ
		TableModel dataModel=new DefaultTableModel(tbody,thead);
		table.setModel(dataModel);
	}
	
	//��������תΪ��ά���鷽��
	private String[][] list2Array(ArrayList<NewspaperItem> list) {
		// TODO Auto-generated method stub
		String[][] tbody=new String[list.size()][4];
		for(int i=0;i<list.size();i++) {
			NewspaperItem newspaperItem=list.get(i);
			tbody[i][0]=newspaperItem.getNumber();
			tbody[i][1]=newspaperItem.getName();
			tbody[i][2]=newspaperItem.getPrice()+"";
			tbody[i][3]=newspaperItem.getUnit();
		}
		return tbody;
	}
	
	//��ӷ���
	@Override
	public void addNewspaperItem() {
		//��ȡ����
		String addNumber=addNumberText.getText();
		String addName=addNameText.getText();
		String addPrice=addPriceText.getText();
		String addUnit=addUnitText.getText();
		
		//����adminService����ӷ���
		boolean addSuccess=adminService.addNewspaperItem(addNumber, addName, addPrice, addUnit);
		if(addSuccess) {
			queryNewspaperItem();
		}else {
			//û����ӳɹ�������������ʾ
			JOptionPane.showMessageDialog(this, "��ֽ��Ų����ظ����������ݣ�");
		}
	}
	
	//�޸ķ���
	@Override
	public void updateNewspaperItem() {
		//��ȡ����
		String updateNumber=updateNumberText.getText();
		String updateNmae=updateNameText.getText();
		String updatePrice=updatePriceText.getText();
		String updateUnit=updateUnitText.getText();
		
		//����adminService���޸ķ���
		boolean updateSuccess=adminService.updateNewspaperItem(updateNumber, updateNmae, updatePrice, updateUnit);
		if(updateSuccess) {
			queryNewspaperItem();
		}else {
			//û���޸ĳɹ�������������ʾ
			JOptionPane.showMessageDialog(this, "û�������ŵı�ֽ���������ݣ�");
		}
	}
	
	//ɾ������
	@Override
	public void delNewspaperItem() {
		String delNumber=delNumberText.getText();
		boolean delSuccess=adminService.delNewspaperItem(delNumber);
		if(delSuccess) {
			queryNewspaperItem();
		}
		else {
			//û���޸ĳɹ�������������ʾ
			JOptionPane.showMessageDialog(this, "û�������ŵı�ֽ���������ݣ�");
		}
	}
}
