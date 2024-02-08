package base.repository;

import base.model.BaseEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public abstract String getTableName();

    public abstract String getColumnsName();

    public abstract String getCountOfQuestionMarkParams();

    public abstract void fillParamForStatement(PreparedStatement preparedStatement ,
                                               TYPE entity ,
                                               boolean isCountOnly) throws SQLException;

    public abstract TYPE mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public abstract String getUpdateQueryParams();
}
