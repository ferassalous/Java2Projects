import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

/**
 *  This class represents MapData which reads in a day of data from a text file, 
 * Parses it, calculates statistics for Air Temperature from 1.5m to 9m, and Statistics about solar radiation.
 * 
 * @author Feras salous
 * Also Collaborated with the TA's and Nahall Mansouri on this project
 * @version 2018-09-12
 * Lab section 13
 */



/**
 * This class represents MapData which reads in a day of data from a text file, 
 * Parses it, and creates MapData
 */
public class MapData {

	private Observation[] sradData;
	private Observation[] tairData;
	private Observation[] ta9mData;
	private static final int size = 1000;
	private static final int NUMBER_OF_MISSING_OBSERVATIONS = 10;
	private static final int STID_POSTION = 0;
	private static final Integer numberOfStations = null;
	private static final int TAIR_POSTION = 4;
	private static final int SRAD_POSTION = 13;
	private static final int TA9M_POSITION = 14;
	private static final String MESONET = "Mesonet";
	private String directory;
	private Observation tairMin;
	private Observation tairMax;
	private Observation tairAverage;
	private Observation ta9mMin;
	private Observation ta9mMax;
	private Observation ta9mAverage;
	private Observation sradMin;
	private Observation sradMax;
	private Observation sradAverage;
	private Observation sradTotal;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	/**
	 * Constructs Map Data
	 * @param year value
	 * @param month value
	 * @param day value
	 * @param hour value
	 * @param minute value
	 * @param directory String
	 * @throws IOException
	 */
	public MapData(int year, int month, int day, int hour, int minute, String directory) throws IOException {
		sradData = new Observation[size];
		tairData = new Observation[size];
		ta9mData = new Observation[size];

		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.directory = directory;
		// parseFile();

	}
	/** Gets the Directory String contained in the MapData Constructor When Called
	 * @return A string Directory
	 */
	public String getDirectory() {
		
		return directory;
	}
	/**Gets the int Year Value contained in the MapData Constructor When Called 
	 * @return The year value
	 */
	public int getYear() {
		/**
		 * @return The year value
		 */
		return year;
	}
	/**Gets the month value Contained in the MapData Constructor When Called
	 * @return The month value
	 */
	public int getMonth() {
		
		return month;
	}
	/**Gets the Day Value Contained in the MapData Constructor When Called
	 * @return The day value
	 */
	public int getDay() {
		
		return day;
	}
	/**Gets the Hour Value Contained in the MapData Constructor When Called 
	 * @return The hour value
	 */
	public int getHour() {
		
		return hour;
	}
	/**Gets the Minute Value Contained in the MapData Constructor When Called 
	 * @return The minute value
	 */
	public int getMinute() {
		
		return minute;
	}
	/**
	 * Gets the number Of Stations
	 * @return the Number of Stations Value
	 */
	public Integer getnumberOfStations()
	{
		return numberOfStations;
	}
	/**
	 * Creates a filename of type mdf
	 * 
	 * @return A string formatted as the mdf file specifies like such;
	 *         YearMonthDayHourMinute
	 */
	public String createFileName() {
		

		return String.format("%04d%02d%02d%02d%02d.mdf", this.year, this.month, this.day, this.hour, this.minute);

	}
	/**
	 * Gets the numberOfMissingObservations in MapData
	 * @return NUMBER_OF_MISSING_OBSERVATIONS
	 */
	public int getNumberOfMissingObservations()
	{
		return NUMBER_OF_MISSING_OBSERVATIONS;
		
	}
	/**
	 * Splits up the Information from the file and stores in the member values.
	 */
	public void parseFile() throws IOException
	
