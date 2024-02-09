package menu;

import service.admin.AdminService;
import service.cart.CartService;
import service.category.CategoryService;
import service.product.ProductService;
import service.user.UserService;
import utility.ApplicationContext;

import java.util.Scanner;

public class Menu {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private final Scanner scanner = new Scanner(System.in);

    private final AdminService adminService = ApplicationContext.getAdminService();
    private final CartService cartService = ApplicationContext.getCartService();
    private final CategoryService categoryService = ApplicationContext.getCategoryService();
    private final ProductService productService = ApplicationContext.getProductService();
    private final UserService userService = ApplicationContext.getUserService();

}
