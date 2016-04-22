package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JKKim on 2016. 4. 1..
 */
@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(ConnectionMaker());
    }

    @Bean
    public UserDao userDaoHalla() {
        return new UserDao(connectionMakerHalla());
    }

    @Bean
    public GetConnectionInterface ConnectionMaker() {
        return  new GetConnectionMaker();
    }

    @Bean
    public GetConnectionInterface connectionMakerHalla() {
        return  new GetConnectionMakerHalla();
    }
}
