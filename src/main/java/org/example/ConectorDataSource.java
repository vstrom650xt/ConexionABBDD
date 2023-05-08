package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConectorDataSource {

    public static DataSource getMysSQLDataSource() {
        Properties properties = new Properties();
        MysqlDataSource mysqlDataSource = null;
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            properties.load(fis);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
            mysqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNMAE"));
            mysqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {

            e.printStackTrace();
        }
            return  mysqlDataSource;
    }

}
