package ouyponlouer.site.fixedassetmanagementsystem.exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice   // necessary
public class ApiException {

    //---============= All Status Exception   ===========---//
    @ExceptionHandler(ResponseStatusException.class)
   ResponseEntity<?> handleResponseStatusException(ResponseStatusException ex) {
        ErrorDetailResponse<?> errorDetailResponse=ErrorDetailResponse.builder()
                .code(ex.getStatusCode().toString())
                .description(ex.getReason())
                .build();

        return  new ResponseEntity<>(ErrorResponse.builder()
                .error(errorDetailResponse)
                .build(),ex.getStatusCode());
    }
    // ResponseEntity: user for dynamic status response
    //----=============================================-----//



    //----============= filed exception   ===========-------//
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ErrorResponse<?>handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    List<Map<String,String>> errorDetail = new ArrayList<>();
    // get all field error and loop
        ex.getFieldErrors()
                .forEach((fieldError) -> {
                    Map<String,String> errorDetailMap= new HashMap<>();
                    errorDetailMap.put("field",fieldError.getField());
                    errorDetailMap.put("reason",fieldError.getDefaultMessage());

                    errorDetail.add(errorDetailMap);
                });

    ErrorDetailResponse<?>  errorDetailResponse=ErrorDetailResponse.builder()
            .code(HttpStatus.BAD_REQUEST.getReasonPhrase()) // get via string
            .description(errorDetail)  // dynamic cuz it is generic (?)
            .build();

        return ErrorResponse.builder()
                .error(errorDetailResponse)
                .build();
    }




    //----=============================================-----//

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFormat(
            HttpMessageNotReadableException ex) {

        Map<String, String> errors = new HashMap<>();

        if (ex.getCause() instanceof InvalidFormatException ife) {
            String fieldName = ife.getPath().get(0).getFieldName();
            errors.put(fieldName, "Must be a valid number");
        }

        return ResponseEntity.badRequest().body(errors);
    }

}
