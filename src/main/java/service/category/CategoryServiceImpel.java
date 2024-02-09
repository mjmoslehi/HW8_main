package service.category;

import base.service.BaseServiceImpel;
import model.Category;
import repository.category.CategoryRepository;

public class CategoryServiceImpel extends BaseServiceImpel<Integer, Category, CategoryRepository> implements CategoryService {

    public CategoryServiceImpel(CategoryRepository repository) {
        super(repository);
    }

}
