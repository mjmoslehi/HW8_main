package service.product;

import base.service.BaseServiceImpel;
import model.Product;
import repository.product.ProductRepository;

import java.sql.SQLException;

public class ProductServiceImpel extends BaseServiceImpel<Integer, Product, ProductRepository> implements ProductService {

    public ProductServiceImpel(ProductRepository repository) {
        super(repository);
    }

    @Override
    public Product[] loadAll() throws SQLException {
        return repository.loadAll();
    }

}
