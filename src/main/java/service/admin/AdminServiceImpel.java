package service.admin;

import base.service.BaseServiceImpel;
import model.Admin;
import repository.admin.AdminRepository;

import java.sql.SQLException;

public class AdminServiceImpel extends BaseServiceImpel<Integer, Admin, AdminRepository> implements AdminService{

    public AdminServiceImpel(AdminRepository repository) {
        super(repository);
    }

    @Override
    public boolean singIn(String username, String password) throws SQLException {
        return repository.singIn(username,password);
    }
}
