/* create database project;
 * use project;
 * CREATE table addressbook(name varchar(30),address varchar(40),no float);
 * 
 */


import java.sql.*;
import java.util.*;

public class AddressBook{
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
                    String ss = "admin";
                    String password = "admin";
                    System.out.println("Enter username and password");
                    String userid = s.nextLine();
                    String pass=s.nextLine();
                    if((userid.equals(ss)) && (pass.equals(password))) { //only admin can log into the system
                        System.out.println("\n\nWELCOME TO ADDRESS BOOK SYSTEM");
                        System.out.println("==============================\n\n");
                        System.out.println("Enter your choice:\n\n1.Insert new record\n2.Update existing record\n3.Delete record\n4.View all records\n5.exit\n");
                        int ch = s.nextInt();
                        
                        switch(ch){
                            case 1: insert();
                                    break;
                            case 2: update();
                                    break;
                            case 3: delete();
                                    break;
                            case 4: select();
                                    break;
                            default: System.out.println("Goodbye");
                        }
                    } else  {
                        System.out.println("Invalid UserID or Password!");
                    }
                
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            s.close();
        }
    }

    public static void insert(){
            Connection con ;
            Statement st;
            float no;
            String name,address;
            Scanner s1 = new Scanner(System.in);
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=utf8","root","");
                System.out.println("Enter name, address and phone number: ");
                name=s1.nextLine();
                address = s1.nextLine();
                no=s1.nextFloat();
                st = con.createStatement();
                // Insert into the database
                String str="insert into addressbook values(";
                str = str + "'"+ name + "','";
                str = str + address + "',";
                str = str + no +")";
                System.out.println(str);
                st.executeUpdate(str);
                System.out.println("Record  inserted successfully!");
            }
            catch(Exception e){
                System.out.println(e);
            }
            finally {
                s1.close();
            }      
    }
    public static void update(){
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
    public static void delete(){
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
    public static void select(){
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
                System.out.print("NAME: ");
                System.out.println(rs.getString("name"));
                System.out.print("ADDRESS: ");
                System.out.println(rs.getString("address"));
                System.out.print("NUMBER: ");
                System.out.println(rs.getString("no"));
                System.out.println("\n");
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