package system.battle.controller;

import character.Character;

import java.util.ArrayList;
import java.util.List;

import character.Enemy;
import character.Player;
import data.MessageCatalog;
import skill.Skill;
import system.battle.action.BattleAction;
import system.battle.action.GuardAction;
import system.battle.action.PhysicalAction;
public class BattleCommandController {

    private BattleCommandController() {
    }

    public static BattleAction selectAction(Character actor, List<Enemy> enemies, List<Player> allies){
        while(true) {

            Skill selectedSkill = selectSkill(actor);

            java.util.List<Character> selectedTargets = selectTargets(actor, selectedSkill, enemies, allies);
            if (selectedTargets == null) {
                continue;
            }

            return createAction(actor, selectedSkill, selectedTargets);
        }
    }

    private static Skill selectSkill(Character actor){
        while (true) {
            gui.MessageViewer.print(data.MessageCatalog.FIRST_COMMAND_LOG);
            int command = gui.CommandScanner.readInt(1, 3);
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
            gui.MessageViewer.print(data.MessageCatalog.SKILL_ERROR_LOG);
            return null;
        }
        gui.MessageViewer.print(data.MessageCatalog.SKILL_COMMAND_LOG);
        gui.MessageViewer.print(MessageCatalog.RETURN_LOG);
        gui.MessageViewer.showSkills(actor.getSkills());
        int skillIndex = gui.CommandScanner.readInt(0, actor.getSkills().size()) - 1;
        if (skillIndex == -1) {
            return null;
        }
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
            case ENEMY -> selectSingleTarget(aliveEnemies);

            case ALLY -> selectSingleTarget(aliveAllies);
            case ALL_ENEMY -> List.copyOf(aliveEnemies);
            case ALL_ALLY -> List.copyOf(aliveAllies);
            //TODO: ここに新しいターゲットタイプを追加する場合は、ここにケースを追加してください
            default -> throw new IllegalArgumentException("未対応のターゲットタイプです: " + skill.getTargetType());
        };
    }

    private static List<Character> selectSingleTarget(List<? extends Character> targets) {
        gui.MessageViewer.print(data.MessageCatalog.TARGET_SELECT);
        gui.MessageViewer.print(data.MessageCatalog.RETURN_LOG);
        gui.MessageViewer.showTargets(targets);
        int targetIndex = gui.CommandScanner.readInt(0, targets.size()) - 1;
        if (targetIndex == -1) {
            return null;
        }
        return List.of(targets.get(targetIndex));
    }

    private static BattleAction createAction(Character actor, Skill skill, List<? extends Character> targets) {
        return switch (skill) {
            case skill.PhysicalSkill physicalSkill -> new PhysicalAction(actor, physicalSkill, targets);
            case skill.GuardSkill guardSkill -> new GuardAction(actor, guardSkill, targets);
            default -> throw new IllegalArgumentException("未対応のスキルタイプです: " + skill.getName()); //TODO: ここに新しいスキルタイプを追加する場合は、ここにケースを追加してください
        };
    }

}
