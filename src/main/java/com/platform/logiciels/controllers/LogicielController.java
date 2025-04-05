package com.platform.logiciels.controllers;

import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.services.LogicielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class LogicielController {
    @Autowired
    LogicielService logicielService;

    @RequestMapping("/ListeLogiciels")
    public String listeLogiciels(ModelMap modelMap) {
        List<Logiciel> logiciels = logicielService.getAllLogiciel();
        modelMap.addAttribute("logiciels", logiciels);
        return "listeLogiciels";
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLogiciel";
    }

    @RequestMapping("/saveLogiciel")
    public String saveLogiciel(@ModelAttribute("logiciel") Logiciel logiciel,
                               @RequestParam("date") String date,
                               ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date datePublication = dateformat.parse(date);
        logiciel.setDatePublicationLogiciel(new java.sql.Date(datePublication.getTime()));

        Logiciel saveLogiciel = logicielService.saveLogiciel(logiciel);
        String msg = "Logiciel enregistré avec Id " + saveLogiciel.getIdLogiciel();
        modelMap.addAttribute("msg", msg);
        return "createLogiciel";
    }

    @RequestMapping("/supprimerLogiciel")
    public String supprimerLogiciel(@RequestParam("id") Long id,
                                    ModelMap modelMap) {
        logicielService.deleteLogicielById(id);
        List<Logiciel> logiciels = logicielService.getAllLogiciel();
        modelMap.addAttribute("logiciels", logiciels);
        return "listeLogiciels";
    }

    @RequestMapping("/modifierLogiciel")
    public String editerLogiciel(@RequestParam("id") Long id,
                                 ModelMap modelMap) {
        Logiciel l = logicielService.getLogiciel(id);
        modelMap.addAttribute("logiciel", l);
        return "editerLogiciel";
    }

    @RequestMapping("/updateLogiciel")
    public String updateLogiciel(@ModelAttribute("logiciel") Logiciel logiciel,
                                 @RequestParam("date") String date,
                                 ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date datePublication = dateformat.parse(date);
        logiciel.setDatePublicationLogiciel(new java.sql.Date(datePublication.getTime()));

        logicielService.updateLogiciel(logiciel);
        List<Logiciel> logiciels = logicielService.getAllLogiciel();
        modelMap.addAttribute("logiciels", logiciels);
        return "listeLogiciels";
    }
}