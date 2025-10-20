package com.felipe.userapi.models.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
     
     private String id;
     @NotBlank (message = "Nome é obrigatório")
     private String nome;
     @NotBlank (message = "CPF é obrigatório")
     private String cpf;
     private String endereco;
     @NotBlank (message = "Email é obrigatório")
     private String email;
     private String telefone;
     private LocalDateTime dataCadastro;

     public static UserDTO convert(User user) {
          UserDTO userDTO = new UserDTO();
          userDTO.setId(user.getId());
          userDTO.setNome(user.getNome());
          userDTO.setEndereco(user.getEndereco());
          userDTO.setCpf(user.getCpf());
          userDTO.setEmail(user.getEmail());
          userDTO.setTelefone(user.getTelefone());
          userDTO.setDataCadastro(user.getDataCadastro());
          return userDTO;
     }
}
