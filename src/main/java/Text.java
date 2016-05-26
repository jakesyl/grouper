package hello;

/**
 * Class that determines what to do with a message
 * @author Zach Panzarino
 * @version 1.0.0
 */
public class Text {
    private String number, text;
    /**
     * Creates a new text and stores the text
     * @param num Sending phone number
     * @param content The content of the message
     */
    public Text(String num, String content){
        number = num;
        text = content;
    }
    /**
     * Determines what to do with a message
     * @return Whether the message was successfully executed
     */
    public String execute(){
        if (text!=null && number!=null){
            Action action;
            if (text.startsWith("/")){
                if (text.startsWith("/leave")){
                    action = new Action(number, "/leave");
                    return action.leave();
                }
                int space = text.indexOf(" ");
                if (space != 1){
                    String command = text.substring(1, space);
                    String content = text.substring(space+1);
                    action = new Action(number, content);
                    if (command.equals("create")){
                        return action.create();
                    }
                    if (command.equals("join")){
                        return action.join();
                    }
                }
            }
            action = new Action(number, text);
            return action.message();
        }
        return null;
    }
}