package com.mygdx.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cube {
    Map<String, Face> Faces = new HashMap<>();
    public Cube(){
        Faces.put("WHITE", new Face("WHITE"));
        Faces.put("RED", new Face("RED"));
        Faces.put("YELLOW", new Face("YELLOW"));
        Faces.put("ORANGE", new Face("ORANGE"));
        Faces.put("GREEN", new Face("GREEN"));
        Faces.put("BLUE", new Face("BLUE"));
    }
}
