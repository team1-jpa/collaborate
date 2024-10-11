package com.ohgiraffers.springdatajpa.menu.service;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;

import com.ohgiraffers.springdatajpa.category.repository.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    public MenuDTO findMenuByCode(int menuCode) {

        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(menu, MenuDTO.class);
    }

    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").ascending());

        return menuList
                .stream()
                .map(m -> modelMapper.map(m, MenuDTO.class))
                .toList();
    }


    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {

        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice);

        return menuList
                .stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteMenu(Integer menuCode) {
        menuRepository.deleteById(menuCode);

    }
}
