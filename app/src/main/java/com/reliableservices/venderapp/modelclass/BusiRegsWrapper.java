package com.reliableservices.venderapp.modelclass;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BusiRegsWrapper extends BaseResponse {
    private ArrayList<BusiRegModel> data;
}
