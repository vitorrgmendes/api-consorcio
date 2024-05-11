package com.consorcio.api.DTO.UserDTO;

public record userSignUp(String name, String email, String password, String cpf, String phone,
                         String address, String complement, String state, String city)
{}
