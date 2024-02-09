package service.product;

import base.service.BaseServiceImpel;
import model.Product;
import repository.product.ProductRepository;

public class ProductServiceImpel extends BaseServiceImpel<Integer, Product, ProductRepository> implements ProductService {

    public ProductServiceImpel(ProductRepository repository) {
        super(repository);
    }

}
