package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BillettController {

    @Autowired
    BillettRepository rep;

    @PostMapping("/lagre")
    public void lagreBillett(Billett film) {
        rep.lagreBillett(film);
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
}


