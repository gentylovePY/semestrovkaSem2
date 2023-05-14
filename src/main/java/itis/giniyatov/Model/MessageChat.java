package itis.giniyatov.Model;

/*
 * Message received from client.
 *
 * @Author Jay Sridhar
 */
public class MessageChat
{
    private String from;
    private String text;

    public MessageChat() {}

    public MessageChat(String from, String text)
    {
	this.from = from;
	this.text = text;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
