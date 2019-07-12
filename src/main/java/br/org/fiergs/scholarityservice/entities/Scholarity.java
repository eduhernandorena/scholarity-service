package br.org.fiergs.scholarityservice.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CCOR_SCHOLARITY")
@SequenceGenerator(name = "seqCCor_Scholarity", sequenceName = "SEQCCOR_SCHOLARITY", allocationSize = 1)
public class Scholarity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCCor_Scholarity")
    private Long id;

    @Max(value = 30, message = "A chave deve conter no máximo 30 caracteres!")
    private String key;

    @NotEmpty(message = "O nome é obrigatório!")
    @Max(value = 30, message = "O Nome deve conter no máximo 30 caracteres!")
    private String name;

    @Max(value = 2, message = "A Código RAIS deve conter no máximo 2 caracteres!")
    private Integer codeRais;

    @Max(value = 12, message = "A CAGED deve conter no máximo 12 caracteres!")
    private String caged;

    @Max(value = 12, message = "A e-Social deve conter no máximo 12 caracteres!")
    private String esocial;

    @Max(value = 12, message = "A Código MEC deve conter no máximo 12 caracteres!")
    private String codeMec;
}
