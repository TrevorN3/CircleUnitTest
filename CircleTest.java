/*
* TCSS 305 Autumn 2018
* Assignment 1 - Unit Testing
*/

package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.geom.Point2D;
import org.junit.Before;
import org.junit.Test;
import shapes.Circle;


/**
 * A class for testing a Circle class.
 * 
 * @author Trevor Nichols
 * @version 1.0
 */
public class CircleTest {
    
    /**A constant used for testing doubles or floats for equality. */
    private static final double TOLERANCE = .000001;
    
    /**A circle used to test methods. */
    private Circle myCircle;

    /**
     *A method that instantiates a circle used for testing before each method.
     */
    @Before
    public void setUp() {
        
        myCircle = new Circle();
    }

    /**
     * A method to test the default constructor's radius.
     */
    @Test
    public void testCircleDefaultConstructorRadius() {
        
        assertEquals(1, myCircle.getRadius(), TOLERANCE);
    }
    
    /**
     * A method to test the default constructor's central point.
     */
    @Test
    public void testCircleDefaultConstructorCenter() {
       
        //The center point is represented as a Point2D object.
        final Point2D p1 = myCircle.getCenter();
        
        //Check that the default center x coordinate is equal to zero.
        assertEquals(0, p1.getX(), TOLERANCE);
        
        //Check the default coordinate for y because it is closely related to the previous
        //assertion.
        assertEquals(0, p1.getY(), TOLERANCE);
    }
    
    /**
     * A method to test the default constructor's color.
     */
    @Test
    public void testCircleDefaultConstructorColor() {
        
        //Check that the default color is black.
        assertEquals(Color.BLACK, myCircle.getColor());
    }

    /**
     * Tests the overloaded constructor's radius with a valid argument.
     */
    @Test
    public void testCircleOverloadedConstructorValidRadius() {
        
        final Circle c1 = new Circle(2.0, new Point2D.Double(0.0, 0.0), Color.BLACK);
        
        assertEquals(2.0, c1.getRadius(), TOLERANCE);
    }
    
    /**
     * Tests the overloaded constructor's radius with an argument of zero.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCircleOverloadedConstructorZeroRadius() {
        
        new Circle(0.0, new Point2D.Double(0.0, 0.0), Color.BLACK);      
    }
    
    /**
     * Tests the overloaded constructor's radius with a negative argument.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCircleOverloadedConstructorNegativeRadius() {
        
        new Circle(-1.0, new Point2D.Double(0.0, 0.0), Color.BLACK);      
    }

    /**
     * Tests the overloaded constructor's center point with a valid argument.
     */
    @Test
    public void testCircleOverloadedConstructorValidCeneter() {
        
        final Circle c1 = new Circle(1.0, new Point2D.Double(1.0, 2.0), Color.BLACK);
        final Point2D p1 = c1.getCenter();
        
        //Check that the center x coordinate is correct
        assertEquals(1.0, p1.getX(), TOLERANCE);
        
        //Check that the center y coordinate is correct
        assertEquals(2.0, p1.getY(), TOLERANCE);
    }
    
    /**
     * Tests the overloaded constructor's center with a null argument.
     */
    @Test(expected = NullPointerException.class)
    public void testCircleOverloadedConstructorNullCeneter() {
        
        new Circle(1.0, null, Color.BLACK);      
    }
    
    /**
     * Tests the overloaded constructor's color with a valid argument.
     */
    @Test
    public void testCircleOverloadedConstructorValidColor() {
        
        final Circle c1 = new Circle(1.0, new Point2D.Double(0.0, 0.0), Color.BLUE);
        
        //may need to use the get method instead of hard coded color.
        assertEquals(Color.BLUE, c1.getColor());
    }
    
    /**
     * Tests the overloaded constructor's color with a null argument.
     */
    @Test(expected = NullPointerException.class)
    public void testCircleOverloadedConstructorNullColor() {
        
        new Circle(1.0, new Point2D.Double(0.0, 0.0), null);      
    }
    
