package no.hvl.dat110.broker;

import no.hvl.dat110.common.Logger;

public class BrokerServer extends Thread {

	private static final int BROKER_DEFAULTPORT = 8080;

	public static void main(String[] args) {

		int port = BROKER_DEFAULTPORT;

		// Command-line argument handling
		if (args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
				if (port <= 0 || port > 65535) {
					throw new NumberFormatException("Port out of range");
				}
			} catch (NumberFormatException e) {
				Logger.log("Invalid port number provided. Exiting...");
				System.exit(1);
			}
		}

		Logger.log("Starting Broker server on port: " + port);

		Storage storage = new Storage();
		Dispatcher dispatcher = new Dispatcher(storage);
		Broker broker = new Broker(dispatcher, port);

		// Start dispatcher and broker threads
		dispatcher.start();
		Logger.log("Dispatcher started successfully.");

		broker.start();
		Logger.log("Broker started successfully.");

		int finalPort = port;
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			Logger.log("Initiating shutdown sequence for broker on port " + finalPort);
			try {
				dispatcher.interrupt();
				broker.interrupt();
				dispatcher.join();
				broker.join();
				Logger.log("Broker server on port " + finalPort + " stopped gracefully.");
			} catch (InterruptedException e) {
				Logger.log("Error stopping broker server on port " + finalPort);
			}
		}));

		// Wait for threads to finish
		try {
			broker.join();
			dispatcher.join();
		} catch (InterruptedException e) {
			Logger.log("Broker server interrupted.");
			e.printStackTrace();
		}

		Logger.log("Broker server stopping...");
	}
}