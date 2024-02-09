package repository.product;

import base.repository.BaseRepositoryImpel;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductRepositoryImpel  extends BaseRepositoryImpel<Integer , Product> implements ProductRepository {

    public ProductRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "product";
    }

    @Override
    public String getColumnsName() {
        return "(name ,cost ,number ,category_id)";
    }

    @Override
    public String getCountOfQuestionMarkParams() {
        return "(?,?,?,?)";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Product entity, boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1,entity.getName());
        preparedStatement.setInt(2,entity.getCost());
        preparedStatement.setInt(3,entity.getNumber());
        preparedStatement.setInt(4,entity.getCategoryId());
    }

}
