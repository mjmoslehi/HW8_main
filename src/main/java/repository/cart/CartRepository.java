package repository.cart;

import base.repository.BaseRepository;
import model.Cart;

import java.sql.SQLException;

public interface CartRepository extends BaseRepository<Integer , Cart> {

    int costOfCart(int userId) throws SQLException;
}
