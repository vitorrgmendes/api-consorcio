package com.consorcio.api.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "group")

public class SorteioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSorteio;

    @NotEmpty
    @NotBlank
    Date data;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;
}
