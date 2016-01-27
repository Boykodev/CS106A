import java.util.*;

import acm.program.*;

public class DateString extends ConsoleProgram
{
	public void init()
	{
		this.setFont("Helvetica-25");
		
		String date = readLine("Enter date(date, month, year): ");
		
		date = dateString(date);
		
		println(date);
	}

	private String dateString(String date)
	{
		StringTokenizer token = new StringTokenizer(date, ".,:; 	");
		
		return dateString(token.nextToken(), token.nextToken(), token.nextToken());
	}
	
	private String dateString(String date, String month, String year)
	{
		return date + "-" + switchMonth(month) + "-" + year.substring(year.length() - 2);
	}
	
	private String switchMonth(String month)
	{
		int n = 0;
		
		if (month.length() == 1)
		{
			n = charToDigit(month.charAt(0));
		}
		else if (month.length() == 2)
		{
			n = charToDigit(month.charAt(1));
			if (month.charAt(0) != '0') n += 10;
		}
		
		switch(n)
		{
			case 1:
				return "Jan";
			case 2:
				return "Feb";
			case 3:
				return "Mar";
			case 4:
				return "Apr";
			case 5:
				return "May";
			case 6:
				return "Jun";
			case 7:
				return "Jul";
			case 8:
				return "Aug";
			case 9:
				return "Sep";
			case 10:
				return "Oct";
			case 11:
				return "Nov";
			case 12:
				return "Dec";
			default:
				return "Err";
		}
	}
	
	private int charToDigit(char ch)
	{
		return ch - '0';
	}
}
