package utility;

import repository.admin.AdminRepository;
import repository.cart.CartRepository;
import repository.category.CategoryRepository;
import repository.product.ProductRepository;
import repository.user.UserRepository;
import service.admin.AdminService;
import service.cart.CartService;
import service.category.CategoryService;
import service.product.ProductService;
import service.user.UserService;

import java.sql.Connection;

public class ApplicationContext {

    private static final Connection CONNECTION;
    private static final AdminRepository ADMIN_REPOSITORY;
    private static final CartRepository CART_REPOSITORY;
    private static final CategoryRepository CATEGORY_REPOSITORY;
    private static final ProductRepository PRODUCT_REPOSITORY;
    private static final UserRepository USER_REPOSITORY;

    private static final AdminService ADMIN_SERVICE;
    private static final CartService CART_SERVICE;
    private static final CategoryService CATEGORY_SERVICE;
    private static final ProductService PRODUCT_SERVICE;
    private static final UserService USER_SERVICE;

}
