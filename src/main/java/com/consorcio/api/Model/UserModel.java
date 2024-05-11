package com.consorcio.api.Model;

import com.consorcio.api.DTO.UserDTO.userSignUp;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "users")
public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    String name;

    @NotEmpty
    @NotBlank
    @Email
    @Column(unique = true)
    String email;

    @NotEmpty
    @NotBlank
    String password;

    @NotEmpty
    @NotBlank
    @Column(unique = true)
    String cpf;

    @NotEmpty
    @NotBlank
    @Column(unique = true)
    String phone;

    @NotEmpty
    @NotBlank
    String address;

    @NotEmpty
    @NotBlank
    String complement;

    @NotEmpty
    @NotBlank
    String state;

    @NotEmpty
    @NotBlank
    String city;
}
