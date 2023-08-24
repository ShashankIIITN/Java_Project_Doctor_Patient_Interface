import java.sql.*;  
class FetchRecord{  
public static void main(String args[])throws Exception{  
  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ap project","root","");  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select `Email`, `Password` from `signup data`");  
  
//getting the record of 3rd row  
while (rs.next()) {
    System.out.println(rs.getString(1)+ " " + rs.getString(2));  
    
}
  
con.close();  
}};