package be.vdab.catalogus.services;

import be.vdab.catalogus.domain.Artikel;
import be.vdab.catalogus.dto.NieuwArtikel;
import be.vdab.catalogus.events.ArtikelGemaakt;
import be.vdab.catalogus.repositories.ArtikelRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ArtikelService {
    private final ArtikelRepository artikelRepository;
    private final AmqpTemplate template;

    public ArtikelService(ArtikelRepository artikelRepository, AmqpTemplate template) {
        this.artikelRepository = artikelRepository;
        this.template = template;
    }
    @Transactional
    public void create(NieuwArtikel nieuwArtikel) {
        var artikel = new Artikel(nieuwArtikel.naam());
        artikelRepository.save(artikel);
        template.convertAndSend("catalogus", null, new ArtikelGemaakt(artikel));
    }
}
