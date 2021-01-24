package org.csu.mypetstore.persistence;

import java.util.List;
import org.csu.mypetstore.domain.Category;
public interface CategoryDAO {

    List<Category> getCategoryList();

    Category getCategory(String categoryId);
}
