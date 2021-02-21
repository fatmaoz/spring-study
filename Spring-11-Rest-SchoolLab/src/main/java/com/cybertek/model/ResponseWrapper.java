package com.cybertek.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)//eger null ise json da visual olarak gostermiyor
//@Eger @JsonIgnore kullanirsan body i komple ignore eder constructordaki empty olmasa bile
public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;//it is converting JSON data

    public ResponseWrapper(String message, Object data) {
        this.message = message;
        this.data = data;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(String message) {
        this.message = message;
        this.code=HttpStatus.OK.value();
        this.success=true;
    }

    public ResponseWrapper(boolean success, String message, Integer code, Object data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
