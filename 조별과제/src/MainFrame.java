import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MainFrame {

   private JFrame Mainframe;
   private JTextField id_txt;
   private JPasswordField pw_txt;
   public static int seat;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MainFrame window = new MainFrame();
               window.Mainframe.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public MainFrame() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      Mainframe = new JFrame();
      Mainframe.getContentPane().setBackground(Color.WHITE);
      Mainframe.setTitle("PC\uBC29");
      Mainframe.setResizable(false);
      Mainframe.setBounds(100, 100, 1192, 767);
      Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Mainframe.getContentPane().setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      panel.setBounds(0, 30, 1186, 461);
      Mainframe.getContentPane().add(panel);
      panel.setLayout(new GridLayout(4, 4, 30, 30));
      
      JButton seat1 = new JButton("1");
      seat1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=1;
            seat1.setBackground(Color.LIGHT_GRAY);
            seat1.enable(false);
         }
      });
      seat1.setForeground(Color.WHITE);
      seat1.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat1.setBackground(Color.PINK);
      panel.add(seat1);
      
      JButton seat2 = new JButton("2");
      seat2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=2;
            seat2.setBackground(Color.LIGHT_GRAY);
            seat2.enable(false);
         }
      });
      seat2.setForeground(Color.WHITE);
      seat2.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat2.setBackground(Color.PINK);
      panel.add(seat2);
      
      JButton seat3 = new JButton("3");
      seat3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=3;
            seat3.setBackground(Color.LIGHT_GRAY);
            seat3.enable(false);
         }
      });
      seat3.setForeground(Color.WHITE);
      seat3.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat3.setBackground(Color.PINK);
      panel.add(seat3);
      
      JButton seat4 = new JButton("4");
      seat4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=4;
            seat4.setBackground(Color.LIGHT_GRAY);
            seat4.enable(false);
         }
      });
      seat4.setForeground(Color.WHITE);
      seat4.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat4.setBackground(Color.PINK);
      panel.add(seat4);
      
      JButton seat5 = new JButton("5");
      seat5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=5;
            seat5.setBackground(Color.LIGHT_GRAY);
            seat5.enable(false);
         }
      });
      seat5.setForeground(Color.WHITE);
      seat5.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat5.setBackground(Color.PINK);
      panel.add(seat5);
      
      JButton seat6 = new JButton("6");
      seat6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=6;
            seat6.setBackground(Color.LIGHT_GRAY);
            seat6.enable(false);
         }
      });
      seat6.setForeground(Color.WHITE);
      seat6.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat6.setBackground(Color.PINK);
      panel.add(seat6);
      
      JButton seat7 = new JButton("7");
      seat7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=7;
            seat7.setBackground(Color.LIGHT_GRAY);
            seat7.enable(false);
         }
      });
      seat7.setForeground(Color.WHITE);
      seat7.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat7.setBackground(Color.PINK);
      panel.add(seat7);
      
      JButton seat8 = new JButton("8");
      seat8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=8;
            seat8.setBackground(Color.LIGHT_GRAY);
            seat8.enable(false);
         }
      });
      seat8.setForeground(Color.WHITE);
      seat8.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat8.setBackground(Color.PINK);
      panel.add(seat8);
      
      JButton seat9 = new JButton("9");
      seat9.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=9;
            seat9.setBackground(Color.LIGHT_GRAY);
            seat9.enable(false);
         }
      });
      seat9.setForeground(Color.WHITE);
      seat9.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat9.setBackground(Color.PINK);
      panel.add(seat9);
      
      JButton seat10 = new JButton("10");
      seat10.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=10;
            seat10.setBackground(Color.LIGHT_GRAY);
            seat10.enable(false);
         }
      });
      seat10.setForeground(Color.WHITE);
      seat10.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat10.setBackground(Color.PINK);
      panel.add(seat10);
      
      JButton seat11 = new JButton("11");
      seat11.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=11;
            seat11.setBackground(Color.LIGHT_GRAY);
            seat11.enable(false);
         }
      });
      seat11.setForeground(Color.WHITE);
      seat11.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat11.setBackground(Color.PINK);
      panel.add(seat11);
      
      JButton seat12 = new JButton("12");
      seat12.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=12;
            seat12.setBackground(Color.LIGHT_GRAY);
            seat12.enable(false);
         }
      });
      seat12.setForeground(Color.WHITE);
      seat12.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat12.setBackground(Color.PINK);
      panel.add(seat12);
      
      JButton seat13 = new JButton("13");
      seat13.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=13;
            seat13.setBackground(Color.LIGHT_GRAY);
            seat13.enable(false);
         }
      });
      seat13.setForeground(Color.WHITE);
      seat13.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat13.setBackground(Color.PINK);
      panel.add(seat13);
      
      JButton seat14 = new JButton("14");
      seat14.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=14;
            seat14.setBackground(Color.LIGHT_GRAY);
            seat14.enable(false);
         }
      });
      seat14.setForeground(Color.WHITE);
      seat14.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat14.setBackground(Color.PINK);
      panel.add(seat14);
      
      JButton seat15 = new JButton("15");
      seat15.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=15;
            seat15.setBackground(Color.LIGHT_GRAY);
            seat15.enable(false);
         }
      });
      seat15.setForeground(Color.WHITE);
      seat15.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat15.setBackground(Color.PINK);
      panel.add(seat15);
      
      JButton seat16 = new JButton("16");
      seat16.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            seat=16;
            seat16.setBackground(Color.LIGHT_GRAY);
            seat16.enable(false);
         }
      });
      seat16.setForeground(Color.WHITE);
      seat16.setBorder(new LineBorder(SystemColor.controlHighlight));
      seat16.setBackground(Color.PINK);
      panel.add(seat16);
      ArrayList<String> a = DB.getCustomers();// ¹öÆ°»ö»ó¹Ù²Ù´Â°Å »ý¼º
      for (int i = 0; i < a.size(); i++)// ¹öÆ°»ö»ó¹Ù²Ù±â
      {
         switch (a.get(i)) {
         case "1":
            seat1.setBackground(Color.gray);
            break;
         case "2":
            seat2.setBackground(Color.gray);
            break;
         case "3":
            seat3.setBackground(Color.gray);
            break;
         case "4":
            seat4.setBackground(Color.gray);
            break;
         case "5":
            seat5.setBackground(Color.gray);
            break;
         case "6":
            seat6.setBackground(Color.gray);
            break;
         case "7":
            seat7.setBackground(Color.gray);
            break;
         case "8":
            seat8.setBackground(Color.gray);
            break;
         case "9":
            seat9.setBackground(Color.gray);
            break;
         case "10":
            seat10.setBackground(Color.gray);
            break;
         case "11":
            seat11.setBackground(Color.gray);
            break;
         case "12":
            seat12.setBackground(Color.gray);
            break;
         case "13":
            seat13.setBackground(Color.gray);
            break;
         case "14":
            seat14.setBackground(Color.gray);
            break;
         case "15":
            seat15.setBackground(Color.gray);
            break;
         case "16":
            seat16.setBackground(Color.gray);
            break;
         }
      }
      int s2=seat;
      JPanel panel_1 = new JPanel();
      panel_1.setBackground(new Color(245, 245, 245));
      panel_1.setBounds(0, 530, 1186, 208);
      Mainframe.getContentPane().add(panel_1);
      panel_1.setLayout(null);
      
      JLabel login_label = new JLabel("LOGIN");
      login_label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
      login_label.setHorizontalAlignment(SwingConstants.CENTER);
      login_label.setBounds(819, 25, 57, 15);
      panel_1.add(login_label);
      
      JLabel id_label = new JLabel("\uD68C\uC6D0 \uC544\uC774\uB514 :");
      id_label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
      id_label.setHorizontalAlignment(SwingConstants.CENTER);
      id_label.setBounds(699, 66, 99, 15);
      panel_1.add(id_label);
      
      JLabel pw_label = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
      pw_label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
      pw_label.setHorizontalAlignment(SwingConstants.CENTER);
      pw_label.setBounds(699, 105, 99, 15);
      panel_1.add(pw_label);
      
      id_txt = new JTextField();
      id_txt.setBounds(798, 63, 116, 21);
      panel_1.add(id_txt);
      id_txt.setColumns(10);
      
      pw_txt = new JPasswordField();
      pw_txt.setBounds(798, 102, 116, 21);
      panel_1.add(pw_txt);
      
      JButton login_btn = new JButton("\uB85C\uADF8\uC778");
      login_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            try{
               if(seat==0) JOptionPane.showMessageDialog(null, "ÁÂ¼®À» ¼±ÅÃÇØÁÖ¼¼¿ä");
               DB.login(id_txt.getText(),pw_txt.getText(),seat);
               if(DB.result && seat!=0) {
               JOptionPane.showMessageDialog(null, "·Î±×ÀÎ ¼º°ø!");
               Desk.main(null);
               ClientGUI.main(null);


               Mainframe.setVisible(false);
               }
            }
            catch(Exception e){
               System.out.println("±âº»Å° Áßº¹");
            }
         }
      });
      login_btn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
      login_btn.setBackground(Color.WHITE);
      login_btn.setBounds(926, 62, 97, 61);
      panel_1.add(login_btn);
      
      JButton search_idpw = new JButton("ID/PW \uCC3E\uAE30");
      search_idpw.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             Search.main(null);
         }
      });
      search_idpw.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
      search_idpw.setBackground(Color.WHITE);
      search_idpw.setBounds(738, 140, 106, 23);
      panel_1.add(search_idpw);
      
      JButton join_btn = new JButton("\uD68C\uC6D0\uAC00\uC785");
      join_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Join.main(null);
         }
      });
      join_btn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
      join_btn.setBackground(Color.WHITE);
      join_btn.setBounds(873, 140, 97, 23);
      panel_1.add(join_btn);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project\\image\\hellow.jpeg"));
      
      lblNewLabel.setBounds(100, 28, 500, 153);
      panel_1.add(lblNewLabel);
      
   }
 
}