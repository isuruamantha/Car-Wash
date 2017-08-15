package View;

import java.awt.EventQueue;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import Database.Database;
import Database.DatabaseManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

import net.proteanit.sql.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;

public class DatabaseTable extends JFrame {

	// to print details
	String Names;
	String Qty;
	String Rate;
	String Amount;
	String date;

	//customer details
	String customerName;
	String telephoneNumber;
	String vehicleNumber;
	String Milage;

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField textField_search;
	private static JTable customer_table;
	private String Table_click;
	
	//ArrayList declration
	public static ArrayList<String> ArrayNames = new ArrayList<>();
	public static ArrayList<String> Arrayqty= new ArrayList<>();
	public static ArrayList<String> Arrayrate = new ArrayList<>();
	public static ArrayList<String> Arrayamount = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// this is for maximize the window and hide the restore
					// button

					DatabaseTable frame = new DatabaseTable();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setResizable(false);
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					frame.setTitle("Sanjeewa Auto A/C and Body Wash");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DatabaseTable() {

		DatabaseManager sendData = new DatabaseManager();
		conn = Database.ConnecrDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		UIManager.put("RootPane.setupButtonVisible", false);

		JButton print_Button = new JButton("Print");
		print_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		print_Button.setBackground(Color.CYAN);
		print_Button.setIcon(new ImageIcon(DatabaseTable.class.getResource("/Images/print-icon.png")));
		print_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// printWithHeader();

				conn = Database.ConnecrDb();

				try {
					int row = customer_table.getSelectedRow();
					Table_click = (customer_table.getModel().getValueAt(row, 0).toString());
					String sql = "select * from customer_details where invoice_number = '" + Table_click + "'  ";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					System.out.println("this is the table id : " + Table_click);
					if (rs.next()) {
						
						customerName = rs.getString("CustomerName");
						telephoneNumber = rs.getString("telephoneNumber");
						vehicleNumber = rs.getString("vehicleNumber");
						Milage = rs.getString("Milage");
						date = rs.getString("Date");
						Names = rs.getString("Names");
						Qty = rs.getString("qty");
						Rate = rs.getString("Rate");
						Amount = rs.getString("Amount");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e, "Sanjeewa Auto A/C and Body Wash",
							JOptionPane.WARNING_MESSAGE);
				} finally {
					try {
						rs.close();
						pst.close();
						conn.close();

					} catch (Exception e) {

					}
				}

//				System.out.println("Before removing : " + Names);
				String after = Pattern.quote("+");
				String[] NamesAfter = Names.split(after);
				String[] QtyAfter = Qty.split(after);
				String[] RateAfter = Rate.split(after);
				String[] AmountAfter = Amount.split(after);
				
				for (String val: NamesAfter) {
				    val.replaceAll("\\+", "");
				    ArrayNames.add(val);
				}
				
				for (String val: QtyAfter) {
				    val.replaceAll("\\+", "");
				    Arrayqty.add(val);
				}
				
				for (String val: RateAfter) {
				    val.replaceAll("\\+", "");
				    Arrayrate.add(val);
				}
				
				for (String val: AmountAfter) {
				    val.replaceAll("\\+", "");
				    Arrayamount.add(val);
				}
				System.out.println("Array names after removal : " + ArrayNames);
				printWithHeader();

				ArrayNames.clear();
				Arrayqty.clear();
				Arrayrate.clear();
				Arrayamount.clear();
			}
		});
		print_Button.setBounds(603, 516, 89, 25);
		contentPane.add(print_Button);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(826, 516, 100, 27);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HomeScreen().main();
				dispose();
			}
		});
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBackground(new Color(0, 255, 255));
		btnBack.setIcon(new ImageIcon(DatabaseTable.class.getResource("/Images/Back-2-2-icon.png")));

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(714, 516, 102, 26);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// sendData.deleteFromTable(customer_table, Table_click);
				String sql = "delete from customer_Details where invoice_Number = ?";
				try {
					conn = Database.ConnecrDb();
					conn.setAutoCommit(true);
					int row = customer_table.getSelectedRow();
					Table_click = (customer_table.getModel().getValueAt(row, 0).toString());
					System.out.println("this is the deleted invoice Number : " + Table_click);
					pst = conn.prepareStatement(sql);
					pst.setString(1, Table_click);
					pst.execute();

					JOptionPane.showMessageDialog(null, "Deleted!", "Sanjeewa Auto A/C and Body Wash",
							JOptionPane.WARNING_MESSAGE);
					new DatabaseTable().main();
					dispose();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						rs.close();
						pst.close();
						conn.close();

					} catch (Exception e) {

					}
				}
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setIcon(new ImageIcon(DatabaseTable.class.getResource("/Images/Close-2-icon.png")));

		JLabel lblCustomerDetailsTable = new JLabel("Customer Details Table");
		lblCustomerDetailsTable.setBounds(372, 11, 138, 14);
		contentPane.add(lblCustomerDetailsTable);

		JLabel lblSearch = new JLabel("Search :");
		lblSearch.setBounds(26, 46, 64, 14);
		contentPane.add(lblSearch);

		textField_search = new JTextField();
		textField_search.setBounds(100, 36, 776, 27);
		contentPane.add(textField_search);
		textField_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				sendData.searchTable(customer_table, textField_search.getText());
			}
		});

		textField_search.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(0, 255, 255));
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setIcon(new ImageIcon(DatabaseTable.class.getResource("/Images/search-icon.png")));
		btnSearch.setBounds(889, 37, 109, 33);
		contentPane.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 988, 376);
		contentPane.add(scrollPane);

		customer_table = new JTable();
		customer_table.setBounds(0, 102, 1330, 486);
		// contentPane.add(customer_table);
		scrollPane.setViewportView(customer_table);

		DatabaseManager updateTalbe = new DatabaseManager();
		updateTalbe.updateCustomerTable(customer_table);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(
				new ImageIcon(DatabaseTable.class.getResource("/Images/tumblr_static_ddi5olaj3io8skk8o00wo04k8.jpg")));
		label_1.setBounds(-30, -19, 1420, 772);
		contentPane.add(label_1);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendData.searchTable(customer_table, textField_search.getText());
			}
		});

	}

	private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

		// create a new cell with the specified Text and Font
		PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		// set the cell alignment
		cell.setHorizontalAlignment(align);
		// set the cell column span in case you want to merge two or more cells
		cell.setColspan(colspan);
		// in case there is no text and you wan to create an empty row
		if (text.trim().equalsIgnoreCase("")) {
			cell.setMinimumHeight(10f);
		}
		// add the call to the table
		table.addCell(cell);

	}
	
	public void printWithHeader(){
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("Quotation.pdf"));
			document.addAuthor("isuru");
			// special font sizes
			Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
			Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);
			document.open();

