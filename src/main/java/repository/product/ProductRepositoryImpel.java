package repository.product;

import base.repository.BaseRepositoryImpel;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpel extends BaseRepositoryImpel<Integer, Product> implements ProductRepository {

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
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getCost());
        preparedStatement.setInt(3, entity.getNumber());
        preparedStatement.setInt(4, entity.getCategoryId());
    }

    @Override
    public Product mapResultSetToEntity(ResultSet resultSet) throws SQLException {

        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setCost(resultSet.getInt("cost"));
        product.setNumber(resultSet.getInt("number"));
        product.setCategoryId(resultSet.getInt("category_id"));
        return product;
    }

    @Override
    public String getUpdateQueryParams() {
        return "name =? , cost = ? , number = ? , category_id = ?";
    }

    @Override
    public Product[] loadAll() throws SQLException {

        String loadAll = "SELECT * FROM " + getTableName();
        try (PreparedStatement preparedStatement = connection.prepareStatement(loadAll,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            int num = 0;

            while (resultSet.next()) {
                num++;
            }

            Product[] products = new Product[num];

            resultSet.beforeFirst();

            int i = 0;

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int number = resultSet.getInt("number");
                int categoryId = resultSet.getInt("category_id");
                products[i] = new Product(id, name, cost, number, categoryId);
                System.out.println(products[i]);
                i++;
            }

            return products;
        }
    }

    @Override
    public int checkCount(int id) throws SQLException {
        String check ="SELECT number FROM product where id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(check)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int num = 0 ;
            if (resultSet.next()){
                num = resultSet.getInt(1);
            }
            return num;
        }
    }
}
