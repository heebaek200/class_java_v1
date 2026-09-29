package oop_test.ch05;

import java.util.ArrayList;
import java.util.List;

public class MemoryItemDao implements ItemDao {

    private ArrayList<Item> inventory = new ArrayList<>();

    @Override
    public void insert(Item item) {
        inventory.add(item);

        System.out.println("[%s] 아이템을 인벤토리에 넣었습니다.".formatted(
                item.getName()
        ));
    }

    @Override
    public List<Item> findAll() {
        return inventory;
    }
}
