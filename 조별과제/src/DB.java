import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DB {
   static boolean result;
   static boolean ma;
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      getConnection();
     createOrderTable();
    createTotalTable();
      //getseat();
   }
   //DB연동
   public static Connection getConnection() {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
      String user = "root";
      String pass = "1234";
      
      try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url,user,pass);
         System.out.println("DB 연결 완료!");
         return conn;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
   
   public static void createMemberTable() {                      //회원 테이블 생성
      try {
         Connection conn=getConnection(); //db연결 conn 객체
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"member(Mid varchar(15) not null ,"             //회원 아이디
                     +"name varchar(20) not null,"            //회원 이름
                     +"pass varchar(20) not null, "            //회원 비밀번호
                     +"birth varchar(8) not null, "            //회원 생년월일(yyyymmdd)
                     +"phone varchar(11) not null, "            //회원 휴대폰 번호
                     +"address varchar(30) not null,"
                     + "primary key(Mid)) ");            //회원 주소(동까지만 기술)                  //회원 아이디를 기본키로 설정
               
               create.execute();
               System.out.println("회원 테이블 생성 완료");
               
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   
   public static void createProductTable() {                        //상품 테이블 생성
      try {
         Connection conn=getConnection(); //db연결 conn 객체
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"product(prodid int not null auto_increment,"
                     +"name varchar(40) not null,"
                     +"price varchar(15) not null, "
                     +"num varchar(10) not null, "
                     +"primary key(prodid))");
               
               create.execute();
               System.out.println("상품 테이블 생성 완료");
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   

   
   public static void createOrderTable() {                   //주문 테이블
      try {
         Connection conn=getConnection(); //db연결 conn 객체
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"orderT(rownum int not null AUTO_INCREMENT,"
                     + "seat int(3) not null,"          //회원 좌석 번호 
                     +"foodname varchar(40) not null, "       //음식명
                     +"num int(3) not null, "
                     + "mon int, "             //주문수량
                     +"state varchar(10) not null,"
                     + "primary key(rownum)) "         //배송 완료/미완료 나타내기
                     );
         
               create.execute();
               System.out.println("주문 테이블 생성 완료");
               
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   
   
   
   public static void createTotalTable(){                    //매출 테이블
      try {
         Connection conn=getConnection(); //db연결 conn 객체
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"total(num int not null auto_increment,"      //매출 번호
                     +"date datetime not null,"         //시간
                     +"price int(15) not null, "            //결제금액
                     +"primary key(num))");               //매출번호 기본키
               
               create.execute();
               System.out.println("매출 테이블 생성 완료");
               
         
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void createLoginTable(){                       //매출 테이블
      try {
         Connection conn=getConnection(); //db연결 conn 객체
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"login(id varchar(15) not null, "               //회원 아이디
                     +"seat int(3) not null,"               //좌석 번호
                     +"date datetime not null,"
                     + "primary key(seat))"               //로그인한 시간
                  );
                  
               
               create.execute();
               System.out.println("로그인 테이블 생성 완료");
               
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

   
   public static void login(String id, String pass,int seat) {  //로그인(id/pass 조회)
      
      try {
         Connection conn = getConnection(); //DB연결 conn객체 
         PreparedStatement statement = conn.prepareStatement(
               "SELECT * FROM member WHERE Mid=? AND pass=?");
         statement.setString(1, id);
         statement.setString(2, pass);
         ResultSet results = statement.executeQuery();
         if(results.next()) { 
           if(seat!=0) {
            insertInfo(id,seat); //login db에 아이디랑 좌석번호 삽입
            // 원래 있던 창 dispose , 새프레임 
            insertOrder (seat,"0","0",1000,"완료");
            result=true;
           }
         } else {
            JOptionPane.showMessageDialog(null, "아이디나 패스워드가 틀립니다");
            result=false;
         }
   
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void insertInfo(String id,int seat) {            //로그인 성공시 login db에 아이디랑 좌석번호 시간 저장
      //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      //Date date = new Date();
      
      try {
         Connection conn = getConnection(); //DB연결 conn객체 
         PreparedStatement insert = conn.prepareStatement(
               "insert into login(id,seat,date) "
                     + "values ('"+ id+"',"+seat+",now())");
         insert.execute();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
 

   //회원가입한 사용자의 개인정보 삽입
   public static void insertMember(String id, String name, String pass, int birth, int phone, String address) {
      try {
         Connection conn = getConnection(); // DB연결 conn객체
         PreparedStatement insert = conn.prepareStatement("INSERT INTO member (Mid,name,pass,birth,phone,address)"
               + "SELECT '" + id + "','" + name + "','" + pass + "'," + birth + "," + phone + ",'" + address
               + "' FROM DUAL" + " WHERE NOT EXISTS (SELECT * FROM member WHERE Mid='" + id + "'and phone=" + phone
               + ");");

         insert.execute();

      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public static void insertOrder(int seat,String name,String num,int mon,String state) {             //로그인 성공시 login db에 아이디랑 좌석번호 시간 저장
      
      try {
         Connection conn = getConnection(); //DB연결 conn객체 
         PreparedStatement insert = conn.prepareStatement(
               "insert into ordert(seat,foodname,num,mon,state) "
                     + "values ('"+seat+"','"+name+"',"+Integer.parseInt(num)+","+mon+",'"+state+"')");
         insert.execute();
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void insertTotal(int price){
      try {
            Connection conn = getConnection(); //DB연결 conn객체 
            PreparedStatement insert = conn.prepareStatement(
                  "insert into total(date,price) "
                        + "values (now(),"+price+")");
            insert.execute();
            
         } catch (Exception e) {
            e.printStackTrace();
         }
   }
   
   public static void createMLoginTable(){                       //매출 테이블
      try {
         Connection conn=getConnection(); //db연결 conn 객체
         PreparedStatement create=conn.prepareStatement(
               "create table if not exists "
               +"manager(mid varchar(15) not null, "             
                     +"mpass varchar(15) not null,"               
                     + "primary key(mid))"               //로그인한 시간
                  );
                  
               
               create.execute();
               System.out.println("직원로그인 테이블 생성 완료");
               
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   public static String[][] getOrder() {
         try {
            Connection conn = getConnection(); //DB연결 conn객체 
            PreparedStatement statement = conn.prepareStatement(
                  "SELECT * FROM ordert");
            ResultSet results = statement.executeQuery();
            ArrayList<String[]> list = new ArrayList<String[]>();
            while(results.next()) {
              if(results.getString("state").equals("미완료")) {
               list.add(new String[] {
                      results.getString("rownum"),
                     results.getString("seat"),
                     results.getString("foodname"),
                     results.getString("num"),
                     results.getString("mon"),
                     results.getString("state"),
               });            
            }}
            System.out.println("검색되었습니다.");
            String [][] arr = new String[list.size()][5];
            return list.toArray(arr);
            
         } catch (Exception e) {
            e.printStackTrace();
            return null;
         }
      }
   public static void mlogin(String mid, String mpass) {        //로그인(id/pass 조회)
      try {
         Connection conn = getConnection(); //DB연결 conn객체 
         PreparedStatement statement = conn.prepareStatement(
               "SELECT * FROM manager WHERE mid=? AND mpass=?");
         statement.setString(1, mid);
         statement.setString(2, mpass);
         ResultSet results = statement.executeQuery();
         if(results.next()) { 
            JOptionPane.showMessageDialog(null, "로그인 성공!");
            ma=true;
         } else {
            JOptionPane.showMessageDialog(null, "아이디나 패스워드가 틀립니다");
            ma=false;
         }
   
      } catch (Exception e) {
         e.printStackTrace();
      }
      
         
   }
   public static ArrayList<String> getCustomers(){
      try{
         Connection con = getConnection();
         PreparedStatement statement = con.prepareStatement("Select seat FROM login");
         ResultSet results = statement.executeQuery();
         ArrayList<String> list = new ArrayList<String>();
         while(results.next()){
            list.add(results.getString("seat"));
         }
         System.out.println("The data has been fetched");
         return list;
         
      }catch(Exception e){
         System.out.println(e.getMessage());
         return null;
      }
   }
   

//주문한 음식이 배달됐을 경우 주문 테이블의 상태(state)를 완료로 바꿔주는 메소드
public static void updateState(int row, String text) {
   try {
      Connection conn = getConnection();// db연결 conn객체
      PreparedStatement update = conn
            .prepareStatement("UPDATE  ordert set state='" + text + "' WHERE rownum='" +row+"'");


      update.execute();
      System.out.println("수정완료");

   } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();

   }
}

public static String[][] getTotal() {
    try {
       Connection conn = getConnection(); //DB연결 conn객체 
       PreparedStatement statement = conn.prepareStatement(
             "SELECT * FROM total");
       ResultSet results = statement.executeQuery();
       ArrayList<String[]> list = new ArrayList<String[]>();
       while(results.next()) {
      
          list.add(new String[] {
                results.getString("num"),
                results.getString("date"),
                results.getString("price"),
          });            }
       
       System.out.println("검색되었습니다.");
       String [][] arr = new String[list.size()][3];
       return list.toArray(arr);
       
    } catch (Exception e) {
       e.printStackTrace();
       return null;
    }
 }




//id와 pw 찾는 메소드 매개변수의 값(num)이 0이면 아이디를 출력, 1이면 비밀번호를 출력
public static void searchMember(String name, int birth, int phone, int num) {
   String id = "", pass = "";
   try {
      Connection conn = getConnection();// db연결 conn객체
      PreparedStatement select = conn
            .prepareStatement("select Mid,pass from member where name=? and birth=? and phone=?");
      select.setString(1, name);
      select.setLong(2, birth);
      select.setLong(3, phone);

      select.execute();
      System.out.println("아이디 찾기");
      ResultSet rs = select.executeQuery();

      ArrayList<ArrayList<String>> data_arr = new ArrayList<ArrayList<String>>();

      if (rs.next()) {
         do {
            ArrayList<String> imsi = new ArrayList<String>();

            imsi.add(rs.getString("Mid"));

            imsi.add(rs.getString("pass"));

            data_arr.add(imsi);

         } while (rs.next());

         String[][] data = new String[data_arr.size()][2];

         for (int i = 0; i < data_arr.size(); i++) {

            ArrayList<String> al = data_arr.get(i);

            for (int j = 0; j < 2; j++) {

               data[i][j] = al.get(j);
            }
         }
         if( data[0][num].toString()==null)    JOptionPane.showMessageDialog(null, "존재하는 정보가 없습니다.");
         JOptionPane.showMessageDialog(null, "회원의 정보는 " + data[0][num].toString() + "입니다");
      }
   } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();

   }
}

//총 결제하는 시스템(현재는 주문테이블에 있는 가격만 계산되서 출력)
public static void payment(int seat) {
   int total=0;
      try {
         Connection conn = getConnection();// db연결 conn객체
         PreparedStatement select = conn
               .prepareStatement("select o.seat, o.foodname, ifnull(sum(o.mon),0) sum from ordert o  where o.seat=? group by o.seat");
         select.setLong(1, seat);
         select.execute();
         
         ResultSet rs = select.executeQuery();

         ArrayList<ArrayList<String>> data_arr = new ArrayList<ArrayList<String>>();

         if (rs.next()) {
            do {
               ArrayList<String> imsi = new ArrayList<String>();

               imsi.add(rs.getString("seat"));

               imsi.add(rs.getString("foodname"));

               imsi.add(rs.getString("sum"));
               
               
               data_arr.add(imsi);

            } while (rs.next());

            String[][] data = new String[data_arr.size()][3];

            for (int i = 0; i < data_arr.size(); i++) {

               ArrayList<String> al = data_arr.get(i);

               for (int j = 0; j < 3; j++) {

                  data[i][j] = al.get(j);
               }
            }
             total=Integer.parseInt(data[0][2].toString());
            
         }
         JOptionPane.showMessageDialog(null, "회원의 정보는 " + total + "원 입니다");
         insertTotal(total);
         deleteOrder(seat);
         
      }
      catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
   }
}


public static void deleteLogin(int seat) {
   try {
      Connection conn = getConnection();// db연결 conn객체
      PreparedStatement delete = conn
            .prepareStatement("delete from login where seat=? ");
      delete.setLong(1, seat);
      delete.execute();
      
      int results = delete.executeUpdate();
      System.out.println("삭제 완료");
   } catch(Exception e) {
      e.printStackTrace();
   }
}

public static void deleteOrder(int seat){
   try {
      Connection conn = getConnection();// db연결 conn객체
      PreparedStatement delete = conn
            .prepareStatement("delete from ordert where seat=? ");
      delete.setLong(1, seat);
      delete.execute();
      
      int results = delete.executeUpdate();
      System.out.println("삭제 완료");
   } catch(Exception e) {
      e.printStackTrace();
   }
}

public static void updateStateToSeat(int seat) {
   try {
      Connection conn = getConnection();// db연결 conn객체
      PreparedStatement update = conn
            .prepareStatement("UPDATE  ordert set state='완료' WHERE rownum='" +seat+"'");


      update.execute();
      System.out.println("수정완료");

   } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();

   }
}
public static ArrayList<String> getseat(){
      try{
         Connection con = getConnection();
         PreparedStatement statement = con.prepareStatement("Select price FROM total");
         ResultSet results = statement.executeQuery();
         ArrayList<String> list = new ArrayList<String>();

         while(results.next()){
             list.add(results.getString("price"));
          }

         return list;
      }catch(Exception e){
         System.out.println(e.getMessage());
         return null;
      }
   }

}



