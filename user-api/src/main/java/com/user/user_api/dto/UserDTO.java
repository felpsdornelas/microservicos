package com.user.user_api.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

     @NotBlank (message = "Nome é obrigatório")
     private String nome;
     
     @NotBlank (message = "CPF é obrigatório")
     private String cpf;

     private String endereco;

     @NotBlank (message = "Email é obrigatório")
     private String email;

     private String telefone;
     
     private LocalDateTime dataCadastro;
     
}
