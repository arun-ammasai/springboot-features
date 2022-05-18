package com.bcv.app.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoadData {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoadData.class);

    public void insertData() {
        LOGGER.info("> Inserting data...");
        jdbcTemplate.execute("insert into person (ID,ADDRESS,EMAIL,FIRST_NAME,LAST_NAME,PINCODE)values(1,'Chennai','xyz@gmail.com','Jack','Daniel',600096)");
        jdbcTemplate.execute("insert into person (ID,ADDRESS,EMAIL,FIRST_NAME,LAST_NAME,PINCODE)values(2,'Bangalore','abc@gmail.com','Phil','Coulson',600090)");
        jdbcTemplate.execute("insert into person (ID,ADDRESS,EMAIL,FIRST_NAME,LAST_NAME,PINCODE)values(3,'Delhi','uvw@gmail.com','Caption','Roger',600097)");
        jdbcTemplate.execute("insert into person (ID,ADDRESS,EMAIL,FIRST_NAME,LAST_NAME,PINCODE)values(4,'Chennai','test@gmail.com','Johndy','Rodes',600098)");
        jdbcTemplate.execute("insert into person (ID,ADDRESS,EMAIL,FIRST_NAME,LAST_NAME,PINCODE)values(5,'Andhra','dummy@gmail.com','Mystic','Falls',600099)");
    }
}
