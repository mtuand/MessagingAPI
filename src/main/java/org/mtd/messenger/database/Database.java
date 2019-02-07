package org.mtd.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.mtd.messenger.model.Message;
import org.mtd.messenger.model.Profile;

/* * 
 * Database implemented using HashMaps in lieu of a real DB.
 * */
public class Database {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}

}
