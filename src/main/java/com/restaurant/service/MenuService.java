package com.restaurant.service;

import java.awt.Menu;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.restaurant.entity.MenuEntity;
import com.restaurant.entity.OrderEntity;
import com.restaurant.repository.MenuRepository;


@Service
public class MenuService {
    
	
	@Autowired
	private MenuRepository Menurepository;
	
	
	public void addMenu(MenuEntity menu) {
		Menurepository.save(menu) ;
	}
	
	
	public List<MenuEntity> getAll() {
		return Menurepository.findAll();
	}
	
	
	public void removeMenuById(Long id) {
		Menurepository.deleteById(id);	
	}

	public void searchMenuById(Long id) {
		Menurepository.findById(id);	
	}

	
	public void updateMenuBy(Long id, MenuEntity menu) {
		Optional<MenuEntity> repoOrder = Menurepository.findById(id);
	     BeanUtils.copyProperties(repoOrder, menu);
	     Menurepository.save(menu);	
	}
	
}