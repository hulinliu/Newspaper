
package cn.itcast.newspaper.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import cn.itcast.newspaper.domain.NewspaperItem;
import cn.itcast.newspaper.tools.JDBCUtils;
import cn.itcast.newspaper.data.*;
/*
 * ����Ա���ݷ�����
 */
/*
public class AdminDao {
	//��ȡ��������
	public ArrayList<NewspaperItem> queryAllData(){
		return DataBase.data;
	}
	//�������
	public void addNewspaperItem(NewspaperItem newspaperItem) {
		DataBase.data.add(newspaperItem);
	}
	//ɾ������
	public void delNewspaperItem(String delNumber) {
		//��ѯ�����е�����
		for(int i=0;i<DataBase.data.size();i++) {
			NewspaperItem thisNewspaperItem = DataBase.data.get(i);
			//����б�ֽ��ı���봫������ͬ����Ӽ�����ɾ��
			if(thisNewspaperItem.getNumber().equals(delNumber)) {
				DataBase.data.remove(i);
			}
		}
	}
}
*/

public class AdminDao {
	//��ȡ��������
	public ArrayList<NewspaperItem> queryAllData(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<NewspaperItem> list=new ArrayList<NewspaperItem>();
		try {
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			//���Statement����
			stmt=conn.createStatement();
			//����SQL���
			String sql="SELECT * FROM newspaper";
			rs=stmt.executeQuery(sql);
			//��������
			while(rs.next()) {
				NewspaperItem newspaperItem=new NewspaperItem();
				newspaperItem.setNumber(rs.getString("number"));
				newspaperItem.setName(rs.getString("newspapername"));
				newspaperItem.setPrice(rs.getDouble("price"));
				newspaperItem.setUnit(rs.getString("unit"));
				list.add(newspaperItem);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs,stmt, conn);
		}
		return null;
	}
	
	//�������
	public void addNewspaperItem(NewspaperItem newspaperItem) {
		//DataBase.data.add(newspaperItem);
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			//���Statement����
			stmt=conn.createStatement();
			//����SQL���
			String sql="INSERT INTO newspaper(number,newspapername,price,unit)"+
			"VALUES"+"("+newspaperItem.getNumber()+",'"
			+newspaperItem.getName()+"','"+newspaperItem.getPrice()
			+"','"+newspaperItem.getUnit()+"')";
			
		int num=stmt.executeUpdate(sql);
			if(num>0) {
			System.out.println("�������ݳɹ���");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs,stmt, conn);
		}
	}
	//ɾ������
	public void delNewspaperItem(String delNumber) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//������ݵ�����
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql="DELETE FROM newspaper WHERE number="+delNumber;
			int num=stmt.executeUpdate(sql);
			if(num>0)
				System.out.println("ɾ���ɹ�!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs,stmt, conn);
		}
	}

}
