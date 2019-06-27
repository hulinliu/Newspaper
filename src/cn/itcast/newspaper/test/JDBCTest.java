package cn.itcast.newspaper.test;

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

public class JDBCTest {

    public static void main(String[] args) {
        NewspaperItem newspaperItem = new NewspaperItem();
        newspaperItem.setName("北京日报");
        newspaperItem.setNumber("2.5");
        newspaperItem.setPrice(3.5);
        newspaperItem.setUnit("张");
        //JDBCUtils jdbcUtils=new JDBCUtils();
        addNewspaperItem(newspaperItem);
    }

    //获取所有数据
    public ArrayList<NewspaperItem> queryAllData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<NewspaperItem> list = new ArrayList<NewspaperItem>();
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "SELECT * FROM newspaper";
            rs = stmt.executeQuery(sql);
            //处理结果集
            while (rs.next()) {
                NewspaperItem newspaperItem = new NewspaperItem();
                newspaperItem.setNumber(rs.getString("number"));
                newspaperItem.setName(rs.getString("newspapername"));
                newspaperItem.setPrice(rs.getDouble("price"));
                newspaperItem.setUnit(rs.getString("unit"));
                list.add(newspaperItem);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //添加数据
    public static void addNewspaperItem(NewspaperItem newspaperItem) {
        //DataBase.data.add(newspaperItem);
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            //获得Statement对象
            stmt = conn.createStatement();
            //发送SQL语句
            String sql = "INSERT INTO newspaper(number,newspapername,price,unit)" +
                    "VALUES" + "(" + newspaperItem.getNumber() + ",'"
                    + newspaperItem.getName() + "','" + newspaperItem.getPrice()
                    + "','" + newspaperItem.getUnit() + "')";

            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                System.out.println("插入数据成功！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }

    //删除数据
    public void delNewspaperItem(String delNumber) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //获得数据的连接
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM newspaper WHERE number=" + delNumber;
            int num = stmt.executeUpdate(sql);
            if (num > 0)
                System.out.println("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }

}
