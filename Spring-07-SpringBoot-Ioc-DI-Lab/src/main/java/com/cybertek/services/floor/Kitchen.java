package com.cybertek.services.floor;

import com.cybertek.intefaces.Floor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Kitchen implements Floor
{
    @Value("${diameter}")
    BigDecimal radious;

    @Override
    public BigDecimal getArea() {
        return radious.pow(2).multiply(new BigDecimal(Math.PI));
    }
}
