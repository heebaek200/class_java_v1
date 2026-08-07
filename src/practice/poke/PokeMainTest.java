package practice.poke;

public class PokeMainTest {

    public static void main(String[] args) {

        // 몬스터 레드 버전을 구입했다.
        RedVersionGameData redVersionGameData = new RedVersionGameData("레드 버전");

        // 레드 버전에서 피카츄, 파이리, 꼬부기를 잡았다!
        Monster pikachu = new Monster("피카츄");
        redVersionGameData.addMonster(pikachu);

        Monster charmander = new Monster("파이리");
        redVersionGameData.addMonster(charmander);

        Monster squirtle = new Monster("꼬부기");
        redVersionGameData.addMonster(squirtle);

        // 몬스터 챔피언스를 구입했다.
        ChampionsGameData championsGameData = new ChampionsGameData("몬스터 챔피언스");

        // 레드 버전의 피카츄, 파이리, 꼬부기를 챔피언스로 이동시켰다.
        redVersionGameData.moveMonsterTo(pikachu, championsGameData);
        redVersionGameData.moveMonsterTo(charmander, championsGameData);
        redVersionGameData.moveMonsterTo(squirtle, championsGameData);

        // 챔피언스의 박스를 확인했다.
        championsGameData.showMonsters();

        // 챔피언스에서 전투를 진행시켰다.
        championsGameData.fightAll();


    }

}
