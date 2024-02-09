package service.admin;

import base.service.BaseServiceImpel;
import model.Admin;
import repository.admin.AdminRepository;

public class AdminServiceImpel extends BaseServiceImpel<Integer, Admin, AdminRepository> implements AdminService{

    public AdminServiceImpel(AdminRepository repository) {
        super(repository);
    }
}
