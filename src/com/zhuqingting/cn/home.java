package com.zhuqingting.cn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.Common;
import util.InfoUs;
import util.textPwd;
public class home extends JFrame {

	private JPanel contentPane;
	private JTextField HomeFloor;
	private JTextField HomeAdmin;
	private JTextField HomePasswd;
	private JTextField HomeFloorS;
	private Common cm=new Common();
	private textPwd tp=new textPwd();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setTitle("\u5BC6\u7801\u7BA1\u7406\u5C0F\u5DE5\u5177");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5BC6\u7801\u95E8\u6237");
		lblNewLabel.setBounds(26, 39, 97, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u6237\u540D");
		lblNewLabel_1.setBounds(26, 115, 97, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u660E\u6587\u5BC6\u7801");
		lblNewLabel_2.setBounds(26, 180, 72, 34);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_Add = new JButton("\u6DFB\u52A0\u95E8\u6237\u6307\u4EE4");
		btn_Add.setBounds(39, 280, 137, 27);
		contentPane.add(btn_Add);
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//添加
				try {
					Add();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("\u95E8\u6237\u4EE4\u724C");
		lblNewLabel_3.setBounds(306, 39, 72, 34);
		contentPane.add(lblNewLabel_3);
		
		HomeFloor = new JTextField();
		HomeFloor.setBounds(26, 66, 170, 30);
		contentPane.add(HomeFloor);
		HomeFloor.setColumns(10);
		
		HomeAdmin = new JTextField();
		HomeAdmin.setBounds(26, 140, 170, 30);
		contentPane.add(HomeAdmin);
		HomeAdmin.setColumns(10);
		
		HomePasswd = new JTextField();
		HomePasswd.setBounds(26, 206, 170, 30);
		contentPane.add(HomePasswd);
		HomePasswd.setColumns(10);
		
		HomeFloorS = new JTextField();
		HomeFloorS.setBounds(306, 66, 170, 30);
		contentPane.add(HomeFloorS);
		HomeFloorS.setColumns(10);
		
		JButton btn_Search = new JButton("\u67E5\u627E\u95E8\u6237\u6307\u4EE4");
		btn_Search.setBounds(334, 119, 123, 27);
		contentPane.add(btn_Search);
		btn_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//查询
				Search();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 263, 194, -101);
		contentPane.add(scrollPane);
	}
	public void Add() throws IOException {
		
		String homeFloor=HomeFloor.getText().toString();
		String homeAdmin=HomeAdmin.getText().toString();
		String homePasswd=HomePasswd.getText().toString();
		String res=tp.textSetPwd(homePasswd);
		InfoUs info=new InfoUs();
		info.setHomeAd(homeAdmin);
		info.setHomeFloor(homeFloor);
		info.setPawd(res);
		cm.openFileWrite(info);
		HomeFloor.setText("");
		HomeAdmin.setText("");
		HomePasswd.setText("");
		JOptionPane.showMessageDialog(null, "门户指令加密成功", "提示", JOptionPane.INFORMATION_MESSAGE); 
		
	}
	
	public void Search() {
		
		String pwd=HomeFloorS.getText();
		String[] se=cm.openFileRead().split("InfoUs ");
		boolean right=false;
		for(int i=se.length-1;i>0;i--) {
			InfoUs sq=cm.changeToObj(se[i]);
			if(sq.getHomeFloor().equals(pwd)) {
				HomeFloor.setText(sq.getHomeFloor());
				HomeAdmin.setText(sq.getHomeAd());
				HomePasswd.setText(tp.textGetPwd(sq.getPawd()));
				right=true;
				break;
			}
		}
		if(!right) {
			JOptionPane.showMessageDialog(null, "对不起没有你需要得门户", "提示", JOptionPane.ERROR_MESSAGE); 
		}
		//HomeFloorS.setText();
	}
}
