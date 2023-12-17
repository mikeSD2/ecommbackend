package com.springboot.mySpringBootCRUDapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mySpringBootCRUDapp.dao.ProductRepository;
import com.springboot.mySpringBootCRUDapp.entity.Product;

import jakarta.transaction.Transactional;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository rep;
	@Override
    @Transactional
    //метод для обновления данных рейтинга
	public void updateProductRating(Product product) {
		// id в присланном product с фронта передаем в новый метод findById тоесть достаем продукт из БД с этим id
		Product productToUpdate = rep.findById(product.getId());
		System.out.println(productToUpdate);
		// в продукте который мы достали из БД обновляем значения рейтинга и колличества оценок
		// значениями который присланы с фронта в product
		productToUpdate.setRating(product.getRating());
		productToUpdate.setRatingsAmount(product.getRatingsAmount());
		// обновляем продукт в БД
		rep.save(productToUpdate);
	}

}
