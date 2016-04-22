package kr.ac.jejunu.userdao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

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

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        context = new GenericXmlApplicationContext("XmlApplicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        long id = 158L;
        String name = "김재관";
        String password = "1234";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        userDao.update(user);

        User user2 = userDao.get(id);

        assertThat(id, is(user2.getId()));
        assertEquals(name, user2.getName());
        assertEquals(password, user2.getPassword());
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        context = new GenericXmlApplicationContext("XmlApplicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        String name = "김재관";
        String password = "1234";

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        long id = userDao.add(user);

        userDao.delete(id);

        assertNull(userDao.get(id));
    }
}
