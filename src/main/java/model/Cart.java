package model;

import base.model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Cart extends BaseEntity<Integer> {

    int userId ;
    int productId;
    int countPro;

    public Cart(Integer id, int userId, int productId, int countPro) {
        super(id);
        this.userId = userId;
        this.productId = productId;
        this.countPro = countPro;
    }
}
