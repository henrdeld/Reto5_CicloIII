package com.usa.misiontic.MasterClass3.repository.crudRepository;

import com.usa.misiontic.MasterClass3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
