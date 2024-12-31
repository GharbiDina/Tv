package tn.esprit.examen.DinaGharbi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Programme {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long prId;
    private  String prgName;
    @ManyToMany(mappedBy="programmes", cascade = CascadeType.ALL)
    private List<Utilisateur> utilisateurs;
    @ManyToOne
    Chaine chaine;


}
