package character;

public class Hero extends Player {
	
	private static final int[] HP = {0,
			15, 22, 24, 31, 35,		//Lv5
			38, 40, 46, 50, 54,		//Lv10
			62, 63, 70, 78, 86,		//Lv15
			92, 100, 115, 130, 138,	//Lv20
			149, 158, 165, 170, 174,//Lv25
			180, 189, 195, 200, 210	//Lv30
	};
	
	private static final int[] MP = {0,
			0, 0, 5, 16, 20,		//Lv5
			24, 26, 29, 36, 40,		//Lv10
			50, 58, 64, 70, 72,		//Lv15
			95, 100, 108, 115, 128,	//Lv20
			135, 146, 153, 161, 161,//Lv25
			168, 175, 180, 190, 200	//LV30
	};
	
	private static final int[] ATK = {0,
			4, 5, 7, 7, 12,			//Lv5
			16, 18, 22, 30, 35,		//Lv10
			40, 48, 52, 60, 68,		//Lv15
			72, 72, 85, 87, 92,		//Lv20
			95, 97, 99, 103, 113,	//Lv25
			117, 125, 130, 135, 140	//Lv30
	};
	
	private static final int[] MAT = {0,
			4, 5, 7, 7, 12,			//Lv5
			16, 18, 22, 30, 35,		//Lv10
			40, 48, 52, 60, 68,		//Lv15
			72, 72, 85, 87, 92,		//Lv20
			95, 97, 99, 103, 113,	//Lv25
			117, 125, 130, 135, 140	//Lv30
	};
	
	private static final int[] SPD = {0,
			4, 4, 6, 8, 10,		 //Lv5
			10, 17, 20, 22, 31,	 //Lv10
			35, 40, 48, 55, 64,	 //Lv15
			70, 78, 84, 86, 88,	 //Lv20
			90, 94, 98, 100, 105,//Lv25
			107, 115, 120, 130 	 //Lv30
	};

	public Hero() {
		
		super(HP[1], MP[1], ATK[1], MAT[1], SPD[1], "勇者", 1, 0);
		
	}
	@Override
	public int getHpGrowth(int nextLevel) {
		return HP[nextLevel];
	}
	@Override
	public int getMpGrowth(int nextLevel) {
		return MP[nextLevel];
	}
	@Override
	public int getAtkGrowth(int nextLevel) {
		return ATK[nextLevel];
	}
	@Override
	public int getMatGrowth(int nextLevel) {
		return MAT[nextLevel];
	}
	@Override
	public int getSpdGrowth(int nextLevel) {
		return SPD[nextLevel];
	}
	
	@Override
	public void updateStats(int newLevel) {
		this.maxHp = HP[newLevel];
		this.hp = HP[newLevel];
		this.maxMp = MP[newLevel];
		this.mp = MP[newLevel];
		this.power = ATK[newLevel];
		this.magicPower = MAT[newLevel];
		this.speed = SPD[newLevel];
		this.level = newLevel;
		this.exp = this.getExp();
		
	}

}
 