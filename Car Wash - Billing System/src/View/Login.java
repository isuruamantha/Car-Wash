package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.Color;

public class Login extends JFrame {

    private JPanel background_contentPane;
    private JTextField textField_userName;
    private JPasswordField textField_userPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        UIManager.put("RootPane.setupButtonVisible", false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        background_contentPane = new JPanel();
        background_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(background_contentPane);
        background_contentPane.setLayout(null);

        JPanel panel_Login = new JPanel();
        panel_Login.setBounds(311, 223, 358, 213);
        background_contentPane.add(panel_Login);
        panel_Login.setLayout(null);

        JLabel lbl_userName = new JLabel("User Name : ");
        lbl_userName.setBounds(40, 65, 99, 14);
        panel_Login.add(lbl_userName);

        JLabel lbl_userPassword = new JLabel("User Password : ");
        lbl_userPassword.setBounds(40, 113, 99, 14);
        panel_Login.add(lbl_userPassword);

        textField_userName = new JTextField();
        textField_userName.setBounds(149, 62, 143, 20);
        panel_Login.add(textField_userName);
        textField_userName.setColumns(10);

        JButton btn_LogIn = new JButton("Log in");
        btn_LogIn.setBackground(new Color(0, 255, 255));
        btn_LogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_LogIn.setIcon(new ImageIcon(Login.class.getResource("/Images/User-Interface-Login-icon (1).png")));

        // this button for login
        btn_LogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                authentication();
            }
        });
        btn_LogIn.setBounds(203, 164, 99, 38);
        panel_Login.add(btn_LogIn);

        textField_userPassword = new JPasswordField();
        textField_userPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    authentication();
                }
            }
        });
        textField_userPassword.setBounds(149, 107, 143, 20);
        panel_Login.add(textField_userPassword);

        JLabel label_imagePanel = new JLabel("");
        label_imagePanel
                .setIcon(new ImageIcon(Login.class.getResource("/Images/tumblr_static_ddi5olaj3io8skk8o00wo04k8.jpg")));
        label_imagePanel.setBounds(0, 0, 358, 213);
        panel_Login.add(label_imagePanel);

        JLabel label_logo = new JLabel("");
        label_logo.setIcon(new ImageIcon(Login.class.getResource("/Images/FinalLogo-resizedToSmall.png")));
        label_logo.setBounds(298, 29, 407, 183);
        background_contentPane.add(label_logo);

        JLabel lblDesignedDeveloped = new JLabel("Designed & developed by Isuru Amantha  |  0719720510");
        lblDesignedDeveloped.setBounds(566, 631, 432, 14);
        background_contentPane.add(lblDesignedDeveloped);

        JLabel label_background = new JLabel("");
        label_background
                .setIcon(new ImageIcon(Login.class.getResource("/Images/tumblr_static_ddi5olaj3io8skk8o00wo04k8.jpg")));
        label_background.setBounds(-27, -17, 1295, 778);
        background_contentPane.add(label_background);

        /*Dummy data*/
//        textField_userName.setText("sanjeewa");
//        textField_userPassword.setText("123");

    }

    public void authentication() {
        // user name is == gayani || sanjeewa
        // password is = 123 || 456

        String passText = new String(textField_userPassword.getPassword());
        System.out.println(passText);

        if (textField_userName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input the user name!", "Sanjeewa Auto A/" + "C and Body Wash",
                    JOptionPane.WARNING_MESSAGE);
        } else if (textField_userPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input the password!", "Sanjeewa Auto A/C " + "and Body Wash",
                    JOptionPane.WARNING_MESSAGE);
        } else if (textField_userName.getText().equals("sanjeewa") && passText.equals("123")) {
            JOptionPane.showMessageDialog(null, "Login succed!", "Sanjeewa Auto A/C and Body Wash",
                    JOptionPane.INFORMATION_MESSAGE);
            new HomeScreen().main();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "User name and password is incorrect. Try again!",
                    "Sanjeewa Auto A/C and Body Wash", JOptionPane.ERROR_MESSAGE);
        }

    }
}
