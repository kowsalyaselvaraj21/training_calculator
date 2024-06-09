package com.softtwig.intenship.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.softtwig.intenship.BO.CalculatorBO;
import com.softtwig.intenship.VO.CalculatorVO;
import com.softtwig.intenship.utils.DBConnection;

public class CalculatorDAOImpl implements CalculatorDAO  {

	@Override
	public int createCalculator(CalculatorVO calculatorVO) {
		// TODO Auto-generated method stub
			int status=0;
			
			try {
			Connection	con = DBConnection.createConnection();
			String sql = "insert into calculator(name,daysSpentperTraining,weeksSpentperTraining,monthsSpentperTraining,courseEndDate) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, calculatorVO.getName());
			ps.setFloat(2, calculatorVO.getDaysSpentperTraining());
			ps.setFloat(3, calculatorVO.getWeeksSpentperTraining());
			ps.setFloat(4, calculatorVO.getMonthsSpentperTraining());
			ps.setString(5, calculatorVO.getCourseEndDate());
		
			
			 status=ps.executeUpdate();
			 con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
	}

	@Override
	public CalculatorBO viewCalculator(int sno) {
		// TODO Auto-generated method stub
		CalculatorBO calculatorBO=null;
		
		try {
		Connection	con = DBConnection.createConnection();
		String sql="select * from calculator where sNo=" +sno;
		PreparedStatement ps = con.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery(sql);    
	         while(rs.next()) {
	        	 
	        	  calculatorBO=new CalculatorBO();
	        	 
		         calculatorBO.setName(rs.getString(2));
		         calculatorBO.setDaysSpentperTraining(rs.getFloat(3));
		         calculatorBO.setWeeksSpentperTraining(rs.getFloat(4));
		         calculatorBO.setMonthsSpentperTraining(rs.getFloat(5));
		         calculatorBO.setCourseEndDate(rs.getString(6));   	 
	         }
	        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return calculatorBO;
	}
}
