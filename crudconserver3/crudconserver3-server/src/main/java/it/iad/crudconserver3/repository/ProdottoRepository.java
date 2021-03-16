package it.iad.crudconserver3.repository;

import it.iad.crudconserver3.model.Prodotto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{
    
    List<Prodotto> findByCodiceContainsOrDescrizioneContains(String c, String a);
}
