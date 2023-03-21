package org.bedu.java.backend.service;

import org.bedu.java.backend.model.Persona;
import org.bedu.java.backend.persistence.AgendaMemoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AgendaService {
    private final ValidadorTelefonoService validadorTelefonoService;
    private final AgendaMemoryDao agendaMemoryDao;

    private final FormatoTelefonoService formatoTelefonoService;
    @Autowired
    public AgendaService(
       ValidadorTelefonoService validadorTelefonoService,
       AgendaMemoryDao agendaMemoryDao,
       FormatoTelefonoService formatoTelefonoService
    ){
        this.validadorTelefonoService = validadorTelefonoService;
        this.agendaMemoryDao = agendaMemoryDao;
        this.formatoTelefonoService = formatoTelefonoService;
    }

    public Persona guardaPersona(Persona persona){

        if(!validadorTelefonoService.validarTelefono(persona.getTelefono())){
            return null;
        }

        persona.setTelefono( formatoTelefonoService.formatoNumero( persona.getTelefono() ) );

        return agendaMemoryDao.guardaPersona(persona);
    }
    public Set<Persona> getPersonas(){
        return agendaMemoryDao.getPersonas();
    }
}
