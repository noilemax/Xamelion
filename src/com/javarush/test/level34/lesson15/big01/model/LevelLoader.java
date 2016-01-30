package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects getLevel(int level)
    {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player;

        walls.add(new Wall(100 + Model.FIELD_SELL_SIZE/2, 100 + Model.FIELD_SELL_SIZE/2));
        walls.add(new Wall(200 + Model.FIELD_SELL_SIZE/2, 200 + Model.FIELD_SELL_SIZE/2));
        walls.add(new Wall(300 + Model.FIELD_SELL_SIZE/2, 300 + Model.FIELD_SELL_SIZE/2));
        boxes.add(new Box(400 + Model.FIELD_SELL_SIZE/2, 400 + Model.FIELD_SELL_SIZE/2));
        homes.add(new Home(500 + Model.FIELD_SELL_SIZE/2, 500 + Model.FIELD_SELL_SIZE/2));
        player = new Player(600 + Model.FIELD_SELL_SIZE/2, 600 + Model.FIELD_SELL_SIZE/2);
        GameObjects gameObjects = new GameObjects(walls, boxes, homes, player);


        return gameObjects;
    }
}