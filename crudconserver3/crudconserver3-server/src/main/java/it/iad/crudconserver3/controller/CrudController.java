package it.iad.crudconserver3.controller;

import it.iad.crudconserver3.dto.DtoCriterio;
import it.iad.crudconserver3.dto.DtoListaProdotti;
import it.iad.crudconserver3.dto.DtoProdotto;
import it.iad.crudconserver3.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CrudController {
    
    @Autowired
    ProdottoService prodottoService;
    
    @RequestMapping("/aggiorna")
    @ResponseBody
    public DtoListaProdotti aggiorna(){
        return new DtoListaProdotti(prodottoService.aggiorna());
    }
    
    @RequestMapping("/ricerca")
    @ResponseBody
    public DtoListaProdotti ricerca(@RequestBody DtoCriterio dto){
        return new DtoListaProdotti(prodottoService.ricerca(dto.getCriterio()));
    } 
    
    @RequestMapping("/rimuovi")
    @ResponseBody
    public DtoListaProdotti rimuovi(@RequestBody DtoProdotto dto){
        return new DtoListaProdotti(prodottoService.rimuovi(dto.getProdotto()));
    } 
    
    @RequestMapping("/modifica")
    @ResponseBody
    public DtoListaProdotti modifica(@RequestBody DtoProdotto dto){
        return new DtoListaProdotti(prodottoService.modifica(dto.getProdotto()));
    } 
    
    @RequestMapping("/add")
    @ResponseBody
    public DtoListaProdotti add(@RequestBody DtoProdotto dto){
        return new DtoListaProdotti(prodottoService.add(dto.getProdotto()));
    } 
}
