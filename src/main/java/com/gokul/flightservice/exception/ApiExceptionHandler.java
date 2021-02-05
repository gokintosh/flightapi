package com.gokul.flightservice.exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@ControllerAdvice(basePackages = "com.gokul.flightservice")
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("handleMethodArgumentNotValid...");
        List<String>errors=ex.getBindingResult().getAllErrors().stream().map(e->e.getDefaultMessage()).collect((Collectors.toList()));

        HttpServletRequest req=((ServletWebRequest)request).getRequest();
        ApiErrorResponse apiError=ApiErrorResponseBuilder.getInstance()
                .withErrorId("Airline-"+ LocalDateTime.now(ZoneOffset.UTC))
                .withPath(req.getRequestURI())
                .withErrors(errors)
                .withMessage(ex.getMessage())
                .withStatus(status.value())
                .build();
        return new ResponseEntity<Object>(apiError,headers,status);
    }
}
