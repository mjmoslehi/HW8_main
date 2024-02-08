package model;

import base.model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Admin extends BaseEntity<Integer> {

    String name ;
    String username;
    String password;

    public Admin(Integer id, String name, String username, String password) {
        super(id);
        this.name = name;
        this.username = username;
        this.password = password;
    }

}
