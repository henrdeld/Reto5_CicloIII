package com.usa.misiontic.MasterClass3.service;

import com.usa.misiontic.MasterClass3.ModelsCustomized.CountClient;
import com.usa.misiontic.MasterClass3.ModelsCustomized.StatusAmount;
import com.usa.misiontic.MasterClass3.entities.Reservation;
import com.usa.misiontic.MasterClass3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservasRepository;

    public List<Reservation> getAll(){
        return reservasRepository.getAll();
    }
    public Optional<Reservation> getReservas(int id){
        return reservasRepository.getReservas(id);
    }
    public Reservation save(Reservation p){
        if (p.getIdReservation()==null) {
            return reservasRepository.save(p);
        }else{
            Optional<Reservation> e = reservasRepository.getReservas(p.getIdReservation());
            if (e.isPresent()){
                return p;
            }else{
                return reservasRepository.save(p);
            }
        }
    }
    public Reservation update(Reservation p){
        if (p.getIdReservation()!=null){
            Optional<Reservation> q = reservasRepository.getReservas(p.getIdReservation());
            if (q.isPresent()){

                if (p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
                }
                if (p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                if (p.getStatus()!=null){
                    q.get().setStatus(p.getStatus());
                }
                reservasRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p= reservasRepository.getReservas(id);
        if (p.isPresent()){
            reservasRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }

    //Reto 5

    public List<CountClient> getTopClients(){
        return reservasRepository.getTopClients();
    }

    public StatusAmount getReservationStatusReport(){
        List<Reservation> completed = reservasRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservasRepository.getReservationByStatus("cancelled");
        return new StatusAmount(completed.size() , cancelled.size());

    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);

        }catch (ParseException e){
            e.printStackTrace();
        }
        if (a.before(b)){
            return reservasRepository.getReservationPeriod(a, b);
            }else{
            return new ArrayList<>();
        }
    }
}