	{
		String myFilePath = directory + "/" + createFileName();

		BufferedReader Br = new BufferedReader(new FileReader(myFilePath));

		{
			String output;
			output = Br.readLine();
			output = Br.readLine();
			output = Br.readLine();
			output = Br.readLine();
			int index = 0;

			while (output != null) {

				String[] theSplitString = output.trim().split("\\s+");
				Observation tempSrad = new Observation(Double.parseDouble(theSplitString[SRAD_POSTION]),
						theSplitString[STID_POSTION]);
				sradData[index] = tempSrad;
				// System.out.println(sradData[index]);
				Observation tempTairData = new Observation(Double.parseDouble(theSplitString[TAIR_POSTION]),
						theSplitString[STID_POSTION]);
				tairData[index] = tempTairData;

				Observation tempTa9mData = new Observation(Double.parseDouble(theSplitString[TA9M_POSITION]),
						theSplitString[STID_POSTION]);
				ta9mData[index] = tempTa9mData;

				++index;
				output = Br.readLine();

				// Br.readLine();

			}
			// this.getSradMax();
			// Br.close();

		}
		Br.close();

	}
	/**
	 * Determines the Minimum Value in the tairData Array
	 * 
	 * @return The Minimum Value in the Observation[] tairData Array
	 */
	public Observation getTairMin() {
		
		double MIN_VALUE = Double.POSITIVE_INFINITY;

		for (int index = 0; index < tairData.length; ++index) {
			Observation myTairMinValue = tairData[index];

			if (myTairMinValue != null && myTairMinValue.isValid() && myTairMinValue.getValue() < MIN_VALUE) {
				MIN_VALUE = myTairMinValue.getValue();
				tairMin = myTairMinValue;

			}

		}
		//System.out.println(tairMin.getValue());

		return tairMin;

	}
	/**
	 * Determines the Maximum Value in the tairData
	 * 
	 * @return The Maximum Value in the tairData
	 */
	public Observation getTairMax() {
		
		// Observation myTestObservation = tairData[index];
		double MAX_VALUE = Double.NEGATIVE_INFINITY;
		for (int index = 0; index < tairData.length; ++index) {
			Observation myTestObservation = tairData[index];
			if (myTestObservation != null && myTestObservation.isValid() && myTestObservation.getValue() > MAX_VALUE) {
				MAX_VALUE = myTestObservation.getValue();
				tairMax = myTestObservation;
				

			}
			
		}
		//System.out.println(tairMax.getValue());
		return tairMax;
		
	}

	/**
	 * Gets the Average Value in tairData
	 * 
	 * @return The Average Value in tairData
	 * 
	 */
	public Observation getTairAverage()

	{ /// set a counter for valid items in my data.
		double elementsAlive = 0;
		double Average = 0;

		for (int index = 0; index < tairData.length; ++index) {

			Observation myAverage = tairData[index];

			if (myAverage != null && myAverage.isValid()) {
				++elementsAlive;
				Average += myAverage.getValue();
				//++elementsAlive;
				//double newAverage = Average / elementsAlive;

			}
			
		}
		double newAverage = Average / elementsAlive;
		Observation theAverage = new Observation(newAverage, MESONET);
		tairAverage = theAverage;
		//System.out.println(theAverage.getValue());

		return tairAverage;
	}

	/**
	 * Gets the Minimum value in Ta9mData
	 * 
	 * @return The Minimum Value in Ta9mData
	 */

	public Observation getTa9mMin() {

		double MIN_VALUE = Double.POSITIVE_INFINITY;
		for (int index = 0; index < ta9mData.length; ++index) {
			Observation myTa9mMin = ta9mData[index];
			if (myTa9mMin != null && myTa9mMin.isValid() && myTa9mMin.getValue() < MIN_VALUE) {
				MIN_VALUE = myTa9mMin.getValue();
				ta9mMin = myTa9mMin;

			}

		}
		//System.out.println(ta9mMin.getValue());
		
		return ta9mMin;
	}
	/**
	 * Get the Maximum Value in Ta9mData
	 * 
	 * @return The Maximum Value in ta9mData
	 */
	public Observation getTa9mMax() {
		
		double MAX_VALUE = Double.NEGATIVE_INFINITY;
		for (int index = 0; index < ta9mData.length; ++index) {
			Observation myta9mMax = ta9mData[index];
			if (myta9mMax != null && myta9mMax.isValid() && myta9mMax.getValue() > MAX_VALUE) {
				MAX_VALUE = myta9mMax.getValue();
//				ta9mMax = myta9mMax;
			//System.out.println(ta9mMax.getValue());
				ta9mMax = myta9mMax;

			}
			

		}
		//System.out.println(ta9mMax.getValue());

		return ta9mMax;
	}
	
	/**
	 * Gets the Average Value in ta9mData
	 * 
	 * @return The average Value in ta9mData
	 */

	public Observation getTa9mAverage() {
		/**
		 * Gets the Average Value in ta9mData
		 * 
		 * @return The average Value in ta9mData
		 */
		double elementsAlive = 0;
		double Average = 0;
		for(int index = 0; index < ta9mData.length; ++index)
		{
			Observation myAverage = ta9mData[index];
			if(myAverage != null && myAverage.isValid())
			{
				++elementsAlive;
				Average += myAverage.getValue();
				
			}
		}
		double newAverage = Average / elementsAlive;
		Observation theAverage = new Observation(newAverage, MESONET);
		ta9mAverage = theAverage;
		//System.out.println(ta9mAverage.getValue());
		return ta9mAverage;
		
	}
	/**
	 * Gets the Minimum Value in the sradData
	 * 
	 * @return The Minimum Value in sradData
	 */
	public Observation getSradMin() {
		
		double MIN_VALUE = Double.POSITIVE_INFINITY;
		for (int index = 0; index < sradData.length; ++index) {
			Observation sradMinValue = sradData[index];
			if (sradMinValue != null && sradMinValue.isValid() && sradMinValue.getValue() < MIN_VALUE) {
				MIN_VALUE = sradMinValue.getValue();
				sradMin = sradMinValue;
			}

		}
		return sradMin;
	}

