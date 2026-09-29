package oop_test.ch05;

import java.util.List;

public interface ItemDao {

    public void insert(Item item);

    public List<Item> findAll();

}
