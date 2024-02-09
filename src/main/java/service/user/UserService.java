package service.user;

import base.service.BaseService;
import model.User;

import java.sql.SQLException;

public interface UserService extends BaseService<Integer , User> {

    Boolean singIn(String username, String password) throws SQLException;
}
