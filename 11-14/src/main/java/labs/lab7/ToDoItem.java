package labs.lab7;

import java.util.Objects;

/**
 * Represents a todo item
 *
 */
public class ToDoItem implements Comparable<ToDoItem> {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String description;
	private int priority;

	/**
	 * 
	 * @param description
	 * @param priority    must be >= 0, otherwise gets priority of 0
	 */
	public ToDoItem(String description, int priority) {
		// FILL IN
		this.description = description;
		this.priority = priority;
		if (this.priority<0){
			this.priority = 0;
		}
	}


	public String getDescription() {
		return description; // FIX ME
	}


	public int getPriority() {
		return priority; // FIX ME
	}
	
	
	@Override
	public String toString() {
		return priority+" "+description; // FIX ME
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToDoItem toDoItem = (ToDoItem) o;
		return priority == toDoItem.priority && Objects.equals(description, toDoItem.description);
	}



	/**
	 * Compares first by priority, then by description
	 */
	public int compareTo(ToDoItem otherObject) {
		return priority-otherObject.priority==0
				?description.compareTo(otherObject.description)
				:priority-otherObject.priority; // FIX ME
	}

}
