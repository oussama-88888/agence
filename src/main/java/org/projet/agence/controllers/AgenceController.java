package org.projet.agence.controllers;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.projet.agence.models.Agence;
import org.projet.agence.services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgenceController {
    
    @Autowired
    private AgenceService agenceService;

	@RequestMapping("/listeAgences")
	public String getAgences(ModelMap modelMap){
	
	List<Agence> agences = agenceService.getAllAgences();
	modelMap.addAttribute("agences", agences);
	
	

	return "listeAgences";
    
	}

	// Delete
	@RequestMapping("/deleteAgence")
	public String deleteAgenceById(@RequestParam Long id) {
		
		agenceService.deleteAgenceById(id);

		return "redirect:/listeAgences";
   }

	// init page Add
    @RequestMapping("/ajoutAgence")
	public String formAdd(ModelMap modelMap){
		modelMap.addAttribute("agence", new Agence());
	return "ajoutAgence";
    
	}
	@RequestMapping("/saveAgence")
	public String saveServ(@Valid Agence agence,BindingResult bindingResult){

        if (bindingResult.hasErrors()) return "ajoutServ";
        agenceService.saveAgence(agence);
	
        return "redirect:/listeAgences";
	
	}

	@RequestMapping("/modifierAgence")
	public String editerServ(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Agence l= agenceService.getAgence(id);
		modelMap.addAttribute("agence", l);
	
		return "modifierAgence";
	
	}

	@RequestMapping("/updateAgence")
	public String updateServ(@Valid Agence agence,BindingResult bindingResult){

        if (bindingResult.hasErrors()) return "modifierAgence";
        agenceService.saveAgence(agence);
	
        return "redirect:/listeAgences";
	
	}






}
