package repository.admin;

import base.repository.BaseRepository;
import model.Admin;

import java.sql.SQLException;

public interface AdminRepository  extends BaseRepository<Integer , Admin> {

    boolean singIn (String username , String password) throws SQLException;
}
