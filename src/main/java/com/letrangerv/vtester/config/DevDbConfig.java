package com.letrangerv.vtester.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
@Configuration
public class DevDbConfig implements DbConfig {
    @Bean
    public final DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder
            .setType(EmbeddedDatabaseType.H2)
            .addScript("src/main/resources/sql/ddl/schema-dev.sql")
            .addScript("src/main/resources/sql/ddl/dataload-dev.sql");
        return builder.build();
    }

    @Bean
    public final PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
