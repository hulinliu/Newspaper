package cn.itcast.newspaper.domain;

/*
 * ��ֽ������ģ��
 */

public class NewspaperItem {
	//����
	private String number;//���
	private String name;  //����
	private double price; //�۸�
	private String unit;  //��λ
	
	//���췽��
	public NewspaperItem(){	
	}
	public NewspaperItem(String number,String name,double price,String unit){
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.unit = unit;	
	}
	//get/set����
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
