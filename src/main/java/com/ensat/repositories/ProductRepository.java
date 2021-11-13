package com.ensat.repositories;

import com.ensat.entities.Product;
import org.springframework.data.repository.CrudRepository;

// TODO : Trouver un moyen içi de récupérer dynamiquement les credentials de la BDD
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
