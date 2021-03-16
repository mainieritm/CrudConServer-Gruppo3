package it.iad.crudconserver3.dto;

public class DtoCriterio {
    private String criterio;

    public DtoCriterio() {
    }

    public DtoCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }
}