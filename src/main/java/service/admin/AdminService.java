package service.admin;

import base.service.BaseService;
import model.Admin;

import java.sql.SQLException;

public interface AdminService extends BaseService<Integer , Admin> {
    boolean singIn (String username , String password) throws SQLException;
}