    /**
     * Test method for setRadius(double) with a valid argument.
     */
    @Test
    public void testSetRadiusValidArgument() {
        
        myCircle.setRadius(2.0);
        
        assertEquals(2.0, myCircle.getRadius(), TOLERANCE);
    }
    
    /**
     * Test method for setRadius(double) with an argument of zero.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusZeroArgument() {
        
        myCircle.setRadius(0.0);
    }
    
    /**
     * Test method for setRadius(double) with a negative argument.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusNegativeArgument() {
        
        myCircle.setRadius(-1.0);
    }

    /**
     * Test method for setCenter(Point2D) with a valid argument.
     */
    @Test
    public void testSetCenterValidArgument() {
        
        myCircle.setCenter(new Point2D.Double(1.0, 10.0));
        final Point2D p1 = myCircle.getCenter();
        
        //Checks that the center x coordinate and y coordinate are correct because they 
        //they are closely related.
        assertEquals(1.0, p1.getX(), TOLERANCE);
        
        assertEquals(10.0, p1.getY(), TOLERANCE);
    }
    
    /**
     * Test method for setCeneter(Point2D) with a null argument.
     */
    @Test(expected = NullPointerException.class)
    public void testSetCeneterNullArgument() {
        
        myCircle.setCenter(null);
    }

    /**
     * Test method for setColor(Color) with a valid argument.
     */
    @Test
    public void testSetColorValidArgument() {
        
        myCircle.setColor(Color.CYAN);
        
        assertEquals(Color.CYAN, myCircle.getColor());
    }
    
    /**
     * Test method for setColor(Color) with a null argument.
     */
    @Test(expected = NullPointerException.class)
    public void testSetColorNullArgument() {
        
        myCircle.setColor(null);
    }

    /**
     * Test method for calculateDiameter() with default radius.
     */
    @Test
    public void testCalculateDiameterDefaultRadius() {
        
        assertEquals(2.0, myCircle.calculateDiameter(), TOLERANCE);
    }
    
    /**
     * Test method for calculateDiameter() with a different radius.
     */
    @Test
    public void testCalculateDiameterDifferentRadius() {
        
        myCircle.setRadius(2.0);
        
        assertEquals(4.0, myCircle.calculateDiameter(), TOLERANCE);
    }

    /**
     * Test method for calculateCircumference() with default radius.
     */
    @Test
    public void testCalculateCircumferenceDefaultRadius() {
        
        assertEquals(2.0 * Math.PI, myCircle.calculateCircumference(), TOLERANCE);
    }
    
    /**
     * Test method for calculateCircumference() with different radius.
     */
    @Test
    public void testCalculateCircumferenceDifferentRadius() {
        
        myCircle.setRadius(2.0);
        
        assertEquals(2.0 * Math.PI * myCircle.getRadius(), 
                     myCircle.calculateCircumference(), TOLERANCE);
    }

    /**
     * Test method for calculateArea() with default radius.
     */
    @Test
    public void testCalculateAreaDefaultRadius() {
        
        assertEquals(Math.PI, myCircle.calculateArea(), TOLERANCE);
    }
    
    /**
     * Test method for calculateArea() with different radius.
     */
    @Test
    public void testCalculateAreaDifferentRadius() {
        
        myCircle.setRadius(2.0);
        assertEquals(Math.PI * myCircle.getRadius() * myCircle.getRadius(), 
                     myCircle.calculateArea(), TOLERANCE);
    }

    /**
     * Test method for confirming toString() creates the proper string representation of
     * the circle.
     */
    @Test
    public void testToString() {
        
        assertEquals("Circle [radius=1.00, center=Point2D.Double[0.0, 0.0], "
                        + "color=java.awt.Color[r=0,g=0,b=0]]", myCircle.toString());
    }

}
