package org.mtd.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.mtd.messenger.database.Database;
import org.mtd.messenger.exception.DataNotFoundException;
import org.mtd.messenger.model.Message;

/**
 * Receives calls from Annotated Methods and updates the Database class. 
 */
public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hello world", "mtd"));
		messages.put(2L, new Message(2, "hello jersey", "mtd"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message> (messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	
	public Message getMessage(long id){
		Message message = messages.get(id);
		if(message == null){
			throw new DataNotFoundException("Message with id " + id + " not found.");
		}
		return message;
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}

}
