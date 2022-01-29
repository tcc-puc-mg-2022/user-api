/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.autenticacao.commons;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AssertUtils {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }
}
