package com.lopez.data.migration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lopez.data.migration.mapper")
@SpringBootApplication
public class DataMigrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataMigrationApplication.class, args);
    }
}
