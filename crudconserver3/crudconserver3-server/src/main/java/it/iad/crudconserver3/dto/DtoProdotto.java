package it.iad.crudconserver3.dto;

import it.iad.crudconserver3.model.Prodotto;

public class DtoProdotto {
    private Prodotto prodotto;

    public DtoProdotto() {
    }
    
    public DtoProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }    

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
    
}