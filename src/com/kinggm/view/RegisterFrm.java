package com.kinggm.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
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

public class RegisterFrm extends JFrame {

	private JPanel contentPane;
	private JTextField un;
	private JPasswordField up;
	private JPasswordField up1;
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrm frame = new RegisterFrm();
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
	public RegisterFrm() {
		setTitle("\u6CE8\u518C\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D:");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		
		un = new JTextField();
		un.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		up = new JPasswordField();
		
		JLabel label_2 = new JLabel("\u518D\u6B21\u786E\u8BA4\u5BC6\u7801:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		
		up1 = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			//重置
			public void actionPerformed(ActionEvent e) {
				
				reset();
				
				
			}
		});
		
		
		
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			
			
			//确认注册
			public void actionPerformed(ActionEvent e) {
				
				try {
					registerConfirm(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		
			
			
			
			
			
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(up, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addGap(18)
									.addComponent(up1, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(un, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))))
					.addGap(167))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(124))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(un, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(up, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(up1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(39))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置窗体居中显示
		this.setLocationRelativeTo(null);
		
	}
	
	//重置方法
	

	protected void reset() {
		un.setText("");
		up.setText("");
		up1.setText("");
	}
	
	
	
	//登录确认
	
	private void registerConfirm(ActionEvent e) throws HeadlessException, Exception {

		
		
		
		
		String userName=un.getText().toString();
		String password=new String(up.getPassword());
		String password1=new String(up1.getPassword());
		if(StringUtil.isEmpty(userName)) { //判断用户名是否为空
			JOptionPane.showMessageDialog(null	, "用户名不能为空！"); //如果用户名为空 则提示用户
			return;
		}
		
		if(StringUtil.isEmpty(password)||StringUtil.isEmpty(password1)) {
			
			JOptionPane.showMessageDialog(null	, "密码不能为空！"); //如果密码为空 则提示用户
			
			return;
		}
		
		if(!(password.equals(password1))) {
			
			JOptionPane.showMessageDialog(null	, "两次输入的密码不同,请重新输入！"); //如果密码为空 则提示用户
			
			return;
		}
		
		
		User user=new User(userName,password);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(userDao.existUser(con, userName)) {
			
			JOptionPane.showMessageDialog(null	, "该用户名已存在，请重新输入"); //如果密码为空 则提示用户
			return;
		}
		
		
	
		try {
			
		    int i=userDao.add(con, user);
		    
		if(i>0) {  
			
			JOptionPane.showMessageDialog(null	, "注册成功"); 
			dispose();
			new LogOnFrm().setVisible(true);
			
			
		}else {
			JOptionPane.showMessageDialog(null	, "注册失败");  
		}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
