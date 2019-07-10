package br.org.fiergs.scholarityservice.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CAD_SCHOLARITY")
@SequenceGenerator(name = "seqCad_Scholarity", sequenceName = "SEQCAD_SCHOLARITY", allocationSize = 1)
public class Scholarity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_Scholarity")
    private Long id;

    private boolean status;

    @NotEmpty(message = "O identificador é obriagtório!")
    private String identifier;

    @NotEmpty(message = "O nome é obrigatório!")
    private String name;
}
