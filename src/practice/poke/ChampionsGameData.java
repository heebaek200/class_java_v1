package practice.poke;

public class ChampionsGameData extends GameData {

    public ChampionsGameData(String gameTitle) {
        super(gameTitle);
    }

    // 게임 내에서 전투에 참가할 수 있다.
    public void fightAll() {
        for (Monster monster : monsterBox) {
            monster.fight();
        }
    }

}
