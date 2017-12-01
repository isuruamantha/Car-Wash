package View;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.itextpdf.tool.xml.html.ParaGraph;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JCheckBox;

public class Quotation extends JFrame {

    private boolean isHeaderNeeded = true;

    private JPanel contentPane;
    private JTextField addressLine1_textField;
    private JTextField addressLine2_textField;
    private JTextField addressLine3_textField;
    private JTextField addressLine6_textField;
    private JTextField addressLine4_textField;
    private JTextField addressLine5_textField;
    private JLabel lblDear;
    private JTextField sir_madam_textField;
    private JLabel lblCallingPrice;
    private JTextField vehicleNumber_textField;
    private JLabel airCondition_lblNewLabel;
    private JLabel toFixAC_lblNewLabel;
    private JLabel refillOIl_lblNewLabel;
    private JLabel serviceCharges_lblNewLabel_2;
    private JLabel lblTotal;
    private JTextField number1_textField;
    private JTextField number2_textField;
    private JTextField number3_textField;
    private JTextField number4_textField;
    private JTextField Total_textField_4;
    private JLabel lblThankYou;
    private JButton btnPrint;

    // variables for the document
    private String addressline1;
    private String addressline2;
    private String addressline3;
    private String addressline4;
    private String addressline5;
    private String addressline6;
    private JTextField other1_textField;
    private JTextField other5_textField;
    private JTextField other2_textField;
    private JTextField other4_textField;
    private JTextField other3_textField;
    private JTextField otheramount1_textField;
    private JTextField otheramount2_textField;
    private JTextField otheramount3_textField;
    private JTextField otheramount4_textField;
    private JTextField otheramount5_textField;
    private JLabel background_Label;
    private JButton btnBack;
    private String name;
    private JCheckBox chckbxPrintWithoutHeader;
    private JCheckBox chckbxPrintWithHeader;

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Quotation frame = new Quotation();
                    frame.setVisible(true);
                    // this is for maximize the window and hide the restore
                    // button
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
                    frame.setResizable(false);
                    frame.setTitle("Sanjeewa Auto A/C and Body Wash");

                    // java.net.URL url =
                    // ClassLoader.getSystemResource("images/transport157.png");
                    // Toolkit kit = Toolkit.getDefaultToolkit();
                    // java.awt.Image imgq = kit.createImage(url);
                    // frame.setIconImage(imgq);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Quotation() {

