package system;
import character.Character;
import java.util.List;
import skill.Skill;
public class BattleCommandController {

    public static BattleAction selectAction(Character actor, List<? extends Character> enemies, List<? extends Character> allies){

        Skill selectedSkill = selectSkill(actor);

        java.util.List<? extends Character> selectedTargets = selectTargets(actor, selectedSkill, enemies, allies);

        return createAction(actor, selectedSkill, selectedTargets);
    }

    private static Skill selectSkill(Character actor){
        gui.MessageViewer.println(data.MessageCatalog.FIRST_COMMAND_LOG);
        int command = gui.CommandScanner.readInt(3);

        return  switch (command) {
            case 1 -> data.SkillMaster.NORMAL_ATTACK;
            case 2 -> {
                if (actor.getSkills().isEmpty()) {
                    gui.MessageViewer.println(data.MessageCatalog.SKILL_ERROR_LOG);
                    yield selectSkill(actor);
                }
                gui.MessageViewer.println(data.MessageCatalog.SKILL_COMMAND_LOG);
                gui.MessageViewer.commandSelectMessage(actor.getSkills());
                int skillIndex = gui.CommandScanner.readInt(actor.getSkills().size()) - 1;
                if (actor.getMp() < actor.getSkills().get(skillIndex).getMpCost()) {
                    gui.MessageViewer.printf(data.MessageCatalog.MP_ERROR_LOG, actor.getName());
                    yield selectSkill(actor);
                }
                yield actor.getSkills().get(skillIndex);
            }
            case 3 -> data.SkillMaster.GUARD;

            default -> selectSkill(actor); //TODO: ここに新しいコマンドを追加する場合は、ここにケースを追加してください
        };
    }
     

    private static java.util.List<? extends Character> selectTargets(Character actor, Skill skill, List<? extends Character> enemies, List<? extends Character> allies) {
        return switch (skill.getTargetType()) {
            case SELF -> List.of(actor);
            case ENEMY -> {
                gui.MessageViewer.println(data.MessageCatalog.TARGET_SELECT);
                gui.MessageViewer.commandSelectMessage(enemies);
                int targetIndex = gui.CommandScanner.readInt(enemies.size()) - 1;
                yield List.of(enemies.get(targetIndex));
            }
            case ALLY -> {
                gui.MessageViewer.println(data.MessageCatalog.TARGET_SELECT);
                gui.MessageViewer.commandSelectMessage(allies);
                int targetIndex = gui.CommandScanner.readInt(allies.size()) - 1;
                yield List.of(allies.get(targetIndex));
            }
            case ALL_ENEMY -> enemies;
            case ALL_ALLY -> allies;
            //TODO: ここに新しいターゲットタイプを追加する場合は、ここにケースを追加してください
            default -> selectTargets(actor, skill, enemies, allies);
        };
    }

    private static BattleAction createAction(Character actor, Skill skill, List<? extends Character> targets) {
        return switch (skill) {
            case skill.PhysicalSkill physicalSkill -> new PhysicalAction(actor, physicalSkill, targets);
            case skill.GuardSkill guardSkill -> new GuardAction(actor, guardSkill, targets);
            default -> createAction(actor, selectSkill(actor), targets); //TODO: ここに新しいスキルタイプを追加する場合は、ここにケースを追加してください
        };
    }

}
