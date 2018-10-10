import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args){

        final String DB_NAME = "jdbc:mysql://localhost:3306/mydb?verifyServerCertificate=false&useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String USER = "root";
        final String PASSWORD = "3366";

        final String SELECT_BOOKS = "SELECT b.Book_name FROM Books b JOIN Authors a WHERE b.idBook=a.idBook and a.Author_name = \"Михаил Лермонтов\"";


        try {
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection(DB_NAME,USER,PASSWORD);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(SELECT_BOOKS);
                List<String> books = new ArrayList<>();
                while (resultSet.next()){
                    String book = resultSet.getString(1);
                    books.add(book);
                }
                for (String book : books) {
                    System.out.println(book);
                }
            }finally {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
