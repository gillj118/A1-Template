package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MazeTest{

	MazeWalk mazeWalk;
	StringManipulator stringManip;

	@BeforeEach
	public void initialize()
	{
		mazeWalk = new MazeWalk(0, 0,'S');
		stringManip = new StringManipulator();
	}

	@Test
	public void testMoveLeft()
	{
		mazeWalk.moveForward();
		int x = 0;
		int y = 1;
		char direc = 'S';
		assertEquals(x,mazeWalk.getXCoord());
		assertEquals(y,mazeWalk.getYCoord());
		assertEquals(direc,mazeWalk.getDirection());
	}

	@Test
	public void testTurnRight()
	{
		mazeWalk.turnRight();
		char direc = 'W';
		assertEquals(direc,mazeWalk.getDirection());
	}

	@Test
	public void testTurnLeft()
	{
		mazeWalk.turnLeft();
		char direc = 'E';
		assertEquals(direc,mazeWalk.getDirection());
	}

	@Test
	public void testCannonicalToFactorized()
	{
		String cannonical = "FFRLLRRFFRRL";
		String factorized = stringManip.cannonicalToFactorized(cannonical);
		assertEquals(factorized, "2F R 2L 2R 2F 2R L");
	}

	@Test
	public void testSingleCannonicalToFactorized()
	{
		String cannonical = "F";
		String factorized = stringManip.cannonicalToFactorized(cannonical);
		assertEquals(factorized, "F");
	}


	@Test
	public void testFactorizedToCanonical()
	{
		String factoriazed = "F R 2F L 3F R F L F R F L 2F";
		String cannonical = stringManip.factorizedToCanonical(factoriazed);
		assertEquals(cannonical, "F R FF L FFF R F L F R F L FF" );
	}

	@Test
	public void testSingleFactorizedToCanonical()
	{
		String factoriazed = "L";
		String cannonical = stringManip.factorizedToCanonical(factoriazed);
		assertEquals(cannonical, "L" );
	}

	@Test
	public void testBigFactorizedToCanonical()
	{
		String factoriazed = "10F10L10R";
		String cannonical = stringManip.factorizedToCanonical(factoriazed);
		assertEquals(cannonical, "FFFFFFFFFFLLLLLLLLLLRRRRRRRRRR");
	}

	@Test
	public void testCheckFactorizedFalse()
	{
		String path = "FFRRFFLLFF";
		assertEquals(false, stringManip.checkFacotrized(path));
	}

	@Test
	public void testCheckFactorizedTrue()
	{
		String path = "FFRR2FLLFF";
		assertEquals(true, stringManip.checkFacotrized(path));
	}



}