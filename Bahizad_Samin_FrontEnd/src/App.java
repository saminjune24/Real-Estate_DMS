import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.ResultSet;


import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.awt.event.ActionEvent;


import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/** @author Samin Bahizad
This is the main app where the GUI is made */
public class App implements ActionListener {

	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable properties;
	private JTable agents;
	private JTable prices;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
		showTableData();
		showTableData1();
		showTableData2();
		showAvgHouseSize();
		showPropertyCount();
		showAgentCount();
		showAvgPrice();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 1250, 702);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPropertyID = new JLabel("Property ID");
		lblPropertyID.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPropertyID.setBounds(43, 44, 158, 32);
		frame.getContentPane().add(lblPropertyID);
		
		JLabel lblSquareFeet = new JLabel("Square feet");
		lblSquareFeet.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSquareFeet.setBounds(43, 86, 120, 32);
		frame.getContentPane().add(lblSquareFeet);
		
		JLabel lblPropertyTypeId = new JLabel("Property Type ID");
		lblPropertyTypeId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPropertyTypeId.setBounds(43, 128, 165, 32);
		frame.getContentPane().add(lblPropertyTypeId);
		
		JLabel lblPropertyStatusId = new JLabel("Property Status ID");
		lblPropertyStatusId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPropertyStatusId.setBounds(43, 176, 185, 32);
		frame.getContentPane().add(lblPropertyStatusId);
		
		JLabel lblYearBuilt = new JLabel("Year Built");
		lblYearBuilt.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblYearBuilt.setBounds(43, 218, 158, 32);
		frame.getContentPane().add(lblYearBuilt);
		
		JLabel lblPriceId = new JLabel("Price ID");
		lblPriceId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPriceId.setBounds(43, 270, 158, 32);
		frame.getContentPane().add(lblPriceId);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAddress.setBounds(43, 312, 158, 32);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblBeds = new JLabel("Beds");
		lblBeds.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblBeds.setBounds(43, 354, 158, 32);
		frame.getContentPane().add(lblBeds);
		
		JLabel lblBaths = new JLabel("Baths");
		lblBaths.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblBaths.setBounds(43, 396, 158, 32);
		frame.getContentPane().add(lblBaths);
		
		JLabel lblLocationId = new JLabel("Location ID");
		lblLocationId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLocationId.setBounds(43, 438, 158, 32);
		frame.getContentPane().add(lblLocationId);
		
		JLabel lblAgentId = new JLabel("Agent ID");
		lblAgentId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAgentId.setBounds(43, 480, 158, 32);
		frame.getContentPane().add(lblAgentId);
		
		textField = new JTextField();
		textField.setBounds(228, 50, 185, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(228, 92, 185, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 134, 185, 30);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(228, 182, 185, 30);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(228, 222, 185, 30);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(228, 270, 185, 30);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(228, 318, 185, 30);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(228, 360, 185, 30);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(228, 400, 185, 30);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(228, 444, 185, 30);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(228, 486, 185, 30);
		frame.getContentPane().add(textField_10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAdd.setBounds(458, 54, 120, 41);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);



		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.setBounds(458, 105, 120, 41);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(this);
		
		JButton btnUpdate= new JButton("UPDATE");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.setBounds(458, 156, 120, 41);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		
		JLabel lblNewLabel_1 = new JLabel("Property Count");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1.setBounds(43, 567, 120, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Average Square Footage");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(43, 533, 185, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		properties = new JTable();
		properties.setSurrendersFocusOnKeystroke(true);
		properties.setFillsViewportHeight(true);
		properties.setBounds(648, 54, 554, 198);
		frame.getContentPane().add(properties);
		
		agents = new JTable();
		agents.setBounds(645, 325, 283, 269);
		frame.getContentPane().add(agents);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(601, 10, 2, 645);
		frame.getContentPane().add(separator);
		
		prices = new JTable();
		prices.setBounds(938, 325, 288, 269);
		frame.getContentPane().add(prices);
		
		JLabel lblNewLabel_1_2 = new JLabel("Agent Count");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(43, 600, 120, 16);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Average Price");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(43, 629, 120, 16);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_11.setBackground(SystemColor.window);
		textField_11.setForeground(SystemColor.desktop);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(228, 534, 133, 19);
//		showAvgHouseSize();
		frame.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_12.setBackground(SystemColor.window);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(228, 568, 133, 19);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_13.setEditable(false);
		textField_13.setBackground(SystemColor.window);
		textField_13.setColumns(10);
		textField_13.setBounds(228, 601, 133, 19);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.BOLD, 10));
		textField_14.setBackground(SystemColor.window);
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(228, 630, 133, 19);
		frame.getContentPane().add(textField_14);
		
		JLabel lblPropertiesTable = new JLabel("Properties Table");
		lblPropertiesTable.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPropertiesTable.setBounds(850, 10, 158, 32);
		frame.getContentPane().add(lblPropertiesTable);
		
		JLabel lblAgentsTable = new JLabel("Agents Table");
		lblAgentsTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgentsTable.setBounds(706, 298, 158, 32);
		frame.getContentPane().add(lblAgentsTable);
		
		JLabel lblPropertyPriceTable = new JLabel("Property Price Table");
		lblPropertyPriceTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPropertyPriceTable.setBounds(977, 298, 214, 32);
		frame.getContentPane().add(lblPropertyPriceTable);
		
		JLabel lblAddDeleteUpdate = new JLabel("Add, Delete,and Update Properties Below");
		lblAddDeleteUpdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblAddDeleteUpdate.setBounds(62, 2, 489, 32);
		frame.getContentPane().add(lblAddDeleteUpdate);
		

	}
	private void showTableData(){
		
		try{
		String connectionString= 
				"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try(Connection connection = DriverManager.getConnection(connectionString)){
		String sql = "SELECT * FROM Properties";
		pst = connection.prepareStatement(sql);
		rs=pst.executeQuery();
		properties.setModel(DbUtils.resultSetToTableModel(rs));
		

				}
				catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);

				}

			//new String[] {
			//	"P_ID", "Square_ft", "Property_TypeID", "P_StatusID", "Year_Built", "Price_ID", "P_Address", "Beds", "Baths", "Agent_ID", "Location_ID"
		//	}
	//	));
		properties.getColumnModel().getColumn(0).setPreferredWidth(60);
		
		}

		
		
		catch(Exception ex){
		JOptionPane.showMessageDialog(null, ex);
		}
	}
	private void showAvgPrice() {
		try{
		String connectionString= 
				"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try(Connection connection = DriverManager.getConnection(connectionString)){
		String sql = "select avg(Listed_Price) as average_Price from Price";
		pst = connection.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			textField_14.setText(String.valueOf(rs.getInt(1)));
		}
				}
				catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);

				}
		}
		catch(Exception ex){
		JOptionPane.showMessageDialog(null, ex);
		}
		
	}
