package br.com.pucminas.tcc.ms.user.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BooleanoChar {

    NAO("Não", "N"), SIM("Sim", "S");

    String label;

    @Getter
    String value;
}
