package it.iad.crudconserver3.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prodotto implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column
    private String codice;
    
    @Column
    private String descrizione;

    public Prodotto() {
    }

    public Prodotto(String codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}