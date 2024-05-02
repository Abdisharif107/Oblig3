package com.example.oblig3;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorOracleDatabaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BillettController {

    @Autowired
    BillettRepository rep;

    private boolean validerSjekk(Billett billett){
        String regexpMobilnummer ="/^[0-9]{8}$/";
        String regexpEpost ="/^[a-z A-Z0-9.-]+@[a-z]+\\.[a-zA-Z]{2,}$/";

        boolean mobilnummerOk = billett.getMobilnummer().matches(regexpMobilnummer);
        boolean epostOk = billett.getEpost().matches(regexpEpost);

        if (mobilnummerOk && epostOk){
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/lagre")
    public void lagreBillett(Billett film, HttpServletResponse response) throws IOException {
        rep.lagreBillett(film);
      /*  if (!validerSjekk(film)){
            response.sendError(HttpStatus.NOT_ACCEPTABLE.value());
        } else {
            if (!rep.lagreBillett(film)){
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        }

       */
    }

    @GetMapping("/hentAlt")
    public List<Billett> hentAlt() {
        return rep.hentAlt();
    }

    @GetMapping("/henteEnBillett")
    public Billett henteEnBillett(int id){
        return rep.henteEnBillett(id);
    }

    @PostMapping("/endre")
    public void endre(Billett billett){
        rep.endreBillett(billett);
    }

    @GetMapping("/slettEnBillett")
    public void slettEnBillett(int id){
        rep.slettEnBillett(id);
    }

    @GetMapping("/slettBillett")
    public void slettBillett() {
        rep.slettBillett();
    }

    @Autowired
    private HttpSession session;
}


