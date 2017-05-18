package Model;

/**
 * Created by thyge on 18-05-2017.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.User;
import Model.IModel;

public class model implements IModel {
    User user;

    public model() {
    }

    public List connectToBD() {
        String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11167340";
        String userName = "sql11167340";
        String pass = "6ZquUXTW4B";
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, userName, pass);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String se = "SELECT * FROM Users";
            System.out.println(se);
            ResultSet rs = stmt.executeQuery(se);
            ArrayList userList = new ArrayList();

            while(rs.next()) {
                int id = rs.getInt("user_ID");
                int se1 = rs.getInt("number");
                String name = rs.getString("name");
                this.user = new User(id, name, se1);
                userList.add(this.user);
                System.out.println(id + " " + se1 + " " + name);
            }

            rs.close();
            stmt.close();
            conn.close();
            ArrayList id1 = userList;
            return id1;
        } catch (SQLException var27) {
            var27.printStackTrace();
        } catch (Exception var28) {
            var28.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
            } catch (SQLException var26) {
                ;
            }

            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException var25) {
                var25.printStackTrace();
            }

        }

        System.out.println("Goodbye!");
        return null;
    }

    public User getUser() {
        return null;
    }

    public List<User> getUsers() {
        return null;
    }
}
