package com.springboot.mySpringBootCRUDapp.dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springboot.mySpringBootCRUDapp.entity.Product;
import com.springboot.mySpringBootCRUDapp.entity.ProductSubcategory;
//для начала создадим четыре таблицы товары, цвета товаров. здесь бедт храниться цвет какого-то товара и 
//колличество этого товара этого цвета (связь - у одного товара может быть много цветов), и категории
//товаров (связь - у категории товара много товаров). также будут категории категорий товаров(связь - у категории товара много подкатегорий).
//у таблиц будут соответствующе аттребуты которые можно увидеть на картинке.
//создаем их следующими SQL коммандами.
//Теперь создадим репозиторий для взаиможействия с нашей таблицей продуктов в БД через класс Product.
//помним что репозиторий автоматически создает ссылки для простых Crud операций с БД.
//Angular фронтенд будет обращаться сюда по ссылке http://localhost:8080/eCommerceBackend/products
//для выборки всех продуктов в БД.
//Сооздадим таблицы следующими коммандами... и добавим в них данные следующими коммандами...

//Адреса эти формируються по тому что мы передали в JpaRepository<[Что сюда передали],Integer>.
//Можно задать имя адресов вручную аннотацией
//@RepositoryRestRecouse(CollectionRecourseRel="newJSONname" path="newActorsMapping") //благодаря path="newActorsMapping" будет не дефолтное сгенерированное /actors а /newActorsMapping
//CollectionRecourseRel задает идентификатор возвращаемым JSON данным newJSONname по которому потом можно будет работать с ними.
//@CrossOrigin("http://localhost:4200/")
@RepositoryRestResource
public interface ProductSubcategoryRepository extends JpaRepository<ProductSubcategory, Long> {
	Page<ProductSubcategory> findById(@Param("id") Long id, Pageable pageable);
}
//также с помощью url можно сортировать присланные обьекты в формате JSON. 
//тоесть вбив в браузере: http://localhost:8080/SpringDataRestCRUDapp/actors?sort=film
//получим JSON в котором обьекты Actor будут упорядочены по полю film