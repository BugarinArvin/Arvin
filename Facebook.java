import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;


public class Facebook {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField password;
	private JTextField bdayMonth;
	private JTextField bdayDay;
	private JTextField bdayYear;
	private JButton userSubmit;
	private ArrayList<User> user = new ArrayList<User>();
	private JLabel lblBirthday;
	private JLabel lblMonth;
	private JLabel lblDay;
	private JLabel lblYear;
	String listusers="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facebook window = new Facebook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Facebook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 606, 590);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstName.setBounds(101, 22, 231, 30);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		
		lastName = new JTextField();
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lastName.setColumns(10);
		lastName.setBounds(101, 65, 231, 30);
		frame.getContentPane().add(lastName);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		password.setColumns(10);
		password.setBounds(101, 106, 231, 30);
		frame.getContentPane().add(password);
		
		bdayMonth = new JTextField();
		bdayMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bdayMonth.setColumns(10);
		bdayMonth.setBounds(101, 162, 81, 30);
		frame.getContentPane().add(bdayMonth);
		
		bdayDay = new JTextField();
		bdayDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bdayDay.setColumns(10);
		bdayDay.setBounds(192, 162, 65, 30);
		frame.getContentPane().add(bdayDay);
		
		bdayYear = new JTextField();
		bdayYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bdayYear.setColumns(10);
		bdayYear.setBounds(267, 162, 65, 30);
		frame.getContentPane().add(bdayYear);
		
		userSubmit = new JButton("Submit");
		userSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strforeName = firstName.getText();
				String strsurname = lastName.getText();
				
				
				user.add(new User(strforeName, strsurname));
				
				
				//for(int i=0; i<user2.size(); i++)
			//	{
				//	System.out.println(user2.get(i).getForeName());
					
			//	}
				
				
				
				System.out.println();
				System.out.println();
			}
		});
		userSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		userSubmit.setBounds(101, 225, 200, 50);
		frame.getContentPane().add(userSubmit);

		JTextArea ListArea = new JTextArea();
		ListArea.setFont(new Font("Monospaced", Font.ITALIC, 14));
		ListArea.setBounds(101, 368, 231, 157);
		frame.getContentPane().add(ListArea);
		
		JButton btnNewButton = new JButton("List All Users");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<User> userSorted = getUser();
				for(User a: userSorted)//printing the sorted list of names
			       listusers = listusers+ " " + a.getSurName() + ", "+a.getForeName() + "\n";
				ListArea.setText(listusers);
			}
			
			
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(102, 339, 136, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(10, 22, 80, 30);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(11, 65, 80, 30);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 106, 80, 30);
		frame.getContentPane().add(lblPassword);
		
		lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBirthday.setBounds(10, 162, 80, 30);
		frame.getContentPane().add(lblBirthday);
		
		lblMonth = new JLabel("Month");
		lblMonth.setBounds(101, 200, 46, 14);
		frame.getContentPane().add(lblMonth);
		
		lblDay = new JLabel("Day");
		lblDay.setBounds(192, 200, 46, 14);
		frame.getContentPane().add(lblDay);
		
		lblYear = new JLabel("Year");
		lblYear.setBounds(267, 200, 46, 14);
		frame.getContentPane().add(lblYear);
		
	}
	

	public ArrayList<User> getUser() {
		Collections.sort(user, User.userNameComparator);
		
		return user;
	}

	public void setUser(ArrayList<User> user) {
		this.user = user;
	}
}
