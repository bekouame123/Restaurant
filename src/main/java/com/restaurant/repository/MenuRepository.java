package com.restaurant.repository;

import java.awt.Menu;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity,Long> {

}
