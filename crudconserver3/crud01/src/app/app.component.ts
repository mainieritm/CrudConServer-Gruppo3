import { AddEvent, ConfermaEvent, ModificaEvent, RicercaEvent, AnnullaEvent, RimuoviEvent, SelezionaEvent } from './automa/eventi';
import { Automabile, State } from './automa/state';
import { Automa } from './automa/automa';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Prodotto } from './prodotto';
import { Event } from './automa/event';
import { DtoProdotto } from './dto-prodotto';
import { DtoListaProdotti } from './dto-lista-prodotti';
import { AggiungiState, ModificaState, RimuoviState } from './automa/stati';
import { DtoCriterio } from './dto-criterio';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements Automabile, OnInit {
  prodotto: Prodotto = new Prodotto();
  prodotti: Prodotto[] = [];
  searchCriterion: string = "";
  automa: Automa;
  stato: State;

  // proprietà gui
  buttonNuovaVisible: boolean = false;
  formDivVisible: boolean = false;
  campiNonEditabili: boolean = false;
  confAnnVisible: boolean = false;
  searchVisible: boolean = false;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    // TODO: caricare lista prodotti all'inizio
    this.aggiorna();
    this.automa = new Automa(this);
  }

  goToAggiungi() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.searchVisible = false;
  }

  goToModifica() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = false;
    this.confAnnVisible = true;
    this.searchVisible = false;
  }

  goToRicerca() {
    this.buttonNuovaVisible = true;
    this.formDivVisible = false;
    // this.campiNonEditabili = true;
    // this.confAnnVisible = true;
    this.searchVisible = true;
  }

  goToRimuovi() {
    this.buttonNuovaVisible = false;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.confAnnVisible = true;
    this.searchVisible = false;
  }

  goToVisualizza() {
    this.buttonNuovaVisible = true;
    this.formDivVisible = true;
    this.campiNonEditabili = true;
    this.confAnnVisible = false;
    this.searchVisible = true;
  }

  nuova() {
    this.stato = this.automa.next(new AddEvent());
  }

  modifica() {
    this.stato = this.automa.next(new ModificaEvent());
  }

  conferma() {
    let dto: DtoProdotto = new DtoProdotto();
    dto.prodotto = this.prodotto;
    if (this.stato instanceof AggiungiState) {
      let oss: Observable<DtoListaProdotti> = this.http.post<DtoListaProdotti>('http://localhost:8080/add', dto);
      oss.subscribe(r => this.prodotti = r.listaProdotti);
    } else if (this.stato instanceof ModificaState) {
      let oss: Observable<DtoListaProdotti> = this.http.post<DtoListaProdotti>('http://localhost:8080/modifica', dto);
      oss.subscribe(r => this.prodotti = r.listaProdotti);
    } else if (this.stato instanceof RimuoviState) {
      let oss: Observable<DtoListaProdotti> = this.http.post<DtoListaProdotti>('http://localhost:8080/rimuovi', dto);
      oss.subscribe(r => this.prodotti = r.listaProdotti);
    }
    this.automa.next(new ConfermaEvent());
    this.prodotto=new Prodotto();
  }

  annulla() {
    this.automa.next(new AnnullaEvent());
  }

  rimuovi() {
    this.stato = this.automa.next(new RimuoviEvent());
  }

  cerca() {
    let dto: DtoCriterio = new DtoCriterio();
    dto.criterio = this.searchCriterion;
    let oss: Observable<DtoListaProdotti> = this.http.post<DtoListaProdotti>('http://localhost:8080/ricerca', dto);
    oss.subscribe(r => this.prodotti = r.listaProdotti);
    this.automa.next(new RicercaEvent());
  }

  seleziona(prod: Prodotto) {
    this.automa.next(new SelezionaEvent());
  }

  aggiorna() {
    let oss: Observable<DtoListaProdotti> = this.http.get<DtoListaProdotti>('http://localhost:8080/aggiorna');
    oss.subscribe(r => this.prodotti = r.listaProdotti);
  }
}
