package service.cart;

import base.service.BaseServiceImpel;
import model.Cart;
import repository.cart.CartRepository;

import java.sql.SQLException;

public class CartServiceImpel extends BaseServiceImpel<Integer , Cart, CartRepository> implements CartService {

    public CartServiceImpel(CartRepository repository) {
        super(repository);
    }

    @Override
    public int costOfCart(int userId) throws SQLException {
        return repository.costOfCart(userId);
    }
}
