package com.fan;

public class FanOperations {
	final int SPEEDLIMIT = 3;
	private enum Direction {
		LEFT, RIGHT
	}
	
	private int speed = 0;
	Direction currentDirection = Direction.LEFT;
	
	//Method for Speed
	public void changeSpeed() {
		if(speed < SPEEDLIMIT ) {
			++speed;
		}else {
			speed = 0;
		}
	}
	
	//Method for Direction
	public void changeDirection() {
		if(currentDirection == Direction.LEFT) {
			currentDirection = Direction.RIGHT;
		}else {
			currentDirection = Direction.LEFT;
		}
	}
	
	//getters and setters
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}
}
