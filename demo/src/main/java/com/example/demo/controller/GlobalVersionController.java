package com.example.demo.controller;

import com.example.demo.model.GlobalVersion;
import com.example.demo.repository.GlobalVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping("/api/global_version")
@CrossOrigin("*")
public class GlobalVersionController {

    @Autowired
    private GlobalVersionRepository globalVersionRepository;

//    @GetMapping
//    @CrossOrigin("*")
//    public List<GlobalVersion> getGlobalVersion() {
//        //GlobalVersion gv =new GlobalVersion("Вася", new Date(876543456),"rriv");
//        // globalVersionRepository.save(gv);
//        //System.out.println("inserted");
//        return globalVersionRepository.findAll();
//    }
    @GetMapping
    @CrossOrigin("*")
    public List<GlobalVersion> getGlobalVersion(int stationId) {
         List<GlobalVersion> list = new LinkedList<>();
         for (GlobalVersion gv : globalVersionRepository.findAll()){
             if (gv.getStation().getId() == stationId)
                 list.add(gv);
         }
        return list;
    }

    @PostMapping
    @CrossOrigin("*")
    public Long addGlobalVersion(@RequestBody GlobalVersion globalVersion) {
        globalVersionRepository.save(globalVersion);
        return globalVersion.getId();
    }

}
