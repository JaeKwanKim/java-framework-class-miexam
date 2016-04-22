package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private jdbcContext context;
    private GetConnectionInterface connetionMaker;

    public void setContext(kr.ac.jejunu.userdao.jdbcContext context) {
        this.context = context;
    }

    public void setConnetionMaker(GetConnectionInterface connetionMaker) {
        this.connetionMaker = connetionMaker;
    }

    public long add(User user) throws ClassNotFoundException, SQLException {
//        String sql = "insert into test(name, password) values(?,?)";
        MakeStatement statement = new AddUserStatementStrategy(user);
        long id = context.jdbcContextWithStatementStrategyForInsert(statement);
//        long id = 0;
//        Connection connection= null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = connetionMaker.getConnection();
//            preparedStatement = statement.makeStatement(connection);
//            preparedStatement.executeUpdate();
//            id = getLastInsertId(connection);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (preparedStatement != null)
//                try {
//                    preparedStatement.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            if (connection != null)
//                try {
//                    connection.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//    }

        return id;
    }
    public User get(Long id) throws ClassNotFoundException, SQLException {
//        String sql = "select * from test where id = ?";
        MakeStatement statement = new GetUserStatementStrategy();
        User user = context.jdbcContextwithStatementStrategyForQuery(statement);
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        User user = new User();
//        try{
//            connection = connetionMaker.getConnection();
//            statement.makeStatement(connection);
//            resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//
//            if(resultSet != null) {
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setPassword(resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            if (resultSet != null)
//            try {
//            resultSet.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            }
//            if (preparedStatement != null)
//            try {
//                preparedStatement.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            if (connection != null)
//            try {
//                connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return user;
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
//        String sql = "update test set name=?, password=? where id=?";
        MakeStatement statement = new UpdateUserStatementStratgy(user);
        context.jdbcContextWithStatementStarategy(statement);
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try{
//            connection = connetionMaker.getConnection();
//            statement.makeStatement(connection);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            if (preparedStatement != null)
//                try {
//                    preparedStatement.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            if (connection != null)
//                try {
//                    connection.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//        }
    }

    public void delete(long id) throws SQLException, ClassNotFoundException {
//        String sql = "DELETE FROM test where id=?";
        MakeStatement statement = new DeleteUserStatementStratgy(id);
        context.jdbcContextWithStatementStarategy(statement);
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
    }

}
