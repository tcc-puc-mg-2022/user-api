/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.user.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Getter;

import java.util.List;

@ApiModel(description = "Objeto de resposta.", value = "Response")
@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    private final List<?> content;
    private final int totalItems;
    private final int totalPages;
    private final int currentPage;
    private final Boolean isFirstPage;
    private final Boolean isLastPage;

    private <T> ResponseDTO(final List<T> content, final int totalItems, final int totalPages, final int currentPage,
                            final Boolean isFirstPage, final Boolean isLastPage) {
        this.content = content;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
    }


    public static <T> ResponseDTO create(final List<T> content, final int totalItems, final int totalPages,
                                         final int currentPage, final Boolean isFirstPage, final Boolean isLastPage) {
        return new ResponseDTO(content, totalItems, totalPages, currentPage, isFirstPage, isLastPage);
    }
}
