package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {
        Database database = Database.getInstance();
        String[] splitedResponse = database.sqlResponseReader("sql/populate_db.sql").split(";");
        Connection conn = database.getConnection();
        try (Statement statement = conn.createStatement()) {
            for (String st: splitedResponse) {
                statement.execute(st);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
