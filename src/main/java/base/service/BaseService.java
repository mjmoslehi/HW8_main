package base.service;

import base.model.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;

public interface BaseService <ID extends Serializable , TYPE extends BaseEntity<ID>> {

    void save(TYPE entity) throws SQLException;

    TYPE findById(ID id)throws SQLException;
}
