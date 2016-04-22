package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by JKKim on 2016. 4. 22..
 */
public interface MakeStatement {
        PreparedStatement makeStatement(Connection connection) throws SQLException;
}
