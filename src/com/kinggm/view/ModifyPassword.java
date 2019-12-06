package com.kinggm.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kinggm.dao.UserDao;
import com.kinggm.model.User;
import com.kinggm.util.DbUtil;
import com.kinggm.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ModifyPassword extends JFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTxt;
	private JTextField newPasswordTxt;
	private JTextField confirmPasswordTxt;
	private static User user=new User();
	private UserDao userDao=new UserDao();
	private DbUtil dbUtil=new DbUtil();
	private String oldPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPassword frame = new ModifyPassword(user);
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
	public ModifyPassword(User user ) {
		setResizable(false);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u539F\u59CB\u5BC6\u7801:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801:");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u8BF7\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		oldPasswordTxt = new JTextField();
		oldPasswordTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		oldPasswordTxt.setColumns(10);
		
		newPasswordTxt = new JTextField();
		newPasswordTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		newPasswordTxt.setColumns(10);
		
		confirmPasswordTxt = new JTextField();
		confirmPasswordTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmPasswordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			
			//修改密码
			public void actionPerformed(ActionEvent e) {
				
				try {
					modifyPassword(e,user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
			
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(oldPasswordTxt, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(24)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(confirmPasswordTxt, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label)
											.addGap(18)
											.addComponent(newPasswordTxt, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(121, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(352, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(105))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(oldPasswordTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(newPasswordTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmPasswordTxt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置窗体居中显示
				this.setLocationRelativeTo(null);
	}
	
	
	
	
	
	
	
	
	
	//修改密码
	public void modifyPassword(ActionEvent e,User user) throws Exception{
		
		
		Connection con=dbUtil.getCon();
		
		ResultSet rs= userDao.searchPassword(con, user);
		
		while (rs.next()) {
			oldPassword= rs.getString("password");
			
			
		}      //得不到密码   需要从数据库查询
		
		
		
		String oldPassword1=oldPasswordTxt.getText().toString().trim();
		String newPassword=newPasswordTxt.getText().toString().trim();
		String newPassword1=confirmPasswordTxt.getText().toString().trim();
		
		if (StringUtil.isEmpty(oldPassword1)) {
			JOptionPane.showMessageDialog(null	, "原始密码不能为空！"); //如果原始密码为空 则提示用户
			return;
		}
		if (StringUtil.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(null	, "新密码不能为空！"); //如果原始密码为空 则提示用户
			return;
		}
		if (StringUtil.isEmpty(newPassword1)) {
			JOptionPane.showMessageDialog(null	, "确认原始密码不能为空！"); //如果原始密码为空 则提示用户
			return;
		}
		if (!(oldPassword1.equals(oldPassword))) {
			JOptionPane.showMessageDialog(null	, "原始密码不正确！"); //如果原始密码不正确 则提示用户
			return;
		}
		
		
		if (!(newPassword.equals(newPassword1))) {
			JOptionPane.showMessageDialog(null	, "两次输入的密码不同！"); //如果原始密码不正确 则提示用户
			return;
		}
		
		
		if (newPassword1.equals(newPassword)&&oldPassword.equals(oldPassword1)) {  //如果原始密码验证正确 且2次输入的新密码相同
			
			
			user.setPassword(newPassword1);
			if(userDao.modifyPassword(con, user)>0) {
				JOptionPane.showMessageDialog(null	, "密码修改成功,新密码为:"+newPassword1);
				dispose();
				new LogOnFrm().setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null	, "修改密码失败！"); 
			}
			
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
