package jdbsTest;

import java.sql.*;


public class JDBC_Query01 {
    /*
    Wonder World College Database Access Information
    type : jdbc:mysql
    host/ip : 194.140.198.209
    port : 3306
    database_name : wonderworld_qa2
    username : wonderworld_qawcollegeuser
    password :1gvyfx6#Q

     */

    //bir jdbc sorgusu yapılmak istendiğinde yapılacak ilk iş
    //Database yoneticisi ile iletisime gecerek ilgili database in Access degerlerini almak olacak

    //URL "jdbc:mysql://194.140.198.209/wonderworld_qa2"
    //USERNAME "wonderworld_qawcollegeuser"
    //PASSWORD ="1gvyfx6#Q"

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1 .Adım veritabanı icin dogru surucu eklemek
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.Adım veritabanı ile iletisimi  baslat
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://194.140.198.209/wonderworld_qa2","wonderworld_qawcollegeuser","1gvyfx6#Q");

        //daha sonra connections kullanabilmek icin bir variable olusturduk

        //3.Adım  SQL sorgularını yonetebilmek icin bir suite hazırla

        Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //statement olusturmak icin connection olmak zorunda
        //connection.createStatement()

        //4.Adım SQL sorgularını calıstır, sonuc al, isle
        String query = "SELECT * FROM wonderworld_qa2.staff";

        statement.executeQuery(query);

        ResultSet resultSet =statement.executeQuery(query);
        resultSet.next();

       while (resultSet.next()){
           System.out.println(resultSet.getString("name")+ "---"+resultSet.getString("employee_id"));
       }

        //System.out.println(resultSet.getArray("name"));

        // Bir SQL query'sini Java kodlari ile calistirmak istiyorsak o SQL kodunu ozel ayarlanmis bir suite icerisine almamiz gerekiyor.
        // Hazirladigimiz bu suit = Statement. Dolayisiyla Statement olmadan bir SQL query'sini Database'e gonderemeyiz.
        // Olusturulan statement'i kullanarak executeQuery() methodu ile SQL sorgumuzu Database'e gondeririz.
        // Yine statement ile donen ResultSet icindeki datalari islemek icin onu bir ResultSet objesine atama yapariz.
        // Elde ettigimiz Result Set icinde islem yapabilmek icin Iterator'dan yardim aliriz.

        //resultSet.next();
        //System.out.println(resultSet.getString("name"));


        resultSet.close();
        statement.close();
        connection.close();
    }
}
