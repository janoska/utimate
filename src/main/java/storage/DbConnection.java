package storage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by jboy on 9/23/2014.
 */
public class DbConnection {

    private String user;
    private String password;
    private String address;
    Connection connection;

    public DbConnection(String user, String password, String address) {
        this.user = user;
        this.password = password;
        this.address = address;
    }

    public DbConnection() {}

    void conn() {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://" + address, user, password);
        }
        catch(Exception ex) {

        }
    }

    void close() {
        try {
            connection.close();
        }
        catch(Exception ex) {

        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
