/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.user.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Objeto que representa os dados de requisição de uma operação sobre usuário", value =
        "UserRequestDTO")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "Nome do usuário é obrigatório")
    @Size(min = 10, max = 80, message = "Nome do usuário deve ter no mínimo {min} e no máximo de {max} caracteres")
    @ApiModelProperty(value = "Nome do usuário", required = true)
    private String userName;

    @Size(min = 8, max = 8, message = "Senha deve ter {min} caracteres")
    @ApiModelProperty(value = "Senha do usuário", position = 1, required = true)
    private String password;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    @ApiModelProperty(value = "Email do usuário", position = 2, required = true)
    private String mail;

    @NotNull(message = "Idenficador do Perfil associado ao usuário é obrigatório")
    @ApiModelProperty(value = "Perfil associado ao usuário", position = 3, required = true)
    private Long profileId;
}
