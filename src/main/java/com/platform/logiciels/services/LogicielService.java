package com.platform.logiciels.services;
import com.platform.logiciels.entities.Logiciel;

import java.util.List;

public interface LogicielService {
    Logiciel saveLogiciel(Logiciel p);
    Logiciel updateLogiciel(Logiciel p);
    void deleteLogiciel(Logiciel p);
    void deleteLogicielById(Long id);
    Logiciel getLogiciel(Long id);
    List<Logiciel> getAllLogiciel();
}
