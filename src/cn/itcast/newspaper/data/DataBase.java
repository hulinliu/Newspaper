package cn.itcast.newspaper.data;
import java.util.ArrayList;
import cn.itcast.newspaper.domain.NewspaperItem;
/*
 * 存储数据
 */
public class DataBase {
	public static ArrayList<NewspaperItem> data = new ArrayList <NewspaperItem>();
	//初始化数据
	static{
		data.add(new NewspaperItem("1","华商报",5.0,"张"));
	}
}