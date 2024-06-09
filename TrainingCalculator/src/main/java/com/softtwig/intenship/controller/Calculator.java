package com.softtwig.intenship.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softtwig.intenship.BO.CalculatorBO;
import com.softtwig.intenship.Service.CalculatorService;
import com.softtwig.intenship.Service.CalculatorServiceImpl;
import com.softtwig.intenship.VO.CalculatorVO;

public class Calculator extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
     CalculatorService calculatorService=new CalculatorServiceImpl();
 	 CalculatorBO calculatorBO=new CalculatorBO();

 	 
 	 public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
 		res.setContentType("text.html");

		PrintWriter pw=res.getWriter();
		
 		int sno=Integer.parseInt(req.getParameter("sNo")); 	
 		
 		
 		
 		CalculatorBO viewcalc = calculatorService.viewCalculator(sno); 

		req.setAttribute("viewcalc", viewcalc);
	/*	RequestDispatcher dispatch = req.getRequestDispatcher("viewcalculator.html");
		dispatch.forward(req, res);*/
		
		pw.println("No of Months you would require to complete the training:"+ viewcalc.getMonthsSpentperTraining());
		pw.println();
		pw.println("No of Week you would require to complete the training:" + viewcalc.getWeeksSpentperTraining());
		pw.println();
		pw.println("No of Days you would require to complete the training:" + viewcalc.getDaysSpentperTraining());
		pw.println();
		pw.println("Your possible training completion and job Ready Date:"+ viewcalc.getCourseEndDate());
 	 }
 	  
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		res.setContentType("text.html");

		PrintWriter pw=res.getWriter();
		
		CalculatorBO calculatorBO=new CalculatorBO();
		
		 calculatorBO.setName(req.getParameter("name"));
		 calculatorBO.setDegree(req.getParameter("degree"));
		 String yearofpassing=req.getParameter("yearOfPassing");
		 calculatorBO.setYearOfPassing(new Integer(yearofpassing));
		 String careergap=req.getParameter("careerGap");
		 calculatorBO.setCareerGap(new Float(careergap));
		 String hoursspentperday=req.getParameter("hoursSpentperDay");
		 calculatorBO.setHoursSpentperDay(new Float(hoursspentperday));
		 String daysSpentperweek=req.getParameter("daysSpentperWeek");
		 calculatorBO.setDaysSpentperWeek(new Float(daysSpentperweek));
		 calculatorBO.setStartingDate(req.getParameter("startingDate"));

	
		 int status=calculatorService.createCalculator(calculatorBO);
		 
		 if(status>0) {
			 pw.println("Congratulations!!");
			 RequestDispatcher dispatch = req.getRequestDispatcher("viewsno.html");
				dispatch.forward(req, res);
			
		 }
		 else {
			 pw.println("oops");
		 }
		
		
	}
	
	

}
