/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.user;

import br.com.pucminas.tcc.ms.user.commons.converters.BooleanoCharConverter;
import br.com.pucminas.tcc.ms.user.commons.entities.AuditEntitySupport;
import br.com.pucminas.tcc.ms.user.commons.enums.BooleanoChar;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Entity
@Table(name = "TAB_PERFIL")
public class Profile extends AuditEntitySupport {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_PERFIL")
    @SequenceGenerator(name = "SG_PERFIL", sequenceName = "SQ_PERFIL", allocationSize = 1)
    @Column(name = "IDT_PERFIL", nullable = false)
    private Long id;

    @NotBlank
    @Size(max = 80)
    @Column(name = "NM_PERFIL")
    private String name;

    @NotBlank
    @Size(max = 254)
    @Column(name = "DS_PERFIL")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "SGL_PERFIL")
    private RoleEnum role;

    @NotNull
    @Column(name = "FLG_ATIVO", nullable = false, columnDefinition = "VARCHAR(1)")
    @Convert(converter = BooleanoCharConverter.class)
    private BooleanoChar active = BooleanoChar.SIM;

}
