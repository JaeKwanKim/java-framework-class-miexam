package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JKKim on 2016. 4. 1..
 */
@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDaoJeju() {
        return new UserDao(ConnectionMakerJeju());
    }

    @Bean
    public UserDao userDaoHalla() {
        return new UserDao(connectionMakerHalla());
    }

    @Bean
    public GetConnectionInterface ConnectionMakerJeju() {
        return  new GetConnectionMakerJeju();
    }

    @Bean
    public GetConnectionInterface connectionMakerHalla() {
        return  new GetConnectionMakerHalla();
    }
}
