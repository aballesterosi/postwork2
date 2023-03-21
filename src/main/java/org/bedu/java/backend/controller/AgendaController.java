package org.bedu.java.backend.controller;

import org.bedu.java.backend.model.Persona;
import org.bedu.java.backend.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AgendaController {

   AgendaService agendaService;
   @Autowired
   AgendaController(
      AgendaService agendaService
   ) {
      this.agendaService = agendaService;
   }

   @GetMapping("/")
   public ModelAndView raiz(
   ) {
      ModelAndView mav = new ModelAndView("redirect:/personas/all" );

      return mav;
   }
   @PostMapping(value = "/personas/save")
   public ModelAndView personasSave(
      @Valid Persona persona,
      Errors errors
   ) {

      ModelAndView mav;

      if( errors.hasErrors() ){
         mav = new ModelAndView("personas-add" );
      }
      else {
         agendaService.guardaPersona(persona);
         mav = new ModelAndView("redirect:/personas/all" );
      }

      return mav;
   }

   @GetMapping("/personas/add")
   public ModelAndView personasAdd() {

      ModelAndView mav = new ModelAndView("personas-add");
      Persona persona = new Persona();
      mav.addObject("persona", persona );

      return mav;
   }

   @GetMapping("/personas/all")
   public ModelAndView personasAll() {

      ModelAndView mav = new ModelAndView("index");
      mav.addObject("personas", agendaService.getPersonas() );

      return mav;
   }

}
