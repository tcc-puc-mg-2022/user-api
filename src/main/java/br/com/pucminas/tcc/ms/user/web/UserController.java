/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.user.web;

import br.com.pucminas.tcc.ms.user.ProfileRepository;
import br.com.pucminas.tcc.ms.user.User;
import br.com.pucminas.tcc.ms.user.UserRepository;
import br.com.pucminas.tcc.ms.user.UserService;
import br.com.pucminas.tcc.ms.user.commons.AbstractControllerSupport;
import br.com.pucminas.tcc.ms.user.web.dto.UserReponseDTO;
import br.com.pucminas.tcc.ms.user.web.dto.UserRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Api(tags = "Usuarios", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/v1/users")
public class UserController extends AbstractControllerSupport {

    private UserRepository repository;
    private ProfileRepository profileRepository;
    private UserService service;

    public UserController(@NonNull ModelMapper modelMapper,
                          @NonNull UserRepository repository,
                          @NonNull ProfileRepository profileRepository) {
        super(modelMapper);
        this.repository = repository;
        this.profileRepository = profileRepository;
    }

    @ApiOperation(value = "Recuperar usuário por identificador", response = UserReponseDTO.class)
    @GetMapping("/{id}")
    public UserReponseDTO getOne(@ApiParam(value = "Identificador do usuário") @PathVariable Long id) {
        return repository.findByIdFetchProfile(id)
                .map(user -> modelMapper.map(user, UserReponseDTO.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, RECURSO_NAO_ENCONTRADO));
    }

    @ApiOperation(value = "Criar usuário", response = UserReponseDTO.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserReponseDTO create(@Valid @RequestBody UserRequestDTO dto) {

        final var profile = profileRepository.findById(dto.getProfileId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil informado não " + "encontrado"));
        final var userEntity = modelMapper.map(dto, User.class);
        userEntity.setProfile(profile);
        return modelMapper.map(service.save(userEntity), UserReponseDTO.class);
    }

    @ApiOperation(value = "Atualizar usuário", response = UserReponseDTO.class)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserReponseDTO update(@ApiParam(value = "Identificador do Usuário") @PathVariable Long id,
                                 @Valid @RequestBody UserRequestDTO dto) {
        return modelMapper.map(service.save(
                        repository.findById(id)
                                .map(user -> {
                                    final var updated = modelMapper.map(dto, User.class);
                                    updated.setProfile(profileRepository.findById(dto.getProfileId())
                                            .orElseThrow(() -> new ResponseStatusException(
                                                    HttpStatus.NOT_FOUND, "Perfil informado não encontrado")));
                                    return updated;
                                })
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, RECURSO_NAO_ENCONTRADO))),
                UserReponseDTO.class);
    }
}
