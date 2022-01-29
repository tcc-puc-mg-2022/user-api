/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.user.commons;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public abstract class AbstractControllerSupport {

    protected static final String RECURSO_NAO_ENCONTRADO = "Recurso não encontrado";

    protected ModelMapper modelMapper;

    protected AbstractControllerSupport(@NonNull ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    protected <S, D> ResponseEntity<ResponseDTO> createResponseEntity(Page<S> page, Class<D> destinationType,
                                                                      UnaryOperator<List<D>> mapper) {
        List<D> content = page.getContent().stream().map(obj -> modelMapper.map(obj, destinationType))
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(content)) {
            return ResponseEntity.ok(
                    ResponseDTO.create(Collections.emptyList(), 0, 0, 0, null, null));
        } else {
            return ResponseEntity.ok(ResponseDTO.create(nonNull(mapper) ? mapper.apply(content) : content, (int) page.getTotalElements(),
                    page.getTotalPages(), page.getNumber(), page.isFirst(), page.isLast()));
        }
    }

    protected <S, D> ResponseEntity<ResponseDTO> createResponseEntity(Page<S> page, Class<D> destinationType) {
        return createResponseEntity(page, destinationType, null);
    }
}
