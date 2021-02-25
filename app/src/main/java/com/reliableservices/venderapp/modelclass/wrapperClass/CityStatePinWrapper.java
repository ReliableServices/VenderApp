package com.reliableservices.venderapp.modelclass.wrapperClass;

import com.reliableservices.venderapp.modelclass.BaseResponse;
import com.reliableservices.venderapp.modelclass.CityStateData;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityStatePinWrapper extends BaseResponse {
    private ArrayList<CityStateData> data;

}
