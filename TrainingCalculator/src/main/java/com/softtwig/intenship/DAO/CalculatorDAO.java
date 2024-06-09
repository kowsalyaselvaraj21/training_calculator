package com.softtwig.intenship.DAO;

import com.softtwig.intenship.BO.CalculatorBO;
import com.softtwig.intenship.VO.CalculatorVO;

public interface CalculatorDAO {

	int createCalculator(CalculatorVO calculatorVO);

	CalculatorBO viewCalculator(int sno);

	

}
