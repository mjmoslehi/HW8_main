package repository.category;

import base.repository.BaseRepositoryImpel;
import model.Category;

import java.sql.Connection;

public class CategoryRepositoryImpel  extends BaseRepositoryImpel<Integer , Category> implements CategoryRepository{

    public CategoryRepositoryImpel(Connection connection) {
        super(connection);
    }
}
