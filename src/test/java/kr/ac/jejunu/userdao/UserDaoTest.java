package kr.ac.jejunu.userdao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private ApplicationContext context;

    @Test
    public void AddJeju() throws SQLException, ClassNotFoundException {
        context = new GenericXmlApplicationContext("XmlApplicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

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
        context = new GenericXmlApplicationContext("XmlApplicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
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
        context = new GenericXmlApplicationContext("XmlApplicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
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
