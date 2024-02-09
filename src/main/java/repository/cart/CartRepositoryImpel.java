package repository.cart;

import base.repository.BaseRepositoryImpel;
import model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Override
    public String getCountOfQuestionMarkParams() {
        return "(? ,? ,? )";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Cart entity, boolean isCountOnly) throws SQLException {
        preparedStatement.setInt(1, entity.getUserId());
        preparedStatement.setInt(2, entity.getProductId());
        preparedStatement.setInt(3, entity.getCountPro());
    }

    @Override
    public Cart mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Cart cart = new Cart();
        cart.setId(resultSet.getInt("id"));
        cart.setUserId(resultSet.getInt("user_id"));
        cart.setProductId(resultSet.getInt("product_id"));
        cart.setCountPro(resultSet.getInt("count_product"));
        return cart;
    }

    @Override
    public String getUpdateQueryParams() {
        return "user_id =? , product_id =? , count_product=?";
    }

    @Override
    public int costOfCart(int userId) throws SQLException {
        String count = "select sum(count_product*product.cost) from cart " +
                "join product on cart.product_id = product.id group by user_id having user_id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(count)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            int cost = 0 ;
            if (resultSet.next()){
                cost = resultSet.getInt(1);
            }
            return cost;
        }
    }

}
