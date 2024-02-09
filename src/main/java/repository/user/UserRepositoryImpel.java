package repository.user;

import base.repository.BaseRepositoryImpel;
import model.User;

import java.sql.Connection;

public class UserRepositoryImpel  extends BaseRepositoryImpel<Integer, User> implements UserRepository{

    public UserRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "users";
    }

}
