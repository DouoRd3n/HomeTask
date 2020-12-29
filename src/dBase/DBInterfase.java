package dBase;

import Model.Human;

public interface DBInterfase {
    Human addHuman(Human human);
    Human getById(String id);

    }
