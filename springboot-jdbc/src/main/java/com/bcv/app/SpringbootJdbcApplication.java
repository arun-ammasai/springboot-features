package com.bcv.app;

import com.bcv.app.data.LoadData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJdbcApplication implements CommandLineRunner {

    @Autowired
    LoadData data;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        data.insertData();
    }
}
