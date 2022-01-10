package vn.ht.bakery.shop.DAO;

import vn.ht.bakery.shop.model.Bakery;

import java.sql.SQLException;
import java.util.List;

public interface IBakeryDAO {
    List<Bakery> selectAllBakery();

    void insertBakery(Bakery bakery) throws SQLException;

    boolean updateBakery(Bakery bakery) throws SQLException;

    Bakery getBakeryById(int id) throws SQLException;
}
