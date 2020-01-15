package com.kinggm.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import com.kinggm.dao.UserDao;
import com.kinggm.model.User;
import com.kinggm.util.DbUtil;
import com.kinggm.util.StringUtil;


import java.util.Properties;
import java.io.*;
public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private static JTextField userNameTxt;
	private static JPasswordField passwordTxt;
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	private static JCheckBox rememberChe;
	private static boolean isSelected;
	static Properties pro= new Properties();
	private static String username="";
	private static String password="";
	static BufferedWriter out=null;
	static ClassLoader classLoader;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//加载用户选择的记住密码选项
		classLoader= LogOnFrm.class.getClassLoader();
		pro.load(classLoader.getResourceAsStream("user_information.properties"));
		isSelected=Boolean.parseBoolean(pro.getProperty("isSelected"));
		username=pro.getProperty("username");
		password=pro.getProperty("password");
		
		System.out.println(isSelected+" "+username+" "+password);
		
				
			
				

	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public LogOnFrm( ) throws IOException {
		setResizable(false);
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u767B\u5F55\u548C\u6CE8\u518C");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u5BC6\u7801:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordTxt.setColumns(10);
		
		 rememberChe = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		rememberChe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {       //checkBox 时间响应
				
				rememberPassword(e);
				
			}

		
		});
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		
		
		
		
		
		
		//登录事件
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginAction(e);
				
				
				
				
			}

		
		});
		
		
		
		
		
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button = new JButton("\u6CE8\u518C");
		
		
		
		
		//注册事件
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerAction(e);
				
			}

		
		});
		
		
		
		
		
		
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lbldblogin = new JLabel("\u6570\u636E\u5E93\u540D:db_login");
		
		JLabel lblTuser = new JLabel("\u8868\u540D: t_user");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTuser, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addGap(96)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(61)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(rememberChe, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))))
					.addGap(142))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbldblogin)
					.addContainerGap(429, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbldblogin)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTuser))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rememberChe)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		//设置窗体居中显示
		this.setLocationRelativeTo(null);
		initSelected();

	}
	
	
	
	//注册方法的实现
	private void registerAction(ActionEvent e) {
	
		dispose();
		new RegisterFrm().setVisible(true);
		
		
		
	}
	
	
	//登录方法的实现
	private void loginAction(ActionEvent e) {
		
		String userName=userNameTxt.getText().toString();
		String password=new String(passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)) { //判断用户名是否为空
			JOptionPane.showMessageDialog(null	, "用户名不能为空！"); //如果用户名为空 则提示用户
			return;
		}
		
		if(StringUtil.isEmpty(password)) {
			
			JOptionPane.showMessageDialog(null	, "密码不能为空！"); //如果密码为空 则提示用户
			
			return;
		}
		
		
		User user=new User(userName,password);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
		User current=userDao.login(con, user);
		if(current!=null) {
			dispose();
			new MainFrm(current).setVisible(true);
			
			
		}else {
			JOptionPane.showMessageDialog(null	, "用户名或密码错误"); //如果用户名为空 则提示用户
		}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	
	
	private void rememberPassword(ActionEvent e) {
		
		try {
			 out = new BufferedWriter(new FileWriter("D:\\Eclipse_J2EE_workspace\\LoginSystem\\src\\user_information.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(rememberChe.isSelected()) {  //选中状态
		
			System.out.println("选中");
			isSelected=true;
	
			pro.setProperty("isSelected", "true");
			pro.setProperty("username", userNameTxt.getText());
			pro.setProperty("password", passwordTxt.getText());
			try {
				pro.store(out,"");
				System.out.println("设置Pro成功");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else {
			System.out.println("未选中");
			isSelected=false;
			pro.setProperty("isSelected", "false");
			pro.setProperty("username","");
			pro.setProperty("password","");
			try {
				pro.store(out, "");
				System.out.println("设置Pro成功");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	public static void initSelected() throws IOException {
		
			userNameTxt.setText(username);
			passwordTxt.setText(password);
			rememberChe.setSelected(isSelected);
	}
	
	
	
}
