package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	// message sent from client to create topic on the broker

    public DeleteTopicMsg(String user, String topic) {
        super(MessageType.DELETETOPIC, user);
        this.topic = topic;
    }


    private String topic;

	// Complete the constructor, get/set-methods, and toString method
	// as described in the project text


    @Override
    public String toString() {
        return "DeleteTopicMsg [topic=" + topic +"]";
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
