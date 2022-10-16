package com.usa.misiontic.MasterClass3.repository.crudRepository;

import com.usa.misiontic.MasterClass3.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product,Integer> {
}
