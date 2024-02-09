package repository.product;

import base.repository.BaseRepositoryImpel;
import model.Product;

import java.sql.Connection;

public class ProductRepositoryImpel  extends BaseRepositoryImpel<Integer , Product> implements ProductRepository {

    public ProductRepositoryImpel(Connection connection) {
        super(connection);
    }

}
