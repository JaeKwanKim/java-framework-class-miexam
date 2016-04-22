package kr.ac.jejunu.userdao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    @Test
    public void AddJeju() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao(new GetConnectionMakerJeju());
//        UserDao userDaoJeju = new UserDao();

        String name = "김재관";
        String password = "1234";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        long id = userDao.add(user);
        System.out.println(id);
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
//        UserDao userDaoJeju = new UserDao();
        UserDao userDao = new UserDao(new GetConnectionMakerJeju());

        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void AddHalla() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao(new GetConnectionMakerHalla());
//        UserDao userDaoJeju = new UserDao();

        String name = "김재관";
        String password = "1234";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        long id = userDao.add(user);
        System.out.println(id);
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());

    }
}
