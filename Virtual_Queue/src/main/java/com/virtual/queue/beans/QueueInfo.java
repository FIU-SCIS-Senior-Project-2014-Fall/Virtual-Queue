package com.virtual.queue.beans;

public class QueueInfo {
	private long queueId;
	private long userId;
	private int capacity;
	private int waitingTime;

	public long getQueueId() {
		return queueId;
	}

	public void setQueueId(long queueId) {
		this.queueId = queueId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

}
