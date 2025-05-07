package com.platform.logiciels.controllers;

import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.services.LogicielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LogicielRESTController {
    @Autowired
    LogicielService logicielService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Logiciel> getAllLogiciels() {
        return logicielService.getAllLogiciel();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Logiciel getLoficielById(@PathVariable("id") Long id) {
        return logicielService.getLogiciel(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Logiciel createLogiciel(@RequestBody Logiciel logiciel) {
        return logicielService.saveLogiciel(logiciel);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Logiciel updateLogiciel(@RequestBody Logiciel logiciel) {
        return logicielService.updateLogiciel(logiciel);
    }
    @RequestMapping(value="/logsDevs/{idDev}",method = RequestMethod.GET)
    public List<Logiciel> getLogicielsByCatId(@PathVariable("idDev") Long idCat) {
        return logicielService.findByDevloppeurIdDevloppeur(idCat);
    }
}

