package cn.itcast.newspaper.service;
import java.util.ArrayList;
import cn.itcast.newspaper.dao.AdminDao;
import cn.itcast.newspaper.domain.NewspaperItem;
/*
 * ����Ԫ������
 */
public class AdminService {
	private AdminDao adminDao=new AdminDao();
	//��ѯ����
	public ArrayList<NewspaperItem> queryNewspaperItem(){
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<NewspaperItem> data=adminDao.queryAllData();
		return data;
	}
	//��ӷ���
	public boolean addNewspaperItem(String number,String name,String price,String unit) {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<NewspaperItem> data=queryNewspaperItem();
		//ʹ������ı�����������ݶԱ�
		for(int i=0;i<data.size();i++) {
			NewspaperItem newspaperItem=data.get(i);
			//��������ظ���ŵ����ݣ�����Ӳ��ɹ�
			if(number.equals(newspaperItem.getNumber())) {
				return false;
			}
		}
		//���û���ظ���ţ������ݷ�װΪNewspaper����
		NewspaperItem thisNewspaperItem=new NewspaperItem(number,name,Double.parseDouble(price),unit);
		//����Dao���������ݷ���
		adminDao.addNewspaperItem(thisNewspaperItem);
		return true;
	}
	//�޸ķ���
	public boolean updateNewspaperItem(String number,String name,String price,String unit) {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<NewspaperItem>data=queryNewspaperItem();
		//ʹ������ı�����������ݶԱ�
		for(int i=0;i<data.size();i++) {
			NewspaperItem newspaperItem=data.get(i);
			//���������ͬ�ı�����ݣ�����Ը���
			if(number.equals(newspaperItem.getNumber())) {
				//����Dao���ɾ��ָ��������ݷ���
				adminDao.delNewspaperItem(number);
				
				//���û���ظ���ţ������ݷ�װΪNewspaper����
				NewspaperItem thisNewspaperItem=new NewspaperItem(number,name,Double.parseDouble(price),unit);
				
				//����Dao���������ݷ���
				adminDao.addNewspaperItem(thisNewspaperItem);
				//���޸����ݺ󣬷�����ӳɹ�
				return true;
			}
		}
		//�����������ͬ��ŵ����ݣ��򲻿��Ը���
		return false;
	}
	//ɾ������
	public boolean delNewspaperItem(String delNumber) {
		//����Dao��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<NewspaperItem> data=queryNewspaperItem();
		//ʹ��������������������ݶԱ�
		for(int i=0;i<data.size();i++) {
			NewspaperItem newspaperItem=data.get(i);
			//���������ͬ������ݣ������ɾ��
			if(delNumber.equals(newspaperItem.getNumber())) {
				//����Dao���ɾ��ָ��������ݷ���
				adminDao.delNewspaperItem(delNumber);
				return true;
			}
		}
		return false;
	}
}
