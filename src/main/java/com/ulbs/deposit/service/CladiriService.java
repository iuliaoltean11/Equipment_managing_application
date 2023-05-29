package com.ulbs.deposit.service;

import com.ulbs.deposit.entity.Cladiri;
import com.ulbs.deposit.repository.CladiriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CladiriService implements ICladiriService {
    @Autowired
    CladiriRepository cladiriRepository;

    @Override
    public List<Cladiri> getAllCladiri() {
        return (List<Cladiri>) cladiriRepository.findAll();
    }

    @Override
    public Boolean addNewCladire(Cladiri cladire) {
        if(cladire != null){
            cladiriRepository.save(cladire);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Cladiri getCladireByName(String name) {
        return cladiriRepository.findCladiriByNumeCladire(name);
    }

    @Override
    public void deleteCladire(Long id) {
        cladiriRepository.deleteById(id);
    }
}
