package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
				
		// create a client object and use it to
		
		// - connect to the broker - use "display" as the username
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker

		Client displayClient = new Client("display","localhost",8080);
		displayClient.connect();

		String topic = "temperature";
		displayClient.createTopic(topic);
		displayClient.subscribe(topic);

		for(int i = 0; i < COUNT; i++){
			Message message = displayClient.receive();

			if (message != null){

				System.out.println("Received message: " + message);



			}



		}

		displayClient.unsubscribe(topic);
		displayClient.disconnect();


		
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
		throw new UnsupportedOperationException(TODO.method());
		
	}
}
