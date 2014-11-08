package com.virtual.queue.rule;

public interface Rule {
public  void loadData(long userId,long rideId);
public boolean apply();
void loadData();
}
