package data;

public class MessageCatalog {
	private MessageCatalog() {
    }
	
	public static final String SKILL_LOG = "%s の %s\n";
	public static final String DAMAGE_LOG = "%s に %d ダメージ\n";
	public static final String GUARD_LOG = "%s は身を守っている\n";
	public static final String ENCOUNTER_LOG = "魔物があらわれた\n";
	public static final String KILL_LOG = "%s をたおした\n";
	public static final String SLAIN_LOG = "%s はたおれた\n";
	public static final String WIN_LOG = "戦いに勝った！\n";
	public static final String LOSE_LOG = "戦いに負けた・・・\n";
	public static final String EXP_LOG = "経験値を %d 手に入れた\n";
	public static final String LEVEL_UP_LOG = "%s はレベルが %d に上がった\n";
	public static final String MP_LOG = "%s は %dMP 回復した\n";
	public static final String MP_ERROR_LOG = "%s はMPが足りない\n";
	public static final String ITEM_LOG = "%s は %s を使った\n";
	public static final String SKILL_LEARN_LOG = "%s は %s を覚えた\n";
	public static final String ADD_CONDITION = "%s は %s 状態になった\n";
	public static final String REMOVE_CONDITION = "%s は %s 状態が解除された\n";
    public static final String CONDITION_DAMAGE = "%s は %s の効果で %d ダメージを受けた\n";
	public static final String FIRST_COMMAND_LOG = "コマンドを選択してください\n1: たたかう\n2: スキル\n3: ぼうぎょ\n ";
	public static final String SKILL_COMMAND_LOG = "スキルを選択してください\n";
	public static final String COMMAND_ERROR_LOG = "※正しい番号を入力してください\n";
	public static final String SKILL_ERROR_LOG = "※スキルがありません\n";
	public static final String TARGET_SELECT = "対象を選択してください\n";
	public static final String COMMAND_SELECT = "%d : %s\n";
	public static final String SKILL_SELECT = "%d : %s (MP: %d )\n";
	public static final String RETURN_LOG = "0 : もどる\n";
	
	public static final String EQUIP_LOG = "%s は %s を装備した\n";
	public static final String UNEQUIP_LOG = "%s は %s を外した\n";
	public static final String UNEQUIP_ERROR_LOG = "%s は外すものがありません\n";
	public static final String GAIN_LOG = "%s を手に入れた\n";
}
