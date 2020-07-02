package mining;

import java.awt.Graphics2D;

import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "Danny Stewart", info = "Basic Mining Script", name = "SimpleMining", version = 0.1, logo = "")
public class SimpleMining extends Script {
	@Override
	public void onStart() {
		log("Let's get mining!");
	}
	
	@Override
	public int onLoop() throws InterruptedException {
		
		// Don't want to do anything if the player is animating
		if (!myPlayer().isAnimating() || !myPlayer().isMoving()) {
			if (getInventory().isFull()) { // Drop all ore if inventory is full
				log("Inventory full... Dropping all ore...");
				getInventory().dropAll("Tin ore", "Copper ore");
				sleep(500);
			} else { // Mine a rock if inventory is not full
				RS2Object rock = getObjects().closest("Rocks");
				if (rock != null) {
					log("Found rock... Mining now...");
					rock.interact("Mine");
					sleep(500);
				}
			}
		}
		
		return random(200, 300);
	}
	
	@Override
	public void onExit() {
		log("Finished Mining!");
	}
	
	@Override
	public void onPaint(Graphics2D g) {
		
	}
}
