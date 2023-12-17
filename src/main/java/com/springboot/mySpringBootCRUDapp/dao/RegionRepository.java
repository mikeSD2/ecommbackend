package com.springboot.mySpringBootCRUDapp.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
/*В сервисе на фронтенде будет посылаться id сюда на сервер spring чтобы извлечь из БД
только продукты с таким id категории или подкатегории. */
import com.springboot.mySpringBootCRUDapp.entity.Product;
import com.springboot.mySpringBootCRUDapp.entity.Region;
//@CrossOrigin("http://localhost:4200/")
//Для выборки областей создаем репозиторий и определяем метод в нем  которы буде по имени совершать запрос. 
//Метод такой - findByCountryName. Параметр это имя страны. По нему извлекаються области. 
//Запрос за кулисами будет такой SELECT * FROM region LEFT OUTER JOIN country ON region.country_id=country.id WHERE country.name = :name. 
//Методом создаеться адрес localhost:8080/api/states/search/findByCountryName?name=Austria. 
//По нему обращаемся за областями. Также отключим для этих репозиториев все http методы кроме GET. Будут только для чтения
@RepositoryRestResource
public interface RegionRepository extends JpaRepository<Region, Long> {
	List<Region> findByCountryName(@Param("name") String name);
}