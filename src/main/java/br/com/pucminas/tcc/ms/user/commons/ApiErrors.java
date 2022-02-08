package br.com.pucminas.tcc.ms.user.commons;

import br.com.pucminas.tcc.ms.user.commons.exceptions.BusinessException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class ApiErrors {
    private List<String> errors;


    public ApiErrors() {
        this.errors = new ArrayList<>();
    }

    public ApiErrors(BindingResult bindingResult) {
        this();
        this.errors.addAll(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(toList()));
    }

    public ApiErrors(BusinessException ex) {
        this();
        this.errors.add(ex.getMessage());
    }

    public ApiErrors(ResponseStatusException ex) {
        this();
        this.errors.add(ex.getReason());
    }

    public ApiErrors(InvalidFormatException ex) {
        this();
        this.errors.add(ex.getMessage());
    }
}
