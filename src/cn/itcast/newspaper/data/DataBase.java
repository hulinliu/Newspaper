package cn.itcast.newspaper.data;
import java.util.ArrayList;
import cn.itcast.newspaper.domain.NewspaperItem;
/*
 * �洢����
 */
public class DataBase {
	public static ArrayList<NewspaperItem> data = new ArrayList <NewspaperItem>();
	//��ʼ������
	static{
		data.add(new NewspaperItem("1","���̱�",5.0,"��"));
	}
}