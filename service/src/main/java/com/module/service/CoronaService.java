package com.module.service;


import com.module.model.CoronaVirus;
import com.module.repository.CoronaVirusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoronaService {

    @Autowired
    CoronaVirusRepo coronaVirusRepo;

    public List<CoronaVirus> fetchCoronaVirus(){
        return coronaVirusRepo.findAll();
    }
}
