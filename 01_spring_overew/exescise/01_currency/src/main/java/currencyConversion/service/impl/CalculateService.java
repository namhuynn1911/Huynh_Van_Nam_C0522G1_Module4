package currencyConversion.service.impl;

import currencyConversion.service.ICalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {


    @Override
    public double convert(String usd) {

        double result= Double.parseDouble(usd) * 23000;
        return result;
    }
}
