package it.iad.crudconserver3.service;

import it.iad.crudconserver3.model.Prodotto;
import java.util.List;

public interface ProdottoService {

    List<Prodotto> ricerca(String s);

    List<Prodotto> rimuovi(Prodotto prodotto);

    List<Prodotto> modifica(Prodotto prodotto);

    List<Prodotto> add(Prodotto prodotto);
    
    List<Prodotto> aggiorna();

}