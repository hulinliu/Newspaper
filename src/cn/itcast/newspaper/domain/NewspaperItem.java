package cn.itcast.newspaper.domain;

/*
 * 报纸项数据模型
 */

public class NewspaperItem {
	//属性
	private String number;//编号
	private String name;  //名称
	private double price; //价格
	private String unit;  //单位
	
	//构造方法
	public NewspaperItem(){	
	}
	public NewspaperItem(String number,String name,double price,String unit){
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.unit = unit;	
	}
	//get/set方法
	public String getNumber(){
		return number;
	}
	
	public void setNumber(String Number){
		this.number=Number;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String Name){
		this.name=Name;
	}
	public double getPrice(){
		return price;
		
	}
	public void setPrice(double price){
		this.price=price;
	}
	public String getUnit(){
		return unit;
		
	}
	public void setUnit(String Unit){
		this.unit=Unit;
	}
}
