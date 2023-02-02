//package s3.fileupload.exception;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@Slf4j
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex){
//        log.error("handleException",ex);
//        ErrorResponse response = new ErrorResponse(ErrorCode.UNAUTHORIZED);
//        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
//    }
//}