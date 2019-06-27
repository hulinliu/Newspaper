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
 * 管理员界面操作类
 */
@SuppressWarnings("serial")
public class AdminDialogController extends AbstractAdminDialog{
	//定义服务类，提供完整功能服务
	private AdminService adminService = new AdminService();
	//构造方法
	public AdminDialogController() {
		super();
	}
	public AdminDialogController(Frame owner,boolean model) {
		super(owner,model);
		//创建对象时展示数据
		queryNewspaperItem();
	}
	//查询方法
	@Override
	public void queryNewspaperItem() {
		//定义表格头
		String[] thead= {"报纸编号","报纸名称","报纸单价（/元）","计价单位"};
		//调用adminService的查询服务
		ArrayList<NewspaperItem> dataList=adminService.queryNewspaperItem();
		//将查询到的集合转为数组，方便为JTable赋值
		String[][] tbody=list2Array(dataList);
		//将查询结果为table赋值
		TableModel dataModel=new DefaultTableModel(tbody,thead);
		table.setModel(dataModel);
	}
	
	//集合数据转为二维数组方法
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
	
	//添加方法
	@Override
	public void addNewspaperItem() {
		//获取数据
		String addNumber=addNumberText.getText();
		String addName=addNameText.getText();
		String addPrice=addPriceText.getText();
		String addUnit=addUnitText.getText();
		
		//调用adminService的添加服务
		boolean addSuccess=adminService.addNewspaperItem(addNumber, addName, addPrice, addUnit);
		if(addSuccess) {
			queryNewspaperItem();
		}else {
			//没有添加成功，弹窗错误提示
			JOptionPane.showMessageDialog(this, "报纸编号不能重复，请检查数据！");
		}
	}
	
	//修改方法
	@Override
	public void updateNewspaperItem() {
		//获取数据
		String updateNumber=updateNumberText.getText();
		String updateNmae=updateNameText.getText();
		String updatePrice=updatePriceText.getText();
		String updateUnit=updateUnitText.getText();
		
		//调用adminService的修改服务
		boolean updateSuccess=adminService.updateNewspaperItem(updateNumber, updateNmae, updatePrice, updateUnit);
		if(updateSuccess) {
			queryNewspaperItem();
		}else {
			//没有修改成功，弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有这个编号的报纸，请检查数据！");
		}
	}
	
	//删除方法
	@Override
	public void delNewspaperItem() {
		String delNumber=delNumberText.getText();
		boolean delSuccess=adminService.delNewspaperItem(delNumber);
		if(delSuccess) {
			queryNewspaperItem();
		}
		else {
			//没有修改成功，弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有这个编号的报纸，请检查数据！");
		}
	}
}
