package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// message sent from client to subscribe on a topic 

    public SubscribeMsg(String user, String topic) {
        super(MessageType.SUBSCRIBE, user);
        this.topic = topic;
    }


    private String topic;

	// Complete the constructor, get/set-methods, and toString method
	// as described in the project text
    @Override
    public String toString(){
        return "SubscribeMsg [topic=" + topic + "]";
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
