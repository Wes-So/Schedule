package com.schedule.core.entity;

import java.time.LocalDateTime;

public class Schedule {
	private Provider provider;
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	
	public Schedule(){
		
	}
	
	public Schedule(Provider provider, LocalDateTime startDateTime, LocalDateTime endDateTime) {
		this.provider = provider;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}

}
