package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

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
import com.mysql.jdbc.PreparedStatement;
import Database.Database;
import Database.DatabaseManager;

public class HomeScreen extends JFrame {

    private JPanel contentPane;
    private JTextField textField_CustomerName;
    private JTextField textField_VehicleNumber;
    private JTextField textField_TelephoneNumber;
    private JTextField textField_Milage;
    private JTextField textField_others2;
    private JTextField textField_others3;
    private JTextField textField_others4;
    private JTextField textField_oil_qty;
    private JTextField textField_oil_rate;
    private JTextField textField_oil_amount;
    private JTextField textField_orings_qty;
    private JTextField textField_acFilter_qty;
    private JTextField textField_acFanMotor_qty;
    private JTextField textField_condenser_qty;
    private JTextField textField_cooler_qty;
    private JTextField textField_compressor_qty;
    private JTextField textField_hose_qty;
    private JTextField textField_welding_qty;
    private JTextField textField_raceBearing_qty;
    private JTextField textField_thermostat_qty;
    private JTextField textField_sonarLights_qty;
    private JTextField textField_blowerMotor_qty;
    private JTextField textField_acRegas_qty;
    private JTextField textField_cabinFilter_qty;
    private JTextField textField_electric_qty;
    private JTextField textField_relay_qty;
    private JTextField textField_connectedValve_qty;
    private JTextField textField_acFullService_qty;
    private JTextField textField_others2_qty;
    private JTextField textField_others3_qty;
    private JTextField textField_others4_qty;
    private JTextField textField_orings_rate;
    private JTextField textField_acFilter_Rate;
    private JTextField textField_fanMotor_rate;
    private JTextField textField_condenser_rate;
    private JTextField textField_cooler_rate;
    private JTextField textField_compressor_rate;
    private JTextField textField_hose_rate;
    private JTextField textField_welding_rate;
    private JTextField textField_raceBearing_rate;
    private JTextField textField_thermostat_rate;
    private JTextField textField_SonarLights_rate;
    private JTextField textField_bloweMotor_rate;
    private JTextField textField_acRegas_rate;
    private JTextField textField_cabinfilter_rate;
    private JTextField textField_electric_rate;
    private JTextField textField_relay_rate;
    private JTextField textField_connectedValve_rate;
    private JTextField textField_acFullService_rate;
    private JTextField textField_others2_rate;
    private JTextField textField_others3_rate;
    private JTextField textField_others4_rate;
    private JTextField textField_orings_amount;
    private JTextField textField_acFilter_amount;
    private JTextField textField_acFanMotor_amount;
    private JTextField textField_condenser_amount;
    private JTextField textField_cooler_amount;
    private JTextField textField_compressor_amount;
    private JTextField textField_hose_amount;
    private JTextField textField_welding_amount;
    private JTextField textField_raceBearing_amount;
    private JTextField textField_thermostat_amount;
    private JTextField textField_SonarLIghts_amount;
    private JTextField textField_blowerMotor_amount;
    private JTextField textField_acRegas_amount;
    private JTextField textField_cabinFilter_amount;
    private JTextField textField_electric_amount;
    private JTextField textField_relay_amount;
    private JTextField textField_connectedValve_amount;
    private JTextField textField_acFullService_amount;
    private JTextField textField_others2_amount;
    private JTextField textField_others3_amount;
    private JTextField textField_others4_amount;
    private JCheckBox chckbx_Oil;
    private JCheckBox chckbxorings;
    private JCheckBox chckbxAcFilter;
    private JCheckBox chckbxAcFanMotor;
    private JCheckBox chckbxCondenser;
    private JCheckBox chckbxCooler;
    private JCheckBox chckbxCompressor;
    private JCheckBox chckbxHorse;
    private JCheckBox chckbxWelding;
    private JCheckBox chckbxRacerBearing;
    private JCheckBox chckbxThermostat;
    private JCheckBox chckbxSonarLight;
    private JCheckBox chckbxBlowerMotor;
    private JCheckBox chckbxConnectedValve;
    private JCheckBox chckbxCabinFilter;
    private JCheckBox chckbxElectric;
    private JCheckBox chckbxRelay;
    private JCheckBox chckbxAcRegas;
    private JCheckBox chckbxAcFullService;
    private JCheckBox checkBox_others2;
    private JCheckBox checkBox_others3;
    private JCheckBox checkBox_others4;
    private JCheckBox oiling_checkbox;
    private JCheckBox chckbxFilterCleaning;
    private JCheckBox chckbxInteriorCleaningOnly;
    private JCheckBox chckbxCushionCleaning;
    private JCheckBox chckbxCarpetCleaning;
    private JCheckBox Oil_Orings_vaccume_regas_checkBox;
    private JCheckBox other5_checkbox;
    private JCheckBox other6_checkbox;
    private JCheckBox other7_checkbox;
    private JLabel total_label;
    private JLabel label_date;
    private int invoiceNumber;
    private static float total = 0;
    private JTextField OIling_qty_textField;
    private JTextField Oiling_rate_textField_1;
    private JTextField Oiling_amount_textField_2;
    private JTextField FilterCleaning_qty_textField_3;
    private JTextField FilterCleaning_rate_textField_4;
    private JTextField FilteCleaning_amount_textField_5;
    private JTextField InteriroCleaning_qty_textField_6;
    private JTextField InteriroCleaning_rate_textField_7;
    private JTextField InteriroCleaning_amount_textField_8;
    private JTextField CushionCleaning_qty_textField_9;
    private JTextField CushionCleaning_rate_textField_10;
    private JTextField CushionCleaning_amount_textField_11;
    private JTextField carpetCleaning_qty_textField_12;
    private JTextField carpetCleaning_rate_textField_13;
    private JTextField tcarpetCleaning__amount_extField_14;
    private JCheckBox chckbxEngineWash;
    private JTextField EngineWash_qty_textField;
    private JTextField engineWash_rate_textField_1;
    private JCheckBox chckbxBodyWash;
    private JCheckBox chckbxAcServices;
    private String months;
    private JCheckBox chckbxWithWarranty;


    // for the sql connection
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private JTextField engineWash_amount_textField_2;
    private JTextField other5_description_textField;
    private JTextField other6_description_textField;
    private JTextField other7_description_textField;
    private JTextField other5_qty_textField;
    private JTextField other6_qty_textField;
    private JTextField other7_qty_textField;
    private JTextField other5_rate_textField;
    private JTextField other6_rate_textField;
    private JTextField other7_rate_textField;
    private JTextField other5_amount_textField;
    private JTextField other6_amount_textField;
    private JTextField other7_amount_textField;
    private JTextField OIl_Orings_Qty_textField;
    private JTextField OIl_Orings_Rate_textField;
    private JTextField OIl_Orings_amount_textField;

    private int DisplayedinvoiceNumber;
    private JButton btnNewButton;
    private JTextField Warranty_textField;
    private JTextField months_textField;
    private JLabel lblMonths;
    private JPanel ACpanel;
    private JTabbedPane tabbedPane;
    private JPanel BodyWashPanel;

    //	ArrayList declrations for storing data
    public static ArrayList<String> Names;
    public static ArrayList<String> qty;
    public static ArrayList<String> rate;
    public static ArrayList<String> amount;

    private JTextField vaccum_cleaning_only_qty_textField;
    private JTextField vaccum_cleaning_only_Rate_textField;
    private JTextField vaccum_cleaning_only_amount_textField;
    private JTextField BodyWash_vaccumCleaningOnly_qty_textField;
    private JTextField BodyWash_vaccumCleaningOnly_rate_textField;
    private JTextField BodyWash_vaccumCleaningOnly_amount_textField;
    private JTextField cutandPolishVax_qty_textField;
    private JTextField cutandPolishVax_rate_textField;
    private JTextField cutandPolishVax_amount_textField;
    private JTextField vax_qty_textField;
    private JTextField vax_rate_textField;
    private JTextField vax_amount_textField;
    private JTextField bodyWashOnly_qty_textField;
    private JTextField bodyWashOnly_rate_textField;
    private JTextField bodyWashOnly_amount_textField;
    private JTextField aluminiumWelding_qty_textField;
    private JTextField aluminiumWelding_rate_textField;
    private JTextField aluminiumWelding_amount_textField;
    private JTextField oil_orings_AC_qty_textField;
    private JTextField oil_orings_AC_rate_textField;
    private JTextField oil_orings_AC_amount_textField;
    private JTextField resistant_qty_textField;
    private JTextField resistant_rate_textField;
    private JTextField resistant_amount_textField;
    private JTextField acBelt_qty_textFileld;
    private JTextField acBelt_rate_textFileld;
    private JTextField acBelt_amount_textFileld;
    private JTextField liquidLane_qty_textField;
    private JTextField liquidLane_rate_textField;
    private JTextField liquidLane_amount_textField;
    private JTextField Fittings_qty_textField;
    private JTextField Fittings_rate_textField;
    private JTextField Fittings_amount_textField;
    private JTextField AcGas_qty_textField;
    private JTextField AcGas_rate_textField;
    private JTextField texAcGas_amount_textFieldtField_2;
    private JTextField adjustmentPully_qty_textField;
    private JTextField adjustmentPully_rate_textField;
    private JTextField adjustmentPully_amount_textField;

    private JCheckBox chckbxAluminiumWelding;
    private JCheckBox chckbxForFullAc;
    private JCheckBox chckbxOilOringsAc;
    private JCheckBox chckbxAdjustmentPully;
    private JCheckBox chckbxResistant;
    private JCheckBox chckbxFittings;
    private JCheckBox chckbxAcBelt;
    private JCheckBox chckbxLiquidLane;
    private JCheckBox chckbxAcGas;
    private JCheckBox chckbxPrintWithoutHeader;
    private JCheckBox chckbxPrintWithHeader;
    private JCheckBox chckbxVaccumCleaningOnly;
    private JCheckBox chckbxCutPolish;
    private JCheckBox chckbxVax;
    private JCheckBox chckbxBodyWashOnly;
    private JCheckBox chckbxBodyWash_1;

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeScreen frame = new HomeScreen();
                    frame.setVisible(true);

