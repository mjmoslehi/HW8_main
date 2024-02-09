package utility;

import connection.JdbcConnection;
import repository.admin.AdminRepository;
import repository.admin.AdminRepositoryImpel;
import repository.cart.CartRepository;
import repository.cart.CartRepositoryImpel;
import repository.category.CategoryRepository;
import repository.category.CategoryRepositoryImpel;
import repository.product.ProductRepository;
import repository.product.ProductRepositoryImpel;
import repository.user.UserRepository;
import repository.user.UserRepositoryImpel;
import service.admin.AdminService;
import service.admin.AdminServiceImpel;
import service.cart.CartService;
import service.cart.CartServiceImpel;
import service.category.CategoryService;
import service.category.CategoryServiceImpel;
import service.product.ProductService;
import service.product.ProductServiceImpel;
import service.user.UserService;
import service.user.UserServiceImpel;

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

    static {

        CONNECTION = JdbcConnection.getConnection();
        ADMIN_REPOSITORY = new AdminRepositoryImpel(CONNECTION);
        CART_REPOSITORY = new CartRepositoryImpel(CONNECTION);
        CATEGORY_REPOSITORY = new CategoryRepositoryImpel(CONNECTION);
        PRODUCT_REPOSITORY = new ProductRepositoryImpel(CONNECTION);
        USER_REPOSITORY = new UserRepositoryImpel(CONNECTION);

        ADMIN_SERVICE = new AdminServiceImpel(ADMIN_REPOSITORY);
        CART_SERVICE = new CartServiceImpel(CART_REPOSITORY);
        CATEGORY_SERVICE = new CategoryServiceImpel(CATEGORY_REPOSITORY);
        PRODUCT_SERVICE = new ProductServiceImpel(PRODUCT_REPOSITORY);
        USER_SERVICE = new UserServiceImpel(USER_REPOSITORY);

    }

    public static AdminService getAdminService(){ return ADMIN_SERVICE;}
    public static CategoryService getCategoryService(){return CATEGORY_SERVICE;}
    public static CartService getCartService (){return CART_SERVICE;}
    public static ProductService getProductService(){return PRODUCT_SERVICE;}
    public static UserService getUserService(){return USER_SERVICE;}

}
