package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private GetConnectionInterface connetionMaker;

    public void setConnetionMaker(GetConnectionInterface connetionMaker) {
        this.connetionMaker = connetionMaker;
    }

    public long add(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into test(name, password) values(?,?)";
        long id = 0;
        Connection connection= null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connetionMaker.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
            id = getLastInsertId(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
        return id;
    }
    public User get(Long id) throws ClassNotFoundException, SQLException {

        String sql = "select * from test where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user;
        try{
            connection = connetionMaker.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (resultSet != null)
            try {
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
            }
            if (preparedStatement != null)
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (connection != null)
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
