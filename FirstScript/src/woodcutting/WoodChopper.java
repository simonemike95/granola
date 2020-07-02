package woodcutting;

import java.awt.*;

import org.osbot.rs07.api.Chatbox.MessageType;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.event.WalkingEvent;
import org.osbot.rs07.input.mouse.MiniMapTileDestination;
import org.osbot.rs07.listener.MessageListener;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "Mike Simone", info = "Wood chopping script.", name = "WoodChopper", version = 0.1, logo = "")
public class WoodChopper extends Script implements MessageListener {
	
	private RS2Object tree;
	private int capacity;
	
	@Override
	public void onStart() {
		log("Let's get started!");
	}

	@Override
	public int onLoop() throws InterruptedException {
		tree = null;
//		
//		// We're not doing anything, click a tree
//		if(!myPlayer().isAnimating()) {
//			 tree = getObjects().closest("Tree");
//		}
//		
//		if (getInventory().contains("Logs")) {			
//			if (getInventory().getItem("Tinderbox").interact("Use")) {
//				getInventory().getItem("Logs").interact();
//			}
//		} else if (tree != null && !myPlayer().isAnimating()) {
//			tree.interact("Chop down");
//		}
		
		
		capacity = (int) getInventory().getEmptySlots(); // Check our inventory
		log("Capacity: " + capacity);
		
		
		if(capacity > 0) { // We have inventory space for more logs

			while(myPlayer().isMoving()) {
				Thread.sleep(1000);
			}
			
			// We're not doing anything, click a tree
			if(!myPlayer().isAnimating()) {
				log("Looking for tree...");
				 tree = getObjects().closest("Tree");
				 
				 if (tree != null) {
					log("Found tree! Chopping...");
					tree.interact("Chop down");
				}
			}
		} else { // Inventory is full, burn the logs
			if(!myPlayer().isAnimating()) {
				// Check for a tinderbox
				if (getInventory().contains("Tinderbox")) {
					log("Found tinderbox!");
					
					while(getInventory().contains("Logs")) {
						if(!myPlayer().isMoving() && !myPlayer().isAnimating()) {
							if (getChatbox().getMessages(MessageType.GAME).get(0).contains("You can't light a fire here.")) {
								log("Stuck, moving...");
								
								MiniMapTileDestination destination = new MiniMapTileDestination(getBot(), myPosition().getArea(1).getRandomPosition());
								getMouse().click(destination);
								
								while(myPlayer().isMoving()) {
									Thread.sleep(500);
								}
								
								if(!myPlayer().isMoving() && !myPlayer().isAnimating()) {
									getInventory().getItem("Tinderbox").interact("Use");
									getInventory().getItem("Logs").interact();
								}
							} else {
								log("Burning logs...");
								
								getInventory().getItem("Tinderbox").interact("Use");
								
								if(!myPlayer().isAnimating()) {
									getInventory().getItem("Logs").interact();
								}
							}
							
							Thread.sleep(2000);
						}
					}
				} else {
					// Drop the logs if there is no tinderbox
					while(getInventory().getItem("Logs").interact("Drop")) {
						log("No tinderbox found, dropping logs...");
					}
				}
			}
		}

		return random(700, 1000);
	}

	@Override
	public void onExit() {
		log("Thanks for running my Tea Thiever!");
	}

	@Override
	public void onPaint(Graphics2D g) {

	}

}
