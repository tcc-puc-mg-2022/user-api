/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.autenticacao.user.web;

import br.com.pucminas.tcc.ms.autenticacao.commons.enums.BooleanoChar;
import br.com.pucminas.tcc.ms.autenticacao.user.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "Objeto que representa o peril do usuário", value = "ProfileResponseDTO")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponseDTO {

    @ApiModelProperty(value = "Identificador do perfil", position = 1)
    private Long id;

    @ApiModelProperty(value = "Nome do perfil", position = 2)
    private String userName;

    @ApiModelProperty(value = "Descrição do Perfil", position = 3)
    private String description;

    @ApiModelProperty(value = "Indica se o perfil está ativo", position = 4)
    private BooleanoChar active;

    @ApiModelProperty(value = "Role do perfil", position = 5)
    private RoleEnum role;

}
