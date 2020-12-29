package dBase;

import Model.Human;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataBase implements DBInterfase {
    public Map<String, Human> getdBMemory() {
        return dBMemory;
    }

    public void setdBMemory(Map<String, Human> dBMemory) {
        this.dBMemory = dBMemory;
    }

    private Map<String, Human> dBMemory =new HashMap<>();

    @Override
    public Human addHuman(Human human) {
        String id = UUID.randomUUID().toString();
        human.setId(id);
        return dBMemory.put(id,human);
    }

    @Override
    public Human getById(String id) {
        return dBMemory.get(id);
    }





}



