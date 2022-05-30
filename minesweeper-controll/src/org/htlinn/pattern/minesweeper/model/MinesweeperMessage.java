package org.htlinn.pattern.minesweeper.model;

public class MinesweeperMessage {
	public enum ACTIONS {
		NOTIFY, CELL_SET, LOST, WON, FIELD_FULL, FLAG_ON, FLAG_OFF
	};

	ACTIONS action;
	int x;
	int y;
	Field field;

	public MinesweeperMessage(ACTIONS action) {
		this(action, 0, 0, null);
	}

	public MinesweeperMessage(ACTIONS action, int x, int y) {
		this (action, x,y, null);
	}

	public MinesweeperMessage(ACTIONS action, int x, int y, Field field) {
		this.action = action;
		this.x = x;
		this.y = y;
		this.field = field;
	}

	public ACTIONS getAction() {
		return action;
	}

	public void setAction(ACTIONS action) {
		this.action = action;
	}


	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("ACTION: %s POS: (%d %d)", action, x, y);
	}


}
