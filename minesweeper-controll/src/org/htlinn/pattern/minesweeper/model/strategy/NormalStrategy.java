package org.htlinn.pattern.minesweeper.model.strategy;

import java.time.chrono.MinguoEra;

import org.htlinn.pattern.minesweeper.model.BombField;
import org.htlinn.pattern.minesweeper.model.EmptyField;
import org.htlinn.pattern.minesweeper.model.MinesweeperMessage;
import org.htlinn.pattern.minesweeper.model.Playground;

public class NormalStrategy implements PlayStrategy {

	@Override
	public boolean set(Playground p, int x, int y) {
		p.get(y, x).setOpen(true);
		if(p.get(x, y) instanceof EmptyField)
		{
			p.setChanged2();
			p.notifyObservers(new MinesweeperMessage(MinesweeperMessage.ACTIONS.CELL_SET, x, y, p.get(x, y)));
		}
		
		//p.notifyObservers(new MinesweeperMessage(MinesweeperMessage.ACTIONS.CELL_SET, x, y, p.get(x, y) instanceof EmptyField ? p.get(x, y) : (((EmptyField) p.get(x, y)).setBombsCnt(-1)))); 
		
		//		p.get(y, x) instanceof EmptyField ? ((EmptyField) p.get(y, x)).getBombsCnt() : -1)

		
		//TODO: machn dass -1 gesetzt wird auf bomben
		if (p.get(y, x) instanceof BombField) {
			return false;
		}
		p.openNeighbour(x, y);
		return true;
	}

	@Override
	public boolean won() {
		return false;
	}

}
