import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Desk extends JFrame {
	   public static String abc;

   private JPanel contentPane;
   public static int time_price;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Desk frame = new Desk();
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
   
   public Desk() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1083, 685);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBackground(new Color(255, 255, 255));
      
      panel_1.setBounds(55, 0, 1067, 646);
      contentPane.add(panel_1);
      panel_1.setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.PINK);
      panel.setBorder(new LineBorder(new Color(0, 0, 0)));
      panel.setBounds(683, 30, 301, 165);
      panel_1.add(panel);
      panel.setLayout(null);
      
      JLabel la_timer = new JLabel("New label");
      la_timer.setForeground(Color.WHITE);
      la_timer.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
      la_timer.setBounds(169, 41, 84, 29);
      panel.add(la_timer);
      TimerRunnable runnable = new TimerRunnable(la_timer);
      
      JLabel lblNewLabel = new JLabel("\uC0AC\uC6A9\uC2DC\uAC04 :");
      lblNewLabel.setForeground(Color.WHITE);
      lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
      lblNewLabel.setBounds(50, 38, 105, 34);
      panel.add(lblNewLabel);
      
      JButton btnNewButton_1 = new JButton("\uC0AC\uC6A9\uC885\uB8CC");
      btnNewButton_1.setBackground(Color.WHITE);
      
      btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
      btnNewButton_1.setBounds(74, 80, 152, 54);
      panel.add(btnNewButton_1);
      
      JLabel lblNewLabel_2 = new JLabel(MainFrame.seat+"");
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
      lblNewLabel_2.setForeground(Color.WHITE);
      lblNewLabel_2.setBounds(50, 21, 57, 15);
      panel.add(lblNewLabel_2);
      Thread th=new Thread(runnable);
      setVisible(true);
      th.start();
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            th.interrupt();
            dispose();
         }
      });
      JButton btnorder = new JButton("\uC74C\uC2DD\uC8FC\uBB38");
      btnorder.setForeground(Color.WHITE);
      btnorder.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            FoodFrame_1.main(null);
         }
      });
      btnorder.setBackground(new Color(216, 191, 216));
      btnorder.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
      btnorder.setBounds(429, 30, 162, 47);
      panel_1.add(btnorder);
      
      JLabel la1 = new JLabel("");
      la1.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\\uAC8C\uC784.jpg"));
      la1.setBounds(35, 253, 220, 176);
      panel_1.add(la1);
      
      JLabel la2 = new JLabel("");
      la2.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\\uBA54\uC2E0\uC800.png"));
      la2.setBounds(279, 253, 220, 176);
      panel_1.add(la2);
      
      JLabel la3 = new JLabel("");
      la3.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\\uBB38\uC11C.jpg"));
      la3.setBounds(529, 253, 220, 176);
      panel_1.add(la3);
      
      JLabel la4 = new JLabel("");
      la4.setIcon(new ImageIcon("C:\\\uC790\uBC14\uD559\uC2B5\\Project _1\\image\\\uC778\uD130\uB137.png"));
      la4.setBounds(797, 253, 220, 176);
      panel_1.add(la4);
      
      JLabel lblNewLabel_1 = new JLabel("\uAC8C\uC784");
      lblNewLabel_1.setForeground(Color.BLACK);
      lblNewLabel_1.setBackground(Color.WHITE);
      lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(59, 443, 162, 47);
      panel_1.add(lblNewLabel_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("\uBA54\uC2E0\uC800");
      lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1_1.setForeground(Color.BLACK);
      lblNewLabel_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
      lblNewLabel_1_1.setBackground(Color.WHITE);
      lblNewLabel_1_1.setBounds(294, 443, 162, 47);
      panel_1.add(lblNewLabel_1_1);
      
      JLabel lblNewLabel_1_1_1 = new JLabel("\uBB38\uC11C");
      lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1_1_1.setForeground(Color.BLACK);
      lblNewLabel_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
      lblNewLabel_1_1_1.setBackground(Color.WHITE);
      lblNewLabel_1_1_1.setBounds(552, 443, 162, 47);
      panel_1.add(lblNewLabel_1_1_1);
      
      JLabel lblNewLabel_1_1_1_1 = new JLabel("\uC778\uD130\uB137");
      lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
      lblNewLabel_1_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
      lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
      lblNewLabel_1_1_1_1.setBounds(822, 443, 162, 47);
      panel_1.add(lblNewLabel_1_1_1_1);
      
      JButton siba = new JButton("New button");
      siba.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		 ClientGUI.main(null);
      	}
      });
      siba.setBounds(678, 253, 105, 27);
      panel_1.add(siba);
      
      System.out.println(MainFrame.seat);
      abc=lblNewLabel_2.getText();
      
   }
   public String Seat() {
	   return abc;
   }
}

   class TimerRunnable implements Runnable{
      private JLabel timerlabel;
      
   
      public TimerRunnable(JLabel timerlabel) {
         this.timerlabel=timerlabel;
         
         
      }
   public void run() {
      
      int second=0;
      int minute=0;
      int hour=0;
      while(true) {
         if(second>59) {
            minute++;
            second=0;
         }
         if(minute>59) {
               hour++;
               minute=0;
         }
         
         timerlabel.setText(Integer.toString(hour)+":"+Integer.toString(minute)+":"+Integer.toString(second));
         second++;
      
         try {
            Thread.sleep(1000);
         }
         catch(InterruptedException e) {
            
            if(minute>=0  || second>=0)
               Desk.time_price+=1000;
            Desk.time_price += hour*1000;
            DB.insertOrder(MainFrame.seat,"null","0",Desk.time_price,"¹Ì¿Ï·á");
            return ;
         }
      }
      }
   }