package mvc.othello;

import com.mrjaffesclass.apcs.messenger.*;

/**
 * The model represents the data that the app uses.
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {

  // Messaging system for the MVC
  private final Messenger mvcMessaging;

  // Model's data variables


  /**
   * Model constructor: Create the data representation of the program
   * @param messages Messaging class instantiated by the Controller for 
   *   local messages between Model, View, and controller
   */
  public Model(Messenger messages) {
    this.mvcMessaging = messages;
    
  }
  
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() {
    this.newGame();
    //subscribe to messages here
    this.mvcMessaging.subscribe("btnClicked", this);
  }
  
    /**
   * Reset the state for a new game
   */
  private void newGame() {
    
  }

  
    @Override
    public void messageHandler(String messageName, Object messagePayload) {
        // Display the message to the console for debugging
        if (messagePayload != null) {
          System.out.println("MSG: received by model: "+messageName+" | "+messagePayload.toString());
        } else {
          System.out.println("MSG: received by model: "+messageName+" | No data sent");
        }

        // playerMove message handler
        switch (messageName) {
            case "btnClicked": {
                //do something
            }

            default: {
                break;
            }
        }
    }
}
