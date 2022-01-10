//package vn.ht.bakery.shop.DAO;
//
//import vn.ht.bakery.shop.DAO.IUserDAO;
//import vn.ht.bakery.shop.model.User;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class gsdajhfs implements IUserDAO {
//
//    private String jdbcURL = "jdbc:mysql://localhost:3306/bakery?useSSL=false";
//    private String jdbcUsername = "root";
//    private String jdbcPassword = "thuanho";
//
//    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
//    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
//    private static final String SELECT_ALL_USERS = "select * from user";
//    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
//
//    public gsdajhfs() {
//    }
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//
//    @Override
//    public void insertUser(User user) throws SQLException {
//
//    }
//
//    @Override
//    public User getUserById(int id) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public int getCount(String role) {
//        return 0;
//    }
//
//    @Override
//    public User getUserByUsername(String username) {
//        return null;
//    }
//
//    @Override
//    public User selectUser(String username, String password) {
//        return null;
//    }
//
//    @Override
//    public User selectUserByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public List<User> selectAllUser() {
//        // using try-with-resources to avoid closing resources (boiler plate code)
//        List<User> users = new ArrayList<>();
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String fullName = rs.getString("fullname");
//                String email = rs.getString("email");
//                String phone = rs.getString("phone");
//                int age = rs.getInt("age");
//                String address = rs.getString("address");
//                String status = rs.getString("status");
//                System.out.println(id);
//                users.add(new User(id, fullName, email,phone,age,address,status));
//                System.out.println(users);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return users;
//    }
//
//    @Override
//    public void updateUser(User user) throws SQLException {
//
//    }
//
//    private void printSQLException(SQLException e) {
//    }
//
//}
//
