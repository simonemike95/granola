package mining;

import java.awt.Graphics2D;
import java.util.Random;

import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import common.Sleep;

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
				
				// 50/50 change of dropping all at once or looping through inventory
				Random rand = new Random();
				if (rand.nextBoolean()) {
					// Drop all ore at once
					getInventory().dropAll("Tin ore", "Copper ore");
				} else {
					// Loop through each ore to drop it
					Item[] items = getInventory().getItems();
					for (Item item : items) {
						if (item.getName().equals("Tin ore") || item.getName().equals("Copper ore")) {
							getInventory().drop(item.getId());
							sleep(random(50, 300));
						}
					}
				}
				
				sleep(500);
			} else { // Mine a rock if inventory is not full
				RS2Object rock = getObjects().closest("Rocks");
				
				if (rock != null && rock.interact("Mine")) {
					Sleep.sleepUntil(() -> myPlayer().isAnimating(), 10000);
				}
			}
		}
		
		return random(700, 1000);
	}
	
	@Override
	public void onExit() {
		log("Finished Mining!");
	}
	
	@Override
	public void onPaint(Graphics2D g) {
		
	}
}
