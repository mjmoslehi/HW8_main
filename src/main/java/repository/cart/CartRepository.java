package repository.cart;

import base.repository.BaseRepository;
import model.Cart;

import java.sql.SQLException;

public interface CartRepository extends BaseRepository<Integer , Cart> {

    int costOfCart(int userId) throws SQLException;

    Cart[] loadAllUserChoices(int userId) throws SQLException;

    int checkingEntityOfStore(int productId)throws SQLException;
}
