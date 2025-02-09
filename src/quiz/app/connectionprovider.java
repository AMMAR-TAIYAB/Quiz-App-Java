package quiz.app;

import java.sql.*;
/**
 *
 * @author chatt
 */
public class connectionprovider {
    public static Connection getCon()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","C@rc1rcar");
            return con;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
    

