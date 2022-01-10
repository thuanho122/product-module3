package vn.ht.bakery.shop.DAO;

import vn.ht.bakery.shop.model.Bakery;
import vn.ht.bakery.shop.model.User;
import vn.ht.bakery.shop.repository.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BakeryDAO implements IBakeryDAO{

    private static final String INSERT_BAKERY_SQL = "INSERT INTO bakery (bakeryname,price,quantity,description) VALUES (?, ?,?,?);";
    private static final String SELECT_ALL_BAKERY= "SELECT * FROM bakery";
    private static final String SELECT_BAKERY_BY_ID = "select id,bakeryname,price,description,quantity from bakery where id = ?;";
    private static final String UPDATE_BAKERY_SQL = "update bakery set bakeryname = ?,price = ?, description = ?, quantity= ? where id = ?;";

    public BakeryDAO(){
        MysqlConnection.init("bakery");
    }

    @Override
    public List<Bakery> selectAllBakery() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Bakery> bakery = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BAKERY);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String bakeryName = rs.getString("bakeryName");
                double price = Double.parseDouble(rs.getString("price"));
                long quantity = rs.getLong("quantity");
                String description = rs.getString("description");
                bakery.add(new Bakery(id, bakeryName, price,quantity ,description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bakery;
    }


    @Override
    public void insertBakery(Bakery bakery) throws SQLException {
        System.out.println(INSERT_BAKERY_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BAKERY_SQL)) {
            preparedStatement.setString(1, bakery.getBakeryName());
            preparedStatement.setDouble(2, bakery.getPrice());
            preparedStatement.setLong(3, bakery.getQuantity());
            preparedStatement.setString(4, bakery.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateBakery(Bakery bakery) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BAKERY_SQL);) {
            statement.setString(1, bakery.getBakeryName());
            statement.setDouble(2, bakery.getPrice());
            statement.setString(3, bakery.getDescription());
            statement.setLong(4, bakery.getQuantity());
            statement.setLong(5,bakery.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Bakery getBakeryById(int id) throws SQLException {
        Bakery bakery = null;
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BAKERY_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String bakeryName = rs.getString("bakeryName");
                double price = Double.parseDouble(rs.getString("price"));
                long quantity = rs.getLong("quantity");
                String description = rs.getString("description");
                bakery = new Bakery(id, bakeryName, price,quantity ,description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bakery;
    }

    private void printSQLException(SQLException e) {
    }


}
