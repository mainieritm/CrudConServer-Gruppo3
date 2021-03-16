package it.iad.crudconserver3.serviceimpl;

import it.iad.crudconserver3.model.Prodotto;
import it.iad.crudconserver3.repository.ProdottoRepository;
import it.iad.crudconserver3.service.ProdottoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoServiceImpl implements ProdottoService{
    
    @Autowired
    ProdottoRepository prodottoRepository;

    @Override
    public List<Prodotto> ricerca(String s) {
        return prodottoRepository.findByCodiceContainsOrDescrizioneContains(s, s);
    }

    @Override
    public List<Prodotto> rimuovi(Prodotto prodotto) {
        prodottoRepository.delete(prodotto);
        return aggiorna();
    }

    @Override
    public List<Prodotto> modifica(Prodotto prodotto) {
        prodottoRepository.save(prodotto);
        return aggiorna();
    }

    @Override
    public List<Prodotto> add(Prodotto prodotto) {
        prodottoRepository.save(prodotto);
        return aggiorna();
    }

    @Override
    public List<Prodotto> aggiorna() {
         return prodottoRepository.findAll();
    }

}