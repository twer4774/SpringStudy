import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by TempSW on 2016. 4. 28..
 */
public class UserDaoTest {
 @Test
    public void get() throws SQLException, ClassNotFoundException {
     UserDao userDao = new UserDao();

     Long id = 1L;
     String name = "허윤호";
     String password = "1234";

     User user = userDao.get(id);

     assertThat(user.getId(), is(id));
     assertThat(user.getName(), is(name));
     assertThat(user.getPassword(), is(password));

 }

 @Test
  public void add() throws SQLException, ClassNotFoundException {
    User user = new User();

    String name = "헐크";
    String password = "2222";

    user.setName(name);
    user.setPassword(password);

    UserDao userDao = new UserDao();
    Long id = userDao.add(user);

    User resultSet = userDao.get(id);

    assertThat(resultSet.getId(), is(id));
    assertThat(resultSet.getName(), is(name));
    assertThat(resultSet.getPassword(), is(password));

 }

}
