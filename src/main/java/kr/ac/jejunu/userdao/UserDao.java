package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    public long add(User user) throws ClassNotFoundException, SQLException {
        GetConnectionInterface connectionMaker = new GetConnectionMaker();
        Connection connection = connectionMaker.getConnection();

        String sql = "insert into test(name, password) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();
        long id = getLastInsertId(connection);

        preparedStatement.close();
        connection.close();

        return id;
    }
    public User get(Long id) throws ClassNotFoundException, SQLException {
        GetConnectionInterface connectionMaker = new GetConnectionMaker();
        Connection connection = connectionMaker.getConnection();

        String sql = "select * from test where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

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
