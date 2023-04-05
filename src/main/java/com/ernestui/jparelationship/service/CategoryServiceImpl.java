package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.Author;
import com.ernestui.jparelationship.data.Category;
import com.ernestui.jparelationship.dto.mapper;
import com.ernestui.jparelationship.dto.requestDto.CategoryRequestDto;
import com.ernestui.jparelationship.dto.responseDto.CategoryResponseDto;
import com.ernestui.jparelationship.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 05/04/2023 - 08:57
 * @project jpa-relationship
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("We couldn't get this category" + categoryId));
    }

    @Override
    @Transactional
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        categoryRepository.save(category);

        return mapper.categoryToCategoryResponseDto(category);
    }

    @Override
    public List<CategoryResponseDto> getCategories() {
        List<Category> categories = StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return mapper.categoryToCategoryResponseDtos(categories);
    }

    @Transactional
    @Override
    public CategoryResponseDto getCategoryById(Long categoryId) {
        Category category = getCategory(categoryId);
        return mapper.categoryToCategoryResponseDto(category);
    }

    @Transactional
    @Override
    public CategoryResponseDto deleteCategory(Long categoryId) {
        Category category = getCategory(categoryId);
        categoryRepository.delete(category);
        return mapper.categoryToCategoryResponseDto(category);
    }

    @Transactional
    @Override
    public CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto) {
        Category categoryToEdit = getCategory(categoryId);
        categoryToEdit.setName(categoryRequestDto.getName());
        return mapper.categoryToCategoryResponseDto(categoryToEdit);
    }
}
