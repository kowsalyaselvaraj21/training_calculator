package com.softtwig.intenship.Service;

import com.softtwig.intenship.BO.CalculatorBO;

public interface CalculatorService {

	int createCalculator(CalculatorBO calculatorBO);

	CalculatorBO viewCalculator(int sno);

}
