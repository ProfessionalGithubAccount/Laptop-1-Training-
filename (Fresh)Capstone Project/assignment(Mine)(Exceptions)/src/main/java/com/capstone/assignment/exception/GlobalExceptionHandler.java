package com.capstone.assignment.exception;
//package com.capstone.assignment.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {


    // Handle IOException
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(
            IOException ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "File processing error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Invalid input", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // Handle NoSuchElementException
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(
            NoSuchElementException ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Element not found", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "This is teh global exception", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ApiError class to format error responses
    public static class ApiError {
        private HttpStatus status;
        private String message;
        private String details;

        public ApiError(HttpStatus status, String message, String details) {
            this.status = status;
            this.message = message;
            this.details = details;
        }

        // Getters and setters
        public HttpStatus getStatus() {
            return status;
        }

        public void setStatus(HttpStatus status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}


//// Handle NoHandlerFoundException
//@ExceptionHandler(NoHandlerFoundException.class)
//public ResponseEntity<Object> handleNoHandlerFoundException(
//        NoHandlerFoundException ex, WebRequest request) {
//    return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Resource not found", ex.getMessage()), HttpStatus.NOT_FOUND);
//}
//
//// Handle MaxUploadSizeExceededException
//@ExceptionHandler(MaxUploadSizeExceededException.class)
//public ResponseEntity<Object> handleMaxUploadSizeExceededException(
//        MaxUploadSizeExceededException ex, WebRequest request) {
//    return new ResponseEntity<>(new ApiError(HttpStatus.PAYLOAD_TOO_LARGE, "File size exceeds limit", ex.getMessage()), HttpStatus.PAYLOAD_TOO_LARGE);
//}

//
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.multipart.MaxUploadSizeExceededException;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//@ControllerAdvice
//public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {
//
//        @ExceptionHandler(IOException.class)
//        public ResponseEntity<Object> handleIOException(IOException ex) {
//            return new ResponseEntity<>("File handling error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
////        @ExceptionHandler(MaxUploadSizeExceededException.class)
////        public ResponseEntity<Object> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
////            return new ResponseEntity<>("File size exceeds the maximum allowed limit", HttpStatus.BAD_REQUEST);
////        }
//
//        @ExceptionHandler(IllegalArgumentException.class)
//        public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//
//        @ExceptionHandler(Exception.class)
//        public ResponseEntity<Object> handleGenericException(Exception ex) {
//            Map<String, Object> errorDetails = new HashMap<>();
//            errorDetails.put("error", ex.getMessage());
//            return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
