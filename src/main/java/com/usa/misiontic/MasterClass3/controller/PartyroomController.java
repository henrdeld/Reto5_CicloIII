package com.usa.misiontic.MasterClass3.controller;


import com.usa.misiontic.MasterClass3.entities.Category;
import com.usa.misiontic.MasterClass3.entities.Partyroom;
import com.usa.misiontic.MasterClass3.service.PartyroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Partyroom")
public class PartyroomController {


    @Autowired
    private PartyroomService partyroomService;

    @GetMapping("/all")
    public List<Partyroom> getAll(){
        return partyroomService.getall();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom p){
        return partyroomService.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return partyroomService.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom update(@RequestBody Partyroom p){
        return partyroomService.update(p);
    }

}
