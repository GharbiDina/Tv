package tn.esprit.examen.DinaGharbi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long usrId;
    private  String usrNom;
    private Date usrDateInscription;
    @Enumerated(EnumType.STRING)
    Profession profession;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Programme> programmes;

}
