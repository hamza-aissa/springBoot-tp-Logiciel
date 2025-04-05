package com.platform.logiciels.services;

import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.repos.LogicielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogicielServiceImpl implements LogicielService {
    @Autowired
    LogicielRepository logicielRepository;

    public LogicielServiceImpl() {
        super();
    }

    @Override
    public Logiciel saveLogiciel(Logiciel l) {
        return logicielRepository.save(l);
    }

    @Override
    public Logiciel updateLogiciel(Logiciel l) {
        return logicielRepository.save(l);
    }

    @Override
    public void deleteLogiciel(Logiciel l) {
        logicielRepository.delete(l);
    }

    @Override
    public void deleteLogicielById(Long id) {
        logicielRepository.deleteById(id);
    }

    @Override
    public Logiciel getLogiciel(Long id) {
        return logicielRepository.findById(id).get();
    }

    @Override
    public List<Logiciel> getAllLogiciel() {
        return logicielRepository.findAll();
    }
}
