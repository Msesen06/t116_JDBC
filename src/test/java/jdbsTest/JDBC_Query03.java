package jdbsTest;

import org.junit.Assert;
import reusableMethodJDBC.ReusableMethod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class JDBC_Query03 {
    /*
    Wonder World College Database Access Information
    type : jdbc:mysql
    host/ip : 194.140.198.209
    port : 3306
    database_name : wonderworld_qa2
    username : wonderworld_qawcollegeuser
    password :1gvyfx6#Q

     */

    public static void main(String[] args) throws SQLException {

        Statement statement = ReusableMethod.setUpStatement(ReusableMethod.setUpConnection());

        ResultSet resultSet =statement.executeQuery("select * from wonderworld_qa2.staff");

        resultSet.next();
        System.out.println(resultSet.getString("name"));

        String actualData = resultSet.getString("name");
        String expectedData ="Joe";

        assertEquals(expectedData,actualData);




    }
}
