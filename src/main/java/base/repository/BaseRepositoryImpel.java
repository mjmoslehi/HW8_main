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
        String sql = "INSERT INTO "+ getTableName() + " "+ getColumnsName()+" VALUES "+
                getCountOfQuestionMarkParams();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            fillParamForStatement(preparedStatement, entity , false);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("you did something bad");
        }
    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        String sql = "SELECT * FROM "+ getTableName() + " WHERE id = ?";
        try(PreparedStatement preparedStatement  = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,(Integer)id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if( resultSet.next())
                return mapResultSetToEntity(resultSet);
        }catch (NullPointerException e){
            System.out.println("you did something bad");
        }
        return null;
    }

    @Override
    public void update(TYPE entity) throws SQLException {
        String update ="UPDATE "+getTableName()+" SET "+getUpdateQueryParams()+ " WHERE id = " + entity.getId();
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)){
            fillParamForStatement(preparedStatement,entity,true);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("you did something bad");
        }
    }

    @Override
    public void delete(ID id) throws SQLException {
        String delete = "DELETE FROM "+ getTableName()+" WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(delete)){
            preparedStatement.setInt(1,(Integer)id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("you did something bad");
        }
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
