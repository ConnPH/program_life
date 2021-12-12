package com.dizikou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dizikou.system.mapper")
public class SystemAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemAdminApplication.class, args);
    }

}
