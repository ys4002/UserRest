package com.yash.support;

import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TimerTask to update db with the feed at an interval
 * 
 * @author Yash
 *
 */
@Component
public class UpdateNewsTimer extends TimerTask {

	@Autowired
	ISupport support;

	// Add your task here
	public void run() {
		support.updateDatabase();
	}
}
