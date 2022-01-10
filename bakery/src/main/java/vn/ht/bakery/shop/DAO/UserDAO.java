package vn.ht.bakery.shop.DAO;

import vn.ht.bakery.shop.model.User;
import vn.ht.bakery.shop.repository.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "select username,password,role from user where username = ? and password = ? ";
    private static final String SELECT_USER_BY_EMAIL = "select id,fullname, email, phone, age,address,status,password,role from user where email = ?";
    private static final String INSERT_USERS_SQL = "INSERT INTO user (fullname,email,phone,age,address,status,password,role ) VALUES (?, ?,?,?,?,?,?,?);";
    private static final String SELECT_USERS_SQL = "select id,fullname,email,gender from user where id =?, email= ?";
    private static final String SELECT_COUNT_USER_SQL = "SELECT COUNT(id) FROM user where role = ?;";
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String SELECT_USER_BY_ID = "select id,fullname,email,phone,age,address,status,role from user where id = ?;";
    private static final String SELECT_USER_BY_USERNAME = "select id,fullname,email,username,role,status from user where username = ?;";
    private static final String UPDATE_USERS_SQL = "update user set fullname = ?,email = ?, phone = ?, age = ?, address = ?,role = ? where id = ?;";
    private static final String DELETE_USERS_SQL = "delete from account where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update user set email = ?,where id = ?;";


    public UserDAO() {
        MysqlConnection.init("bakery");
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);) {
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getLong("id");
                String fullName = rs.getString("fullName");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String status = rs.getString("status");
                String password = rs.getString("password");
                String role = rs.getString("role");
                user = new User(id,fullName, email, phone, age,address,status,password,role);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = MysqlConnection.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getStatus());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setString(8,user.getRole());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

//    @Override
//    public User getUserById(int id) throws SQLException {
//        User user = null;
//        // Step 1: Establishing a Connection
//        try (Connection connection = MysqlConnection.getInstance().getConnection();
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                String fullName = rs.getString("fullName");
//                String email = rs.getString("email");
//                String phone = rs.getString("phone");
//                int age = rs.getInt("age");
//                String address = rs.getString("address");
//                user = new User(id, fullName, email, phone, age, address);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return user;
//    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String status = rs.getString("status");
                String role = rs.getString("role");
                user = new User(id, fullName, email, phone, age, address,status,role);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public int getCount(String role) {
        return 0;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User selectUser(String username, String password) {
        return null;
    }

    @Override
    public User selectUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getLong("id");
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String status = rs.getString("status");
                String role = rs.getString("role");
                users.add(new User(id, fullName, email, phone, age, address, status, role));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    private void printSQLException(SQLException e) {
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getRole());
            statement.setLong(7, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public User selectUser(int id) {
        return null;
    }

//    public boolean deleteUser(int id) throws SQLException {
//        boolean rowDeleted;
//        try (Connection connection = MysqlConnection.getInstance().getConnection();
//             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
//            statement.setInt(1, id);
//            rowDeleted = statement.executeUpdate() > 0;
//        }
//        return rowDeleted;
//    }


}
