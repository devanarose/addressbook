/* create database project;
 * use project;
 * CREATE table addressbook(name varchar(30),address varchar(40),no float);
 * 
 */


 import java.sql.*;
 import java.util.*;
 
 public class delete{
     public static void main(String[] args) throws Exception {
         Connection con ;
         Statement st;
         String name;
         Scanner s = new Scanner(System.in);
         try {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8","root","");
             st = con.createStatement();
             System.out.println("Enter the name to be deleted");
             name=s.nextLine();
             //deleting
             String str="delete from  addressbook where name='"+name+"'";
             System.out.println(str);
             st.executeUpdate(str);
             System.out.println("Record deleted successfully!");
         }
         catch(Exception e){
             System.out.println(e);
         }
         finally{
             s.close();
         }
     }
 }