private void showAvgHouseSize(){
	try{
		String connectionString= 
				"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try(Connection connection = DriverManager.getConnection(connectionString)){
		String sql = "select avg(Square_feet) as average_size from Properties";
		pst = connection.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			textField_11.setText(String.valueOf(rs.getInt(1)));
		}
				}
				catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);

				}
		}
		catch(Exception ex){
		JOptionPane.showMessageDialog(null, ex);
		}
		
	}

private void showPropertyCount(){
	try{
		String connectionString= 
				"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try(Connection connection = DriverManager.getConnection(connectionString)){
		String sql = "select count(Property_ID) from Properties";
		pst = connection.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			textField_12.setText(String.valueOf(rs.getInt(1)));
		}
				}
				catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);

				}
		}
		catch(Exception ex){
		JOptionPane.showMessageDialog(null, ex);
		}
		
	}
private void showAgentCount(){
	try{
		String connectionString= 
				"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try(Connection connection = DriverManager.getConnection(connectionString)){
		String sql = "select count(AgentID) from Agents";
		pst = connection.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			textField_13.setText(String.valueOf(rs.getInt(1)));
		}
				}
				catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);

				}
		}
		catch(Exception ex){
		JOptionPane.showMessageDialog(null, ex);
		}
		
	}
	private void showTableData1(){
		
		try{
		String connectionString= 
				"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try(Connection connection = DriverManager.getConnection(connectionString)){
		String sql = "SELECT * FROM Agents";
		pst = connection.prepareStatement(sql);
		rs=pst.executeQuery();
		agents.setModel(DbUtils.resultSetToTableModel(rs));

				}
				catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);

				}


		agents.getColumnModel().getColumn(0).setPreferredWidth(60);
		
		}

		
		
		catch(Exception ex){
		JOptionPane.showMessageDialog(null, ex);
		}
	}
