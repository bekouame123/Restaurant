package com.restaurant.service;

import java.awt.Menu;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.entity.MenuEntity;
import com.restaurant.repository.MenuRepository;


@Service
public class MenuService {
    
	
	@Autowired
	private MenuRepository repository;
	
	
	public void addMenu(MenuEntity menu) {
		repository.save(menu) ;
	}


	public List<MenuEntity> getAll() {
		return repository.findAll();
	}



	public void removeMenuById(Long id) {
		repository.deleteById(id);
		
	}


	public void searchMenuById(Long id) {
		repository.findById(id);
		
	}


	public void updateMenuBy(Long id,MenuEntity menu) {
		Optional<MenuEntity> repoMenuEntity = repository.findById(id);

     BeanUtils.copyProperties(repoMenuEntity, menu);
     
     repository.save(menu);
	
	
}