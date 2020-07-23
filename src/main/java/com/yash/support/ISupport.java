package com.yash.support;

/**
 * Support Interface is created so that NewsSupport class
 * can use all the services and this interface can be autowired with the timertask
 * 
 * @author Yash
 *
 */
public interface ISupport {
	public void updateDatabase();
}
