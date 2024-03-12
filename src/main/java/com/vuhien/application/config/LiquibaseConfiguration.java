package com.vuhien.application.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
public class LiquibaseConfiguration {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:config/liquibase/master.xml"); // Đặt changelog file của bạn ở đây
        liquibase.setContexts("dev"); // Đặt contexts nếu cần
        liquibase.setTag("test");
        liquibase.setDropFirst(false); // Đặt giá trị true nếu bạn muốn xóa cơ sở dữ liệu trước khi áp dụng thay đổi
        return liquibase;
    }
}
