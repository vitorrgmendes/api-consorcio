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

public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotEmpty
    @NotBlank
    String name;

    @NotEmpty
    @NotBlank
    Long valorTotal;

    @NotEmpty
    @NotBlank
    Long valorParcelas;

    @NotEmpty
    @NotBlank
    Date dataCricao;

    @NotEmpty
    @NotBlank
    int meses;

    @NotEmpty
    @NotBlank
    Date dataFinal;

    int quantidadePessoas;

    @NotEmpty
    @NotBlank
    boolean privado;

    @NotEmpty
    @NotBlank
    @Id
    private long idCliente;
}
