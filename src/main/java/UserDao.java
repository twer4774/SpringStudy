import java.sql.*;

/**
 * Created by TempSW on 2016. 4. 28..
 */
public class UserDao {
    public User get(Long id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conneticon = DriverManager.getConnection("jdbc:mysql://db.skyserv.kr/jejunu", "jeju", "jejupw");

        String sql = "select * from userinfo where id = ?";

        PreparedStatement preparedStatement = conneticon.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultset = preparedStatement.executeQuery();
        resultset.next();

        User user = new User();
        user.setId(resultset.getLong("id"));
        user.setName(resultset.getString("name"));
        user.setPassword(resultset.getString("password"));

        return user;
    }
}