	public Observation getSradMax() {
		/**
		 * Gets the Maximum Value in the sradData
		 * 
		 * @return The Maximum Value in the sradData
		 */
		double MAX_VALUE = Double.NEGATIVE_INFINITY;
		for (int index = 0; index < sradData.length; ++index) {
			Observation mySradMaxValue = sradData[index];
			{
				if (mySradMaxValue != null && mySradMaxValue.isValid() && mySradMaxValue.getValue() > MAX_VALUE) {
					MAX_VALUE = mySradMaxValue.getValue();
					sradMax = mySradMaxValue;
				}
			}

		}
		// this.sradMax = this.sradData[1];
		// System.out.println(this.sradMax);

		return sradMax;
	}
	/**
	 * Gets the average value in sradData
	 * 
	 * @return The average Value in sradData
	 */
	public Observation getSradAverage() {
		double elementsAlive = 0;
		double Average = 0;
		for(int index = 0; index < sradData.length; ++index)
		{
			Observation myAverage = sradData[index];
			if(myAverage != null && myAverage.isValid())
			{
				++elementsAlive;
				Average+= myAverage.getValue();
				
			}
		}
		double newAverage = Average / elementsAlive;
		Observation theAverage = new Observation(newAverage, MESONET);
		//System.out.println(theAverage.getValue());
		sradAverage = theAverage;

		
		
		return sradAverage;
//		System.out.println(theAverage.getValue());
	}
	/**
	 * Calculates the total for Solar radiation 
	 * @return sradTotal
	 */
	public Observation getSradTotal() {
		double total = 0.0;
		
		
		for(int index = 0; index < sradData.length; ++index)
		{
			Observation myTotal = sradData[index];
			if(myTotal != null && myTotal.isValid())
			{
				total += myTotal.getValue();
				
				
				
			}
			
		}
		
		//System.out.println(total);
		
		Observation totalValue = new Observation(total, "");
		sradTotal = totalValue;
		return sradTotal;
		
	}
	/**
	 * Formats a String that returns AirTemperature Statistics, Ta9mStatistics, and SolarRadiationStatistics
	 */
	public String toString() {
		System.out.println(String.format(
				"========================================================\n" + "=== %04d-%02d-%02d %d:%d ===\n"
						+ "========================================================\n",
				getYear(), getMonth(), getDay(), getHour(), getMinute()));
		calculateAirTemperatureStatistics();
		calculateTa9mTemperatureStatistics();
		calculateSolarRadiationStatistcs();
		
		
		return "";

	}
/**
 * Calculates AirTemperatureStatistics
 */
	private void calculateAirTemperatureStatistics() {
		Observation average = getTairAverage();
		Observation max = getTairMax();
		Observation min = getTairMin();
		System.out.println("========================================================");
		System.out.print(String.format(
				"Maximum Air Temperature[1.5m] = %.1f C at %s\n" + "Minimum Air Temperature[1.5m] = %.1f C at %s\n"
						+ "Average Air Temperature[1.5m] = %.1f C at %s\n",
				max.getValue(), max.getStid(), min.getValue(), min.getStid(), average.getValue(), average.getStid()));
		System.out.println("========================================================");

	}
	
/**
 * Calculates Ta9mTempertaureStatistics
 */
	private void calculateTa9mTemperatureStatistics() {
		Observation avg = getTa9mAverage();
		Observation max = getTa9mMax();
		Observation min = getTa9mMin();
		System.out.println("========================================================");
		System.out.print(String.format(
				"Maximum Air Temperature[9.0m] = %.1f C at %s\n" + "Minimum Air Temperature[9.0m] = %.1f C at %s\n"
						+ "Average Air Temeprature[9.0m] = %.1f C at %s\n",
				max.getValue(), max.getStid(),  min.getValue(), min.getStid(), avg.getValue(), avg.getStid()));
		System.out.println("========================================================");

	}
/**
 * Calculates SolarRadiationStatistics
 */
	private void calculateSolarRadiationStatistcs() {
		Observation min = getSradMin();
		Observation max = getSradMax();
		
		Observation avg = getSradAverage();
		System.out.println("========================================================");
		System.out.println(String.format("Maximum Solar Radiation[1.5m] = %.1f W/m^2 at %s\n" + 
		"Minimum Solar Radiation[1.5m] = %.1f W/m^2 at %s\n" + 
				"Average Solar Radiation[1.5m] = %.1f W/m^2 at %s\n", max.getValue(), max.getStid(), min.getValue(),min.getStid(),avg.getValue(),avg.getStid()));
		System.out.println("========================================================");
		
		

	}

}
