package com.time;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/clock")
public class Timer extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			String country = req.getParameter("country");
			PrintWriter printWriter = res.getWriter();
			SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("dd MM yyyy HH:MM:ss z");
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone(country));
			String time = simpleDateFormat.format(Calendar.getInstance().getTime());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.html");
			requestDispatcher.include(req, res);
			printWriter.println("<h1>"+time+"</h1>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
