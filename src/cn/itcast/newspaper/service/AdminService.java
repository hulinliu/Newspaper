package cn.itcast.newspaper.service;
import java.util.ArrayList;
import cn.itcast.newspaper.dao.AdminDao;
import cn.itcast.newspaper.domain.NewspaperItem;
/*
 * 管理元服务类
 */
public class AdminService {
	private AdminDao adminDao=new AdminDao();
	//查询服务
	public ArrayList<NewspaperItem> queryNewspaperItem(){
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<NewspaperItem> data=adminDao.queryAllData();
		return data;
	}
	//添加服务
	public boolean addNewspaperItem(String number,String name,String price,String unit) {
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<NewspaperItem> data=queryNewspaperItem();
		//使用输入的编号与所有数据对比
		for(int i=0;i<data.size();i++) {
			NewspaperItem newspaperItem=data.get(i);
			//如果存在重复编号的数据，则添加不成功
			if(number.equals(newspaperItem.getNumber())) {
				return false;
			}
		}
		//如果没有重复编号，将数据封装为Newspaper对象
		NewspaperItem thisNewspaperItem=new NewspaperItem(number,name,Double.parseDouble(price),unit);
		//调用Dao层的添加数据方法
		adminDao.addNewspaperItem(thisNewspaperItem);
		return true;
	}
	//修改服务
	public boolean updateNewspaperItem(String number,String name,String price,String unit) {
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<NewspaperItem>data=queryNewspaperItem();
		//使用输入的编号与所有数据对比
		for(int i=0;i<data.size();i++) {
			NewspaperItem newspaperItem=data.get(i);
			//如果存在相同的编号数据，则可以更新
			if(number.equals(newspaperItem.getNumber())) {
				//调用Dao层的删除指定编号数据方法
				adminDao.delNewspaperItem(number);
				
				//如果没有重复编号，将数据封装为Newspaper对象
				NewspaperItem thisNewspaperItem=new NewspaperItem(number,name,Double.parseDouble(price),unit);
				
				//调用Dao层的添加数据方法
				adminDao.addNewspaperItem(thisNewspaperItem);
				//在修改数据后，返回添加成功
				return true;
			}
		}
		//如果不存在相同编号的数据，则不可以更新
		return false;
	}
	//删除服务
	public boolean delNewspaperItem(String delNumber) {
		//调用Dao层的获取所有数据方法获取所有数据
		ArrayList<NewspaperItem> data=queryNewspaperItem();
		//使用输入的数据与所有数据对比
		for(int i=0;i<data.size();i++) {
			NewspaperItem newspaperItem=data.get(i);
			//如果存在相同编号数据，则可以删除
			if(delNumber.equals(newspaperItem.getNumber())) {
				//调用Dao层的删除指定编号数据方法
				adminDao.delNewspaperItem(delNumber);
				return true;
			}
		}
		return false;
	}
}
