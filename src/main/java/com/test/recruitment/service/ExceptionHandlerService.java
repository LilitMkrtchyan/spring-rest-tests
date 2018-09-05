package com.test.recruitment.service;

import com.test.recruitment.exception.ServiceException;
import com.test.recruitment.json.ErrorCode;
import com.test.recruitment.json.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Exception handler
 *
 * @author A525125
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerService {
    /**
     * Handles {@link ServiceException}
     *
     * @param ex exception the exception entity
     * @return error response
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleServiceException(
            ServiceException ex) {
        log.error("Error : " + ex.getMessage());
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus().value())
                .body(new ErrorResponse(ex.getErrorCode(), ex.getMessage()));
    }

    /**
     * Handles {@link IllegalArgumentException} and {@link IllegalStateException}
     *
     * @param ex the exception entity
     * @return error response
     */
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            RuntimeException ex) {
        log.error("Error : " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ErrorCode.BAD_REQUEST, ex.getMessage()));
    }
}
