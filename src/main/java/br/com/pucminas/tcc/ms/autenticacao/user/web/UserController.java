/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.autenticacao.web;

import br.com.pucminas.tcc.ms.autenticacao.commons.AbstractControllerSupport;
import br.com.pucminas.tcc.ms.autenticacao.domain.User;
import br.com.pucminas.tcc.ms.autenticacao.domain.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Api(tags = "Usuarios", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/v1/users")
public class UserController extends AbstractControllerSupport {

    private UserRepository repository;

    public UserController(@NonNull ModelMapper modelMapper,
                          @NonNull UserRepository repository) {
        super(modelMapper);
        this.repository = repository;
    }

    @ApiOperation(value = "Recuperar usuário por identificador", response = UserReponseDTO.class)
    @GetMapping("/{id}")
    public UserReponseDTO findById(@ApiParam(value = "Identificador do usuário") @PathVariable Long id) {
        return repository.findByIdFetchProfile(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, RECURSO_NAO_ENCONTRADO));
    }

    private UserReponseDTO convertToDto(User user) {
        var dto = modelMapper.map(user, UserReponseDTO.class);
        return dto;
    }

}
