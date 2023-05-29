package com.ulbs.deposit.service;
import com.ulbs.deposit.entity.Echipament;
import com.ulbs.deposit.repository.EchipamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EchipamenteService implements IEchipamenteService{
    @Autowired
    EchipamentRepository echipamentRepository;

    @Override
    public List<Echipament> getAllEchipamente() {
        return echipamentRepository.findAll();
    }

    @Override
    public Boolean addNewEchipamente(Echipament echipament) {
        if(echipament != null){
//            String id = UUID.randomUUID().toString();
//            echipament.setId(id);
            echipamentRepository.save(echipament);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Echipament> searchEchipamente(String keyword) {
       List<Echipament>echipaments = echipamentRepository.findAll();
       List<Echipament> searchElements = new ArrayList<>();
        for (Echipament echipament: echipaments) {
           if(echipament.getNumeEchipament().toLowerCase().contains(keyword.toLowerCase())){
                searchElements.add(echipament);
            }
        }
        return searchElements;
    }

    @Override
    public Echipament getEchipamentById(Long id) {
        Optional<Echipament> echipament = echipamentRepository.findById(id);
        return echipament.get();
    }

    @Override
    public void deleteEchipament(Long id) {
        echipamentRepository.deleteById(id);
    }
}
