/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.autenticacao.user.web.dto;

import br.com.pucminas.tcc.ms.autenticacao.commons.enums.BooleanoChar;
import br.com.pucminas.tcc.ms.autenticacao.user.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "Objeto que representa os dados de resposta de uma operação sobre perfil do usuário",
        value = "ProfileResponseDTO")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponseDTO {

    @ApiModelProperty(value = "Identificador do perfil")
    private Long id;

    @ApiModelProperty(value = "Nome do perfil", position = 1)
    private String profileName;

    @ApiModelProperty(value = "Descrição do Perfil", position = 2)
    private String description;

    @ApiModelProperty(value = "Indica se o perfil está ativo", position = 3)
    private BooleanoChar active;

    @ApiModelProperty(value = "Role do perfil", position = 4)
    private RoleEnum role;

}
