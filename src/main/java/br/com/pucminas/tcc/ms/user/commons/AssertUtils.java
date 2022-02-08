package br.com.pucminas.tcc.ms.user.commons;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AssertUtils {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }
}
