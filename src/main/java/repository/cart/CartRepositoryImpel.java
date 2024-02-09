package repository.cart;

import base.repository.BaseRepositoryImpel;
import model.Cart;

import java.sql.Connection;

public class CartRepositoryImpel extends BaseRepositoryImpel<Integer, Cart> implements CartRepository{

    public CartRepositoryImpel(Connection connection) {
        super(connection);
    }

}
