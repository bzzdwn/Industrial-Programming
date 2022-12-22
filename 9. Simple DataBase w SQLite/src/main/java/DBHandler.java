import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DBHandler {
    private static final String url = "jdbc:sqlite:users.db";
    private static volatile DBHandler instance;
    private Connection connection;
    private DBHandler() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to DataBase");
            String query = "CREATE TABLE IF NOT EXISTS users (\n"
                    + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "	name VARCHAR(50),\n"
                    + "	phone VARCHAR(50),\n"
                    + "	position VARCHAR(50)\n"
                    + ");";
            Statement statement = connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static DBHandler getInstance() {
        DBHandler local_instance = instance;
        if (local_instance == null)
        {
            synchronized (DBHandler.class){
                local_instance = instance;
                if (local_instance == null)
                {
                    instance = new DBHandler();
                }
            }

        }
        return instance;
    }
    public ArrayList<User> select() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT id, name, phone, position FROM users ORDER BY id";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String position = resultSet.getString("position");
                users.add(new User(name, phone, position));
                System.out.println(id + "\t|\t" + name + "\t|\t" + phone + "\t|\t" + position);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    void insert(User user) {
        try {
            String query =
                    "INSERT INTO users (name, phone, position) " +
                            "VALUES ('" + user.getName() + "', '" + user.getPhone() + "', '" + user.getPosition() + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("User added");
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void edit(int id, User user) {
        try {
            String query =
                    "UPDATE users SET name = " + user.getName() +
                            ", phone = " + user.getPhone() +
                            ", position = " + user.getPosition() +
                            " WHERE id = " + id;
            Statement statement = connection.prepareStatement(query);
            System.out.println("User edited");
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void erase(int id) {
        try {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM users WHERE id = " + id;
            statement.executeUpdate(query);
            query = "UPDATE users SET id = id - 1 WHERE id > " + id;
            statement.executeUpdate(query);
            System.out.println("User deleted");
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void close(){
        try {
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
