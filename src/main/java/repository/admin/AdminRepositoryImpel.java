package repository.admin;

import base.repository.BaseRepositoryImpel;
import model.Admin;

import java.sql.Connection;

public class AdminRepositoryImpel extends BaseRepositoryImpel<Integer, Admin> implements AdminRepository{

    public AdminRepositoryImpel(Connection connection) {
        super(connection);
    }
}
