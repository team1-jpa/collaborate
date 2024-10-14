package com.ohgiraffers.springdatajpa;

import com.ohgiraffers.springdatajpa.menu.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class Chap06SpringDataJpaApplicationTests {

    @Autowired
    MenuService menuService;

    //코드 검색으로 메뉴 찾기 테스트
    @Test
    public void foundCodeMenu() {

        //given
        int menuCode = 1;

        //when
        MenuDTO findMenu = menuService.findMenuByCode(menuCode);

        //then
        assertNotNull(findMenu);
        System.out.println("findMenu = " + findMenu);
    }

    //가격 검색으로 메뉴 리스트 호출하기 테스트
    @Test
    public void findMenuPrice() {

        //given
        int price = 10000;

        //when
        List<MenuDTO> menuPriceList = menuService.findByMenuPrice(price);

        //then
        assertNotNull(menuPriceList);
        System.out.println("menuPriceList = " + menuPriceList);
    }

}
