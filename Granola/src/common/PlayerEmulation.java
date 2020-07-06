package common;

import java.util.Random;

import org.osbot.rs07.script.Script;

/**
 * 
 * @author		Mike Simone
 * @brief		To use this class, create a new PlayerEmulation object, then call any of the sub functions.
 * @implNote	This has not been tested as of 7/6/2020.
 */
public class PlayerEmulation extends Script {
	
	private final int MIN_TIME = 5000; // 5 Seconds
	private final int MAX_TIME = 60000; // 60 Seconds / 1 Minute
	
	public void randomAfkEvent() {
		Random rand = new Random();
		int eventNum = rand.nextInt(3); // Generates us a random number from 0 - 2
		
		switch(eventNum) {
			case 0: // Move the mouse off the screen for a random amount of time
				mouseOffScreen(0, 0);
				break;
			case 1: // Check a random skill
				checkRandomSkill();
				break;
			case 2: // Fall through on purpose
			default: // Check our friends list breifly
				checkFriendsList();
				break;
		}
	}
	
	// Moves the mouse off the screen for a set amount of time
	public void mouseOffScreen(int direction, int secondsOffScreen) {
		if(direction <= 0) {
			// Randomize direction the mouse moves off the screen
		}
		
		if(secondsOffScreen <= 0) {
			// No amount of time was specified.
			// Set the value to a random time between 5 seconds and 1 minute
			Random rand = new Random();
			secondsOffScreen = rand.nextInt(MAX_TIME - MIN_TIME) + MIN_TIME;
		}
				
		// Move the mouse off the screen
		mouse.moveOutsideScreen();
		
		// Wait for seconds off screen
		try {
			Thread.sleep(secondsOffScreen);
		} catch (InterruptedException e) {
			log("Error while waiting for mouse off screen!!!");
			e.printStackTrace();
		}
	}
	
	// Checks the specified skill
	public void checkSkill(String skillToCheck) {
		
	}
	
	// Checks a random skill
	public void checkRandomSkill() {
		// Go to skills tab
		// Check any skill and hover over it for 3 - 5 seconds
	}
	
	public void checkFriendsList() {
		// Go to the friends list tab
		// Hover mouse over some names or something stupid
	}

	@Override
	public int onLoop() throws InterruptedException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
