package au.edu.sydney.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Chris
 * @date 2021-09-14 19:37
 * @description
 */
@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix= "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }

}
