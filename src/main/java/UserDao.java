import java.sql.*;

/**
 * Created by TempSW on 2016. 4. 28..
 */
public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conneticon = DriverManager.getConnection("jdbc:mysql://db.skyserv.kr/jejunu?characterEncoding=utf-8", "jeju", "jejupw");

        String sql = "select * from userinfo where id = ?";

        PreparedStatement preparedStatement = conneticon.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        conneticon.close();

        return user;
    }

    public Long add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conneticon = DriverManager.getConnection("jdbc:mysql://db.skyserv.kr/jejunu?characterEncoding=utf-8", "jeju", "jejupw");

        String sql = "insert into userinfo(name, password) values(?,?) ";

        PreparedStatement preparedStatement = conneticon.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();

        PreparedStatement preparedStatement2 = conneticon.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement2.executeQuery();
        resultSet.next();

        Long id = resultSet.getLong(1);

        resultSet.close();
        preparedStatement.close();
        preparedStatement2.close();
        conneticon.close();

        return id;
    }
}
