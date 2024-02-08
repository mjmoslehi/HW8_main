package base.repository;

import base.model.BaseEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class  BaseRepositoryImpel <ID extends Serializable , TYPE extends BaseEntity<ID>>
        implements BaseRepository<ID , TYPE>{

    protected final Connection connection;

    public BaseRepositoryImpel(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(TYPE entity) throws SQLException {

    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        return null;
    }

    @Override
    public void update(TYPE entity) throws SQLException {

    }

    @Override
    public void delete(ID id) throws SQLException {

    }


}
