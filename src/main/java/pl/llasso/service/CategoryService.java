package pl.llasso.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.llasso.entity.Category;
import pl.llasso.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
