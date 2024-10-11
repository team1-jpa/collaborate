package com.ohgiraffers.springdatajpa.category.service;

import com.ohgiraffers.springdatajpa.category.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.category.entity.Category;
import com.ohgiraffers.springdatajpa.category.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryDTO> findAllCategory () {

        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }
}
