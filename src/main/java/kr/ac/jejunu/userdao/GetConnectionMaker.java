package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionMaker implements GetConnectionInterface {
    private String ClassName;
    private String url;
    private String userName;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    private String password;
    public GetConnectionMaker() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(ClassName);
        return DriverManager.getConnection(url, userName, password);
    }
}