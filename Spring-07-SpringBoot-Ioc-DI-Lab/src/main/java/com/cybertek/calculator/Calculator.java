package com.cybertek.calculator;

import com.cybertek.enums.City;
import com.cybertek.intefaces.Carpet;
import com.cybertek.intefaces.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Calculator {

    @Qualifier("carpetTX")
    @Autowired
    private Carpet carpet;

    @Qualifier("kitchen")
    @Autowired
    private Floor floor;

    public String getTotalCarpetCost(City city) throws Exception {

        BigDecimal cost = carpet.calculate(city).multiply(floor.getArea());

        if (cost.compareTo(BigDecimal.ZERO)==0){
            throw new Exception(("This city doesnt exist"));
        }

        return "Total cost is : " + (carpet.calculate(city).multiply(floor.getArea()));
    }


}
