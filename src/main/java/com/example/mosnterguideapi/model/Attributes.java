package com.example.mosnterguideapi.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Embeddable
public class Attributes {
    private Integer strengh;
    private Integer defense;
    private Integer life;
}