private void showTableData2(){
		
		try{
		String connectionString= 
				"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try(Connection connection = DriverManager.getConnection(connectionString)){
		String sql = "SELECT * FROM Price";
		pst = connection.prepareStatement(sql);
		rs=pst.executeQuery();
		prices.setModel(DbUtils.resultSetToTableModel(rs));

				}
				catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex);

				}


		prices.getColumnModel().getColumn(0).setPreferredWidth(60);
		
		}

		
		
		catch(Exception ex){
		JOptionPane.showMessageDialog(null, ex);
		}
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String action = e.getActionCommand();
			if(action.equals("ADD"))
			{
				addOperation();
			}else if(action.equals("UPDATE"))
			{
				updateOperation();
			}else if(action.equals("DELETE"))
			{
				deleteOperation();
			}
			
		}
			
		private void addOperation() {
			
			String connectionString= 
					"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
					try(Connection connection = DriverManager.getConnection(connectionString)){

		
				String sql = "INSERT INTO Properties " + "VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
				pst = connection.prepareStatement(sql);
				pst.setString(1,textField.getText());
				pst.setString(2,textField_1.getText().toString());
				pst.setString(3,textField_2.getText().toString());
				pst.setString(4,textField_3.getText().toString());
				pst.setString(5,textField_4.getText().toString());
				pst.setString(6,textField_5.getText().toString());
				pst.setString(7,textField_6.getText().toString());
				pst.setString(8,textField_7.getText().toString());
				pst.setString(9,textField_8.getText().toString());
				pst.setString(10,textField_9.getText().toString());
				pst.setString(11,textField_10.getText().toString());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "inserted successfully");
				showTableData();
				showAvgHouseSize();
				showPropertyCount();

					}
				}
				catch(SQLException | HeadlessException ex){
				JOptionPane.showMessageDialog(null, ex);

				}
		}
		private void deleteOperation() {
			String connectionString= 
					"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
			PreparedStatement pst = null;
			ResultSet rs = null;
			
				try(Connection connection = DriverManager.getConnection(connectionString)){
				
				String sql = "DELETE FROM Properties WHERE Property_ID =?";
				pst = connection.prepareStatement(sql);
				pst.setString(1,textField.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "deleted successfully");
				showTableData();
				showAvgHouseSize();
				showPropertyCount();


				}
				catch(SQLException | HeadlessException ex){
				JOptionPane.showMessageDialog(null, ex);
				}
				
		}
		private void updateOperation() {
			String connectionString= 
					"jdbc:sqlserver://DESKTOP-Q7IJH5L\\samin;Database=Bahizad_Samin_db;Port=1433;integratedSecurity=true";
			PreparedStatement pst = null;
			ResultSet rs = null;
			
				try(Connection connection = DriverManager.getConnection(connectionString)){
					//VALUES(5134,1800,1,0003,2000,458,'525 Pottsdamer Street', 4, 2, 200, 225);
				String sql = "UPDATE properties SET Square_feet=?,Property_TypeID=?,Property_StatusID=?, Year_Built=?, Price_ID=?,Property_Addr=?, bedrooms=?,bathrooms=?,Location_ID=?, AgentID=? WHERE Property_ID=?";
				pst = connection.prepareStatement(sql);
				pst.setString(11, textField.getText());
				pst.setString(1,textField_1.getText().toString());
				pst.setString(2,textField_2.getText().toString());
				pst.setString(3,textField_3.getText().toString());
				pst.setString(4,textField_4.getText().toString());
				pst.setString(5,textField_5.getText().toString());
				pst.setString(6,textField_6.getText().toString());
				pst.setString(7,textField_7.getText().toString());
				pst.setString(8,textField_8.getText().toString());
				pst.setString(9,textField_9.getText().toString());
				pst.setString(10,textField_10.getText().toString());
				 pst.executeUpdate();
				 JOptionPane.showMessageDialog(null, "updated successfully");
				 showTableData();
				 showAvgHouseSize();
				showPropertyCount();

				 }
				 catch(SQLException | HeadlessException ex){
				 JOptionPane.showMessageDialog(null, ex);
				 }}

}
				
	
			
				
			
		
			
		
		

