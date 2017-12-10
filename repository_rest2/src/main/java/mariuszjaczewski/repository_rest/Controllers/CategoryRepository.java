package mariuszjaczewski.repository_rest.Controllers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import mariuszjaczewski.repository_rest.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@JsonDeserialize(as = Category.class)
public interface CategoryRepository extends JpaRepository<Category, Long>{


}
