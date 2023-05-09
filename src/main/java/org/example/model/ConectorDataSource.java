package org.example.model;

import com.mysql.cj.jdbc.MysqlDataSource;
import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class ConectorDataSource {
// esto es lo q conecta a ka bbdd
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

    public static DataSource getOracleDataSource() {
        Properties properties = new Properties();
        OracleDataSource oracleDataSource = null;

        try (FileInputStream fis = new FileInputStream("db.properties")) {

            properties.load(fis);
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(properties.getProperty("MYSQL_DB_URL2"));
            oracleDataSource.setUser(properties.getProperty("MYSQL_DB_USERNMAE2"));
            oracleDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD2"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oracleDataSource;
    }



}
