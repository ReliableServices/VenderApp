package com.reliableservices.venderapp.modelclass;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private String status;
    private String message;
}
