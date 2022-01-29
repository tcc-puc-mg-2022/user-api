/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.autenticacao.user.web.dto;

import br.com.pucminas.tcc.ms.autenticacao.commons.enums.BooleanoChar;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "Objeto que representa os dados de resposta de uma operação sobre usuário", value =
        "UserReponseDTO")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReponseDTO {

    @ApiModelProperty(value = "Identificador do usuário")
    private Long id;

    @ApiModelProperty(value = "Nome do usuário", position = 1)
    private String userName;

    @ApiModelProperty(value = "Email do usuário", position = 2)
    private String mail;

    @ApiModelProperty(value = "Indica se o usuário está ativo", position = 3)
    private BooleanoChar active;

    @ApiModelProperty(value = "Perfil associado ao usuário", position = 4)
    private ProfileResponseDTO profile;

}
