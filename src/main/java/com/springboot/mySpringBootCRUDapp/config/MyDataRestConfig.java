package com.springboot.mySpringBootCRUDapp.config;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.springboot.mySpringBootCRUDapp.entity.Order;
import com.springboot.mySpringBootCRUDapp.entity.Product;
import com.springboot.mySpringBootCRUDapp.entity.Region;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

//!!!Репозиторий покупателя например нам нужен только чтобы извлечь номер телефона с помощью метода который мы используем.
//И мы не хотим чтобы этот репозиторий автоматически генерировал адреса для взаимодействия с БД. В конфигурациях 
//Spring Boot можно откключить эту генерацию. Annotated означает что автоматически генрироваться ссылки будет только
//для репозиториев с аннотацией @ReporsitoryRestResource. Также есть еще VISIBILITY ссылки генерируються для всех
//public репозиториев, DEFAULT - генерация для public репозиториев или тех которые помечены аннотациец и 
//ALL генерируються для всех репозиториев с аннотацией или без, public или не public.
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	@Autowired
	private EntityManager entityManager;
	
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT}; 

        config.getExposureConfiguration()
                .forDomainType(Product.class) 
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) 
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        config.getExposureConfiguration()
				.forDomainType(Region.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) 
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        config.getExposureConfiguration()
				.forDomainType(Order.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)) 
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
        
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        
        List<Class> entityClasses = new ArrayList<>();
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
        // Можно дать разрешения сразу 
        // всем ркпозиториям по пути в addmapping в конфигурациях.
        cors.addMapping("/eCommerceApi/**").allowedOrigins("http://localhost:4200/");
    }
}