        UIManager.put("RootPane.setupButtonVisible", false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        chckbxPrintWithoutHeader = new JCheckBox("Print without header");
        chckbxPrintWithoutHeader.setBounds(205, 7, 139, 23);
        contentPane.add(chckbxPrintWithoutHeader);

        chckbxPrintWithHeader = new JCheckBox("Print with header");
        chckbxPrintWithHeader.setBounds(28, 7, 128, 23);
        contentPane.add(chckbxPrintWithHeader);

        addressLine1_textField = new JTextField();
        addressLine1_textField.setBounds(321, 47, 264, 20);
        contentPane.add(addressLine1_textField);
        addressLine1_textField.setColumns(10);

        addressLine2_textField = new JTextField();
        addressLine2_textField.setColumns(10);
        addressLine2_textField.setBounds(321, 70, 264, 20);
        contentPane.add(addressLine2_textField);

        addressLine3_textField = new JTextField();
        addressLine3_textField.setColumns(10);
        addressLine3_textField.setBounds(321, 94, 264, 20);
        contentPane.add(addressLine3_textField);

        addressLine6_textField = new JTextField();
        addressLine6_textField.setColumns(10);
        addressLine6_textField.setBounds(321, 164, 264, 20);
        contentPane.add(addressLine6_textField);

        addressLine4_textField = new JTextField();
        addressLine4_textField.setColumns(10);
        addressLine4_textField.setBounds(321, 117, 264, 20);
        contentPane.add(addressLine4_textField);

        addressLine5_textField = new JTextField();
        addressLine5_textField.setColumns(10);
        addressLine5_textField.setBounds(321, 140, 264, 20);
        contentPane.add(addressLine5_textField);

        lblDear = new JLabel("Dear ");
        lblDear.setBounds(321, 208, 34, 14);
        contentPane.add(lblDear);

        sir_madam_textField = new JTextField();
        sir_madam_textField.setBounds(358, 205, 79, 20);
        contentPane.add(sir_madam_textField);
        sir_madam_textField.setColumns(10);

        lblCallingPrice = new JLabel("Calling prices to repair the vehicle numbered ");
        lblCallingPrice.setBounds(542, 265, 264, 14);
        contentPane.add(lblCallingPrice);

        vehicleNumber_textField = new JTextField();
        vehicleNumber_textField.setBounds(805, 262, 111, 20);
        contentPane.add(vehicleNumber_textField);
        vehicleNumber_textField.setColumns(10);

        airCondition_lblNewLabel = new JLabel("To aircondition the vehicle (134 A A/C)gas filling) - ");
        airCondition_lblNewLabel.setBounds(411, 316, 252, 14);
        contentPane.add(airCondition_lblNewLabel);

        toFixAC_lblNewLabel = new JLabel("To fix the (A/C) filter - ");
        toFixAC_lblNewLabel.setBounds(411, 341, 215, 14);
        contentPane.add(toFixAC_lblNewLabel);

        refillOIl_lblNewLabel = new JLabel("To refill 134 oil - ");
        refillOIl_lblNewLabel.setBounds(411, 366, 215, 14);
        contentPane.add(refillOIl_lblNewLabel);

        serviceCharges_lblNewLabel_2 = new JLabel("Service charges - ");
        serviceCharges_lblNewLabel_2.setBounds(410, 391, 216, 14);
        contentPane.add(serviceCharges_lblNewLabel_2);

        lblTotal = new JLabel("Total = ");
        lblTotal.setBounds(580, 562, 46, 14);
        contentPane.add(lblTotal);

        number1_textField = new JTextField();
        number1_textField.setBounds(661, 313, 111, 20);
        contentPane.add(number1_textField);
        number1_textField.setColumns(10);

        number2_textField = new JTextField();
        number2_textField.setColumns(10);
        number2_textField.setBounds(661, 338, 111, 20);
        contentPane.add(number2_textField);

        number3_textField = new JTextField();
        number3_textField.setColumns(10);
        number3_textField.setBounds(661, 363, 111, 20);
        contentPane.add(number3_textField);

        number4_textField = new JTextField();
        number4_textField.setColumns(10);
        number4_textField.setBounds(661, 388, 111, 20);
        contentPane.add(number4_textField);

        Total_textField_4 = new JTextField();
        Total_textField_4.setColumns(10);
        Total_textField_4.setBounds(661, 559, 111, 20);
        contentPane.add(Total_textField_4);

        lblThankYou = new JLabel("Thanking you,");
        lblThankYou.setBounds(397, 613, 67, 14);
        contentPane.add(lblThankYou);

        btnPrint = new JButton("Print");
        btnPrint.setBackground(new Color(0, 255, 255));
        btnPrint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPrint.setIcon(new ImageIcon(Quotation.class.getResource("/Images/print-icon.png")));
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printDetails();
            }
        });
        btnPrint.setBounds(911, 667, 89, 33);
        contentPane.add(btnPrint);

        other1_textField = new JTextField();
        other1_textField.setBounds(411, 416, 227, 20);
        contentPane.add(other1_textField);
        other1_textField.setColumns(10);

        other5_textField = new JTextField();
        other5_textField.setColumns(10);
        other5_textField.setBounds(411, 502, 227, 20);
        contentPane.add(other5_textField);

        other2_textField = new JTextField();
        other2_textField.setColumns(10);
        other2_textField.setBounds(411, 438, 227, 20);
        contentPane.add(other2_textField);

        other4_textField = new JTextField();
        other4_textField.setColumns(10);
        other4_textField.setBounds(411, 481, 227, 20);
        contentPane.add(other4_textField);

        other3_textField = new JTextField();
        other3_textField.setColumns(10);
        other3_textField.setBounds(411, 459, 227, 20);
        contentPane.add(other3_textField);

        otheramount1_textField = new JTextField();
        otheramount1_textField.setBounds(661, 416, 111, 20);
        contentPane.add(otheramount1_textField);
        otheramount1_textField.setColumns(10);

        otheramount2_textField = new JTextField();
        otheramount2_textField.setColumns(10);
        otheramount2_textField.setBounds(661, 438, 111, 20);
        contentPane.add(otheramount2_textField);

        otheramount3_textField = new JTextField();
        otheramount3_textField.setColumns(10);
        otheramount3_textField.setBounds(661, 459, 111, 20);
        contentPane.add(otheramount3_textField);

        otheramount4_textField = new JTextField();
        otheramount4_textField.setColumns(10);
        otheramount4_textField.setBounds(661, 481, 111, 20);
        contentPane.add(otheramount4_textField);

        otheramount5_textField = new JTextField();
        otheramount5_textField.setColumns(10);
        otheramount5_textField.setBounds(661, 502, 111, 20);
        contentPane.add(otheramount5_textField);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(0, 255, 255));
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HomeScreen().main();
                dispose();
            }
        });
        btnBack.setIcon(new ImageIcon(Quotation.class.getResource("/Images/Back-2-2-icon.png")));
        btnBack.setBounds(805, 667, 96, 33);
        contentPane.add(btnBack);

        JButton btnCalculate = new JButton("Calculate Sum");
        btnCalculate.setBackground(new Color(0, 255, 255));
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    float sum = 0;
                    if (!(number1_textField.getText().equals("")))
                        sum += Integer.parseInt(number1_textField.getText());
                    if (!(number2_textField.getText().equals(""))) {
                        System.out.println("step 1");
                        sum += Integer.parseInt(number2_textField.getText());
                        System.out.println("printed");
                    }
                    if (!(number3_textField.getText().equals("")))
                        sum += Integer.parseInt(number3_textField.getText());
                    if (!(number4_textField.getText().equals("")))
                        sum += Integer.parseInt(number4_textField.getText());
                    if (!(otheramount1_textField.getText().equals("")))
                        sum += Integer.parseInt(otheramount1_textField.getText());
                    if (!(otheramount2_textField.getText().equals("")))
                        sum += Integer.parseInt(otheramount2_textField.getText());
                    if (!(otheramount3_textField.getText().equals("")))
                        sum += Integer.parseInt(otheramount3_textField.getText());
                    if (!(otheramount4_textField.getText().equals("")))
                        sum += Integer.parseInt(otheramount4_textField.getText());
                    if (!(otheramount5_textField.getText().equals("")))
                        sum += Integer.parseInt(otheramount5_textField.getText());
                    Total_textField_4.setText(String.valueOf(sum));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnCalculate.setBounds(855, 585, 128, 23);
        contentPane.add(btnCalculate);

        JCheckBox chckbxSir = new JCheckBox("Sir");
        chckbxSir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = "sir";
            }
        });
        chckbxSir.setBounds(443, 204, 62, 23);
        contentPane.add(chckbxSir);

        JCheckBox chckbxMadam = new JCheckBox("Madam");
        chckbxMadam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = "madam";
            }
        });
        chckbxMadam.setBounds(507, 204, 89, 23);
        contentPane.add(chckbxMadam);

        background_Label = new JLabel("");
        background_Label.setIcon(
                new ImageIcon(Quotation.class.getResource("/Images/tumblr_static_ddi5olaj3io8skk8o00wo04k8.jpg")));
        background_Label.setBounds(-23, -21, 1396, 779);
        contentPane.add(background_Label);
    }

    public void printDetails() {
        if (chckbxPrintWithHeader.isSelected()) {
            isHeaderNeeded = true;
            printWithHeader();
        } else if (chckbxPrintWithoutHeader.isSelected()) {
            isHeaderNeeded = false;
            printWithHeader();
//            printWithoutHeader();
        } else if (!(chckbxPrintWithHeader.isSelected() || chckbxPrintWithoutHeader.isSelected())) {
            JOptionPane.showMessageDialog(null, "Please select the method of printing!",
                    "Sanjeewa Auto A/C and Body Wash", JOptionPane.WARNING_MESSAGE);
        }
    }


    public void printWithHeader() {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Quotation.pdf"));
            document.open();

            if (isHeaderNeeded) {
//                Image image = Image.getInstance("F:\\Rapticon\\Car Wash\\Car Wash - Billing System\\src\\Images\\quotation-header.png");
                Image image = Image.getInstance("C:\\CarWashData\\quotation-header.png");
                document.add(image);
            } else {
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
            }
//

            document.add(new Paragraph(addressLine1_textField.getText()));
            document.add(new Paragraph(addressLine2_textField.getText()));
            document.add(new Paragraph(addressLine3_textField.getText()));
            document.add(new Paragraph(addressLine4_textField.getText()));
            document.add(new Paragraph(addressLine5_textField.getText() + "\n"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph(lblDear.getText() + name + ","));

            /*Create the table*/
            PdfPTable table = new PdfPTable(2);


            /*----------*/
            document.add(
                    new Paragraph("                 " + lblCallingPrice.getText() + vehicleNumber_textField.getText()));
            document.add(new Paragraph(
                    "                 ------------------------------------------------------------------------------"));
            document.add(new Paragraph(" "));

            table.addCell(getCell("Description", PdfPCell.ALIGN_CENTER));
            table.addCell(getCell( "Amount(Rs.)", PdfPCell.ALIGN_CENTER));

            table.addCell(getCell("\u2022 " + airCondition_lblNewLabel.getText(), PdfPCell.ALIGN_LEFT));
            table.addCell(getCell( number1_textField.getText(), PdfPCell.ALIGN_RIGHT));

            table.addCell(getCell("\u2022 " + toFixAC_lblNewLabel.getText(), PdfPCell.ALIGN_LEFT));
            table.addCell(getCell( number2_textField.getText(), PdfPCell.ALIGN_RIGHT));

            table.addCell(getCell("\u2022 " + refillOIl_lblNewLabel.getText(), PdfPCell.ALIGN_LEFT));
            table.addCell(getCell( number3_textField.getText(), PdfPCell.ALIGN_RIGHT));

            table.addCell(getCell("\u2022 " + serviceCharges_lblNewLabel_2.getText(), PdfPCell.ALIGN_LEFT));
            table.addCell(getCell( number4_textField.getText(), PdfPCell.ALIGN_RIGHT));


            if (!((other1_textField.getText().equals("")) && otheramount1_textField.getText().equals(""))) {
                table.addCell(getCell("\u2022 " + other1_textField.getText(), PdfPCell.ALIGN_LEFT));
                table.addCell(getCell( otheramount1_textField.getText(), PdfPCell.ALIGN_RIGHT));
            }
            if (!((other2_textField.getText().equals("")) && otheramount2_textField.getText().equals(""))) {
                table.addCell(getCell("\u2022 " + other2_textField.getText(), PdfPCell.ALIGN_LEFT));
                table.addCell(getCell( otheramount2_textField.getText(), PdfPCell.ALIGN_RIGHT));
            }
            if (!((other3_textField.getText().equals("")) && otheramount3_textField.getText().equals(""))) {
                table.addCell(getCell("\u2022 " + other3_textField.getText(), PdfPCell.ALIGN_LEFT));
                table.addCell(getCell( otheramount3_textField.getText(), PdfPCell.ALIGN_RIGHT));
            }
            if (!((other4_textField.getText().equals("")) && otheramount4_textField.getText().equals(""))) {
                table.addCell(getCell("\u2022 " + other4_textField.getText(), PdfPCell.ALIGN_LEFT));
                table.addCell(getCell( otheramount4_textField.getText(), PdfPCell.ALIGN_RIGHT));
            }
            if (!((other5_textField.getText().equals("")) && otheramount5_textField.getText().equals(""))) {
                table.addCell(getCell("\u2022 " + other5_textField.getText(), PdfPCell.ALIGN_LEFT));
                table.addCell(getCell( otheramount5_textField.getText(), PdfPCell.ALIGN_RIGHT));
            }

            table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
            table.addCell(getCell("---------------------", PdfPCell.ALIGN_RIGHT));

            table.addCell(getCell(lblTotal.getText(), PdfPCell.ALIGN_RIGHT));
            table.addCell(getCell( Total_textField_4.getText(), PdfPCell.ALIGN_RIGHT));

//            table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
//            table.addCell(getCell("---------------------", PdfPCell.ALIGN_CENTER));
//            table.addCell(getCell("", PdfPCell.ALIGN_LEFT));
//            table.addCell(getCell("---------------------", PdfPCell.ALIGN_CENTER));

            document.add(table);


            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Thank you for your intereset in our organization and look forward" +
                    " received your valued order in near future. "));
            document.add(new Paragraph(lblThankYou.getText()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(
                    "                                                                              ..................................."));

            document.close();

            File myFile = new File("quotation.pdf");
            Desktop.getDesktop().open(myFile);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Sanjeewa Auto A/C and Body Wash", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * When creating the pdf table
     *
     * @param text
     * @param alignment
     * @return
     */
    public PdfPCell getCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setHorizontalAlignment(alignment);
//        cell.setPadding(0);
//        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }


    public void printWithoutHeader() {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Quotation.pdf"));
            document.open();
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(addressLine1_textField.getText()));
            document.add(new Paragraph(addressLine2_textField.getText()));
            document.add(new Paragraph(addressLine3_textField.getText()));
            document.add(new Paragraph(addressLine4_textField.getText()));
            document.add(new Paragraph(addressLine5_textField.getText() + "\n"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph(lblDear.getText() + name));
            document.add(
                    new Paragraph("                 " + lblCallingPrice.getText() + vehicleNumber_textField.getText()));
            document.add(new Paragraph(
                    "                 -----------------------------------------------------------------------------"));
            document.add(new Paragraph(
                    "\u2022 " + airCondition_lblNewLabel.getText() + "      Rs." + number1_textField.getText()));
            document.add(new Paragraph("\u2022 " + toFixAC_lblNewLabel.getText()
                    + "                                                    Rs." + number2_textField.getText()));
            document.add(new Paragraph("\u2022 " + refillOIl_lblNewLabel.getText()
                    + "                                                            Rs." + number3_textField.getText()));
            document.add(new Paragraph("\u2022 " + serviceCharges_lblNewLabel_2.getText()
                    + "                                                          Rs." + number4_textField.getText()));
            document.add(new Paragraph(other1_textField.getText() + otheramount1_textField.getText()));
            document.add(new Paragraph(other2_textField.getText() + otheramount2_textField.getText()));
            document.add(new Paragraph(other3_textField.getText() + otheramount3_textField.getText()));
            document.add(new Paragraph(other4_textField.getText() + otheramount4_textField.getText()));
            document.add(new Paragraph(other5_textField.getText() + otheramount5_textField.getText()));
            document.add(new Paragraph(
                    "                                                                              --------------------------"));
            document.add(new Paragraph("                                                              "
                    + lblTotal.getText() + "    Rs." + Total_textField_4.getText()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("   " + lblThankYou.getText()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(
                    "                                                                              ..................................."));

            document.close();

            File myFile = new File("quotation.pdf");
            Desktop.getDesktop().open(myFile);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Sanjeewa Auto A/C and Body Wash", JOptionPane.WARNING_MESSAGE);
        }

    }

}
