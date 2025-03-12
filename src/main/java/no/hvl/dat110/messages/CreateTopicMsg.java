package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {

    private String topic;

    // Constructor to create a CreateTopicMsg instance
    public CreateTopicMsg(String user, String topic) {
        super(MessageType.CREATETOPIC, user);
        this.topic = topic;
    }

    // Getter for topic
    public String getTopic() {
        return topic;
    }

    // Setter for topic
    public void setTopic(String topic) {
        this.topic = topic;
    }


    @Override
    public String toString() {
        return "CreateTopicMsg [user=" + getUser() + ", topic=" + topic + "]";
    }
}