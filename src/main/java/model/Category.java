package model;

import base.model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Category extends BaseEntity<Integer> {

    String name;

    public Category(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
