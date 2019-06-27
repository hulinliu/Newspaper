package cn.itcast.newspaper.view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.itcast.newspaper.tools.GUITools;
/*
 * ��������
 */
@SuppressWarnings("serial")
public abstract class AbstractMainFrame extends JFrame {
	//���
	private JLabel titleLabel=new JLabel(new ImageIcon("Newspaper.jpg"));
	private JButton btn = new JButton("����ϵͳ");  //�˿Ͱ�ť
	
	//���캯��
	public AbstractMainFrame(){
		this.init();         //��ʼ������
		this.addComponent(); //������
		this.addListener(); //��Ӽ�����
		
	}
	
	//��ʼ������
	private void init(){
		this.setTitle("���绶ӭ����");   //����
		this.setSize(800,550);      //�����С��λ��
		GUITools.center(this);	//���ô�������Ļ�ϵ�λ��
		GUITools.setTitleImage(this, "title.png");
		this.setResizable(false);	//�����С�̶�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //�رմ���Ĭ�ϲ���
	}
	
	//������
	private void addComponent(){
		//����ʹ��Ĭ�ϵı߽粼�֣���������ͼƬ
		this.add(this.titleLabel,BorderLayout.NORTH);
		//����JPanel����
		JPanel btnPanel = new JPanel();
		//������֣�ʹPanel�е��齨�����Զ���λ��
		btnPanel.setLayout(null);
		//��JPanel������ӵ�������
		this.add(btnPanel);
		//����߽�λ��
		btn.setBounds(240,20,120,50);
		//����ť��ӵ�JPanel������
		btnPanel.add(btn);
		
	}
	
	//��Ӽ�����
	private void addListener(){
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				showAdminDialog();
			}
		});
	}
	
	//չʾ����Ա���淽��
	public abstract void showAdminDialog();

}
