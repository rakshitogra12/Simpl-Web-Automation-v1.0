package tachyonTestScripts;

import org.apache.commons.io.input.ReversedLinesFileReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadOutput {

	public static void main(String[] args) throws ParseException {

		List<String> lines = readLastLine(
				new File("/Users/mandeep/Documents/code/eclipse/appium_practice/src/test/B.txt"), 3);

	}

	public static List<String> readLastLine(File file, int numLastLineToRead) throws ParseException {

		List<String> result = new ArrayList<>();
		try (ReversedLinesFileReader reader = new ReversedLinesFileReader(file, StandardCharsets.UTF_8)) {

			String line = "";
			while ((line = reader.readLine()) != null && result.size() < numLastLineToRead) {

				result.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> list = new ArrayList<String>();
		list.addAll(result);

		// System.out.println("Printing List: "+list);

		String time1 = list.get(0);
		String time2 = list.get(1);
		String time3 = list.get(2);

		System.out.println("first event " + time3);
		System.out.println("second event " + time2);
		System.out.println("third event " + time1);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

		// Parsing the Time Period
		java.util.Date date1 = simpleDateFormat.parse(time1);
		java.util.Date date2 = simpleDateFormat.parse(time2);
		java.util.Date date3 = simpleDateFormat.parse(time3);

		// Calculating the difference in milliseconds
		long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());

		// Calculating the difference in Hours
		long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;

		// Calculating the difference in Minutes
		long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;

		// Calculating the difference in Seconds
		long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60;

		// Printing the answer
		System.out.println("Difference between third and second event is " + differenceInHours + " hours "
				+ differenceInMinutes + " minutes " + differenceInSeconds + " Seconds. ");

		long differenceInMilliSeconds1 = Math.abs(date3.getTime() - date2.getTime());

		long differenceInHours1 = (differenceInMilliSeconds1 / (60 * 60 * 1000)) % 24;

		// Calculating the difference in Minutes
		long differenceInMinutes1 = (differenceInMilliSeconds1 / (60 * 1000)) % 60;

		// Calculating the difference in Seconds
		long differenceInSeconds1 = (differenceInMilliSeconds1 / 1000) % 60;
		// Printing the answer
		System.out.println("Difference between second and first event is " + differenceInHours1 + " hours "
				+ differenceInMinutes1 + " minutes " + differenceInSeconds1 + " Seconds. ");
		return result;
	}

}
