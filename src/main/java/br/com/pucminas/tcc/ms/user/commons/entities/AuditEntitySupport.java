/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.user.commons.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Setter
@Getter
@MappedSuperclass
public class AuditEntitySupport implements Serializable {

    @NotNull
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @Column(name = "DAT_INCLUSAO", nullable = false, columnDefinition = "TIMESTAMP")
    private OffsetDateTime createdAt;

    @NotNull
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @Column(name = "DAT_ALTERACAO", columnDefinition = "TIMESTAMP")
    private OffsetDateTime changedAt;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (createdAt == null) {
            createdAt = OffsetDateTime.now();
            changedAt = createdAt;
        } else {
            changedAt = OffsetDateTime.now();
        }
    }

}
