package com.twa.flights.api.provider.beta.controller;

import com.google.common.collect.Lists;
import com.twa.flights.api.provider.beta.controller.documentation.ErrorsResources;
import com.twa.flights.api.provider.beta.dto.ErrorDTO;
import com.twa.flights.api.provider.beta.enums.ExceptionStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/errors")
public class ErrorsController implements ErrorsResources {

    @Override
    public ResponseEntity<List<ErrorDTO>> getErrors() {
        List<ErrorDTO> errors = Lists.newArrayList();

        for (ExceptionStatus exceptionStatus : ExceptionStatus.values()) {
            errors.add(new ErrorDTO(exceptionStatus.getCode(), exceptionStatus.getMessage(), null));
        }

        return new ResponseEntity<>(errors, HttpStatus.OK);
    }
}
