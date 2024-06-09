package com.softtwig.intenship.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import com.softtwig.intenship.BO.CalculatorBO;
import com.softtwig.intenship.DAO.CalculatorDAO;
import com.softtwig.intenship.DAO.CalculatorDAOImpl;
import com.softtwig.intenship.VO.CalculatorVO;

public class CalculatorServiceImpl implements CalculatorService {
	
	
	//private static final String BeanUtils = null;

	CalculatorDAO calculatorDAO=new CalculatorDAOImpl();
	
	CalculatorVO calculatorVO=new CalculatorVO();
	CalculatorBO calculatorBO=new CalculatorBO();

	@Override
	public int createCalculator(CalculatorBO calculatorBO) {
		// TODO Auto-generated method stub
		
		 float days=800/calculatorBO.getHoursSpentperDay();
		 System.out.println(days);
		 float week=800/(calculatorBO.getDaysSpentperWeek()*5);
		 System.out.println(week);
		 float months=week/4;
		 System.out.println(months);
		// float workingdays=week*2;
		// System.out.println(workingdays);
		 String startingDate=calculatorBO.getStartingDate();
		 System.out.println("Starting Date:"+startingDate);
	
		 SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyy");
		 Calendar cal=Calendar.getInstance();
		 String start = calculatorBO.getStartingDate();
		
		 LocalDate date=LocalDate.parse(start).plusMonths((long) months);
		 String startD=date.toString();
		 System.out.println("Course End Date:"+startD);
		 
		// String end=sdf.format(cal.getTime());
		 //System.out.println("Course End Date:"+end);
		 
		 calculatorBO.setCourseEndDate(startD);
		 calculatorBO.setDaysSpentperTraining(days);
		 calculatorBO.setWeeksSpentperTraining(week);
		 calculatorBO.setMonthsSpentperTraining(months);
		
		 calculatorVO.setName(calculatorBO.getName());
		 calculatorVO.setCourseEndDate(calculatorBO.getCourseEndDate());
		 calculatorVO.setDaysSpentperTraining(calculatorBO.getDaysSpentperTraining());
		 calculatorVO.setWeeksSpentperTraining( calculatorBO.getWeeksSpentperTraining());
		 calculatorVO.setMonthsSpentperTraining(calculatorBO.getMonthsSpentperTraining());
		 
		 return calculatorDAO.createCalculator(calculatorVO);
		
	}

	@Override
	public CalculatorBO viewCalculator(int sno) {
		// TODO Auto-generated method stub
		
		CalculatorBO response=calculatorDAO.viewCalculator(sno);

		return response;
	}
}
