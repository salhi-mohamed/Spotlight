package com.example.spotlight.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SpectacleDTO {
    private Long id;
    private String titre;
    private String date;
    private BigDecimal heureDebut;
    private BigDecimal duree;
    private Integer nbSpectateurs;
    private String nomLieu;
    private String imageUrl; // Ajoutez ce champ
    private BigDecimal price;

    // Ajoutez le getter
    public BigDecimal getPrice() {
        return price;
    }
    // ... autres champs et méthodes

    public String getImageUrl() {
        return imageUrl;}
    // Getters et setters
    public Long getId() { return id; }
    public String getTitre() { return titre; }
    public String getDate() { return date; }
    public BigDecimal getHeureDebut() { return heureDebut; }
    public BigDecimal getDuree() { return duree; }
    public Integer getNbSpectateurs() { return nbSpectateurs; }
    public String getNomLieu() { return nomLieu; }
}