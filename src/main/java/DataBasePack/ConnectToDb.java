package DataBasePack;
import java.sql.*;

public class ConnectToDb {

    Connection con;
    Statement stmt;

    public void ConDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "Automatic@123");
//here productdb is database name, root is username and password
            stmt=con.createStatement();
            //WriteDB();
           // ReadDB();
            //con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void ReadDB() {
        try {

            ResultSet rs = stmt.executeQuery("select * from product");
            while (rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getLong(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + " " + rs.getDouble(6));
                con.close();
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
    public void WriteDB()
    {
        try{

            System.out.println("Inserting records into the table...");

                    /*String sql = ("INSERT INTO product" +"VALUES ('A106','ponds',80,'white','Body_cream',2)");
                        stmt.executeUpdate(sql);*/
            System.out.println("Inserted records into the table...");
            String query = " insert into product (productid,name,price,color,category,discountpercent)"
                    + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, "A108");
            preparedStmt.setString (2, "tea");
            preparedStmt.setLong   (3, 80);
            preparedStmt.setString(4, "black");
            preparedStmt.setString(5, "Drink");
            preparedStmt.setDouble (6, 2);

            preparedStmt.execute();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }


    public static void main(String args[]){

            ConnectToDb DB1=new ConnectToDb();
            DB1.ConDataBase();
            //WriteDB();
            DB1.ReadDB();

    }
}
