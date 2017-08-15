package Database;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import View.HomeScreen;
import net.proteanit.sql.DbUtils;

public class DatabaseManager {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public DatabaseManager() {
		conn = Database.ConnecrDb();
	}

	//method to send all the details to the database
	public void newVersion(String Date, String CustomerName, String TelephoneNumber, String VehicleNumber, String Milage){
		try{
			conn = Database.ConnecrDb();
			String sql = "Insert into Customer_Details(Date, CustomerName, TelephoneNumber, VehicleNumber, Milage, Names, qty, Rate, Amount ) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			String names = "";
			String Qty = "";
			String Rate = "";
			String Amount = "";
			
			for (int i = 0; i < HomeScreen.Names.size(); i++) {
				names+=HomeScreen.Names.get(i) + "+";
			}
			
			for (int i = 0; i < HomeScreen.qty.size(); i++) {
				Qty+=HomeScreen.qty.get(i) + "+";
			}
			
			for (int i = 0; i < HomeScreen.rate.size(); i++) {
				Rate+=HomeScreen.rate.get(i) + "+";
			}
			
			for (int i = 0; i < HomeScreen.amount.size(); i++) {
				Amount+=HomeScreen.amount.get(i) + "+";
			}
			
			pst.setString(1, Date);
			pst.setString(2, CustomerName);
			pst.setString(3, TelephoneNumber);
			pst.setString(4, VehicleNumber);
			pst.setString(5, Milage);
			pst.setString(6, names);
			pst.setString(7, Qty);
			pst.setString(8, Rate);
			pst.setString(9, Amount);
			pst.execute();
			
		}catch(Exception e){
			System.out.println("New Version : " + e);
		}
		
	}

	// this method for getting the invoice number
	public int getInvoiceNumber() {
		conn = Database.ConnecrDb();

		int invoiceNumber = 0;
		// System.out.println("database name : " + name);
		String sql = "SELECT invoice_Number FROM  Customer_Details ";

		try {

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				invoiceNumber = (rs.getInt("Invoice_number"));
				
			}
			 //System.out.println("this is the current invoice" + invoiceNumber);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}finally{
			try{
				rs.close();
				pst.close();
				conn.close();

			}catch(Exception e){
				
			}
		}
		return invoiceNumber;
	}

	// to get the data from the database
	public void updateCustomerTable(JTable tableRoot) {
		conn = Database.ConnecrDb();

		try {
			String sql = "Select Invoice_Number, Date, CustomerName, TelephoneNumber, VehicleNumber, Milage from Customer_details";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			tableRoot.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			System.out.println("Table errors : " + e);
		}finally{
			try{
				rs.close();
				pst.close();
				conn.close();

			}catch(Exception e){
				
			}
		}
	}

	// to search data from the database
	public void searchTable(JTable tableRoot, String name) {
		conn = Database.ConnecrDb();

		try {
			String sql = "Select Invoice_Number, Date, CustomerName, TelephoneNumber, VehicleNumber, Milage FROM customer_Details WHERE invoice_number LIKE '%"
					+ name + "%' OR customerName LIKE '%" + name + "%' OR date LIKE '%" + name
					+ "%' OR telephoneNumber LIKE '%" + name + "%' OR vehicleNumber LIKE '%" + name + "%'  ";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			tableRoot.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			System.out.println("Table errors : " + e);
		}finally{
			try{
				rs.close();
				pst.close();
				conn.close();

			}catch(Exception e){
				
			}
		}
	}

	public void deleteFromTable(JTable table, String row) {
		conn = Database.ConnecrDb();

		try {
			String sql = "delete from customer_Details where invoice_Number = '" + row + "'";
			System.out.println(row);
			pst = conn.prepareStatement(sql);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Deleted!", "Sanjeewa Auto A/C and Body Wash",
					JOptionPane.WARNING_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pst.close();
				conn.close();

			}catch(Exception e){
				
			}
		}
	}


}
