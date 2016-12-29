package ru.kkiselev.model.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kkiselev.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kv on 27.12.16.
 */
public class DBConnection {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private static Connection conn;

    private String url = "jdbc:h2:~/test8";

//    static {
//        try {
//            Class.forName("org.h2.Driver");
//        } catch (ClassNotFoundException e) {
//            LOG.error("Can't load jdbc driver", e);
//            throw new RuntimeException(e);
//        }
//    }

    private DBConnection(){
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(conn == null){
            new DBConnection();
        }
        return conn;

    }
}
