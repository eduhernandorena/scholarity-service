package br.org.fiergs.scholarityservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Scholarity {

    @Id
    private Long id;

    private boolean status;

    @NotEmpty(message = "O identificador é obriagtório!")
    private String identifier;

    @NotEmpty(message = "O nome é obrigatório!")
    private String name;
}
