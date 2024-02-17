package com.example.snowconnectiontest.config;

import com.example.snowconnectiontest.utils.PrivateKeyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    private PrivateKeyReader keyReader;


    @Bean
    public DataSource dataSource() throws Exception {

        //add private key to properties
        Properties prop = new Properties();
        prop.put("privateKey", keyReader.get(env.getProperty("snowflake.auth.key.path"),env.getProperty("snowflake.auth.key.passphrase")));

       //prepare a datasource
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        //dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setConnectionProperties(prop);

        return dataSource;
    }
}
