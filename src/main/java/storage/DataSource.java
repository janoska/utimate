package storage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jboy on 9/23/2014.
 */
public class DataSource {

    DbConnection dbConnection;

    public DataSource(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public DataSource() {

    }

    public String simpleQuery(String query) {
        dbConnection.conn();
        try{
            Statement st = dbConnection.connection.createStatement();
            st.execute(query);
            dbConnection.close();
        }
        catch(SQLException ex)
        { System.out.println(ex);
            dbConnection.close();
            return ex.toString();
        }
        return "0";
    }

    public ArrayList<String> getAll(String query) {
        dbConnection.conn();
        try {
            Statement st = dbConnection.connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsMdata = rs.getMetaData();
            int colNo = rsMdata.getColumnCount();
            ArrayList<String> resultList = new ArrayList<String>();
            while(rs.next()) {

                for(int i=1;i<colNo+1;i++)
                {
                    resultList.add(rs.getString(i));
                }

            }
            dbConnection.close();
            return resultList;
        }
        catch(SQLException ex) {
            ArrayList<String> r = new ArrayList<String>();
            r.add("");
            dbConnection.close();
            return r;
        }}

    public ArrayList<String[]> getArr(String query) {
        dbConnection.conn();
        try {
            Statement st = dbConnection.connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsMdata = rs.getMetaData();
            int colNo = rsMdata.getColumnCount();
            ArrayList<String[]> resultList = new ArrayList<String[]>();
            while(rs.next())
            {
                String[] rw = new String[colNo];
                for(int i=1;i<=colNo;i++)
                {
                    rw[i-1]=rs.getString(i);
                }
                resultList.add(rw);
            }
            dbConnection.close();
            return resultList;
        } catch (SQLException ex) {
            ArrayList<String[]> r = new ArrayList<String[]>();
            String[] s = new String[1];
            s[0]=ex.getMessage();
            r.add(s);
            dbConnection.close();
            return r;

        }
    }

    public int getColumnCount(String query) {
        dbConnection.conn();
        try {
            Statement st = dbConnection.connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int rowCount = 0;
            while (rs.next()){
                rowCount = rs.getInt(1);
            }
            dbConnection.close();
            return rowCount;
        } catch (SQLException ex) {
            System.out.println(ex);
            dbConnection.close();
        }
        return 0;
    }

    public List<String> login(String query, String userName, String password) {
        dbConnection.conn();
        List<String> userDetails = null;
        try {
            PreparedStatement prepareQuery = dbConnection.connection.prepareStatement(query);
            prepareQuery.setString(1, userName);
            prepareQuery.setString(2, password);
            prepareQuery.execute();
            ResultSet rs = prepareQuery.getResultSet();
            while(rs.next()) {
                userDetails = new ArrayList<String>();
                userDetails.add(rs.getString(3));
                userDetails.add(rs.getString(7));
            }
        }
        catch(Exception e) {}
        return userDetails;
    }

    public void setDbConnection(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public DbConnection getDbConnection() {
        return this.dbConnection;
    }
}
