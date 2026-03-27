
public class Message {

    private final User sender;
    private final String content;

    public Message(User sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public Message(String content) {
        sender = null;
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public static Message deserialize(String line) {
        String[] parts = line.split("\\:", 2);
        User sender = new User(parts[0]);
        String content = parts.length > 0 ? parts[1] : null;
        return new Message(sender, content);
    }

    @Override
    public String toString() {
        return (sender != null) ? sender.getName() + ": " + content : content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Message))
            return false;

        Message other = (Message) obj;
        return sender.equals(other.sender)
                && content.equals(other.content);
    }
}
