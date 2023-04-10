package be.vdab.catalogus.controllers;

import be.vdab.catalogus.dto.NieuwArtikel;
import be.vdab.catalogus.services.ArtikelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtikelController {
    private final ArtikelService artikelService;

    public ArtikelController(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }
    @PostMapping("/artikels")
    @ResponseStatus(HttpStatus.CREATED)
    void post(@RequestBody @Valid NieuwArtikel nieuwArtikel) {
        artikelService.create(nieuwArtikel);
    }
}
