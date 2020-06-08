package DataBasePack;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectToDb {

    Connection con;
    Statement stmt;

    public ConnectToDb() {
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
    public String readDB(String query) {
        try {
            ObjectMapper objectmapper=new ObjectMapper();
            ArrayNode arrayNode=objectmapper.createArrayNode();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {


                ObjectNode  objectNode=objectmapper.createObjectNode();

                //System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getLong(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + " " + rs.getDouble(6));
                objectNode.put("productId", rs.getString(1));
                objectNode.put("name", rs.getString(2));
                objectNode.put("price",rs.getString(3));
                objectNode.put("color",rs.getString(4));
                objectNode.put("category",rs.getString(5));
                objectNode.put("discountpercent",rs.getString(6));
                arrayNode.add(objectNode);

            }
            return arrayNode.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return null;
    }


    public String readById(List<String> idList)
    {
        String query="select * from product where productId in (";
        for(int i=0;i<idList.size();i++)
        {
            query= query+'"'+idList.get(i)+'"';
            if(i!=idList.size()-1)
            {
                query=query+",";
            }
        }
        query=query+")";
        System.out.println(query);
        return readDB(query);
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
            System.out.println(DB1.readById(new ArrayList<String>(Arrays.asList("A105","A103"))));//WriteDB();


    }
}
