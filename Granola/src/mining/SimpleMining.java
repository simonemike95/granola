package mining;

import java.awt.Graphics2D;
import java.util.Random;

import org.osbot.rs07.api.Chatbox.MessageType;
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
				log("Inventory is full... Dropping all of the ore...");
				getInventory().dropAll("Tin ore", "Iron ore");
				sleep(500);
			} else { // Mine a rock if inventory is not full
				RS2Object rock = getObjects().closest("Rocks");
				
				if (rock != null && rock.interact("Mine")) {
					log("Starting to mine the rock");
					sleep(100);
					Sleep.sleepUntil(() -> !myPlayer().isAnimating() || getChatbox().getMessages(MessageType.GAME).get(0).contains("You manage to mine some"), 10000);
					log("Finished conditional sleep for mining");
				}
			}
		}
		
		return random(1000, 7000);
	}
	
	@Override
	public void onExit() {
		log("Finished Mining!");
	}
	
	@Override
	public void onPaint(Graphics2D g) {
		
	}
}
