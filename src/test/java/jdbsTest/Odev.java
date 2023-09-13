package jdbsTest;

import org.junit.Assert;
import org.junit.Test;
import java.sql.*;

public class Odev {

    //Database üzerinden students tablosundaki firstname= Edward ve lastname= Thomas olan
    //öğrencinin email bilgisinin edvard@gmail.com olduğunu doğrulayınız.

    @Test
    public void query01() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://194.140.198.209/wonderworld_qa2",
                "wonderworld_qawcollegeuser",
                "1gvyfx6#Q");

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String query = "select email from wonderworld_qa2.students where firstname='Edward' and lastname='Thomas'";

        ResultSet resultSet =statement.executeQuery(query);
        resultSet.next();
        System.out.println(resultSet.getString("email"));

        String expectedData ="edward@gmail.com";
        String actualData = resultSet.getString("email");

        Assert.assertEquals(expectedData,actualData);


    }

}
