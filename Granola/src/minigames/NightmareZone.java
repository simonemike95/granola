package minigames;

import java.awt.Graphics2D;

import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "Mike Simone", info = "Nightmare Zone training script", name = "NMZ", version = 0.1, logo = "")
public class NightmareZone extends Script {
	@Override
	public void onStart() {
//		log("Let's get mining!");
	}
	
	@Override
	public int onLoop() throws InterruptedException {
		// At first this will be simple range only
		// Can be modified once we have a GUI to do more specific types of NMZ training
		
		// Check area for NMZ location
		// if not already there, tele there with minigame tele
		// unlock coffer
		// if no money in coffer, exit
		// if money in coffer, dream from dominic
		// rumble, normal
		// ***Bosses should already be set***
		// Press accept
		// Run to middle square
		// Drink absorption pots
		// Drink range pot once enemies appear
		// Check absorption level, if under 600, drink until full
		// Check range boost, if 9 or lower, drink range pot
		// Check special attack, if above 50, use it
		
		return random(200, 300);
	}
	
	@Override
	public void onExit() {
//		log("Finished Mining!");
	}
	
	@Override
	public void onPaint(Graphics2D g) {
		
	}
}