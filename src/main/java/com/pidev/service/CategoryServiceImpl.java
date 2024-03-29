package com.pidev.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pidev.models.Category;
import com.pidev.repository.CategoryRepository;
import com.pidev.serviceInterface.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public void deleteCategory(Long cid) throws Exception {
		this.categoryRepository.deleteById(cid);

	}

	@Override
	public Category getCategoryById(Long cid) throws Exception {
		Category category=this.categoryRepository.findById(cid).get();
		return category;
	}

}