                    // this is for maximize the window and hide the restore
                    // button
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setResizable(false);
                    frame.setTitle("Sanjeewa Auto A/C and Body Wash");
                    org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public HomeScreen() {

        System.out.println("Homescreen is working");

        // this is for maximize the window and hide the restore
        // button

        //initialize the arraylists
        Names = new ArrayList<String>();
        qty = new ArrayList<String>();
        rate = new ArrayList<String>();
        amount = new ArrayList<String>();

        conn = Database.ConnecrDb();
        // this object created for get the invoice number
        DatabaseManager getInvoiceNumber = new DatabaseManager();
        invoiceNumber = getInvoiceNumber.getInvoiceNumber();
//		System.out.println("Invoice number in Homescreen : " + invoiceNumbersansan);
        UIManager.put("RootPane.setupButtonVisible", false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 1024, 768);
        contentPane.add(tabbedPane);

        ACpanel = new JPanel();
        tabbedPane.addTab("A/C Service", null, ACpanel, null);
        ACpanel.setLayout(null);

        BodyWashPanel = new JPanel();
        tabbedPane.addTab("Body Wash", null, BodyWashPanel, null);
        BodyWashPanel.setLayout(null);

        JLabel lblSanjeewaAuto = new JLabel("Sanjeewa Auto A/C & Body Wash");
        lblSanjeewaAuto.setBounds(564, 0, 208, 29);
        ACpanel.add(lblSanjeewaAuto);

        chckbx_Oil = new JCheckBox("Oil");
        chckbx_Oil.setBounds(18, 138, 97, 23);
        ACpanel.add(chckbx_Oil);

        JLabel lblCustomerName = new JLabel("Customer Name :");
        lblCustomerName.setBounds(75, 34, 109, 23);
        ACpanel.add(lblCustomerName);

        textField_CustomerName = new JTextField();
        textField_CustomerName.setBounds(194, 34, 198, 20);
        ACpanel.add(textField_CustomerName);
        textField_CustomerName.setColumns(10);

        JLabel lblVehicleNumber = new JLabel("Vehicle Number :");
        lblVehicleNumber.setBounds(75, 55, 109, 23);
        ACpanel.add(lblVehicleNumber);

        textField_VehicleNumber = new JTextField();
        textField_VehicleNumber.setBounds(194, 58, 198, 20);
        ACpanel.add(textField_VehicleNumber);
        textField_VehicleNumber.setColumns(10);

        JLabel lblTelephoneNumber = new JLabel("Telephone Number :");
        lblTelephoneNumber.setBounds(439, 34, 122, 23);
        ACpanel.add(lblTelephoneNumber);

        textField_TelephoneNumber = new JTextField();
        textField_TelephoneNumber.setBounds(571, 34, 198, 20);
        ACpanel.add(textField_TelephoneNumber);
        textField_TelephoneNumber.setColumns(10);

        JLabel lblMilage = new JLabel("Milage :");
        lblMilage.setBounds(439, 55, 109, 23);
        ACpanel.add(lblMilage);

        textField_Milage = new JTextField();
        textField_Milage.setBounds(571, 57, 198, 20);
        ACpanel.add(textField_Milage);
        textField_Milage.setColumns(10);

        JLabel lblDate = new JLabel("Date :");
        lblDate.setBounds(817, 40, 44, 23);
        ACpanel.add(lblDate);

        label_date = new JLabel("");
        label_date.setBounds(858, 40, 70, 23);
        ACpanel.add(label_date);

        JLabel lblInvoiceNumber = new JLabel("Invoice Number :");
        lblInvoiceNumber.setBounds(796, 87, 97, 23);
        ACpanel.add(lblInvoiceNumber);

        JLabel label_invoiceNumber = new JLabel("");
        label_invoiceNumber.setBounds(898, 87, 60, 23);
        ACpanel.add(label_invoiceNumber);


        chckbxorings = new JCheckBox("\"O\"rings");
        chckbxorings.setBounds(18, 164, 97, 23);
        ACpanel.add(chckbxorings);

        chckbxAcFilter = new JCheckBox("(A/C)  Filter");
        chckbxAcFilter.setBounds(18, 190, 97, 23);
        ACpanel.add(chckbxAcFilter);

        chckbxAcFanMotor = new JCheckBox("(A/C) Fan Motor");
        chckbxAcFanMotor.setBounds(18, 216, 109, 23);
        ACpanel.add(chckbxAcFanMotor);

        chckbxCondenser = new JCheckBox("(A/C) Condenser");
        chckbxCondenser.setBounds(18, 240, 109, 23);
        ACpanel.add(chckbxCondenser);

        chckbxCooler = new JCheckBox("(A/C) Cooler");
        chckbxCooler.setBounds(18, 264, 97, 23);
        ACpanel.add(chckbxCooler);

        chckbxCompressor = new JCheckBox("Compressor");
        chckbxCompressor.setBounds(18, 289, 97, 23);
        ACpanel.add(chckbxCompressor);

        chckbxHorse = new JCheckBox("Hose");
        chckbxHorse.setBounds(18, 313, 97, 23);
        ACpanel.add(chckbxHorse);

        chckbxWelding = new JCheckBox("Welding");
        chckbxWelding.setBounds(18, 338, 97, 23);
        ACpanel.add(chckbxWelding);

        chckbxRacerBearing = new JCheckBox("Racer bearing");
        chckbxRacerBearing.setBounds(18, 363, 109, 23);
        ACpanel.add(chckbxRacerBearing);

        chckbxThermostat = new JCheckBox("Thermostat");
        chckbxThermostat.setBounds(18, 387, 97, 23);
        ACpanel.add(chckbxThermostat);

        chckbxSonarLight = new JCheckBox("Sonar Lights");
        chckbxSonarLight.setBounds(18, 411, 97, 23);
        ACpanel.add(chckbxSonarLight);

        chckbxBlowerMotor = new JCheckBox("(A/C) Blower Motor");
        chckbxBlowerMotor.setBounds(18, 436, 109, 23);
        ACpanel.add(chckbxBlowerMotor);

        chckbxConnectedValve = new JCheckBox("Connected Valve");
        chckbxConnectedValve.setBounds(-481, 1001, 129, 23);
        ACpanel.add(chckbxConnectedValve);

        chckbxCabinFilter = new JCheckBox("(A/C) Cabin Filter");
        chckbxCabinFilter.setBounds(18, 486, 97, 23);
        ACpanel.add(chckbxCabinFilter);

        chckbxElectric = new JCheckBox("Electric");
        chckbxElectric.setBounds(18, 510, 97, 23);
        ACpanel.add(chckbxElectric);

        chckbxRelay = new JCheckBox("Relay");
        chckbxRelay.setBounds(18, 535, 97, 23);
        ACpanel.add(chckbxRelay);

        chckbxAcRegas = new JCheckBox("(A/C) Regas");
        chckbxAcRegas.setBounds(18, 462, 97, 23);
        ACpanel.add(chckbxAcRegas);

        chckbxAcFullService = new JCheckBox("(A/C)  Full service & labour charge");
        chckbxAcFullService.setBounds(506, 279, 192, 23);
        ACpanel.add(chckbxAcFullService);

        JLabel lblDescription = new JLabel("Description");
        lblDescription.setBounds(18, 116, 82, 14);
        ACpanel.add(lblDescription);

        textField_others2 = new JTextField();
        textField_others2.setBounds(506, 373, 177, 20);
        ACpanel.add(textField_others2);
        textField_others2.setColumns(10);

        textField_others3 = new JTextField();
        textField_others3.setBounds(506, 396, 177, 20);
        ACpanel.add(textField_others3);
        textField_others3.setColumns(10);

        textField_others4 = new JTextField();
        textField_others4.setBounds(506, 419, 177, 20);
        ACpanel.add(textField_others4);
        textField_others4.setColumns(10);

        textField_oil_qty = new JTextField();
        textField_oil_qty.setBounds(130, 139, 86, 20);
        ACpanel.add(textField_oil_qty);
        textField_oil_qty.setColumns(10);

        JLabel lblQty = new JLabel("Qty");
        lblQty.setBounds(148, 116, 46, 14);
        ACpanel.add(lblQty);

        JLabel lblRaters = new JLabel("Rate (Rs.)");
        lblRaters.setBounds(249, 116, 57, 14);
        ACpanel.add(lblRaters);

        textField_oil_rate = new JTextField();
        textField_oil_rate.setBounds(238, 139, 86, 20);
        ACpanel.add(textField_oil_rate);
        textField_oil_rate.setColumns(10);

        JLabel lblAmount = new JLabel("Amount (Rs.)");
        lblAmount.setBounds(358, 116, 81, 14);
        ACpanel.add(lblAmount);

        textField_oil_amount = new JTextField();
        textField_oil_amount.setBounds(353, 139, 86, 20);
        ACpanel.add(textField_oil_amount);
        textField_oil_amount.setColumns(10);

        textField_orings_qty = new JTextField();
        textField_orings_qty.setBounds(130, 165, 86, 20);
        ACpanel.add(textField_orings_qty);
        textField_orings_qty.setColumns(10);

        textField_acFilter_qty = new JTextField();
        textField_acFilter_qty.setBounds(130, 191, 86, 20);
        ACpanel.add(textField_acFilter_qty);
        textField_acFilter_qty.setColumns(10);

        textField_acFanMotor_qty = new JTextField();
        textField_acFanMotor_qty.setBounds(130, 217, 86, 20);
        ACpanel.add(textField_acFanMotor_qty);
        textField_acFanMotor_qty.setColumns(10);

        textField_condenser_qty = new JTextField();
        textField_condenser_qty.setBounds(130, 241, 86, 20);
        ACpanel.add(textField_condenser_qty);
        textField_condenser_qty.setColumns(10);

        textField_cooler_qty = new JTextField();
        textField_cooler_qty.setBounds(130, 265, 86, 20);
        ACpanel.add(textField_cooler_qty);
        textField_cooler_qty.setColumns(10);

        textField_compressor_qty = new JTextField();
        textField_compressor_qty.setBounds(130, 290, 86, 20);
        ACpanel.add(textField_compressor_qty);
        textField_compressor_qty.setColumns(10);

        textField_hose_qty = new JTextField();
        textField_hose_qty.setBounds(130, 314, 86, 20);
        ACpanel.add(textField_hose_qty);
        textField_hose_qty.setColumns(10);

        textField_welding_qty = new JTextField();
        textField_welding_qty.setBounds(130, 339, 86, 20);
        ACpanel.add(textField_welding_qty);
        textField_welding_qty.setColumns(10);

        textField_raceBearing_qty = new JTextField();
        textField_raceBearing_qty.setBounds(130, 364, 86, 20);
        ACpanel.add(textField_raceBearing_qty);
        textField_raceBearing_qty.setColumns(10);

        textField_thermostat_qty = new JTextField();
        textField_thermostat_qty.setBounds(130, 388, 86, 20);
        ACpanel.add(textField_thermostat_qty);
        textField_thermostat_qty.setColumns(10);

        textField_sonarLights_qty = new JTextField();
        textField_sonarLights_qty.setBounds(130, 412, 86, 20);
        ACpanel.add(textField_sonarLights_qty);
        textField_sonarLights_qty.setColumns(10);

        textField_blowerMotor_qty = new JTextField();
        textField_blowerMotor_qty.setBounds(130, 437, 86, 20);
        ACpanel.add(textField_blowerMotor_qty);
        textField_blowerMotor_qty.setColumns(10);

        textField_acRegas_qty = new JTextField();
        textField_acRegas_qty.setBounds(130, 463, 86, 20);
        ACpanel.add(textField_acRegas_qty);
        textField_acRegas_qty.setColumns(10);

        textField_cabinFilter_qty = new JTextField();
        textField_cabinFilter_qty.setBounds(130, 487, 86, 20);
        ACpanel.add(textField_cabinFilter_qty);
        textField_cabinFilter_qty.setColumns(10);

        textField_electric_qty = new JTextField();
        textField_electric_qty.setBounds(130, 511, 86, 20);
        ACpanel.add(textField_electric_qty);
        textField_electric_qty.setColumns(10);

        textField_relay_qty = new JTextField();
        textField_relay_qty.setBounds(130, 536, 86, 20);
        ACpanel.add(textField_relay_qty);
        textField_relay_qty.setColumns(10);

        textField_connectedValve_qty = new JTextField();
        textField_connectedValve_qty.setBounds(-346, 1002, 86, 20);
        ACpanel.add(textField_connectedValve_qty);
        textField_connectedValve_qty.setColumns(10);

        textField_acFullService_qty = new JTextField();
        textField_acFullService_qty.setBounds(705, 280, 86, 20);
        ACpanel.add(textField_acFullService_qty);
        textField_acFullService_qty.setColumns(10);

        textField_others2_qty = new JTextField();
        textField_others2_qty.setBounds(705, 373, 86, 20);
        ACpanel.add(textField_others2_qty);
        textField_others2_qty.setColumns(10);

        textField_others3_qty = new JTextField();
        textField_others3_qty.setBounds(705, 396, 86, 20);
        ACpanel.add(textField_others3_qty);
        textField_others3_qty.setColumns(10);

        textField_others4_qty = new JTextField();
        textField_others4_qty.setBounds(705, 419, 86, 20);
        ACpanel.add(textField_others4_qty);
        textField_others4_qty.setColumns(10);

        textField_orings_rate = new JTextField();
        textField_orings_rate.setBounds(238, 165, 86, 20);
        ACpanel.add(textField_orings_rate);
        textField_orings_rate.setColumns(10);

        textField_acFilter_Rate = new JTextField();
        textField_acFilter_Rate.setBounds(238, 191, 86, 20);
        ACpanel.add(textField_acFilter_Rate);
        textField_acFilter_Rate.setColumns(10);

        textField_fanMotor_rate = new JTextField();
        textField_fanMotor_rate.setBounds(238, 217, 86, 20);
        ACpanel.add(textField_fanMotor_rate);
        textField_fanMotor_rate.setColumns(10);

        textField_condenser_rate = new JTextField();
        textField_condenser_rate.setBounds(238, 241, 86, 20);
        ACpanel.add(textField_condenser_rate);
        textField_condenser_rate.setColumns(10);

        textField_cooler_rate = new JTextField();
        textField_cooler_rate.setBounds(238, 265, 86, 20);
        ACpanel.add(textField_cooler_rate);
        textField_cooler_rate.setColumns(10);

        textField_compressor_rate = new JTextField();
        textField_compressor_rate.setBounds(238, 290, 86, 20);
        ACpanel.add(textField_compressor_rate);
        textField_compressor_rate.setColumns(10);

        textField_hose_rate = new JTextField();
        textField_hose_rate.setBounds(238, 314, 86, 20);
        ACpanel.add(textField_hose_rate);
        textField_hose_rate.setColumns(10);

        textField_welding_rate = new JTextField();
        textField_welding_rate.setBounds(238, 339, 86, 20);
        ACpanel.add(textField_welding_rate);
        textField_welding_rate.setColumns(10);

        textField_raceBearing_rate = new JTextField();
        textField_raceBearing_rate.setBounds(238, 364, 86, 20);
        ACpanel.add(textField_raceBearing_rate);
        textField_raceBearing_rate.setColumns(10);

        textField_thermostat_rate = new JTextField();
        textField_thermostat_rate.setBounds(238, 388, 86, 20);
        ACpanel.add(textField_thermostat_rate);
        textField_thermostat_rate.setColumns(10);

        textField_SonarLights_rate = new JTextField();
        textField_SonarLights_rate.setBounds(238, 412, 86, 20);
        ACpanel.add(textField_SonarLights_rate);
        textField_SonarLights_rate.setColumns(10);

        textField_bloweMotor_rate = new JTextField();
        textField_bloweMotor_rate.setBounds(238, 437, 86, 20);
        ACpanel.add(textField_bloweMotor_rate);
        textField_bloweMotor_rate.setColumns(10);

        textField_acRegas_rate = new JTextField();
        textField_acRegas_rate.setBounds(238, 463, 86, 20);
        ACpanel.add(textField_acRegas_rate);
        textField_acRegas_rate.setColumns(10);

        textField_cabinfilter_rate = new JTextField();
        textField_cabinfilter_rate.setBounds(238, 487, 86, 20);
        ACpanel.add(textField_cabinfilter_rate);
        textField_cabinfilter_rate.setColumns(10);

        textField_electric_rate = new JTextField();
        textField_electric_rate.setBounds(238, 511, 86, 20);
        ACpanel.add(textField_electric_rate);
        textField_electric_rate.setColumns(10);

        textField_relay_rate = new JTextField();
        textField_relay_rate.setBounds(238, 536, 86, 20);
        ACpanel.add(textField_relay_rate);
        textField_relay_rate.setColumns(10);

        textField_connectedValve_rate = new JTextField();
        textField_connectedValve_rate.setBounds(-238, 1001, 86, 20);
        ACpanel.add(textField_connectedValve_rate);
        textField_connectedValve_rate.setColumns(10);

        textField_acFullService_rate = new JTextField();
        textField_acFullService_rate.setBounds(807, 280, 86, 20);
        ACpanel.add(textField_acFullService_rate);
        textField_acFullService_rate.setColumns(10);

        textField_others2_rate = new JTextField();
        textField_others2_rate.setBounds(801, 373, 86, 20);
        ACpanel.add(textField_others2_rate);
        textField_others2_rate.setColumns(10);

        textField_others3_rate = new JTextField();
        textField_others3_rate.setBounds(801, 396, 86, 20);
        ACpanel.add(textField_others3_rate);
        textField_others3_rate.setColumns(10);

        textField_others4_rate = new JTextField();
        textField_others4_rate.setBounds(801, 419, 86, 20);
        ACpanel.add(textField_others4_rate);
        textField_others4_rate.setColumns(10);

        textField_orings_amount = new JTextField();
        textField_orings_amount.setBounds(353, 165, 86, 20);
        ACpanel.add(textField_orings_amount);
        textField_orings_amount.setColumns(10);

        textField_acFilter_amount = new JTextField();
        textField_acFilter_amount.setBounds(353, 191, 86, 20);
        ACpanel.add(textField_acFilter_amount);
        textField_acFilter_amount.setColumns(10);

        textField_acFanMotor_amount = new JTextField();
        textField_acFanMotor_amount.setBounds(353, 217, 86, 20);
        ACpanel.add(textField_acFanMotor_amount);
        textField_acFanMotor_amount.setColumns(10);

        textField_condenser_amount = new JTextField();
        textField_condenser_amount.setBounds(353, 241, 86, 20);
        ACpanel.add(textField_condenser_amount);
        textField_condenser_amount.setColumns(10);

        textField_cooler_amount = new JTextField();
        textField_cooler_amount.setBounds(353, 265, 86, 20);
        ACpanel.add(textField_cooler_amount);
        textField_cooler_amount.setColumns(10);

        textField_compressor_amount = new JTextField();
        textField_compressor_amount.setBounds(353, 292, 86, 20);
        ACpanel.add(textField_compressor_amount);
        textField_compressor_amount.setColumns(10);

        textField_hose_amount = new JTextField();
        textField_hose_amount.setBounds(353, 316, 86, 20);
        ACpanel.add(textField_hose_amount);
        textField_hose_amount.setColumns(10);

        textField_welding_amount = new JTextField();
        textField_welding_amount.setBounds(353, 339, 86, 20);
        ACpanel.add(textField_welding_amount);
        textField_welding_amount.setColumns(10);

        textField_raceBearing_amount = new JTextField();
        textField_raceBearing_amount.setBounds(353, 364, 86, 20);
        ACpanel.add(textField_raceBearing_amount);
        textField_raceBearing_amount.setColumns(10);

        textField_thermostat_amount = new JTextField();
        textField_thermostat_amount.setBounds(353, 388, 86, 20);
        ACpanel.add(textField_thermostat_amount);
        textField_thermostat_amount.setColumns(10);

        textField_SonarLIghts_amount = new JTextField();
        textField_SonarLIghts_amount.setBounds(353, 412, 86, 20);
        ACpanel.add(textField_SonarLIghts_amount);
        textField_SonarLIghts_amount.setColumns(10);

        textField_blowerMotor_amount = new JTextField();
        textField_blowerMotor_amount.setBounds(353, 437, 86, 20);
        ACpanel.add(textField_blowerMotor_amount);
        textField_blowerMotor_amount.setColumns(10);

        textField_acRegas_amount = new JTextField();
        textField_acRegas_amount.setBounds(353, 463, 86, 20);
        ACpanel.add(textField_acRegas_amount);
        textField_acRegas_amount.setColumns(10);

        textField_cabinFilter_amount = new JTextField();
        textField_cabinFilter_amount.setBounds(353, 487, 86, 20);
        ACpanel.add(textField_cabinFilter_amount);
        textField_cabinFilter_amount.setColumns(10);

        textField_electric_amount = new JTextField();
        textField_electric_amount.setBounds(353, 511, 86, 20);
        ACpanel.add(textField_electric_amount);
        textField_electric_amount.setColumns(10);

        textField_relay_amount = new JTextField();
        textField_relay_amount.setBounds(353, 536, 86, 20);
        ACpanel.add(textField_relay_amount);
        textField_relay_amount.setColumns(10);

        textField_connectedValve_amount = new JTextField();
        textField_connectedValve_amount.setBounds(-123, 1001, 86, 20);
        ACpanel.add(textField_connectedValve_amount);
        textField_connectedValve_amount.setColumns(10);

        textField_acFullService_amount = new JTextField();
        textField_acFullService_amount.setBounds(912, 280, 86, 20);
        ACpanel.add(textField_acFullService_amount);
        textField_acFullService_amount.setColumns(10);

        textField_others2_amount = new JTextField();
        textField_others2_amount.setBounds(912, 373, 86, 20);
        ACpanel.add(textField_others2_amount);
        textField_others2_amount.setColumns(10);

        textField_others3_amount = new JTextField();
        textField_others3_amount.setBounds(912, 396, 86, 20);
        ACpanel.add(textField_others3_amount);
        textField_others3_amount.setColumns(10);

        textField_others4_amount = new JTextField();
        textField_others4_amount.setBounds(912, 419, 86, 20);
        ACpanel.add(textField_others4_amount);
        textField_others4_amount.setColumns(10);

        chckbxEngineWash = new JCheckBox("Engine Wash");
        chckbxEngineWash.setBounds(17, 216, 109, 23);
        BodyWashPanel.add(chckbxEngineWash);

        checkBox_others2 = new JCheckBox("");
        checkBox_others2.setBounds(479, 370, 27, 23);
        ACpanel.add(checkBox_others2);

        checkBox_others3 = new JCheckBox("");
        checkBox_others3.setBounds(479, 393, 27, 23);
        ACpanel.add(checkBox_others3);

        checkBox_others4 = new JCheckBox("");
        checkBox_others4.setBounds(479, 416, 27, 23);
        ACpanel.add(checkBox_others4);

        chckbxBodyWash = new JCheckBox("Body Wash");
        chckbxBodyWash.setBounds(23, 19, 103, 23);
        BodyWashPanel.add(chckbxBodyWash);

        chckbxBodyWash.setForeground(Color.RED);

        chckbxAcServices = new JCheckBox("A/C Services");
        chckbxAcServices.setBounds(18, 87, 97, 23);
        ACpanel.add(chckbxAcServices);
        chckbxAcServices.setForeground(Color.RED);

        JButton btnPrint = new JButton("Print");
        btnPrint.setBounds(898, 622, 97, 39);
        ACpanel.add(btnPrint);
        btnPrint.setBackground(new Color(0, 255, 255));
        btnPrint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPrint.setIcon(new ImageIcon(HomeScreen.class.getResource("/Images/print-icon.png")));

        JButton btnDatabase = new JButton("Database");
        btnDatabase.setBounds(777, 622, 111, 39);
        ACpanel.add(btnDatabase);
        btnDatabase.setBackground(new Color(0, 255, 255));
        btnDatabase.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDatabase.setIcon(new ImageIcon(HomeScreen.class.getResource("/Images/Folder-Data-icon.png")));

        JLabel lblSubTotal = new JLabel("Sub Total :");
        lblSubTotal.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 17));
        lblSubTotal.setBounds(652, 588, 97, 29);
        ACpanel.add(lblSubTotal);
        lblSubTotal.setForeground(Color.RED);

        total_label = new JLabel("");
        total_label.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 17));
        total_label.setBounds(759, 590, 87, 29);
        ACpanel.add(total_label);
        total_label.setForeground(Color.RED);
        total_label.setText(Float.toString(total));

        oiling_checkbox = new JCheckBox("Oiling");
        oiling_checkbox.setBounds(17, 88, 136, 23);
        BodyWashPanel.add(oiling_checkbox);

        OIling_qty_textField = new JTextField();
        OIling_qty_textField.setBounds(154, 89, 86, 20);
        BodyWashPanel.add(OIling_qty_textField);
        OIling_qty_textField.setColumns(10);

        Oiling_rate_textField_1 = new JTextField();
        Oiling_rate_textField_1.setBounds(262, 89, 86, 20);
        BodyWashPanel.add(Oiling_rate_textField_1);
        Oiling_rate_textField_1.setColumns(10);

        Oiling_amount_textField_2 = new JTextField();
        Oiling_amount_textField_2.setBounds(377, 89, 86, 20);
        BodyWashPanel.add(Oiling_amount_textField_2);
        Oiling_amount_textField_2.setColumns(10);

        chckbxFilterCleaning = new JCheckBox("Filter Cleaning");
        chckbxFilterCleaning.setBounds(17, 114, 136, 23);
        BodyWashPanel.add(chckbxFilterCleaning);

        FilterCleaning_qty_textField_3 = new JTextField();
        FilterCleaning_qty_textField_3.setBounds(154, 115, 86, 20);
        BodyWashPanel.add(FilterCleaning_qty_textField_3);
        FilterCleaning_qty_textField_3.setColumns(10);

        FilterCleaning_rate_textField_4 = new JTextField();
        FilterCleaning_rate_textField_4.setBounds(262, 115, 86, 20);
        BodyWashPanel.add(FilterCleaning_rate_textField_4);
        FilterCleaning_rate_textField_4.setColumns(10);

        FilteCleaning_amount_textField_5 = new JTextField();
        FilteCleaning_amount_textField_5.setBounds(377, 115, 86, 20);
        BodyWashPanel.add(FilteCleaning_amount_textField_5);
        FilteCleaning_amount_textField_5.setColumns(10);

        chckbxInteriorCleaningOnly = new JCheckBox("Interior Cleaning ");
        chckbxInteriorCleaningOnly.setBounds(17, 140, 136, 23);
        BodyWashPanel.add(chckbxInteriorCleaningOnly);

        InteriroCleaning_qty_textField_6 = new JTextField();
        InteriroCleaning_qty_textField_6.setBounds(154, 141, 86, 20);
        BodyWashPanel.add(InteriroCleaning_qty_textField_6);
        InteriroCleaning_qty_textField_6.setColumns(10);

        InteriroCleaning_rate_textField_7 = new JTextField();
        InteriroCleaning_rate_textField_7.setBounds(262, 141, 86, 20);
        BodyWashPanel.add(InteriroCleaning_rate_textField_7);
        InteriroCleaning_rate_textField_7.setColumns(10);

        InteriroCleaning_amount_textField_8 = new JTextField();
        InteriroCleaning_amount_textField_8.setBounds(377, 141, 86, 20);
        BodyWashPanel.add(InteriroCleaning_amount_textField_8);
        InteriroCleaning_amount_textField_8.setColumns(10);

        chckbxCushionCleaning = new JCheckBox("Cushion Cleaning");
        chckbxCushionCleaning.setBounds(17, 166, 136, 23);
        BodyWashPanel.add(chckbxCushionCleaning);

        CushionCleaning_qty_textField_9 = new JTextField();
        CushionCleaning_qty_textField_9.setBounds(154, 167, 86, 20);
        BodyWashPanel.add(CushionCleaning_qty_textField_9);
        CushionCleaning_qty_textField_9.setColumns(10);

        CushionCleaning_rate_textField_10 = new JTextField();
        CushionCleaning_rate_textField_10.setBounds(262, 167, 86, 20);
        BodyWashPanel.add(CushionCleaning_rate_textField_10);
        CushionCleaning_rate_textField_10.setColumns(10);

        CushionCleaning_amount_textField_11 = new JTextField();
        CushionCleaning_amount_textField_11.setBounds(377, 167, 86, 20);
        BodyWashPanel.add(CushionCleaning_amount_textField_11);
        CushionCleaning_amount_textField_11.setColumns(10);

        chckbxCarpetCleaning = new JCheckBox("Carpet Cleaning");
        chckbxCarpetCleaning.setBounds(17, 190, 136, 23);
        BodyWashPanel.add(chckbxCarpetCleaning);

        carpetCleaning_qty_textField_12 = new JTextField();
        carpetCleaning_qty_textField_12.setBounds(154, 191, 86, 20);
        BodyWashPanel.add(carpetCleaning_qty_textField_12);
        carpetCleaning_qty_textField_12.setColumns(10);

        carpetCleaning_rate_textField_13 = new JTextField();
        carpetCleaning_rate_textField_13.setBounds(262, 191, 86, 20);
        BodyWashPanel.add(carpetCleaning_rate_textField_13);
        carpetCleaning_rate_textField_13.setColumns(10);

        tcarpetCleaning__amount_extField_14 = new JTextField();
        tcarpetCleaning__amount_extField_14.setBounds(377, 191, 86, 20);
        BodyWashPanel.add(tcarpetCleaning__amount_extField_14);
        tcarpetCleaning__amount_extField_14.setColumns(10);

        JLabel label = new JLabel("Description");
        label.setBounds(539, 349, 82, 14);
        ACpanel.add(label);

        JLabel label_1 = new JLabel("Qty");
        label_1.setBounds(730, 349, 46, 14);
        ACpanel.add(label_1);

        JLabel label_2 = new JLabel("Rate (Rs.)");
        label_2.setBounds(818, 349, 57, 14);
        ACpanel.add(label_2);

        JLabel label_3 = new JLabel("Amount (Rs.)");
        label_3.setBounds(917, 349, 81, 14);
        ACpanel.add(label_3);

        EngineWash_qty_textField = new JTextField();
        EngineWash_qty_textField.setBounds(154, 217, 86, 20);
        BodyWashPanel.add(EngineWash_qty_textField);
        EngineWash_qty_textField.setColumns(10);

        engineWash_rate_textField_1 = new JTextField();
        engineWash_rate_textField_1.setBounds(262, 217, 86, 20);
        BodyWashPanel.add(engineWash_rate_textField_1);
        engineWash_rate_textField_1.setColumns(10);

        engineWash_amount_textField_2 = new JTextField();
        engineWash_amount_textField_2.setBounds(377, 217, 86, 20);
        BodyWashPanel.add(engineWash_amount_textField_2);
        engineWash_amount_textField_2.setColumns(10);

        other5_description_textField = new JTextField();
        other5_description_textField.setBounds(506, 443, 177, 20);
        ACpanel.add(other5_description_textField);
        other5_description_textField.setColumns(10);

        other5_checkbox = new JCheckBox("");
        other5_checkbox.setBounds(479, 443, 27, 23);
        ACpanel.add(other5_checkbox);

        other6_checkbox = new JCheckBox("");
        other6_checkbox.setBounds(479, 466, 27, 23);
        ACpanel.add(other6_checkbox);

        other7_checkbox = new JCheckBox("");
        other7_checkbox.setBounds(479, 486, 27, 23);
        ACpanel.add(other7_checkbox);

        other6_description_textField = new JTextField();
        other6_description_textField.setBounds(506, 466, 177, 20);
        ACpanel.add(other6_description_textField);
        other6_description_textField.setColumns(10);

        other7_description_textField = new JTextField();
        other7_description_textField.setBounds(506, 489, 177, 20);
        ACpanel.add(other7_description_textField);
        other7_description_textField.setColumns(10);

        other5_qty_textField = new JTextField();
        other5_qty_textField.setBounds(705, 443, 86, 20);
        ACpanel.add(other5_qty_textField);
        other5_qty_textField.setColumns(10);

        other6_qty_textField = new JTextField();
        other6_qty_textField.setBounds(705, 466, 86, 20);
        ACpanel.add(other6_qty_textField);
        other6_qty_textField.setColumns(10);

        other7_qty_textField = new JTextField();
        other7_qty_textField.setBounds(705, 489, 86, 20);
        ACpanel.add(other7_qty_textField);
        other7_qty_textField.setColumns(10);

        other5_rate_textField = new JTextField();
        other5_rate_textField.setBounds(801, 443, 86, 20);
        ACpanel.add(other5_rate_textField);
        other5_rate_textField.setColumns(10);

        other6_rate_textField = new JTextField();
        other6_rate_textField.setBounds(801, 466, 86, 20);
        ACpanel.add(other6_rate_textField);
        other6_rate_textField.setColumns(10);

        other7_rate_textField = new JTextField();
        other7_rate_textField.setBounds(801, 489, 86, 20);
        ACpanel.add(other7_rate_textField);
        other7_rate_textField.setColumns(10);

        other5_amount_textField = new JTextField();
        other5_amount_textField.setBounds(912, 443, 86, 20);
        ACpanel.add(other5_amount_textField);
        other5_amount_textField.setColumns(10);

        other6_amount_textField = new JTextField();
        other6_amount_textField.setBounds(912, 466, 86, 20);
        ACpanel.add(other6_amount_textField);
        other6_amount_textField.setColumns(10);

        other7_amount_textField = new JTextField();
        other7_amount_textField.setBounds(912, 489, 86, 20);
        ACpanel.add(other7_amount_textField);
        other7_amount_textField.setColumns(10);

        JLabel lblExtras = new JLabel("Extras");
        lblExtras.setBounds(762, 338, 46, 14);
        ACpanel.add(lblExtras);

        Oil_Orings_vaccume_regas_checkBox = new JCheckBox("Oil, \"O\"rings, Vaccum and Regas");
        Oil_Orings_vaccume_regas_checkBox.setBounds(506, 227, 192, 23);
        ACpanel.add(Oil_Orings_vaccume_regas_checkBox);

        OIl_Orings_Qty_textField = new JTextField();
        OIl_Orings_Qty_textField.setBounds(705, 228, 86, 20);
        ACpanel.add(OIl_Orings_Qty_textField);
        OIl_Orings_Qty_textField.setColumns(10);

        OIl_Orings_Rate_textField = new JTextField();
        OIl_Orings_Rate_textField.setBounds(807, 228, 86, 20);
        ACpanel.add(OIl_Orings_Rate_textField);
        OIl_Orings_Rate_textField.setColumns(10);

        OIl_Orings_amount_textField = new JTextField();
        OIl_Orings_amount_textField.setBounds(912, 228, 86, 20);
        ACpanel.add(OIl_Orings_amount_textField);
        OIl_Orings_amount_textField.setColumns(10);

        JLabel label_4 = new JLabel("Description");
        label_4.setBounds(38, 66, 82, 14);
        BodyWashPanel.add(label_4);

        JLabel label_5 = new JLabel("Qty");
        label_5.setBounds(168, 66, 46, 14);
        BodyWashPanel.add(label_5);

        JLabel label_6 = new JLabel("Rate (Rs.)");
        label_6.setBounds(269, 66, 57, 14);
        BodyWashPanel.add(label_6);

        JLabel label_7 = new JLabel("Amount (Rs.)");
        label_7.setBounds(378, 66, 81, 14);
        BodyWashPanel.add(label_7);

        chckbxVaccumCleaningOnly = new JCheckBox("Vaccum cleaning only");
        chckbxVaccumCleaningOnly.setBounds(17, 242, 136, 23);
        BodyWashPanel.add(chckbxVaccumCleaningOnly);
        chckbxVaccumCleaningOnly.addItemListener(new CheckBoxListener());

        vaccum_cleaning_only_qty_textField = new JTextField();
        vaccum_cleaning_only_qty_textField.setColumns(10);
        vaccum_cleaning_only_qty_textField.setBounds(154, 243, 86, 20);
        BodyWashPanel.add(vaccum_cleaning_only_qty_textField);

        vaccum_cleaning_only_Rate_textField = new JTextField();
        vaccum_cleaning_only_Rate_textField.setColumns(10);
        vaccum_cleaning_only_Rate_textField.setBounds(262, 243, 86, 20);
        BodyWashPanel.add(vaccum_cleaning_only_Rate_textField);

        vaccum_cleaning_only_amount_textField = new JTextField();
        vaccum_cleaning_only_amount_textField.setColumns(10);
        vaccum_cleaning_only_amount_textField.setBounds(377, 243, 86, 20);
        BodyWashPanel.add(vaccum_cleaning_only_amount_textField);

        chckbxBodyWash_1 = new JCheckBox("Body wash & vaccum Cleaning ");
        chckbxBodyWash_1.setBounds(17, 347, 198, 23);
        BodyWashPanel.add(chckbxBodyWash_1);
        chckbxBodyWash_1.addItemListener(new CheckBoxListener());

        BodyWash_vaccumCleaningOnly_qty_textField = new JTextField();
        BodyWash_vaccumCleaningOnly_qty_textField.setColumns(10);
        BodyWash_vaccumCleaningOnly_qty_textField.setBounds(221, 350, 86, 20);
        BodyWashPanel.add(BodyWash_vaccumCleaningOnly_qty_textField);

        BodyWash_vaccumCleaningOnly_rate_textField = new JTextField();
        BodyWash_vaccumCleaningOnly_rate_textField.setColumns(10);
        BodyWash_vaccumCleaningOnly_rate_textField.setBounds(329, 350, 86, 20);
        BodyWashPanel.add(BodyWash_vaccumCleaningOnly_rate_textField);

        BodyWash_vaccumCleaningOnly_amount_textField = new JTextField();
        BodyWash_vaccumCleaningOnly_amount_textField.setColumns(10);
        BodyWash_vaccumCleaningOnly_amount_textField.setBounds(444, 350, 86, 20);
        BodyWashPanel.add(BodyWash_vaccumCleaningOnly_amount_textField);

        chckbxCutPolish = new JCheckBox("Cut & Polish vax");
        chckbxCutPolish.setBounds(17, 268, 130, 23);
        BodyWashPanel.add(chckbxCutPolish);
        chckbxCutPolish.addItemListener(new CheckBoxListener());

        cutandPolishVax_qty_textField = new JTextField();
        cutandPolishVax_qty_textField.setColumns(10);
        cutandPolishVax_qty_textField.setBounds(154, 269, 86, 20);
        BodyWashPanel.add(cutandPolishVax_qty_textField);

        cutandPolishVax_rate_textField = new JTextField();
        cutandPolishVax_rate_textField.setColumns(10);
        cutandPolishVax_rate_textField.setBounds(262, 269, 86, 20);
        BodyWashPanel.add(cutandPolishVax_rate_textField);

        cutandPolishVax_amount_textField = new JTextField();
        cutandPolishVax_amount_textField.setColumns(10);
        cutandPolishVax_amount_textField.setBounds(377, 269, 86, 20);
        BodyWashPanel.add(cutandPolishVax_amount_textField);

        chckbxVax = new JCheckBox("Wax");
        chckbxVax.setBounds(17, 294, 130, 23);
        BodyWashPanel.add(chckbxVax);
        chckbxVax.addItemListener(new CheckBoxListener());

        vax_qty_textField = new JTextField();
        vax_qty_textField.setColumns(10);
        vax_qty_textField.setBounds(154, 295, 86, 20);
        BodyWashPanel.add(vax_qty_textField);

        vax_rate_textField = new JTextField();
        vax_rate_textField.setColumns(10);
        vax_rate_textField.setBounds(262, 295, 86, 20);
        BodyWashPanel.add(vax_rate_textField);

        vax_amount_textField = new JTextField();
        vax_amount_textField.setColumns(10);
        vax_amount_textField.setBounds(377, 295, 86, 20);
        BodyWashPanel.add(vax_amount_textField);

        chckbxBodyWashOnly = new JCheckBox("Body Wash Only");
        chckbxBodyWashOnly.setBounds(17, 320, 130, 23);
        BodyWashPanel.add(chckbxBodyWashOnly);
        chckbxBodyWashOnly.addItemListener(new CheckBoxListener());

        bodyWashOnly_qty_textField = new JTextField();
        bodyWashOnly_qty_textField.setColumns(10);
        bodyWashOnly_qty_textField.setBounds(154, 321, 86, 20);
        BodyWashPanel.add(bodyWashOnly_qty_textField);

        bodyWashOnly_rate_textField = new JTextField();
        bodyWashOnly_rate_textField.setColumns(10);
        bodyWashOnly_rate_textField.setBounds(262, 321, 86, 20);
        BodyWashPanel.add(bodyWashOnly_rate_textField);

        bodyWashOnly_amount_textField = new JTextField();
        bodyWashOnly_amount_textField.setColumns(10);
        bodyWashOnly_amount_textField.setBounds(377, 321, 86, 20);
        BodyWashPanel.add(bodyWashOnly_amount_textField);

        JButton btnQuotation = new JButton("Quotation");
        btnQuotation.setBounds(652, 622, 117, 39);
        ACpanel.add(btnQuotation);
        btnQuotation.setBackground(new Color(0, 255, 255));
        btnQuotation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnQuotation.setIcon(new ImageIcon(HomeScreen.class.getResource("/Images/Actions-document-edit-icon.png")));

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(539, 622, 109, 39);
        ACpanel.add(btnRefresh);
        // btnRefresh.setBackground(new Color(0, 255, 255));
        btnRefresh.setBackground(new Color(0, 255, 255));
        btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                total_label.setText("");
                new HomeScreen().main();
                dispose();
            }
        });
        btnRefresh.setIcon(new ImageIcon(HomeScreen.class.getResource("/Images/Button-Refresh-icon.png")));

        btnNewButton = new JButton("Double Check");
        btnNewButton.setBounds(856, 588, 133, 29);
        ACpanel.add(btnNewButton);
        btnNewButton.setBackground(new Color(0, 255, 255));
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Warranty_textField = new JTextField();
        Warranty_textField.setBounds(617, 535, 133, 20);
        ACpanel.add(Warranty_textField);
        Warranty_textField.setColumns(10);

        months_textField = new JTextField();
        months_textField.setBounds(752, 535, 60, 20);
        ACpanel.add(months_textField);
        months_textField.setColumns(10);

        lblMonths = new JLabel("Months");
        lblMonths.setBounds(818, 538, 57, 14);
        ACpanel.add(lblMonths);

        chckbxForFullAc = new JCheckBox("For full A/C service body wash & vaccum cleaning free");
        chckbxForFullAc.setBounds(479, 560, 333, 23);
        ACpanel.add(chckbxForFullAc);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    float sum = 0;
                    if (!(textField_oil_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_oil_amount.getText());
                    if (!(textField_orings_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_orings_amount.getText());
                    if (!(textField_acFilter_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_acFilter_amount.getText());
                    if (!(textField_acFanMotor_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_acFanMotor_amount.getText());
                    if (!(textField_condenser_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_condenser_amount.getText());
                    if (!(textField_cooler_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_cooler_amount.getText());
                    if (!(textField_compressor_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_compressor_amount.getText());
                    if (!(textField_hose_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_hose_amount.getText());
                    if (!(textField_welding_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_welding_amount.getText());
                    if (!(textField_raceBearing_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_raceBearing_amount.getText());
                    if (!(textField_thermostat_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_thermostat_amount.getText());
                    if (!(textField_SonarLIghts_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_SonarLIghts_amount.getText());
                    if (!(textField_blowerMotor_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_blowerMotor_amount.getText());
                    if (!(textField_acRegas_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_acRegas_amount.getText());
                    if (!(textField_cabinFilter_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_cabinFilter_amount.getText());
                    if (!(textField_electric_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_electric_amount.getText());
                    if (!(textField_relay_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_relay_amount.getText());
                    if (!(engineWash_amount_textField_2.getText().equals("")))
                        sum += Float.parseFloat(engineWash_amount_textField_2.getText());
                    if (!(textField_connectedValve_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_connectedValve_amount.getText());
                    if (!(textField_acFullService_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_acFullService_amount.getText());
                    if (!(OIl_Orings_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(OIl_Orings_amount_textField.getText());
                    if (!(Oiling_amount_textField_2.getText().equals("")))
                        sum += Float.parseFloat(Oiling_amount_textField_2.getText());
                    if (!(FilteCleaning_amount_textField_5.getText().equals("")))
                        sum += Float.parseFloat(FilteCleaning_amount_textField_5.getText());
                    if (!(InteriroCleaning_amount_textField_8.getText().equals("")))
                        sum += Float.parseFloat(InteriroCleaning_amount_textField_8.getText());
                    if (!(CushionCleaning_amount_textField_11.getText().equals("")))
                        sum += Float.parseFloat(CushionCleaning_amount_textField_11.getText());
                    if (!(tcarpetCleaning__amount_extField_14.getText().equals("")))
                        sum += Float.parseFloat(tcarpetCleaning__amount_extField_14.getText());
                    if (!(textField_others2_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_others2_amount.getText());
                    if (!(textField_others3_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_others3_amount.getText());
                    if (!(textField_others4_amount.getText().equals("")))
                        sum += Float.parseFloat(textField_others4_amount.getText());
                    if (!(other5_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(other5_amount_textField.getText());
                    if (!(other6_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(other6_amount_textField.getText());
                    if (!(other7_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(other7_amount_textField.getText());
                    if (!(aluminiumWelding_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(aluminiumWelding_amount_textField.getText());
                    if (!(oil_orings_AC_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(oil_orings_AC_amount_textField.getText());
                    if (!(resistant_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(resistant_amount_textField.getText());
                    if (!(acBelt_amount_textFileld.getText().equals("")))
                        sum += Float.parseFloat(acBelt_amount_textFileld.getText());
                    if (!(liquidLane_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(liquidLane_amount_textField.getText());
                    if (!(Fittings_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(Fittings_amount_textField.getText());
                    if (!(texAcGas_amount_textFieldtField_2.getText().equals("")))
                        sum += Float.parseFloat(texAcGas_amount_textFieldtField_2.getText());
                    if (!(adjustmentPully_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(adjustmentPully_amount_textField.getText());
                    if (!(vaccum_cleaning_only_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(vaccum_cleaning_only_amount_textField.getText());
                    if (!(cutandPolishVax_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(cutandPolishVax_amount_textField.getText());
                    if (!(vax_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(vax_amount_textField.getText());
                    if (!(bodyWashOnly_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(bodyWashOnly_amount_textField.getText());
                    if (!(BodyWash_vaccumCleaningOnly_amount_textField.getText().equals("")))
                        sum += Float.parseFloat(BodyWash_vaccumCleaningOnly_amount_textField.getText());


                    if (Float.parseFloat(total_label.getText()) == (sum)) {
                        JOptionPane.showMessageDialog(null, "Correct!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                        total_label.setText(String.valueOf(sum));
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnQuotation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                new Quotation().main();
                dispose();
            }
        });
        Oil_Orings_vaccume_regas_checkBox.addItemListener(new CheckBoxListener());
        other7_checkbox.addItemListener(new CheckBoxListener());
        other6_checkbox.addItemListener(new CheckBoxListener());
        other5_checkbox.addItemListener(new CheckBoxListener());
        chckbxCarpetCleaning.addItemListener(new CheckBoxListener());
        chckbxCushionCleaning.addItemListener(new CheckBoxListener());
        chckbxInteriorCleaningOnly.addItemListener(new CheckBoxListener());
        chckbxFilterCleaning.addItemListener(new CheckBoxListener());
        oiling_checkbox.addItemListener(new CheckBoxListener());
        btnDatabase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                new DatabaseTable().main();
                dispose();
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (textField_CustomerName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill the relevant feilds!",
                            "Sanjeewa Auto A/C and Body Wash", JOptionPane.WARNING_MESSAGE);
                } else if (chckbxAcServices.isSelected() && chckbxPrintWithHeader.isSelected()) {
                    printWithHeader();
                    senDataAgain();
                } else if (chckbxAcServices.isSelected() && chckbxPrintWithoutHeader.isSelected()) {
                    printWithoutHeader();
                    senDataAgain();
                } else if (chckbxBodyWash.isSelected() && chckbxPrintWithHeader.isSelected()) {
                    printWithHeader();
                    senDataAgain();
                } else if (chckbxBodyWash.isSelected() && chckbxPrintWithoutHeader.isSelected()) {
                    printWithoutHeader();
                    senDataAgain();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select the service!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        chckbxAcServices.addItemListener(new CheckBoxListener());
        chckbxBodyWash.addItemListener(new CheckBoxListener());
        checkBox_others4.addItemListener(new CheckBoxListener());
        checkBox_others3.addItemListener(new CheckBoxListener());
        checkBox_others2.addItemListener(new CheckBoxListener());
        chckbxEngineWash.addItemListener(new CheckBoxListener());
        chckbxAcFullService.addItemListener(new CheckBoxListener());
        chckbxAcRegas.addItemListener(new CheckBoxListener());
        chckbxRelay.addItemListener(new CheckBoxListener());
        chckbxElectric.addItemListener(new CheckBoxListener());
        chckbxCabinFilter.addItemListener(new CheckBoxListener());
        chckbxConnectedValve.addItemListener(new CheckBoxListener());
        chckbxBlowerMotor.addItemListener(new CheckBoxListener());
        chckbxSonarLight.addItemListener(new CheckBoxListener());
        chckbxThermostat.addItemListener(new CheckBoxListener());
        chckbxRacerBearing.addItemListener(new CheckBoxListener());
        chckbxWelding.addItemListener(new CheckBoxListener());
        chckbxHorse.addItemListener(new CheckBoxListener());
        chckbxCompressor.addItemListener(new CheckBoxListener());
        chckbxCooler.addItemListener(new CheckBoxListener());
        chckbxCondenser.addItemListener(new CheckBoxListener());
        chckbxAcFanMotor.addItemListener(new CheckBoxListener());
        chckbxAcFilter.addItemListener(new CheckBoxListener());
        chckbxorings.addItemListener(new CheckBoxListener());
        chckbx_Oil.addItemListener(new CheckBoxListener());

        // to get the date of the system
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        label_date.setText(simpleDate.format(date));

        chckbxAluminiumWelding = new JCheckBox("Aluminium Welding");
        chckbxAluminiumWelding.setBounds(506, 177, 144, 23);
        ACpanel.add(chckbxAluminiumWelding);
        chckbxAluminiumWelding.addItemListener(new CheckBoxListener());

        aluminiumWelding_qty_textField = new JTextField();
        aluminiumWelding_qty_textField.setColumns(10);
        aluminiumWelding_qty_textField.setBounds(705, 178, 86, 20);
        ACpanel.add(aluminiumWelding_qty_textField);

        aluminiumWelding_rate_textField = new JTextField();
        aluminiumWelding_rate_textField.setColumns(10);
        aluminiumWelding_rate_textField.setBounds(807, 178, 86, 20);
        ACpanel.add(aluminiumWelding_rate_textField);

        aluminiumWelding_amount_textField = new JTextField();
        aluminiumWelding_amount_textField.setColumns(10);
        aluminiumWelding_amount_textField.setBounds(912, 178, 86, 20);
        ACpanel.add(aluminiumWelding_amount_textField);

        chckbxOilOringsAc = new JCheckBox("(A/C) Full service, Oil, Orings, A/C Filter, Vaccum & regas");
        chckbxOilOringsAc.setBounds(507, 203, 191, 23);
        ACpanel.add(chckbxOilOringsAc);
        chckbxOilOringsAc.addItemListener(new CheckBoxListener());

        oil_orings_AC_qty_textField = new JTextField();
        oil_orings_AC_qty_textField.setColumns(10);
        oil_orings_AC_qty_textField.setBounds(705, 202, 86, 20);
        ACpanel.add(oil_orings_AC_qty_textField);

        oil_orings_AC_rate_textField = new JTextField();
        oil_orings_AC_rate_textField.setColumns(10);
        oil_orings_AC_rate_textField.setBounds(807, 202, 86, 20);
        ACpanel.add(oil_orings_AC_rate_textField);

        oil_orings_AC_amount_textField = new JTextField();
        oil_orings_AC_amount_textField.setColumns(10);
        oil_orings_AC_amount_textField.setBounds(912, 202, 86, 20);
        ACpanel.add(oil_orings_AC_amount_textField);

        chckbxResistant = new JCheckBox("Resistant");
        chckbxResistant.setBounds(18, 588, 97, 23);
        ACpanel.add(chckbxResistant);
        chckbxResistant.addItemListener(new CheckBoxListener());

        resistant_qty_textField = new JTextField();
        resistant_qty_textField.setColumns(10);
        resistant_qty_textField.setBounds(130, 589, 86, 20);
        ACpanel.add(resistant_qty_textField);

        resistant_rate_textField = new JTextField();
        resistant_rate_textField.setColumns(10);
        resistant_rate_textField.setBounds(238, 589, 86, 20);
        ACpanel.add(resistant_rate_textField);

        resistant_amount_textField = new JTextField();
        resistant_amount_textField.setColumns(10);
        resistant_amount_textField.setBounds(353, 589, 86, 20);
        ACpanel.add(resistant_amount_textField);

        chckbxAcBelt = new JCheckBox("(A/C)  Belt");
        chckbxAcBelt.setBounds(18, 640, 102, 23);
        ACpanel.add(chckbxAcBelt);
        chckbxAcBelt.addItemListener(new CheckBoxListener());

        acBelt_qty_textFileld = new JTextField();
        acBelt_qty_textFileld.setColumns(10);
        acBelt_qty_textFileld.setBounds(130, 641, 86, 20);
        ACpanel.add(acBelt_qty_textFileld);

        acBelt_rate_textFileld = new JTextField();
        acBelt_rate_textFileld.setColumns(10);
        acBelt_rate_textFileld.setBounds(238, 641, 86, 20);
        ACpanel.add(acBelt_rate_textFileld);

        acBelt_amount_textFileld = new JTextField();
        acBelt_amount_textFileld.setColumns(10);
        acBelt_amount_textFileld.setBounds(353, 641, 86, 20);
        ACpanel.add(acBelt_amount_textFileld);

        chckbxLiquidLane = new JCheckBox("Liquid Line");
        chckbxLiquidLane.setBounds(507, 305, 97, 23);
        ACpanel.add(chckbxLiquidLane);
        chckbxLiquidLane.addItemListener(new CheckBoxListener());

        liquidLane_qty_textField = new JTextField();
        liquidLane_qty_textField.setColumns(10);
        liquidLane_qty_textField.setBounds(705, 307, 86, 20);
        ACpanel.add(liquidLane_qty_textField);

        liquidLane_rate_textField = new JTextField();
        liquidLane_rate_textField.setColumns(10);
        liquidLane_rate_textField.setBounds(807, 306, 86, 20);
        ACpanel.add(liquidLane_rate_textField);

        liquidLane_amount_textField = new JTextField();
        liquidLane_amount_textField.setColumns(10);
        liquidLane_amount_textField.setBounds(912, 306, 86, 20);
        ACpanel.add(liquidLane_amount_textField);

        chckbxFittings = new JCheckBox("Fittings");
        chckbxFittings.setBounds(18, 614, 109, 23);
        ACpanel.add(chckbxFittings);
        chckbxFittings.addItemListener(new CheckBoxListener());

        Fittings_qty_textField = new JTextField();
        Fittings_qty_textField.setColumns(10);
        Fittings_qty_textField.setBounds(130, 616, 86, 20);
        ACpanel.add(Fittings_qty_textField);

        Fittings_rate_textField = new JTextField();
        Fittings_rate_textField.setColumns(10);
        Fittings_rate_textField.setBounds(238, 615, 86, 20);
        ACpanel.add(Fittings_rate_textField);

        Fittings_amount_textField = new JTextField();
        Fittings_amount_textField.setColumns(10);
        Fittings_amount_textField.setBounds(353, 615, 86, 20);
        ACpanel.add(Fittings_amount_textField);

        chckbxAcGas = new JCheckBox("134 a (A/C) Gas");
        chckbxAcGas.setBounds(18, 561, 109, 23);
        ACpanel.add(chckbxAcGas);
        chckbxAcGas.addItemListener(new CheckBoxListener());

        AcGas_qty_textField = new JTextField();
        AcGas_qty_textField.setColumns(10);
        AcGas_qty_textField.setBounds(130, 562, 86, 20);
        ACpanel.add(AcGas_qty_textField);

        AcGas_rate_textField = new JTextField();
        AcGas_rate_textField.setColumns(10);
        AcGas_rate_textField.setBounds(238, 562, 86, 20);
        ACpanel.add(AcGas_rate_textField);

        texAcGas_amount_textFieldtField_2 = new JTextField();
        texAcGas_amount_textFieldtField_2.setColumns(10);
        texAcGas_amount_textFieldtField_2.setBounds(353, 562, 86, 20);
        ACpanel.add(texAcGas_amount_textFieldtField_2);

        chckbxAdjustmentPully = new JCheckBox("Adjustment Pully");
        chckbxAdjustmentPully.setBounds(507, 253, 176, 23);
        ACpanel.add(chckbxAdjustmentPully);
        chckbxAdjustmentPully.addItemListener(new CheckBoxListener());

        adjustmentPully_qty_textField = new JTextField();
        adjustmentPully_qty_textField.setColumns(10);
        adjustmentPully_qty_textField.setBounds(705, 254, 86, 20);
        ACpanel.add(adjustmentPully_qty_textField);

        adjustmentPully_rate_textField = new JTextField();
        adjustmentPully_rate_textField.setColumns(10);
        adjustmentPully_rate_textField.setBounds(807, 254, 86, 20);
        ACpanel.add(adjustmentPully_rate_textField);

        adjustmentPully_amount_textField = new JTextField();
        adjustmentPully_amount_textField.setColumns(10);
        adjustmentPully_amount_textField.setBounds(912, 254, 86, 20);
        ACpanel.add(adjustmentPully_amount_textField);

        chckbxPrintWithHeader = new JCheckBox("Print with header");
        chckbxPrintWithHeader.setBounds(6, 6, 129, 23);
        ACpanel.add(chckbxPrintWithHeader);

        chckbxPrintWithoutHeader = new JCheckBox("Print without header");
        chckbxPrintWithoutHeader.setBounds(148, 6, 158, 23);
        ACpanel.add(chckbxPrintWithoutHeader);

        JLabel label_8 = new JLabel("Description");
        label_8.setBounds(539, 147, 82, 14);
        ACpanel.add(label_8);

        JLabel label_9 = new JLabel("Qty");
        label_9.setBounds(730, 147, 46, 14);
        ACpanel.add(label_9);

        JLabel label_10 = new JLabel("Rate (Rs.)");
        label_10.setBounds(818, 147, 57, 14);
        ACpanel.add(label_10);

        JLabel label_11 = new JLabel("Amount (Rs.)");
        label_11.setBounds(917, 147, 81, 14);
        ACpanel.add(label_11);

        chckbxWithWarranty = new JCheckBox("With Warranty");
        chckbxWithWarranty.setBounds(478, 535, 133, 23);
        ACpanel.add(chckbxWithWarranty);

        DisplayedinvoiceNumber = invoiceNumber + 1;
        label_invoiceNumber.setText(Integer.toString(DisplayedinvoiceNumber));

    }

    class CheckBoxListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == chckbx_Oil) {
                if (chckbx_Oil.isSelected()) {
                    try {

                        float number1 = Float.parseFloat(textField_oil_qty.getText());
                        float number2 = Float.parseFloat(textField_oil_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_oil_amount.setText(String.valueOf(result));

                        qty.add(textField_oil_qty.getText());
                        Names.add(chckbx_Oil.getText());
                        rate.add(textField_oil_rate.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                        e1.printStackTrace();
                    }

                }
            }
            if (e.getSource() == chckbxorings) {
                try {
                    if (chckbxorings.isSelected()) {
                        float number1 = Float.parseFloat(textField_orings_qty.getText());
                        float number2 = Float.parseFloat(textField_orings_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_orings_amount.setText(String.valueOf(result));

                        qty.add(textField_orings_qty.getText());
                        Names.add(chckbxorings.getText());
                        rate.add(textField_orings_rate.getText());
                        amount.add(String.valueOf(result));

                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxAcFilter) {
                try {
                    if (chckbxAcFilter.isSelected()) {
                        float number1 = Float.parseFloat(textField_acFilter_qty.getText());
                        float number2 = Float.parseFloat(textField_acFilter_Rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_acFilter_amount.setText(String.valueOf(result));

                        qty.add(textField_acFilter_qty.getText());
                        rate.add(textField_acFilter_Rate.getText());
                        Names.add(chckbxAcFilter.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxAcFanMotor) {
                try {
                    if (chckbxAcFanMotor.isSelected()) {
                        float number1 = Float.parseFloat(textField_fanMotor_rate.getText());
                        float number2 = Float.parseFloat(textField_acFanMotor_qty.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_acFanMotor_amount.setText(String.valueOf(result));

                        qty.add(textField_acFanMotor_qty.getText());
                        rate.add(textField_fanMotor_rate.getText());
                        Names.add(chckbxAcFanMotor.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxCondenser) {
                try {
                    if (chckbxCondenser.isSelected()) {
                        float number1 = Float.parseFloat(textField_condenser_rate.getText());
                        float number2 = Float.parseFloat(textField_condenser_qty.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_condenser_amount.setText(String.valueOf(result));

                        qty.add(textField_condenser_qty.getText());
                        rate.add(textField_condenser_rate.getText());
                        Names.add(chckbxCondenser.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxCooler) {
                try {
                    if (chckbxCooler.isSelected()) {
                        float number1 = Float.parseFloat(textField_cooler_rate.getText());
                        float number2 = Float.parseFloat(textField_cooler_qty.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_cooler_amount.setText(String.valueOf(result));

                        qty.add(textField_cooler_qty.getText());
                        rate.add(textField_cooler_rate.getText());
                        Names.add(chckbxCooler.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxCompressor) {
                try {
                    if (chckbxCompressor.isSelected()) {
                        float number1 = Float.parseFloat(textField_compressor_qty.getText());
                        float number2 = Float.parseFloat(textField_compressor_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_compressor_amount.setText(String.valueOf(result));

                        qty.add(textField_compressor_qty.getText());
                        rate.add(textField_compressor_rate.getText());
                        Names.add(chckbxCompressor.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxHorse) {
                try {
                    if (chckbxHorse.isSelected()) {
                        float number1 = Float.parseFloat(textField_hose_qty.getText());
                        float number2 = Float.parseFloat(textField_hose_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_hose_amount.setText(String.valueOf(result));

                        qty.add(textField_hose_qty.getText());
                        rate.add(textField_hose_rate.getText());
                        Names.add(chckbxHorse.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxWelding) {
                try {
                    if (chckbxWelding.isSelected()) {
                        float number1 = Float.parseFloat(textField_welding_qty.getText());
                        float number2 = Float.parseFloat(textField_welding_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_welding_amount.setText(String.valueOf(result));

                        qty.add(textField_welding_qty.getText());
                        rate.add(textField_welding_rate.getText());
                        Names.add(chckbxWelding.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxRacerBearing) {
                try {
                    if (chckbxRacerBearing.isSelected()) {
                        float number1 = Float.parseFloat(textField_raceBearing_qty.getText());
                        float number2 = Float.parseFloat(textField_raceBearing_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_raceBearing_amount.setText(String.valueOf(result));

                        qty.add(textField_raceBearing_qty.getText());
                        rate.add(textField_raceBearing_rate.getText());
                        Names.add(chckbxRacerBearing.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxThermostat) {
                try {
                    if (chckbxThermostat.isSelected()) {
                        float number1 = Float.parseFloat(textField_thermostat_qty.getText());
                        float number2 = Float.parseFloat(textField_thermostat_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_thermostat_amount.setText(String.valueOf(result));

                        qty.add(textField_thermostat_qty.getText());
                        rate.add(textField_thermostat_rate.getText());
                        Names.add(chckbxThermostat.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxSonarLight) {
                try {
                    if (chckbxSonarLight.isSelected()) {
                        float number1 = Float.parseFloat(textField_sonarLights_qty.getText());
                        float number2 = Float.parseFloat(textField_SonarLights_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_SonarLIghts_amount.setText(String.valueOf(result));

                        qty.add(textField_sonarLights_qty.getText());
                        rate.add(textField_SonarLights_rate.getText());
                        Names.add(chckbxSonarLight.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxBlowerMotor) {
                try {
                    if (chckbxBlowerMotor.isSelected()) {
                        float number1 = Float.parseFloat(textField_bloweMotor_rate.getText());
                        float number2 = Float.parseFloat(textField_blowerMotor_qty.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_blowerMotor_amount.setText(String.valueOf(result));

                        qty.add(textField_blowerMotor_qty.getText());
                        rate.add(textField_bloweMotor_rate.getText());
                        Names.add(chckbxBlowerMotor.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxConnectedValve) {
                try {
                    if (chckbxConnectedValve.isSelected()) {
                        float number1 = Float.parseFloat(textField_connectedValve_qty.getText());
                        float number2 = Float.parseFloat(textField_connectedValve_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_connectedValve_amount.setText(String.valueOf(result));

                        qty.add(textField_connectedValve_qty.getText());
                        rate.add(textField_connectedValve_rate.getText());
                        Names.add(chckbxConnectedValve.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxCabinFilter) {
                try {
                    if (chckbxCabinFilter.isSelected()) {
                        float number1 = Float.parseFloat(textField_cabinFilter_qty.getText());
                        float number2 = Float.parseFloat(textField_cabinfilter_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_cabinFilter_amount.setText(String.valueOf(result));

                        qty.add(textField_cabinFilter_qty.getText());
                        rate.add(textField_cabinfilter_rate.getText());
                        Names.add(chckbxCabinFilter.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxElectric) {
                try {
                    if (chckbxElectric.isSelected()) {
                        float number1 = Float.parseFloat(textField_electric_qty.getText());
                        float number2 = Float.parseFloat(textField_electric_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_electric_amount.setText(String.valueOf(result));

                        qty.add(textField_electric_qty.getText());
                        rate.add(textField_electric_rate.getText());
                        Names.add(chckbxElectric.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxRelay) {
                try {
                    if (chckbxRelay.isSelected()) {
                        float number1 = Float.parseFloat(textField_relay_qty.getText());
                        float number2 = Float.parseFloat(textField_relay_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_relay_amount.setText(String.valueOf(result));

                        qty.add(textField_relay_qty.getText());
                        rate.add(textField_relay_rate.getText());
                        Names.add(chckbxRelay.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxAcRegas) {
                try {
                    if (chckbxAcRegas.isSelected()) {
                        float number1 = Float.parseFloat(textField_acRegas_qty.getText());
                        float number2 = Float.parseFloat(textField_acRegas_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_acRegas_amount.setText(String.valueOf(result));

                        qty.add(textField_acRegas_qty.getText());
                        rate.add(textField_acRegas_rate.getText());
                        Names.add(chckbxAcRegas.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxAcFullService) {
                try {
                    if (chckbxAcFullService.isSelected()) {
                        float number1 = Float.parseFloat(textField_acFullService_qty.getText());
                        float number2 = Float.parseFloat(textField_acFullService_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_acFullService_amount.setText(String.valueOf(result));

                        qty.add(textField_acFullService_qty.getText());
                        rate.add(textField_acFullService_rate.getText());
                        Names.add(chckbxAcFullService.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == checkBox_others2) {
                try {
                    if (checkBox_others2.isSelected()) {
                        float number1 = Float.parseFloat(textField_others2_qty.getText());
                        float number2 = Float.parseFloat(textField_others2_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_others2_amount.setText(String.valueOf(result));

                        qty.add(textField_others2_qty.getText());
                        rate.add(textField_others2_rate.getText());
                        Names.add(textField_others2.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == checkBox_others3) {
                try {
                    if (checkBox_others3.isSelected()) {
                        float number1 = Float.parseFloat(textField_others3_qty.getText());
                        float number2 = Float.parseFloat(textField_others3_rate.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_others3_amount.setText(String.valueOf(result));

                        qty.add(textField_others3_qty.getText());
                        rate.add(textField_others3_rate.getText());
                        Names.add(textField_others3.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == checkBox_others4) {
                try {
                    if (checkBox_others4.isSelected()) {
                        float number1 = Float.parseFloat(textField_others4_qty.getText());
                        float number2 = Float.parseFloat(textField_others4_rate.getText());
                        float result = number1 * number2;
                        System.out.println("result : " + result);
                        total += result;
                        total_label.setText(String.valueOf(total));
                        textField_others4_amount.setText(String.valueOf(result));

                        qty.add(textField_others4_qty.getText());
                        rate.add(textField_others4_rate.getText());
                        Names.add(textField_others4.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxEngineWash) {
                try {
                    if (chckbxEngineWash.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(engineWash_rate_textField_1.getText());
                        float number2 = Float.parseFloat(EngineWash_qty_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        engineWash_amount_textField_2.setText(String.valueOf(result));

                        qty.add(EngineWash_qty_textField.getText());
                        rate.add(engineWash_rate_textField_1.getText());
                        Names.add(chckbxEngineWash.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == oiling_checkbox) {
                try {
                    if (oiling_checkbox.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(OIling_qty_textField.getText());
                        float number2 = Float.parseFloat(Oiling_rate_textField_1.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        Oiling_amount_textField_2.setText(String.valueOf(result));

                        qty.add(OIling_qty_textField.getText());
                        rate.add(Oiling_rate_textField_1.getText());
                        Names.add(oiling_checkbox.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxFilterCleaning) {
                try {
                    if (chckbxFilterCleaning.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(FilterCleaning_qty_textField_3.getText());
                        float number2 = Float.parseFloat(FilterCleaning_rate_textField_4.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        FilteCleaning_amount_textField_5.setText(String.valueOf(result));

                        qty.add(FilterCleaning_qty_textField_3.getText());
                        rate.add(FilterCleaning_rate_textField_4.getText());
                        Names.add(chckbxFilterCleaning.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxInteriorCleaningOnly) {
                try {
                    if (chckbxInteriorCleaningOnly.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(InteriroCleaning_qty_textField_6.getText());
                        float number2 = Float.parseFloat(InteriroCleaning_rate_textField_7.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        InteriroCleaning_amount_textField_8.setText(String.valueOf(result));

                        qty.add(InteriroCleaning_qty_textField_6.getText());
                        rate.add(InteriroCleaning_rate_textField_7.getText());
                        Names.add(chckbxInteriorCleaningOnly.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxCushionCleaning) {
                try {
                    if (chckbxCushionCleaning.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(CushionCleaning_qty_textField_9.getText());
                        float number2 = Float.parseFloat(CushionCleaning_rate_textField_10.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        CushionCleaning_amount_textField_11.setText(String.valueOf(result));

                        qty.add(CushionCleaning_qty_textField_9.getText());
                        rate.add(CushionCleaning_rate_textField_10.getText());
                        Names.add(chckbxCushionCleaning.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxCarpetCleaning) {
                try {
                    if (chckbxCarpetCleaning.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(carpetCleaning_qty_textField_12.getText());
                        float number2 = Float.parseFloat(carpetCleaning_rate_textField_13.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        tcarpetCleaning__amount_extField_14.setText(String.valueOf(result));

                        qty.add(carpetCleaning_qty_textField_12.getText());
                        rate.add(carpetCleaning_rate_textField_13.getText());
                        Names.add(chckbxCarpetCleaning.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == Oil_Orings_vaccume_regas_checkBox) {
                try {
                    if (Oil_Orings_vaccume_regas_checkBox.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(OIl_Orings_Qty_textField.getText());
                        float number2 = Float.parseFloat(OIl_Orings_Rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        OIl_Orings_amount_textField.setText(String.valueOf(result));

                        qty.add(OIl_Orings_Qty_textField.getText());
                        rate.add(OIl_Orings_Rate_textField.getText());
                        Names.add(Oil_Orings_vaccume_regas_checkBox.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == other5_checkbox) {
                try {
                    if (other5_checkbox.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(other5_qty_textField.getText());
                        float number2 = Float.parseFloat(other5_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        other5_amount_textField.setText(String.valueOf(result));

                        qty.add(other5_qty_textField.getText());
                        rate.add(other5_rate_textField.getText());
                        Names.add(other5_description_textField.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == other6_checkbox) {
                try {
                    if (other6_checkbox.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(other6_qty_textField.getText());
                        float number2 = Float.parseFloat(other6_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        other6_amount_textField.setText(String.valueOf(result));

                        qty.add(other6_qty_textField.getText());
                        rate.add(other6_rate_textField.getText());
                        Names.add(other6_description_textField.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == other7_checkbox) {
                try {
                    if (other7_checkbox.isSelected()) {
                        System.out.println("check box is selected");
                        float number1 = Float.parseFloat(other7_qty_textField.getText());
                        float number2 = Float.parseFloat(other7_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        other7_amount_textField.setText(String.valueOf(result));

                        qty.add(other7_qty_textField.getText());
                        rate.add(other7_rate_textField.getText());
                        Names.add(other7_description_textField.getText());
                        amount.add(String.valueOf(result));
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            if (e.getSource() == chckbxAcServices) {
                if (chckbxAcServices.isSelected()) {
                    try {

                        // printACServices();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }

                }

            }
            if (e.getSource() == chckbxAluminiumWelding) {
                if (chckbxAluminiumWelding.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(aluminiumWelding_qty_textField.getText());
                        float number2 = Float.parseFloat(aluminiumWelding_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        aluminiumWelding_amount_textField.setText(String.valueOf(result));

                        qty.add(aluminiumWelding_qty_textField.getText());
                        rate.add(aluminiumWelding_rate_textField.getText());
                        Names.add(chckbxAluminiumWelding.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxOilOringsAc) {
                if (chckbxOilOringsAc.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(oil_orings_AC_qty_textField.getText());
                        float number2 = Float.parseFloat(oil_orings_AC_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        oil_orings_AC_amount_textField.setText(String.valueOf(result));

                        qty.add(oil_orings_AC_qty_textField.getText());
                        rate.add(oil_orings_AC_rate_textField.getText());
                        Names.add(chckbxOilOringsAc.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxAdjustmentPully) {
                if (chckbxAdjustmentPully.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(adjustmentPully_qty_textField.getText());
                        float number2 = Float.parseFloat(adjustmentPully_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        adjustmentPully_amount_textField.setText(String.valueOf(result));

                        qty.add(adjustmentPully_qty_textField.getText());
                        rate.add(adjustmentPully_rate_textField.getText());
                        Names.add(chckbxAdjustmentPully.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxAcGas) {
                if (chckbxAcGas.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(AcGas_qty_textField.getText());
                        float number2 = Float.parseFloat(AcGas_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        texAcGas_amount_textFieldtField_2.setText(String.valueOf(result));

                        qty.add(AcGas_qty_textField.getText());
                        rate.add(AcGas_rate_textField.getText());
                        Names.add(chckbxAcGas.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxResistant) {
                if (chckbxResistant.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(resistant_qty_textField.getText());
                        float number2 = Float.parseFloat(resistant_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        resistant_amount_textField.setText(String.valueOf(result));

                        qty.add(resistant_qty_textField.getText());
                        rate.add(resistant_rate_textField.getText());
                        Names.add(chckbxResistant.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxFittings) {
                if (chckbxFittings.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(Fittings_qty_textField.getText());
                        float number2 = Float.parseFloat(Fittings_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        Fittings_amount_textField.setText(String.valueOf(result));

                        qty.add(Fittings_qty_textField.getText());
                        rate.add(Fittings_rate_textField.getText());
                        Names.add(chckbxResistant.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxResistant) {
                if (chckbxResistant.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(resistant_qty_textField.getText());
                        float number2 = Float.parseFloat(resistant_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        resistant_amount_textField.setText(String.valueOf(result));

                        qty.add(resistant_qty_textField.getText());
                        rate.add(resistant_rate_textField.getText());
                        Names.add(chckbxResistant.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxVaccumCleaningOnly) {
                if (chckbxVaccumCleaningOnly.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(vaccum_cleaning_only_qty_textField.getText());
                        float number2 = Float.parseFloat(vaccum_cleaning_only_Rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        vaccum_cleaning_only_amount_textField.setText(String.valueOf(result));

                        qty.add(vaccum_cleaning_only_qty_textField.getText());
                        rate.add(vaccum_cleaning_only_Rate_textField.getText());
                        Names.add(chckbxVaccumCleaningOnly.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxCutPolish) {
                if (chckbxCutPolish.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(cutandPolishVax_qty_textField.getText());
                        float number2 = Float.parseFloat(cutandPolishVax_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        cutandPolishVax_amount_textField.setText(String.valueOf(result));

                        qty.add(cutandPolishVax_qty_textField.getText());
                        rate.add(cutandPolishVax_rate_textField.getText());
                        Names.add(chckbxCutPolish.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxVax) {
                if (chckbxVax.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(vax_qty_textField.getText());
                        float number2 = Float.parseFloat(vax_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        vax_amount_textField.setText(String.valueOf(result));

                        qty.add(vax_qty_textField.getText());
                        rate.add(vax_rate_textField.getText());
                        Names.add(chckbxVax.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxBodyWashOnly) {
                if (chckbxBodyWashOnly.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(bodyWashOnly_qty_textField.getText());
                        float number2 = Float.parseFloat(bodyWashOnly_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        bodyWashOnly_amount_textField.setText(String.valueOf(result));

                        qty.add(bodyWashOnly_qty_textField.getText());
                        rate.add(bodyWashOnly_rate_textField.getText());
                        Names.add(chckbxBodyWashOnly.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxBodyWash_1) {
                if (chckbxBodyWash_1.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(BodyWash_vaccumCleaningOnly_qty_textField.getText());
                        float number2 = Float.parseFloat(BodyWash_vaccumCleaningOnly_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        BodyWash_vaccumCleaningOnly_amount_textField.setText(String.valueOf(result));

                        qty.add(BodyWash_vaccumCleaningOnly_qty_textField.getText());
                        rate.add(BodyWash_vaccumCleaningOnly_rate_textField.getText());
                        Names.add(chckbxBodyWash_1.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxAcBelt) {
                if (chckbxAcBelt.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(acBelt_qty_textFileld.getText());
                        float number2 = Float.parseFloat(acBelt_rate_textFileld.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        acBelt_amount_textFileld.setText(String.valueOf(result));

                        qty.add(acBelt_qty_textFileld.getText());
                        rate.add(acBelt_rate_textFileld.getText());
                        Names.add(chckbxAcBelt.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (e.getSource() == chckbxLiquidLane) {
                if (chckbxLiquidLane.isSelected()) {
                    try {
                        float number1 = Float.parseFloat(liquidLane_qty_textField.getText());
                        float number2 = Float.parseFloat(liquidLane_rate_textField.getText());
                        float result = number1 * number2;
                        total += result;
                        total_label.setText(String.valueOf(total));
                        liquidLane_amount_textField.setText(String.valueOf(result));

                        qty.add(liquidLane_qty_textField.getText());
                        rate.add(liquidLane_rate_textField.getText());
                        Names.add(chckbxLiquidLane.getText());
                        amount.add(String.valueOf(result));

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Plese input a number!", "Sanjeewa Auto A/C and Body Wash",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }


        }
    }

    // method for sending parameters to the database
    public void senDataAgain() {

        months = months_textField.getText();
        DatabaseManager sendData = new DatabaseManager();
        sendData.newVersion(label_date.getText(), textField_CustomerName.getText(),
                textField_TelephoneNumber.getText(), textField_VehicleNumber.getText(), textField_Milage.getText());


    }

    public void printWithHeader() {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Quotation.pdf"));
            document.addAuthor("isuru");
            // special font sizes
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);
            document.open();

			Image image = Image
					.getInstance("C:\\Users\\JS\\Google Drive\\CarWash\\quotation-header.png");

//            Image image = Image.getInstance("F:\\Rapticon\\Car Wash\\Car Wash - Billing System\\src\\Images\\quotation-header.png");

            document.add(image);
            // create a paragraph
            Paragraph paragraph = new Paragraph("");

            document.add(new Paragraph("Customer Name: " + textField_CustomerName.getText() + "                                                     	Invoice Number : " + DisplayedinvoiceNumber));
            document.add(new Paragraph("Telephone Number : " + textField_TelephoneNumber.getText() + "                                                  Date : " + label_date.getText()));

            document.add(new Paragraph("Vehicle Number : " + textField_VehicleNumber.getText()));
            document.add(new Paragraph("Milage : " + textField_Milage.getText()));
            document.add(new Paragraph(" "));
            // specify column widths
            float[] columnWidths = {0.8f, 5f, 2f, 2f};
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
            for (int x = 0; x < Names.size(); x++) {

                insertCell(table, qty.get(x), Element.ALIGN_RIGHT, 1, bf12);
                insertCell(table, Names.get(x), Element.ALIGN_LEFT, 1, bf12);
                insertCell(table, rate.get(x), Element.ALIGN_RIGHT, 1, bf12);
                insertCell(table, amount.get(x), Element.ALIGN_RIGHT, 1, bf12);
            }
            insertCell(table, "Total = ", Element.ALIGN_RIGHT, 3, bfBold12);
            insertCell(table, String.valueOf(total), Element.ALIGN_RIGHT, 1, bfBold12);

            // add the PDF table to the paragraph
            paragraph.add(table);
            // add the paragraph to the document
            document.add(paragraph);
            if (chckbxForFullAc.isSelected()) {
                document.add(new Paragraph(chckbxForFullAc.getText()));
            }
            if (chckbxWithWarranty.isSelected()) {
                document.add(new Paragraph("* With warranty : " + Warranty_textField.getText() + " " + months_textField.getText() + " months"));
            }

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

    public void printWithoutHeader() {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Quotation.pdf"));
            document.addAuthor("isuru");
            // special font sizes
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);
            document.open();

            // create a paragraph
            Paragraph paragraph = new Paragraph("");
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Customer Name: " + textField_CustomerName.getText() + "                                                     Invoice Number : " + DisplayedinvoiceNumber));
            document.add(new Paragraph("Telephone Number : " + textField_TelephoneNumber.getText() + "                                                  Date : " + label_date.getText()));
            document.add(new Paragraph("Vehicle Number : " + textField_VehicleNumber.getText()));
            document.add(new Paragraph("Milage : " + textField_Milage.getText()));
            document.add(new Paragraph(" "));
            // specify column widths
            float[] columnWidths = {0.8f, 5f, 2f, 2f};
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
            for (int x = 0; x < Names.size(); x++) {

                insertCell(table, qty.get(x), Element.ALIGN_RIGHT, 1, bf12);
                insertCell(table, Names.get(x), Element.ALIGN_LEFT, 1, bf12);
                insertCell(table, rate.get(x), Element.ALIGN_RIGHT, 1, bf12);
                insertCell(table, amount.get(x), Element.ALIGN_RIGHT, 1, bf12);
            }
            insertCell(table, "Total = ", Element.ALIGN_RIGHT, 3, bfBold12);
            insertCell(table, String.valueOf(total), Element.ALIGN_RIGHT, 1, bfBold12);

            // add the PDF table to the paragraph
            paragraph.add(table);
            // add the paragraph to the document
            document.add(paragraph);
            if (chckbxForFullAc.isSelected()) {
                document.add(new Paragraph(chckbxForFullAc.getText()));
            }
            if (chckbxWithWarranty.isSelected()) {
                document.add(new Paragraph("* With warranty : " + Warranty_textField.getText() + " " + months_textField.getText() + " months"));
            }

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
}
