package com.springboot.mySpringBootCRUDapp.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springboot.mySpringBootCRUDapp.entity.Country;
/*В сервисе на фронтенде будет посылаться id сюда на сервер spring чтобы извлечь из БД
только продукты с таким id категории или подкатегории. */
import com.springboot.mySpringBootCRUDapp.entity.Product;

//@CrossOrigin("http://localhost:4200/")
//Далее на бекенд стороне создаем Entity классы нашых таблиц. Для страны создаем репозиторий. 
//будем обращаться за странами по адресу localhost:8080/api/countries
@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Country, Long> {
}