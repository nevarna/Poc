package test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketController {


    @MessageMapping("/message")
    @SendTo("/topic/reply")
    public testMessage processMessageFromClient(Message message) throws Exception {
    	System.out.println("Je reçois un message "  + message);
    	
    	testMessage  t = new testMessage() ;
    	t.text = "Reponse : " + message.getText();
    	t.from = message.getFrom() ;
        return t;
    }

    @MessageExceptionHandler
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }
}

class Message {
	 
    private String from;
    private String text;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
 
    // getters and setters
}

class testMessage {
	String from;
	String text ;
	LocalDateTime time  = LocalDateTime.now();
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	 
}