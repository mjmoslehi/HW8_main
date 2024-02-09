package service.cart;

import base.service.BaseService;
import model.Cart;

import java.sql.SQLException;

public interface CartService extends BaseService<Integer , Cart> {

    int costOfCart(int userId) throws SQLException;

    Cart [] loadAllUserChoices(int userId) throws SQLException;
}
