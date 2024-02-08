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

    public Product(Integer id, String name, int cost,int number, int categoryId) {
        super(id);
        this.name = name;
        this.cost = cost;
        this.number=number;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId()+
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", number=" + number +
                ", categoryId=" + categoryId +
                '}';
    }

}
