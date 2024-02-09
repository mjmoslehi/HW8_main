package repository.admin;

import base.repository.BaseRepositoryImpel;
import model.Admin;

import java.sql.Connection;

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
}
