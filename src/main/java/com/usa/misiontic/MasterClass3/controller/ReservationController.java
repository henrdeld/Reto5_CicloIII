package com.usa.misiontic.MasterClass3.controller;


import com.usa.misiontic.MasterClass3.ModelsCustomized.CountClient;
import com.usa.misiontic.MasterClass3.ModelsCustomized.StatusAmount;
import com.usa.misiontic.MasterClass3.entities.Category;
import com.usa.misiontic.MasterClass3.entities.Reservation;
import com.usa.misiontic.MasterClass3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        return reservationService.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return reservationService.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation p){
        return reservationService.update(p);
    }

    //Reto5
    @GetMapping("/reports-clients")
    public List<CountClient> getReservationReportClient(){
        return reservationService.getTopClients();
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationStatus(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne,dateTwo) ;
    }


}
