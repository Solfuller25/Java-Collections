package com.cooksys.ftd.assignments.collections.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.cooksys.ftd.assignments.collections.util.MissingImplementationException;

/**
 * TODO: Implement this class
 *  <br><br>
 *  A worker is a type of employee that cannot be a superior to another employee.
 *  <br>
 *  A worker should have a name, and, optionally, a manager superior to them.
 */
public class Worker implements Employee {

    // TODO: Does this class need private fields? If so, add them here
	private String name;
	private Manager manager;
    /**
     * TODO: Implement this constructor.
     *
     * @param name the name of the worker to be created
     */
    public Worker(String name) {
        this.name = name;
    }

    /**
     *  TODO: Implement this constructor.
     *
     * @param name the name of the worker to be created
     * @param manager the direct manager of the worker to be created
     */
    public Worker(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return the name of the worker
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * TODO: Implement this getter.
     *
     * @return {@code true} if this worker has a manager, or {@code false} otherwise
     */
    @Override
    public boolean hasManager() {
        if(this.manager != null) {
        	return true;
        } else {
        	return false;
        }
    }

    /**
     * TODO: Implement this getter.
     *
     * @return the manager of this worker, or null if it has none
     */
    @Override
    public Manager getManager() {
        return this.manager;
    }

    /**
     * TODO: Implement this method.
     *  <br><br>
     *  Retrieves the worker's chain of command as a {@code List<Manager>}, starting with their direct {@code Manager},
     *  followed by that {@code Manager}'s {@code Manager}, and so on, until the top of the hierarchy is reached.
     *  <br><br>
     *  The returned list should never be or contain {@code null}.
     *  <br><br>
     *  If the worker does not have a {@code Manager}, an empty
     *  {@code List<Manager>} should be returned.
     *
     * @return a {@code List<Manager>} that represents the worker's chain of command,
     */
    @Override
    public List<Manager> getChainOfCommand() {
    	List<Manager> managerList = new ArrayList<>();
        
        // Check if this manager has a manager. If not, return empty list
        Manager nextManager;
        if (this.hasManager()) {
            nextManager = this.manager;
        } else {
        	return managerList;
        }

        // Start looping if this manager has a manager
        while(true) {
        	managerList.add(nextManager);
        	if (nextManager.hasManager()) {
        		// Update to the next manager
        		nextManager = nextManager.getManager();
        	} else {
        		break;
        	}
        }
        
    	return managerList;
    }

	@Override
	public int hashCode() {
		return Objects.hash(manager, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Worker)) {
			return false;
		}
		Worker other = (Worker) obj;
		return Objects.equals(manager, other.manager) && Objects.equals(name, other.name);
	}

    // TODO: Does this class need custom .equals() and .hashcode() methods? If so, implement them here.
    

    // TODO [OPTIONAL]: Consider adding a custom .toString() method here if you want to debug your code with System.out.println() statements
}
