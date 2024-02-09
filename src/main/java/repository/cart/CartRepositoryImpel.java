package repository.cart;

import base.repository.BaseRepositoryImpel;
import model.Cart;

import java.sql.Connection;

public class CartRepositoryImpel extends BaseRepositoryImpel<Integer, Cart> implements CartRepository{

    public CartRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "cart";
    }

    @Override
    public String getColumnsName() {
        return "(user_id , product_id , count_product)";
    }
}
