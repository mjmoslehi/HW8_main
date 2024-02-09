package repository.user;

import base.repository.BaseRepositoryImpel;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepositoryImpel  extends BaseRepositoryImpel<Integer, User> implements UserRepository{

    public UserRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "users";
    }

    @Override
    public String getColumnsName() {
        return "(firstname , lastname , username , password )";
    }

    @Override
    public String getCountOfQuestionMarkParams() {
        return "(?,?,?,?)";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, User entity, boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1, entity.getFirstname());
        preparedStatement.setString(2, entity.getLastname());
        preparedStatement.setString(3, entity.getUsername());
        preparedStatement.setString(4, entity.getPassword());
    }

}
