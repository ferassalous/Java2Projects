/**Runs Junit tests for MapData to all public methods succeed upon execution 
 * the Driver.
 * @author Feras salous
 * @version 2018-09-13
 * Lab section 13
 */
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class MapDataTest {

	@Test
	public void testgetYearValue() throws IOException {
		MapData myHour = new MapData(2018, 8, 01, 07, 00, "Data");
		Assert.assertEquals("This is the incorect value", 2018, myHour.getYear());
		Assert.assertEquals("This is the incorrect value", 8, myHour.getMonth());

		// fail("Not yet Implemented");
	}

	@Test
	public void testGetMonthValue()throws IOException

	{
		MapData myHour = new MapData(2018, 8, 01, 07, 00, "Data");
		Assert.assertEquals("This is the incorrect value", 8, myHour.getMonth());

		 //fail("Not yet Implemented");

	}

	@Test
	public void testGetDayValue()throws IOException {
		MapData myHour = new MapData(2018, 8, 01, 07, 00, "Data");
		Assert.assertEquals("This is the incorrect value", 01, myHour.getDay());
		
		//fail("Not yet Implemented");
	}


	@Test
	public void testGetHourValue() throws IOException{
		MapData myHour = new MapData(2018, 8, 01, 07, 00, "Data");
		Assert.assertEquals("This is the incorrect value", 07, myHour.getHour());
		
		//fail("Not yet Implemented");
	}

	@Test
	public void testGetMinuteValue() throws IOException{
		MapData myHour = new MapData(2018, 8, 01, 07, 00, "Data");
		Assert.assertEquals("This is the incorrect value", 00, myHour.getMinute());

		
		
		//fail("Not yet Implemented");

	}

	@Test
	public void testGetDirectoryString() throws IOException {
		MapData myHour = new MapData(2018, 8, 01, 07, 00, "Data");
		Assert.assertEquals("This is the incorrect value", "Data", myHour.getDirectory());
		
				
		
		//fail("Not yet Implemented");

	}

	@Test
	public void testCreateFileName() throws IOException
{
		MapData myHour = new MapData(2018, 8, 30, 17, 45, "data");
		String file = "201808301745.mdf";
		//String actual = myHour.createFileName();
		Assert.assertEquals(file, myHour.createFileName());
		
		
	
	//fail("Not yet Implemented");
}

	@Test
	public void testParseFile() throws IOException{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;
		final String directory = "Data";
		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(828.1355932203389, mapData.getSradAverage().getValue(),0.001);
		Assert.assertEquals(97720.0, mapData.getSradTotal().getValue(),0.001);
		Assert.assertEquals(968.0, mapData.getSradMax().getValue(),0.001);
		Assert.assertEquals(163.0, mapData.getSradMin().getValue(),0.001);
		
		Assert.assertEquals(31.556779661016947, mapData.getTa9mAverage().getValue(),0.001);
		Assert.assertEquals(34.9, mapData.getTa9mMax().getValue(),0.001);
		Assert.assertEquals(20.7, mapData.getTa9mMin().getValue(),0.001);
		
		Assert.assertEquals(32.425000000000004, mapData.getTairAverage().getValue(),0.001);
		Assert.assertEquals(36.5, mapData.getTairMax().getValue(),0.001);
		Assert.assertEquals(20.8, mapData.getTairMin().getValue(),0.001);
		
		

	}

	@Test
	public void testgetSradAverage() throws IOException {
		
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;

		final String directory = "Data";

		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(828.1355932203389, mapData.getSradAverage().getValue(),0.001);
		 
		//fail("Not yet Implemented");

	}
	@Test
	public void testGetNumberOfObservations()throws IOException
	{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;

		final String directory = "Data";

		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(10, mapData.getNumberOfMissingObservations());
		
		
	}

	@Test
	public void testgetSradMax() throws IOException{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;

		final String directory = "Data";

		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		//System.out.println(mapData.getSradMax());
		Assert.assertEquals(968.00, mapData.getSradMax().getValue(), 0.0001);

	}

	@Test
	public void testSradMin() throws IOException{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;
		final String directory = "Data";
		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(163.00, mapData.getSradMin().getValue(), 0.0001);
		
		
		
		//fail("Not yet Implemented");

	}

	@Test
	public void testgetSradTotal() throws IOException{
		
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;
		final String directory = "Data";
		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals( 97720.0,mapData.getSradTotal().getValue(),0.001);

	}

	@Test
	public void testgetTa9mAverage() throws IOException{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;
		final String directory = "Data";
		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(31.556779661016947, mapData.getTa9mAverage().getValue(),0.001);

	}

	@Test
	public void testgetTa9mMax() throws IOException{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;
		final String directory = "Data";
		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(34.9, mapData.getTa9mMax().getValue(),0.001);
		//fail("Not yet Implemented");

	}

	@Test
	public void testgetTa9mMin()throws IOException {
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;
		final String directory = "Data";
		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(20.7, mapData.getTa9mMin().getValue(),0.001);
		
		
		//fail("Not yet Implemented");

	}

	@Test
	public void testgetTairAverage() throws IOException{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;

		final String directory = "Data";

		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(32.425000000000004, mapData.getTairAverage().getValue(), 0.0001);
		
		

		// fail("Not yet Implemented");

	}

	@Test
	public void testgetTairMax() throws IOException{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;

		final String directory = "Data";

		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(36.5, mapData.getTairMax().getValue(),0.001);
		
		//fail("Not yet Implemented");

	}

	@Test
	public void testgetTairMin() throws IOException{
		final int YEAR = 2018;
		final int MONTH = 8;
		final int DAY = 30;
		final int HOUR = 17;
		final int MINUTE = 45;

		final String directory = "Data";

		MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);
		mapData.parseFile();
		Assert.assertEquals(20.8, mapData.getTairMin().getValue(),0.001);
		
		
		
		//fail("Not yet Implemented");

	}

	@Test
	public void testgettoString () throws IOException 
	{
		String expected ="";
		
		

		MapData mapData = new MapData(2018, 8,  30, 17, 45, "Data");
		mapData.parseFile();
		Assert.assertEquals(expected, mapData.toString());
		//fail("Not yet Implemented");

	}
	@Test
	public void testGetNumberOfObservatiions()throws IOException
	{
		MapData mapData = new MapData(2018, 8,  30, 17, 45, "Data");
		mapData.parseFile();
		Assert.assertNull(mapData.getnumberOfStations());
		
	}

}
