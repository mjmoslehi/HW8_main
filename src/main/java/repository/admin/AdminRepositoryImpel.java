package repository.admin;

import base.repository.BaseRepositoryImpel;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
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


}
