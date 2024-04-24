package com.example.oblig3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Billett film){
        String sql = "INSERT INTO Billett(film, antall, fornavn, etternavn, adresse, mobilnummer, epost)" +
                " VALUES(?,?,?,?,?,?,?);";
        db.update(sql, film.getFilm(),film.getAntall(),film.getFornavn(),film.getEtternavn(), film.getAdresse(),
                film.getMobilnummer(), film.getEpost());
    }

    public List<Billett> hentAlt(){
        String sql = "SELECT * FROM Billett ";
        List<Billett> billettRegister = db.query(sql, new BeanPropertyRowMapper(Billett.class));
        billettRegister.sort(new BillettParator());
        return billettRegister;
    }
    public Billett henteEnBillett(int id){
        String sql = "SELECT * FROM Billett WHERE id=?";
        Billett billett = db.queryForObject(sql,BeanPropertyRowMapper.newInstance(Billett.class),id);
        return billett;
    }

    public void endreBillett(Billett film){
        String sql = "UPDATE Billett SET film=?,antall=?, fornavn=?, etternavn =?, adresse=?, mobilnummer=?,epost=? where id=?";
        db.update(sql,film.getFilm(),film.getAntall(),film.getFornavn(),film.getEtternavn(),film.getAdresse(),
                film.getMobilnummer(),film.getEpost(), film.getId());
    }

    public void slettEnBillett(long mobillnummer) {
        String sql = "DELETE FROM Billett WHERE id=?";
        db.update(sql,mobillnummer);
    }

    public void slettBillett(){
        String sql = "DELETE FROM Billett;";
        db.update(sql);
    }
}
