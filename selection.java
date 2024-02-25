/* create database project;
 * use project;
 * CREATE table addressbook(name varchar(30),address varchar(40),no float);
 * 
 */


 import java.sql.*;
 import java.util.*;
 
 public class selection{
     public static void main(String[] args) {
         Connection con ;
         Statement st;
         ResultSet rs;
         Scanner s = new Scanner(System.in);
         try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8","root","");
             st = con.createStatement();
             //selection
             String str="Select * from addressbook";
             rs=st.executeQuery(str);
             while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("address"));
                System.out.println(rs.getString("no"));
             }
         }
         catch(Exception e){
             System.out.println(e);
         }
         finally{
             s.close();
         }
     }
 }