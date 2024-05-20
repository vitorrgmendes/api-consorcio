package com.consorcio.api.Model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import jakarta.persistence.Entity;
import org.springframework.lang.Nullable;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "group")

public class BoletosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoleto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;

    @NotEmpty
    @NotBlank
    Long valor;

    @NotEmpty
    @NotBlank
    Date dataVencimento;

    @Nullable
    Date dataPagamento;

}
