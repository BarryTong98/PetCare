package au.edu.sydney;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Chris
 * @date 2021-09-14 19:20
 */
@MapperScan(value = "au.edu.sydney.web.dao")
@SpringBootApplication
public class SpringApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}

