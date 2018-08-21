package Data;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DatabaseHandler
{
    public static DatabaseHandler instance;
    private Connection connection;

    public DatabaseHandler(String url, String user, String password) throws SQLException {
        connect(url, user, password);
    }
    public DatabaseHandler() throws SQLException {
    }
    public void connect(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);

    }
    public void close() throws SQLException {
        connection.close();
    }
    public void createTable (String tableName, HashMap<String, String> colums, String tableIdentifier) throws SQLException {
        String toExecute = "create table " + tableName + "(";
        for (Map.Entry<String, String> entry: colums.entrySet()) {
            toExecute += entry.getKey() + " " + entry.getValue() + ", ";
        }
        toExecute += tableIdentifier + "ID VARCHAR(32) PRIMARY KEY)";
        toExecute += ";";
        executeStatement(toExecute);
    }
    public void dropTable (String tableName) throws  SQLException {
        executeStatement("drop table " + tableName);
    }
    public void insertInto (String tableName, HashMap<String, String> content, String tableIdentifier) throws SQLException {
        String toExecute = new String();

        String colums = new String();
        String values = new String();

        for (Map.Entry<String, String> entry: content.entrySet()) {
            colums +=  entry.getKey() + ", ";
            values += "'" + entry.getValue() + "', ";
        }
        toExecute = "insert into " + tableName + " (" + colums + tableIdentifier + "ID" + ") " + "values (" + values + "'" + tableIdentifier + getIDString() + "');";
        executeStatement(toExecute);
    }
    public ResultSet selectFrom (String tableName, List<String> Colums, String tableIdentifier) throws SQLException {
        String toExecute = new String();

        return executeStatement(toExecute);
    }
    public void removeFrom (String tableName, String id, String tableIdentifier)
    {
        String toExecute = "delete from " + tableName + " where " + tableIdentifier + "_id = " + id ;
    }
    public ResultSet executeStatement(String toExecute) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(toExecute);
        return statement.getResultSet();
    }

    protected String getIDString() {
        String RANDCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder ID = new StringBuilder();
        Random rnd = new Random();
        while (ID.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * RANDCHARS.length());
            ID.append(RANDCHARS.charAt(index));
        }
        String IDStr = ID.toString();
        return IDStr;

    }
}
