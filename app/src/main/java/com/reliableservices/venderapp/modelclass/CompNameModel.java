package com.reliableservices.venderapp.modelclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompNameModel extends BaseResponse {
    private String company_name;
    private String 	ic_id;
    private String company_id;
    private String delete_data;
}
