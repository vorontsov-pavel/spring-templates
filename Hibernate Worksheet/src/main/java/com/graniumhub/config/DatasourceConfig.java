package com.graniumhub.config;

import net.ttddyy.dsproxy.listener.DataSourceQueryCountListener;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/**
 * Created by Sasha.Chepurnoi on 28.11.16.
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.graniumhub.repo")
public class DatasourceConfig {


    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driverClassName}")
    private String driverClass;


    @Bean
    public DataSource dataSource() {
        DataSource ds = DataSourceBuilder.create().driverClassName(driverClass).username(username).url(url).build();
        ProxyDataSource proxy = new ProxyDataSource();
        proxy.setDataSource(ds);
        proxy.setListener(new DataSourceQueryCountListener());
        return proxy;
    }


}
