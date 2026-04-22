package com.exercise.products.crud_products.exception;

import org.springframework.http.HttpStatus;

public record ExceptionDTOReq(HttpStatus status, String message) {
}
