package com.platform.logiciels.controllers;

import com.platform.logiciels.entities.Devloppeur;
import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.services.LogicielService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException
    {
        request.logout();
        return "redirect:/login";
    }

    @RequestMapping("/listeLogiciels")
    public String listeLogiciels(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<Logiciel> logics = logicielService.getAllLogicielParPage(page, size);
        modelMap.addAttribute("logiciels", logics);
        modelMap.addAttribute("pages", new int[logics.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeLogiciels";
    }


    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
        List<Devloppeur> devs = logicielService.getAllDevloppeurs();
        modelMap.addAttribute("logiciel", new Logiciel());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("devloppeurs", devs);
        return "formLogiciel";
    }

    @RequestMapping("/saveLogiciel")
    public String saveLogiciel(@Valid Logiciel logiciel, BindingResult bindingResult,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "2") int size) {
        int currentPage;
        boolean isNew = false;
        if (bindingResult.hasErrors()) return "formLogiciel";
        if (logiciel.getIdLogiciel() == null) isNew = true;
        logicielService.saveLogiciel(logiciel);
        if (isNew) { // ajout
            Page<Logiciel> logs = logicielService.getAllLogicielParPage(page, size);
            currentPage = logs.getTotalPages() - 1;
        } else { // modif
            currentPage = page;
        }
        return "redirect:/listeLogiciels?page=" + currentPage + "&size=" + size;
    }

    @RequestMapping("/supprimerLogiciel")
    public String supprimerLogiciel(@RequestParam("id") Long id,
                                    ModelMap modelMap,
                                    @RequestParam (name="page",defaultValue = "0") int page,
                                    @RequestParam (name="size", defaultValue = "2") int size)  {
        logicielService.deleteLogicielById(id);
        List<Logiciel> logiciels = logicielService.getAllLogiciel();
        modelMap.addAttribute("logiciels", logiciels);
        return "listeLogiciels";
    }
    @RequestMapping("/modifierLogiciel")
    public String modifierLogiciel(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Logiciel l = logicielService.getLogiciel(id);
        List<Devloppeur> devs = logicielService.getAllDevloppeurs();
        modelMap.addAttribute("logiciel", l);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("devloppeurs", devs);
        return "formLogiciel";
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