package com.example.mosnterguideapi.model;

import com.example.mosnterguideapi.model.Enum.MonsterTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MonsterTypeEnum type;
    @Embedded
    private Attributes attributes;
    private Integer level;

}
