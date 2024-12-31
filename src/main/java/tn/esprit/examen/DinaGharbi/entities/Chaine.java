package tn.esprit.examen.DinaGharbi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Chaine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long chId;
    String cNnom;
    @Enumerated(EnumType.STRING)
    Thematique chThematique;
}
