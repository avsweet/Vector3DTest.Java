
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class Vector3DTest {
	
	public double random() {
		return (int)((Math.random() * 100.0) * 10) / 10.0;
	}
	
	public double negRandom() {
		return (int)((Math.random()* 100.0)* 10)/ - 10.0;
	}
	@Test
	/**
	 * Did a test for myself for the test Vector Constructor to make sure it was operating properly
	 * @return x,y and z components of the vector
	 */
	public void testVectorConstructor() {
		double r = Math.random();
		double x = 0;
		double y = 0;
		double z = 0;
		
		if( r < 0.5) 
			x = negRandom();
			else 
				x = random();
			r = Math.random();
			if (r < 0.5) 
				y = negRandom();
			else 
				y = random();
			    r = Math.random();
		   if(r< 0.5)
			   z = negRandom();
		   else 
			   z =random();
		       
		       
		Vector3D vector = new Vector3D(x,y,z);
		testGetX(x,vector);
		testGetY(y, vector);
		testGetZ(z,vector);
	}		
	public void testGetX(double x, Vector3D vector) {
		boolean equalX = Math.abs(x - vector.getX()) < 0.00001;	
		String text = "The constructor is wrong for x = " + x;
  	    assertTrue(text, equalX);
	}
	public void testGetY( double y, Vector3D vector) {
		boolean equalY = Math.abs(y - vector.getY()) < .00001;
		String text1 = "The constructor is wrong for x = " + y;
		assertTrue(text1, equalY);
}
	public void testGetZ(double z, Vector3D vector) {
		boolean equalZ = Math.abs(z - vector.getZ()) < .00001;
		String text2 = "The constructor is wrong for z = " + z;
		assertTrue(text2, equalZ);
	}
	
	@Test
	/**
	 * Did a test for Vector copy constructor for myself
	 * @return x,y, and z of the components within the vector
	 */
    public void testVectorConstructor1() {
		Vector3D vector = new Vector3D(random(), random(), random());
		Vector3D copy = new Vector3D(vector);
		testGetX(vector.getX(), copy);
		testGetY(vector.getY(), copy);
		testGetZ(vector.getZ(), copy);
	}
	
@Test
/**
 * Test for adding to the vector 
 */
	public void testAdd() {
		Vector3D vector1 = new Vector3D(4.0,3.2,5.0);
		Vector3D vector2 = new Vector3D(2.0,3.0,4.0);
		vector1.add(vector2);
		testGetX(6.0, vector1);
	    testGetY(6.2, vector1);
     	testGetZ(9.0, vector1);
	}
	
	@Test 
	/**
	 * Test for subtracting the vector
	 */
	public void testSubtract() {
		Vector3D vector1 = new Vector3D(4.0,3.2,5.0);
		Vector3D vector2 = new Vector3D(2.0,3.0,4.0);
		vector1.subtract(vector2);
		testGetX(2.0, vector1);
		testGetY(.2, vector1);
		testGetZ(1, vector1);
	}
	@Test
	/**
	 * Test for the scale using multiplication 
	 */
	public void testScale(){
		Vector3D vector1 = new Vector3D(4.0,3.2,5.0);
		vector1.multipleByScale(3);
		testGetX(12.0, vector1);
		testGetY(9.6, vector1);
		testGetZ(15.0,vector1);
	}
	@Test
	/**
	 * Test for the dot product method using vector
	 */
	public void testDot(){
		Vector3D vector1 = new Vector3D(5.0,6.0,8.0);
		Vector3D vector2 = new Vector3D(1.0,2.0,3.0);
		assertEquals(5*1 + 6*2 + 8*3, vector1.doubleDot(vector2), .00001);
	}
	@Test
	/**
	 * Test for the magnitude using the vector
	 */
	public void testMagnitude(){
		Vector3D vector1 = new Vector3D(1,2,3);
		double mag = vector1.magnitude();
		assertEquals(Math.sqrt(1*1 +2*2 +3*3), mag,.00001);
	}
	@Test
	/**
	 * Test for the String method for vector 
	 */
        public void testToString() {
		Vector3D vector1 = new Vector3D();
		assertEquals("[0.000000,0.000000,0.000000]", vector1.toString());
		vector1 =new Vector3D(5.00,6.30,8.55);
		assertEquals("[5.000000,6.300000,8.550000]", vector1.toString());
	}
	@Test
	/**
	 * Test for the Equal method for vector
	 */
	public void testEqual() {
		Vector3D vector1 = new Vector3D(5.0,6.0,8.0);
		Vector3D vector2 = new Vector3D(5.00001,6.00002,8.00004);
		assertTrue("equalTo() returned wrong value", vector1.equalsTo(vector2,0.001));
	}
	
}
			
		

	


