package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.Category;
import com.ernestui.jparelationship.dto.requestDto.CategoryRequestDto;
import com.ernestui.jparelationship.dto.responseDto.CategoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 04/04/2023 - 20:45
 * @project jpa-relationship
 */
@Service
public interface CategoryService {
    public Category getCategory(Long categoryId);
    public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
    public List<CategoryResponseDto> getCategories();
    public CategoryResponseDto getCategoryById(Long categoryId);
    public CategoryResponseDto deleteCategory(Long categoryId);
    public CategoryResponseDto editCategory(Long categoryId, CategoryRequestDto categoryRequestDto);
}
