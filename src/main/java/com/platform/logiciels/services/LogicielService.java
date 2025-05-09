package com.platform.logiciels.services;
import com.platform.logiciels.entities.Devloppeur;
import com.platform.logiciels.entities.Logiciel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LogicielService {
    Logiciel saveLogiciel(Logiciel p);
    Logiciel updateLogiciel(Logiciel p);
    void deleteLogiciel(Logiciel p);
    void deleteLogicielById(Long id);
    Logiciel getLogiciel(Long id);
    List<Logiciel> getAllLogiciel();
    Page<Logiciel> getAllLogicielParPage(int page , int size);
    List<Logiciel> findByDevloppeur(Devloppeur devloppeur);
    List<Logiciel> findByDevloppeurIdDevloppeur(Long id);
    List<Logiciel> findByOrderByNomLogicielAsc();
    List<Logiciel> trierLogicielsNomsPrix();
    List<Devloppeur> getAllDevloppeurs();
 }
