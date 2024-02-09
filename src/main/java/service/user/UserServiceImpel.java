package service.user;

import base.service.BaseServiceImpel;
import model.User;
import repository.user.UserRepository;

public class UserServiceImpel extends BaseServiceImpel<Integer , User, UserRepository> implements UserService {

    public UserServiceImpel(UserRepository repository) {
        super(repository);
    }

}
