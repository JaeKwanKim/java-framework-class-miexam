package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by JKKim on 2016. 4. 22..
 */
public interface GetConnectionInterface {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
