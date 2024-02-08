package model;

import base.model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User extends BaseEntity<Integer> {

    String firstname;
    String lastname;
    String username;
    String password;

    public User(Integer id, String firstname, String lastname, String username, String password) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }
}
