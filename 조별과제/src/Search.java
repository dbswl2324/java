import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class Search extends JFrame {

   private JPanel contentPane;
   private final JPanel panel = new JPanel();
   private JLabel lasearch;
   private JLabel laname;
   private JLabel labirth;
   private JLabel laphone;
   private JButton btnID;
   private JButton btnPW;
   private JTextField idTxt;
   private JTextField birthTxt;
   private JTextField phoneTxt;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Search frame = new Search();
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
   public Search() {
      setTitle("ID/PW Ã£±â");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 500);
      setLocationRelativeTo(null);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      panel.setBounds(0, 0, 384, 461);
      contentPane.add(panel);
      panel.setLayout(null);
      
      JButton btnclose = new JButton("\uB2EB\uAE30");
      btnclose.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      btnclose.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });
      btnclose.setBounds(40, 358, 294, 51);
      panel.add(btnclose);
      
      lasearch = new JLabel("ID/PW \uCC3E\uAE30");
      lasearch.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
      lasearch.setHorizontalAlignment(SwingConstants.CENTER);
      lasearch.setBounds(12, 10, 360, 51);
      panel.add(lasearch);
      
      laname = new JLabel("\uC774\uB984");
      laname.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      laname.setBounds(48, 96, 67, 41);
      panel.add(laname);
      
      labirth = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
      labirth.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      labirth.setBounds(48, 150, 67, 41);
      panel.add(labirth);
      
      laphone = new JLabel("\uC804\uD654\uBC88\uD638");
      laphone.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      laphone.setBounds(48, 201, 67, 41);
      panel.add(laphone);
      
      btnID = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
      
      btnID.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      btnID.setBounds(40, 284, 129, 51);
      panel.add(btnID);
      
      btnPW = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
      btnPW.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            DB.searchMember(idTxt.getText(),Integer.parseInt(birthTxt.getText()),Integer.parseInt(phoneTxt.getText()),1);            
         }
      });
      btnPW.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      btnPW.setBounds(205, 284, 129, 51);
      panel.add(btnPW);
      
      idTxt = new JTextField();
      idTxt.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      idTxt.setColumns(10);
      idTxt.setBounds(139, 100, 136, 34);
      panel.add(idTxt);
      
      birthTxt = new JTextField();
      birthTxt.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      birthTxt.setColumns(10);
      birthTxt.setBounds(139, 154, 136, 34);
      panel.add(birthTxt);
      
      phoneTxt = new JTextField();
      phoneTxt.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
      phoneTxt.setColumns(10);
      phoneTxt.setBounds(139, 205, 136, 34);
      panel.add(phoneTxt);
      btnID.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
            DB.searchMember(idTxt.getText(),Integer.parseInt(birthTxt.getText()),Integer.parseInt(phoneTxt.getText()),0);            
            }catch(NumberFormatException e1) {
                  JOptionPane.showMessageDialog(null, "¼ýÀÚ¸¸ ÀÔ·ÂÇÏ¼¼¿ä!");
            }
            }
      });
   }
}