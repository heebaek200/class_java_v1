package practice.poke;

public class RedVersionGameData extends GameData {

    public RedVersionGameData(String gameTitle) {
        super(gameTitle);
    }


    // 게임 내에서 포켓몬을 포획할 수 있다.
    public void catchMonster(String monsterName) {
        Monster monster = new Monster(monsterName);
        this.addMonster(monster);
    }

}
