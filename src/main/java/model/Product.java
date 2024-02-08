package model;

import base.model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Product extends BaseEntity<Integer> {

    String name;
    int cost;
    int number;
    int categoryId;


}
