package labs.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * Represents a list of TodoItems
 *
 */
public class ToDoList {

	// ADD YOUR INSTANCE VARIABLES EHRE
	List<ToDoItem> itemList;

	public ToDoList() {
		// FILL IN
		itemList = new ArrayList<>();
	}


	/**
	 * Adds an item to the list
	 * 
	 * @param description	description of item to add 
	 * @param priority		priority of item to add
	 */
	public void addItem(String description, int priority) {
		// FILL IN
		ToDoItem toDoItem = new ToDoItem(description,priority);
		itemList.add(toDoItem);
	}


	/**
	 * Removes the first item with the given description
	 * 
	 * @param description	item description to remove
	 * @return				true if the item was removed
	 */
	public boolean removeFirstItemWithDescription(String description) {
		for (ToDoItem item :
				itemList) {
			if (item.getDescription().equals(description)) {
				itemList.remove(item);
				return true;
			}
		}
		return false; // FIX ME
	}


	/**
	 * Removes all items with the given description
	 * 
	 * @param description	item description to remove
	 * @return				true if at least one item was removed
	 */
	public boolean removeAllItemsWithDescription(String description) {
		boolean hasRemove = false;
		for (int i = 0; i < itemList.size(); i++) {
			ToDoItem item = itemList.get(i);
			if (item.getDescription().equals(description)){
				itemList.remove(i);
				i--;
				hasRemove = true;
			}
		}
		return hasRemove; // FIX ME
	}


	/**
	 * Removes the first item with the given priority
	 * "First item" is determined according to the sort order
	 * of the ToDoItems in the list.
	 * 
	 * @param priority	item priority to remove
	 * @return			true if the item was removed
	 */
	public boolean removeFirstItemWithPriority(int priority) {
		for (ToDoItem item :
				itemList) {
			if (item.getPriority() == priority) {
				itemList.remove(item);
				return true;
			}
		}
		return false; // FIX ME
	}
	
	
	/**
	 * Removes all items with the given priority
	 * 
	 * @param priority	item priority to remove
	 * @return			true if at least one item was removed
	 */
	public boolean removeAllItemsWithPriority(int priority) {
		boolean hasRemove = false;
		for (int i = 0; i < itemList.size(); i++) {
			ToDoItem item = itemList.get(i);
			if (item.getPriority() == priority){
				itemList.remove(i);
				i--;
				hasRemove = true;
			}
		}
		return hasRemove; // FIX ME
	}


	/**
	 * Returns the first item with the given description.
	 * "First item" is determined according to the sort order
	 * of the ToDoItems in the list.
	 * 
	 * @param description	item description to find
	 * @return				the item, or null if not found
	 */
	public ToDoItem findFirstItemWithDescription(String description) {
		for (ToDoItem item :
				itemList) {
			if (item.getDescription().equals(description)) {
				return item;
			}
		}
		return null; // FIX ME
	}


	/**
	 * Returns a sorted list of all items with the given description
	 * 
	 * @param description	item description to find
	 * @return				a list of all items with the matching description
	 */
	public List<ToDoItem> findAllItemsWithDescription(String description) {
		List<ToDoItem> list = new ArrayList<>();
		for (int i = 0; i < itemList.size(); i++) {
			ToDoItem item = itemList.get(i);
			if (item.getDescription().equals(description)){
				list.add(item);
			}
		}
		Collections.sort(list);
		return list; // FIX ME
	}


	/**
	 * Returns the first item with the given priority.
	 * "First item" is determined according to the sort order
	 * of the ToDoItems in the list.
	 * 
	 * @param priority	item priority to find
	 * @return			the item, or null if not found
	 */
	public ToDoItem findFirstItemWithPriority(int priority) {
		for (ToDoItem item :
				itemList) {
			if (item.getPriority() == priority) {
				return item;
			}
		}
		return null; // FIX ME
	}
	
	
	/**
	 * Returns a sorted list of all items with the given priority
	 * 
	 * @param priority	item priority to find
	 * @return			a list of all items with the matching priority
	 */
	public List<ToDoItem> findAllItemsWithPriority(int priority) {
		List<ToDoItem> list = new ArrayList<>();
		for (int i = 0; i < itemList.size(); i++) {
			ToDoItem item = itemList.get(i);
			if (item.getPriority() == priority){
				list.add(item);
			}
		}
		Collections.sort(list);
		return list; // FIX ME
	}


	/**
	 * @return	a list of all ToDoItems, sorted
	 */
	public List<ToDoItem> getSortedItems() {
		List<ToDoItem> list = new ArrayList<>(itemList);
		Collections.sort(list);
		return list; // FIX ME
	}
	
	
	/**
	 * Prints all the items in the list, sorted, with a comma and space between
	 * each one
	 */
	@Override
	public String toString() {
		String res = "";
		for (ToDoItem item :
				getSortedItems()) {
			res+=item.toString()+", ";
		}
		return res.substring(0,res.length()-2); // FIX ME
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToDoList toDoList = (ToDoList) o;
		return Objects.equals(itemList, toDoList.itemList);
	}

	//	@Override
//	public boolean equals(Object o) {
//		return false; // FIX ME
//	}
}
