package com.ohgiraffers.springdatajpa.menu.controller;


import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {this.menuService = menuService;}

    @GetMapping("/list")
    public String list(Model model) {

        List<MenuDTO> menuList = menuService.findMenuList();

        model.addAttribute("menuList", menuList);

        return "/menu/list";
    }


}
