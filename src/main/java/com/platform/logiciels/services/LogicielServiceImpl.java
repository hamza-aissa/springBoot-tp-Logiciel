package com.platform.logiciels.services;

import com.platform.logiciels.entities.Devloppeur;
import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.repos.DevloppeurRepository;
import com.platform.logiciels.repos.LogicielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogicielServiceImpl implements LogicielService {
    @Autowired
    LogicielRepository logicielRepository;
    @Autowired
    DevloppeurRepository devloppeurRepository;

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
    @Override
    public Page<Logiciel> getAllLogicielParPage(int page , int size) {
        return logicielRepository.findAll(PageRequest.of(page,size));
    }
    @Override
    public List<Logiciel> findByDevloppeur(Devloppeur devloppeur) {
        return logicielRepository.findByDevloppeur(devloppeur);
    }

    @Override
    public List<Logiciel> findByDevloppeurIdDevloppeur(Long id) {
        return logicielRepository.findByDevloppeurIdDevloppeur(id);
    }
    @Override
    public List<Logiciel> findByOrderByNomLogicielAsc() {
        return logicielRepository.findByOrderByNomLogicielAsc();
    }

    @Override
    public List<Logiciel> trierLogicielsNomsPrix() {
        return logicielRepository.trierLogicielsNomsPrix();
    }
    @Override
    public List<Devloppeur> getAllDevloppeurs() {
        return devloppeurRepository.findAll();
        }
    }
