package service.user;

import base.service.BaseServiceImpel;
import model.User;
import repository.user.UserRepository;

import java.sql.SQLException;

public class UserServiceImpel extends BaseServiceImpel<Integer , User, UserRepository> implements UserService {

    public UserServiceImpel(UserRepository repository) {
        super(repository);
    }

    @Override
    public Boolean singIn(String username, String password) throws SQLException {
        return repository.singIn(username,password);
    }

}
