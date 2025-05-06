package com.platform.logiciels.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Devloppeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDevloppeur;
    private String nomDevloppeur;
    private String specialite;
    @JsonIgnore
    @OneToMany(mappedBy = "devloppeur")
    private List<Logiciel> logiciels;

}