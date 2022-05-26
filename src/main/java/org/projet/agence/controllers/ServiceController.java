package org.projet.agence.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.projet.agence.models.Agence;
import org.projet.agence.models.Serv;
import org.projet.agence.services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServiceController {

	@Autowired
    private AgenceService agenceService;



	@RequestMapping("/ListeServiceAgence")
	public String getListSerAgence(ModelMap modelMap){

		
		List<Serv> services = agenceService.getAllServices();
		modelMap.addAttribute("services", services);

	return "ListeServiceAgence";
    
	}


	// Delete
	@RequestMapping("/deleteServ")
	public String deleteServById(@RequestParam Long id) {
		
		agenceService.deleteServiceById(id);

		return "redirect:/ListeServiceAgence";
   }


	// init page Add
    @RequestMapping("/ajoutServ")
	public String formAdd(ModelMap modelMap){
		modelMap.addAttribute("serv", new Serv());
		List<Agence> agences = agenceService.getAllAgences();
		modelMap.addAttribute("agences", agences);
	return "ajoutServ";
    
	}




   @RequestMapping("/saveServ")
	public String saveServ(@Valid Serv serv,BindingResult bindingResult){

        if (bindingResult.hasErrors()) return "ajoutServ";
        agenceService.saveService(serv);
	
        return "redirect:/ListeServiceAgence";
	
	}


	@RequestMapping("/modifierServ")
	public String editerServ(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Serv s= agenceService.getService(id);
	List<Agence> agences = agenceService.getAllAgences();
	modelMap.addAttribute("agences", agences);
	modelMap.addAttribute("serv", s);
	
	return "modifierServ";
	
	}

	@RequestMapping("/updateServ")
	public String updateLivre(@RequestParam Long id,@RequestParam String description,@RequestParam double prixService,
	
	@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateExpiration,ModelMap modelMap) throws ParseException
	{
	//conversion de la date 
	Serv serv = new Serv();  
	serv.setDateExpiration(dateExpiration);
	serv.setDescription(description);
	serv.setId(id);
	serv.setPrixService(prixService);
	
	agenceService.updateService(serv);
	
	return "redirect:/ListeServiceAgence";
	}
 



    
}
