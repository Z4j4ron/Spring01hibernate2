package pl.llasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.llasso.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
