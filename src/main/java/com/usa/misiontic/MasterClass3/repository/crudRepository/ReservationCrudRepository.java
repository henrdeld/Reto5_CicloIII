package com.usa.misiontic.MasterClass3.repository.crudRepository;

import com.usa.misiontic.MasterClass3.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    //select client_id, count(*) as total from reservation   group by client_id order by total DESC;
    @Query("SELECT c.client,COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT (c.client) DESC")
    public List<Object[]>countTotalReservationsByClient();

    public List<Reservation> findAllByStatus(String Status);

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

}
