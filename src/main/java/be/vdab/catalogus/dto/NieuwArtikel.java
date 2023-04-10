package be.vdab.catalogus.dto;

import jakarta.validation.constraints.NotBlank;

public record NieuwArtikel(@NotBlank String naam) {
}
