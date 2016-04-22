package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionMaker implements GetConnectionInterface {
    private String ClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String userName = "root";
    private String password = "";

    public GetConnectionMaker() {
    }

    public GetConnectionMaker(String className, String url, String userName, String password) {
        ClassName = className;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

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

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(ClassName);
        return DriverManager.getConnection(url, userName, password);
    }
}