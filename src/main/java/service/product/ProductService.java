package service.product;

import base.service.BaseService;
import model.Product;

import java.sql.SQLException;

public interface ProductService extends BaseService<Integer, Product> {

    Product[] loadAll() throws SQLException;

    int checkCount(int id)throws SQLException;
}
