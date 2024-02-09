package repository.admin;

import base.repository.BaseRepositoryImpel;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpel extends BaseRepositoryImpel<Integer, Admin> implements AdminRepository{

    public AdminRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "admin";
    }

    @Override
    public String getColumnsName() {
        return "(name , username , password)";
    }

    @Override
    public String getCountOfQuestionMarkParams() {
        return "(?,?,?)";
    }

    public void fillParamForStatement(PreparedStatement preparedStatement, Admin entity, boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getUsername());
        preparedStatement.setString(3, entity.getPassword());

    }

    public Admin mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Admin admin = new Admin();
        admin.setId(resultSet.getInt("id"));
        admin.setName(resultSet.getString("name"));
        admin.setUsername(resultSet.getString("username"));
        admin.setPassword(resultSet.getString("password"));
        return admin;
    }



    @Override
    public boolean singIn(String username, String password) throws SQLException {
        String singIn = "SELECT * FROM " + getTableName() + " WHERE username = ? AND password =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(singIn)) {
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }

    }

}
