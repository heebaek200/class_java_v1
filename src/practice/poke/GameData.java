package practice.poke;

import java.util.LinkedList;

public class GameData {

    protected String gameTitle;
    protected LinkedList<Monster> monsterBox;

    public GameData(String gameTitle) {
        this.gameTitle = gameTitle;

        monsterBox = new LinkedList<>();
    }


    // 박스에 몬스터를 추가한다.
    public void addMonster(Monster monster) {
        monsterBox.add(monster);
    }

    // 박스에서 몬스터를 빼낸다.
    public void removeMonster(Monster monster) {
        monsterBox.remove(monster);
    }

    // 다른 게임 타이틀의 박스으로 몬스터를 이동시킨다.
    public void moveMonsterTo(Monster monster, GameData anoterGameData) {

        // 이 박스에서 몬스터를 빼내고
        this.removeMonster(monster);

        // 다른 게임의 박스로 이동시킨다.
        anoterGameData.monsterBox.add(monster);

    }

    // 게임 박스를 확인해보았다.
    public void showMonsters() {
        for (Monster monster : monsterBox) {
            monster.showInfo();
        }
    }



}
