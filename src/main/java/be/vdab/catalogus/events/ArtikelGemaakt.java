package be.vdab.catalogus.events;

import be.vdab.catalogus.domain.Artikel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artikelsgemaakt")
public class ArtikelGemaakt {
    @Id
    private long id;
    private String naam;
    public ArtikelGemaakt(Artikel artikel) {
        this.id = artikel.getId();
        this.naam = artikel.getNaam();
    }
    protected ArtikelGemaakt() {

    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
