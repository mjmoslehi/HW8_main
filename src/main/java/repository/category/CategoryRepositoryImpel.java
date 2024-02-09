package repository.category;

import base.repository.BaseRepositoryImpel;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepositoryImpel  extends BaseRepositoryImpel<Integer , Category> implements CategoryRepository{

    public CategoryRepositoryImpel(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "category";
    }

    @Override
    public String getColumnsName() {
        return "(name)";
    }

    @Override
    public String getCountOfQuestionMarkParams() {
        return "(?)";
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Category entity, boolean isCountOnly) throws SQLException {
        preparedStatement.setString(1,entity.getName());
    }

}
