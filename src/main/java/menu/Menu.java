package menu;

import model.Cart;
import model.User;
import service.admin.AdminService;
import service.cart.CartService;
import service.category.CategoryService;
import service.product.ProductService;
import service.user.UserService;
import utility.ApplicationContext;

import java.sql.SQLException;
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

    public void publicMenu() throws SQLException {
        int num = 0;
        boolean check = false;
        while (!check) {

            System.out.println(ANSI_BLUE + "****Welcome****");
            System.out.println(ANSI_YELLOW + "1-if you are User");
            System.out.println(ANSI_YELLOW + "2-if you are Admin");
            num = scanner.nextInt();

//todo user

            if (num == 1) {

                System.out.println(ANSI_BLUE + "so you are User :) ");
                System.out.println(ANSI_YELLOW + "1-singUp");
                System.out.println(ANSI_YELLOW + "2-singIn");
                num = scanner.nextInt();

                while (!check) {

                    if (num == 1) {

                        System.out.println(ANSI_BLUE + "you are singing up");
                        singUpUser();
                        break;

                    } else if (num == 2) {

                        System.out.println(ANSI_BLUE + "you are singing in");
                        singInUser();
                        break;

                    } else {
                        System.out.println(ANSI_GREEN + "it is not true");
                    }
                }

                System.out.println(ANSI_BLUE + "our all products");
                loadAllProducts();

                while (!check) {

                    System.out.println(ANSI_YELLOW + "1-add to cart");
                    System.out.println(ANSI_YELLOW + "2-delete from cart");
                    System.out.println(ANSI_YELLOW + "3-edit cart");
                    System.out.println(ANSI_GREEN + "4-exit from user services");
                    num = scanner.nextInt();

//todo adding
                    if (num == 1) {

                        while (!check) {

                            System.out.println(ANSI_BLUE + "your cart :");
                            loadAllUserChoices();
                            System.out.println(ANSI_BLUE + "the cost of your cart");
                            costOfCart();
                            System.out.println(ANSI_BLUE + "you are adding to cart");
                            addToCart();
                            System.out.println(ANSI_YELLOW + "1-add cart again");
                            System.out.println(ANSI_YELLOW + "2-adding to cart is enough");
                            num = scanner.nextInt();

                            if (num == 1) {
                                System.out.println(ANSI_BLUE + "how many times do you want to add to cart ?");
                                num = scanner.nextInt();
                                for (int i = 0; i < num; i++) {
                                    System.out.println(ANSI_BLUE + "you are adding to cart");
                                    addToCart();
                                }
                                System.out.println(ANSI_BLUE + "the cost of your cart");
                                costOfCart();
                                break;

                            } else if (num == 2) break;
                            else {
                                System.out.println("not valid");
                            }
                        }
                    }

//todo deleting
                    else if (num == 2) {

                        while (!check) {

                            System.out.println(ANSI_BLUE + "your cart :");
                            loadAllUserChoices();
                            System.out.println(ANSI_BLUE + "the cost of your cart");
                            costOfCart();
                            System.out.println(ANSI_BLUE + "you are deleting a cart");
                            deleteFromCart();
                            System.out.println(ANSI_YELLOW + "1-delete cart again");
                            System.out.println(ANSI_YELLOW + "2-deleting cart is enough");
                            num = scanner.nextInt();

                            if (num == 1) {
                                System.out.println(ANSI_BLUE + "how many times do you want to delete a cart ?");
                                num = scanner.nextInt();
                                for (int i = 0; i < num; i++) {
                                    System.out.println(ANSI_BLUE + "you are deleting a cart");
                                    deleteFromCart();
                                }
                                System.out.println(ANSI_BLUE + "the cost of your cart");
                                costOfCart();
                                break;

                            } else if (num == 2) break;
                            else {
                                System.out.println("not valid");
                            }
                        }
                    }
//todo editing
                    else if (num == 3) {
                        while (!check) {

                            System.out.println(ANSI_BLUE + "your cart :");
                            loadAllUserChoices();
                            System.out.println(ANSI_BLUE + "the cost of your cart");
                            costOfCart();
                            System.out.println(ANSI_BLUE + "you are editing cart");
                            editCart();
                            System.out.println(ANSI_YELLOW + "1-edit cart again");
                            System.out.println(ANSI_YELLOW + "2-editing cart is enough");
                            num = scanner.nextInt();

                            if (num == 1) {
                                System.out.println(ANSI_BLUE + "how many times do you want to edit cart ?");
                                num = scanner.nextInt();
                                for (int i = 0; i < num; i++) {
                                    System.out.println(ANSI_BLUE + "you are editing cart");
                                    editCart();
                                }
                                System.out.println(ANSI_BLUE + "the cost of your cart");
                                costOfCart();
                                break;

                            } else if (num == 2) break;
                            else {
                                System.out.println("not valid");
                            }
                        }
                    }
//todo break user
                    else if (num == 4) {
                        System.out.println(ANSI_GREEN + "exiting from user service");
                        break;
                    } else System.out.println(ANSI_GREEN + "not valid, try again");
                }
//todo admin
            } else if (num == 2) {

                System.out.println(ANSI_BLUE + "so you are Admin :) ");
                System.out.println(ANSI_YELLOW + "plz first do singIn");
                adminSingIn();
                while (!check) {
                    System.out.println(ANSI_YELLOW + "1-add category");
                    System.out.println(ANSI_YELLOW + "2-add product");
                    System.out.println(ANSI_YELLOW + "3-exit admin services");
                    num = scanner.nextInt();
//todo add category
                    if (num == 1) {

                        while (!check) {

                            System.out.println(ANSI_BLUE + "you are adding category");
                            addToCategory();
                            System.out.println(ANSI_YELLOW + "1-add category again");
                            System.out.println(ANSI_YELLOW + "2-adding category is enough");
                            num = scanner.nextInt();
                            if (num == 1) {
                                System.out.println(ANSI_BLUE + "how many times do you want to add category ?");
                                num = scanner.nextInt();
                                for (int i = 0; i < num; i++) {
                                    System.out.println(ANSI_BLUE + "you are adding category");
                                    addToCategory();
                                }
                                break;

                            } else if (num == 2) break;
                            else {
                                System.out.println("not valid");
                            }
                        }
                    }
//todo add product
                    else if (num == 2) {

                        while (!check) {

                            System.out.println(ANSI_BLUE + "you are adding product");
                            addToProduct();
                            System.out.println(ANSI_YELLOW + "1-add product again");
                            System.out.println(ANSI_YELLOW + "2-adding product is enough");
                            num = scanner.nextInt();
                            if (num == 1) {
                                System.out.println(ANSI_BLUE + "how many times do you want to add product ?");
                                num = scanner.nextInt();
                                for (int i = 0; i < num; i++) {
                                    System.out.println(ANSI_BLUE + "you are adding product");
                                    addToProduct();
                                }
                                break;

                            } else if (num == 2) break;
                            else {
                                System.out.println("not valid");
                            }
                        }
                    } else if (num == 3) {
                        System.out.println(ANSI_GREEN + "exiting from admin services");
                        break;
                    } else System.out.println("not valid");
                }
            }
        }
    }

    public void singUpUser() throws SQLException {
        System.out.println("firstname");
        String firstname = scanner.next();

        System.out.println("lastname");
        String lastname = scanner.next();

        System.out.println("username");
        String username = scanner.next();

        System.out.println("password");
        String password = scanner.next();

        User user = new User(firstname, lastname, username, password);
        userService.save(user);
        System.out.println(ANSI_GREEN + "sing up in done");
    }

    public void singInUser() throws SQLException {

        boolean check = false;
        while (!check) {
            System.out.println("username");
            String username = scanner.next();

            System.out.println("password");
            String password = scanner.next();

            boolean user = userService.singIn(username, password);

            if (user) {
                System.out.println("user found");
                break;
            } else {
                System.out.println("user didn't find , try again");
            }
        }
    }

    public void loadAllProducts() throws SQLException {
        System.out.println(productService.loadAll());
    }

    public void adminSingIn() throws SQLException {

        boolean check = false;
        while (!check) {
            System.out.println("username");
            String username = scanner.next();

            System.out.println("password");
            String password = scanner.next();

            boolean user = adminService.singIn(username, password);

            if (user) {
                System.out.println("user found");
                break;
            } else {
                System.out.println("user didn't find , try again");
            }
        }
    }

    public void addToCart() throws SQLException {

        boolean check = false;
        while (!check) {

            System.out.println("user id");
            int userId = scanner.nextInt();

            System.out.println("product id");
            int productId = scanner.nextInt();


            System.out.println("count product");
            int number = scanner.nextInt();

            if (cartService.checkingEntityOfStore(productId) + productId <= productService.checkCount(productId)) {

                Cart cart = new Cart(userId, productId, number);
                cartService.save(cart);
                break;
            } else System.out.println(ANSI_GREEN + "count product is more than store entity , plz do it again");
        }
    }

    public void deleteFromCart() throws SQLException {
        System.out.println("id of cart");
        int id = scanner.nextInt();
        cartService.delete(id);
        System.out.println(ANSI_YELLOW + "deleting done");
    }

    public void editCart() throws SQLException {

        boolean check = false;
        while (!check) {
            try {
                System.out.println("cart id");
                int id = scanner.nextInt();
                Cart cart = cartService.findById(id);

                System.out.println("user id");
                int userid = scanner.nextInt();
                cart.setUserId(userid);

                System.out.println("product id");
                int productId = scanner.nextInt();
                cart.setProductId(productId);

                System.out.println("count of product");
                int count = scanner.nextInt();
                cart.setCountPro(count);

                if (cartService.checkingEntityOfStore(productId) <= productService.checkCount(productId)) {

                    cartService.update(cart);
                    break;

                } else
                    System.out.println(ANSI_YELLOW + "count product is more than store entity , plz do it again");
            } catch (NullPointerException e) {
                System.out.println("null point exception");
            }
        }

    }

    public void loadAllUserChoices() throws SQLException {
        System.out.println("enter user id");
        int id = scanner.nextInt();
        cartService.loadAllUserChoices(id);
    }

}
