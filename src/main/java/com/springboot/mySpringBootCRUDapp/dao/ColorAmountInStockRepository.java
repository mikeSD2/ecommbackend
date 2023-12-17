package com.springboot.mySpringBootCRUDapp.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.springboot.mySpringBootCRUDapp.entity.ColorAmountInStock;
import com.springboot.mySpringBootCRUDapp.entity.Product;

//@CrossOrigin("http://localhost:4200/")
@RepositoryRestResource //значит что репозиторий будет генерировать ссылки в Custome у нас нет такой значит он не будет
public interface ColorAmountInStockRepository extends JpaRepository<ColorAmountInStock, Long> {
}