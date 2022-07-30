package com.zahra.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zahra.languages.models.Language;
import com.zahra.languages.services.LanguageService;

@Controller
public class LangaugesController {

	@Autowired
	LanguageService languageService;
	
	@RequestMapping("/languages")
	public String Home(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
    @RequestMapping(value="/languages", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
            return "index.jsp";
        } else {
        	languageService.createLanguage(language);
        	return "redirect:/languages";
        }
	}
    
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "show.jsp";
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result,
    		@PathVariable("id") Long id,
    		@RequestParam(value="name") String name,
    		@RequestParam(value="creator") String creator,
    		@RequestParam(value="currentVersion") Double currentVersion) {
    	if (result.hasErrors()) {
            return "redirect:/languages/{id}/edit";
        } else {
        	languageService.UpdateLanguage(id, name, creator, currentVersion);
        	return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	languageService.destroy(id);
    	return "redirect:/languages";
    }
}
