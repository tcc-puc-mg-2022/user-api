/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.autenticacao.commons.converters;

import br.com.pucminas.tcc.ms.autenticacao.commons.enums.BooleanoChar;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BooleanoCharConverter implements AttributeConverter<BooleanoChar, String> {
    @Override
    public String convertToDatabaseColumn(BooleanoChar value) {
        return value != null ? value.getValue() : null;
    }

    @Override
    public BooleanoChar convertToEntityAttribute(String code) {
        return Stream.of(BooleanoChar.values())
                .filter(id -> id.getValue().equalsIgnoreCase(code))
                .findFirst().orElseThrow();
    }
}
