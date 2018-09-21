import java.io.IOException;
/** The main program is Executed here, and it prints out MapData statistics for the speicfied year,
 * month, day, hour, minute.
 * 
 * @author Feras salous
 *version 2019-09-19
 *Lab Section 13
 */

public class Driver {

		// TODO Auto-generated method stub
		public static void main(String[] args) throws IOException
		{

		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;

		final String directory = "Data";

		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);

		mapData.parseFile();
		System.out.println(mapData);
		}
		
		
		
	}


