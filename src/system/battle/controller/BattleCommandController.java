package system.battle.controller;

import character.Character;

import java.util.ArrayList;
import java.util.List;

import character.Enemy;
import character.Player;
import skill.Skill;
import system.battle.action.BattleAction;
import system.battle.action.GuardAction;
import system.battle.action.PhysicalAction;
public class BattleCommandController {

    private BattleCommandController() {
    }

    public static BattleAction selectAction(Character actor, List<Enemy> enemies, List<Player> allies){

        
        Skill selectedSkill = selectSkill(actor);

        java.util.List<Character> selectedTargets = selectTargets(actor, selectedSkill, enemies, allies);


        return createAction(actor, selectedSkill, selectedTargets);
        
    }

    private static Skill selectSkill(Character actor){
        while (true) {
            gui.MessageViewer.println(data.MessageCatalog.FIRST_COMMAND_LOG);
            int command = gui.CommandScanner.readInt(3);
            switch (command) {

                case 1 -> {
                    return data.SkillMaster.NORMAL_ATTACK;
                }
                case 2 -> {
                    Skill selected  = selectSkillFromList(actor);
                    if (selected != null) {
                        return selected;
                    }
                }
                case 3 -> {
                    return data.SkillMaster.GUARD;
                }

                default -> throw new IllegalArgumentException("未対応のコマンドです: " + command); //TODO: ここに新しいコマンドを追加する場合は、ここにケースを追加してください
            }
        }
    }
    private static Skill selectSkillFromList(Character actor){
        if (actor.getSkills().isEmpty()) {
            gui.MessageViewer.println(data.MessageCatalog.SKILL_ERROR_LOG);
            return null;
        }
        gui.MessageViewer.println(data.MessageCatalog.SKILL_COMMAND_LOG);
        gui.MessageViewer.showSkills(actor.getSkills());
        int skillIndex = gui.CommandScanner.readInt(actor.getSkills().size()) - 1;
        Skill selected = actor.getSkills().get(skillIndex);
        if (actor.getMp() < selected.getMpCost()) {
            gui.MessageViewer.printf(data.MessageCatalog.MP_ERROR_LOG, actor.getName());
            return null;
        }
        return selected;
    }

    private static java.util.List<Character> selectTargets(Character actor, Skill skill, List<Enemy> enemies, List<Player> allies) {
        List<Enemy> aliveEnemies = new ArrayList<>(enemies);
        aliveEnemies.removeIf(Character::isDead);
        List<Player> aliveAllies = new ArrayList<>(allies);
        aliveAllies.removeIf(Character::isDead);

        return switch (skill.getTargetType()) {
            case SELF -> List.of(actor);
            case ENEMY -> {
                gui.MessageViewer.println(data.MessageCatalog.TARGET_SELECT);
                gui.MessageViewer.showTargets(aliveEnemies);
                int targetIndex = gui.CommandScanner.readInt(aliveEnemies.size()) - 1;
                yield List.of(aliveEnemies.get(targetIndex));
            }
            case ALLY -> {
                gui.MessageViewer.println(data.MessageCatalog.TARGET_SELECT);
                gui.MessageViewer.showTargets(aliveAllies);
                int targetIndex = gui.CommandScanner.readInt(aliveAllies.size()) - 1;
                yield List.of(aliveAllies.get(targetIndex));
            }
            case ALL_ENEMY -> List.copyOf(aliveEnemies);
            case ALL_ALLY -> List.copyOf(aliveAllies);
            //TODO: ここに新しいターゲットタイプを追加する場合は、ここにケースを追加してください
            default -> throw new IllegalArgumentException("未対応のターゲットタイプです: " + skill.getTargetType());
        };
    }

    private static BattleAction createAction(Character actor, Skill skill, List<? extends Character> targets) {
        return switch (skill) {
            case skill.PhysicalSkill physicalSkill -> new PhysicalAction(actor, physicalSkill, targets);
            case skill.GuardSkill guardSkill -> new GuardAction(actor, guardSkill, targets);
            default -> throw new IllegalArgumentException("未対応のスキルタイプです: " + skill.getName()); //TODO: ここに新しいスキルタイプを追加する場合は、ここにケースを追加してください
        };
    }

}