//			Image image = Image
//					.getInstance("C:\\Users\\JS\\Google Drive\\CarWash\\SanjeewaCarWash\\quotation-header.png");
			Image image = Image
					.getInstance("C:\\Users\\user\\Google Drive\\Java Work Place - Eclipse 2\\Car Wash - Billing System\\Images\\quotation-header.png");
			document.add(image);
			// create a paragraph
			Paragraph paragraph = new Paragraph("");

			document.add(new Paragraph("Customer Name: " + customerName));
			document.add(new Paragraph("Vehicle Number : " + vehicleNumber ));
			document.add(new Paragraph("Milage : " + Milage));
			document.add(new Paragraph("Date : " + date));
			document.add(new Paragraph(" "));
			// specify column widths
			float[] columnWidths = { 0.8f, 5f, 2f, 2f };
			// create PDF table with the given widths
			PdfPTable table = new PdfPTable(columnWidths);
			// set table width a percentage of the page width
			table.setWidthPercentage(90f);

			// insert column headings
			insertCell(table, "Qty", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Description", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Rate", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Amount(Rs.)", Element.ALIGN_LEFT, 1, bfBold12);
			table.setHeaderRows(1);
			
			// insert an empty row
			insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
			// create section heading by cell merging

			// just some random data to fill
			for (int x = 0; x < Arrayamount.size() ; x++) {
				
				insertCell(table, Arrayqty.get(x), Element.ALIGN_RIGHT, 1, bf12);
				insertCell(table, ArrayNames.get(x), Element.ALIGN_LEFT, 1, bf12);
				insertCell(table, Arrayrate.get(x), Element.ALIGN_RIGHT, 1, bf12);
				insertCell(table, Arrayamount.get(x), Element.ALIGN_RIGHT, 1, bf12);
			}
//			insertCell(table, "Total = ", Element.ALIGN_RIGHT, 3, bfBold12);
//			insertCell(table, String.valueOf(total) , Element.ALIGN_RIGHT, 1, bfBold12);

			// add the PDF table to the paragraph
			paragraph.add(table);
			// add the paragraph to the document
			document.add(paragraph);
			
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("                                                                                                          ............................."));
			document.add(new Paragraph("                                                                                                 (Sanjeewa auto A/c & body wash)"));
			document.add(new Paragraph("                                                                                                                  Owner"));
			document.close();

			File myFile = new File("quotation.pdf");
			Desktop.getDesktop().open(myFile);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Sanjeewa Auto A/C and Body Wash", JOptionPane.WARNING_MESSAGE);
		}

		
	}

}
