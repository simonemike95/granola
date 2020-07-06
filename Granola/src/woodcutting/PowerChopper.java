package woodcutting;

import java.awt.*;

import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.listener.MessageListener;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "Mike Simone", info = "Wood chopping script that cuts logs until inventory is full, then drops them all.", name = "PowerChopper", version = 0.1, logo = "")
public class PowerChopper extends Script implements MessageListener {
	
	private RS2Object tree;
	private int capacity;
	private int woodcuttingLevel = 0;
	private String treeToCut;
	
	@Override
	public void onStart() {
		log("Started power chopper");
		log("Getting woodcutting level...");
		
		woodcuttingLevel = getSkills().getStatic(Skill.WOODCUTTING);
		
		log("Woodcutting level is: " + woodcuttingLevel);
		log("Nice");
		
		if(woodcuttingLevel < 15) {
			// Cut trees
			treeToCut = "Tree";
		} else if(woodcuttingLevel < 30 && woodcuttingLevel > 15) {
			// Cut oak trees
			treeToCut = "Oak Tree";
		} else if(woodcuttingLevel < 45 && woodcuttingLevel > 30) {
			// Cut willow trees
			treeToCut = "Willow Tree";
		
		/** 
		 * The rest of these are kind of pointless for right now.
		 * These will never be used for power chopping, but we can add the option
		 * for it later just to have a complete feature set.
		 * Redwood logs can only be cut in one place, and should just be banked anyways.
		 * This case should be handled separately from the rest.
		 * 		e.g. instead of dropping all the logs, we should bank them.
		 */
		
//		} else if(woodcuttingLevel < 60 && woodcuttingLevel > 45) {
//			// Cut maple trees
//			treeToCut = "Maple Tree";
//		} else if(woodcuttingLevel < 75 && woodcuttingLevel > 60) {
//			// Cut yew trees
//			treeToCut = "Yew Tree";
//		} else if(woodcuttingLevel < 60 && woodcuttingLevel > 75) {
//			// Cut magic trees
//			treeToCut = "Magic Tree";
		} else if(woodcuttingLevel > 90) {
			// Cut redwood trees
			treeToCut = "Redwood Tree";
		}
		
		log("Tree to be chopped based on level is " + treeToCut);
	}

	@Override
	public int onLoop() throws InterruptedException {
		tree = null;
		
		capacity = (int) getInventory().getEmptySlots(); // Check our inventory
		log("Capacity: " + capacity);
		
		
		if(capacity > 0) { // We have inventory space for more logs

			while(myPlayer().isMoving()) {
				Thread.sleep(1000);
			}
			
			// We're not doing anything, click a tree
			if(!myPlayer().isAnimating()) {
				log("Looking for nearest " + treeToCut + "...");
				tree = getObjects().closest(treeToCut);
				 
				 if (tree != null) {
					log("Found " + treeToCut + "! Chopping...");
					tree.interact("Chop down");
				} else {
					// No tree found nearby, wait for one to respawn
				}
			}
		} else { // Inventory is full, drop any logs
			if(!myPlayer().isAnimating()) {
				// Just drop everything in the inventory, presumably just logs...
				while((int) getInventory().getEmptySlots() > 0) {
					getInventory().dropAll();
				}
			}
		}

		return random(700, 1000);
	}

	@Override
	public void onExit() {
		log("Done chopping.");
	}

	@Override
	public void onPaint(Graphics2D g) {

	}

}
