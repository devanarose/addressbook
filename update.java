/* create database project;
 * use project;
 * CREATE table addressbook(name varchar(30),address varchar(40),no float);
 * 
 */


 import java.sql.*;
 import java.util.*;
 
 public class update{
     public static void main(String[] args) throws Exception {
         Connection con ;
         Statement st;
         float no;
         String name,address;
         Scanner s = new Scanner(System.in);
         try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8","root","");
             st = con.createStatement();
             System.out.println("Enter name, new address and phone number: ");
             name=s.nextLine();
             address = s.nextLine();
             no=s.nextFloat();
             // update
             String str="update addressbook set address = '";
             str = str + address + "',"+"no='"+no+"' where name='"+name+"';";
             System.out.println(str);
             st.executeUpdate(str);
             System.out.println("Record updated successfully!");
         }
         catch(Exception e){
             System.out.println(e);
         }
         finally{
             s.close();
         }
     }
 }