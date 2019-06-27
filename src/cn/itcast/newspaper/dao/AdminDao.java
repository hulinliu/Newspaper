
package cn.itcast.newspaper.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import cn.itcast.newspaper.domain.NewspaperItem;
import cn.itcast.newspaper.tools.JDBCUtils;
import cn.itcast.newspaper.data.*;
/*
 * 管理员数据访问类
 */
/*
public class AdminDao {
	//获取所有数据
	public ArrayList<NewspaperItem> queryAllData(){
		return DataBase.data;
	}
	//添加数据
	public void addNewspaperItem(NewspaperItem newspaperItem) {
		DataBase.data.add(newspaperItem);
	}
	//删除数据
	public void delNewspaperItem(String delNumber) {
		//查询集合中的数据
		for(int i=0;i<DataBase.data.size();i++) {
			NewspaperItem thisNewspaperItem = DataBase.data.get(i);
			//如果有报纸项的编号与传入编号相同，则从集合中删除
			if(thisNewspaperItem.getNumber().equals(delNumber)) {
				DataBase.data.remove(i);
			}
		}
	}
}
*/

public class AdminDao {
	//获取所有数据
	public ArrayList<NewspaperItem> queryAllData(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<NewspaperItem> list=new ArrayList<NewspaperItem>();
		try {
			//获得数据的连接
			conn=JDBCUtils.getConnection();
			//获得Statement对象
			stmt=conn.createStatement();
			//发送SQL语句
			String sql="SELECT * FROM newspaper";
			rs=stmt.executeQuery(sql);
			//处理结果集
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
	
	//添加数据
	public void addNewspaperItem(NewspaperItem newspaperItem) {
		//DataBase.data.add(newspaperItem);
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//获得数据的连接
			conn=JDBCUtils.getConnection();
			//获得Statement对象
			stmt=conn.createStatement();
			//发送SQL语句
			String sql="INSERT INTO newspaper(number,newspapername,price,unit)"+
			"VALUES"+"("+newspaperItem.getNumber()+",'"
			+newspaperItem.getName()+"','"+newspaperItem.getPrice()
			+"','"+newspaperItem.getUnit()+"')";
			
		int num=stmt.executeUpdate(sql);
			if(num>0) {
			System.out.println("插入数据成功！");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs,stmt, conn);
		}
	}
	//删除数据
	public void delNewspaperItem(String delNumber) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//获得数据的连接
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql="DELETE FROM newspaper WHERE number="+delNumber;
			int num=stmt.executeUpdate(sql);
			if(num>0)
				System.out.println("删除成功!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(rs,stmt, conn);
		}
	}

}
