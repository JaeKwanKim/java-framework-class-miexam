package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    public long add(User user) throws ClassNotFoundException, SQLException {
        //Driver Class Load
        Class.forName("com.mysql.jdbc.Driver");
        // Connection    접속정보는? localhost jeju id : jeju pw: jejupw
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "");
        // 쿼리만들고
        String sql = "insert into test(name, password) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        // 실행
        preparedStatement.executeUpdate();
        long id = getLastInsertId(connection);
        //자원을 해지한다.
        preparedStatement.close();
        connection.close();

        return id;
    }
    public User get(Long id) throws ClassNotFoundException, SQLException {
        //데이터는어디에?   Mysql
        //Driver Class Load
        Class.forName("com.mysql.jdbc.Driver");
        // Connection    접속정보는? localhost jeju id : jeju pw: jejupw
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "");
        // 쿼리만들고
        String sql = "select * from test where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        // 실행
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        // 결과매핑
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        //자원을 해지한다.
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public long getLastInsertId(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select last_insert_id()");

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        long id = resultSet.getLong(1);

        resultSet.close();
        preparedStatement.close();

        return id;
    }
}
