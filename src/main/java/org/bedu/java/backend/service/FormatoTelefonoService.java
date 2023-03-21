package org.bedu.java.backend.service;

import org.springframework.stereotype.Service;

@Service
public class FormatoTelefonoService {

    // Elimina cualquier caractér que no sea número
    public String obtenerNumeros(String telefono){
        StringBuilder numero = new StringBuilder();
        for(char ch: telefono.toCharArray()){
            if(ch >= 48 && ch <= 57){
                numero.append(ch);
            }
        }
        return numero.toString();
    }

    // Se agrega formato (##)-####-#### al número de teléfono
    public String formatoNumero(String telefono) {
        String numero = obtenerNumeros(telefono);
        return String.format("%s-%s-%s",
                numero.substring(0,2),
                numero.substring(2,6),
                numero.substring(6, 10));

    }
}
