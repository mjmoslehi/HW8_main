package service.cart;

import base.service.BaseServiceImpel;
import model.Cart;
import repository.cart.CartRepository;

public class CartServiceImpel extends BaseServiceImpel<Integer , Cart, CartRepository> implements CartService {

    public CartServiceImpel(CartRepository repository) {
        super(repository);
    }

}
