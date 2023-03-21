package org.bedu.java.backend.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidadorTelefonoService {
    public boolean validarTelefono(String telefono){
        return verificarCaracteres(telefono) && verificaDiezDigitos(telefono);
    }

    // Verifica que solo existan números de 0 a 9, espacios en blanco y guiones.
    public boolean verificarCaracteres(String telefono) {
        Pattern pattern = Pattern.compile("^[0-9 -]+$");
        Matcher validarDigitos = pattern.matcher(telefono);
        return validarDigitos.matches();
    }

    // Verifica que se tengan 10 dígitos sin tomar en cuenta los espacios en blanco y los guiones.
    public boolean verificaDiezDigitos(String telefono){
        Pattern pattern = Pattern.compile("^(?:\\D*\\d){10}\\D*$");
        Matcher validarNumeros = pattern.matcher(telefono);
        return validarNumeros.matches();
    }

    public String limpiarTelefono(String telefono){
        return telefono.replaceAll("[0-9]", "");
    }
}
