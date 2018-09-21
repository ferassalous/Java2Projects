/** Runs Junit Testing for Observation Methods to ensure success upon Execution in the Driver.
 * @author Feras salous
 * @version 2018-09-14
 * Lab section 13
 * 
 */
import org.junit.Assert;
import org.junit.Test;



public class ObservationTest {

	@Test
	public void testGetValue()
	{
		Observation myValue = new Observation(3.0, "Feras");
		Assert.assertEquals("The value is not correct", 3.0, myValue.getValue(),0.001);
					
	}
	@Test
	public void testIsValid()
	{
		Observation myValue = new Observation(-999,"Feras");
		Assert.assertEquals(false, myValue.isValid());
		Observation myTrueValue = new Observation(50, "Feras");
		Assert.assertEquals(true, myTrueValue.isValid());
		
	}
	@Test 
	public void testGetStid()
	{
		Observation myString = new Observation(50, "Feras");
		Assert.assertEquals("Feras",myString.getStid());
		//Assert.assertEquals("Mary", myString.getStid()); Tested for a fail.
		
	}
	@Test
	public void testToString()
	{
		Observation myString = new Observation(50, "Feras");
		String expected = "50.00 C At Feras";
		Assert.assertEquals(expected ,myString.toString());	
	}
	

}
