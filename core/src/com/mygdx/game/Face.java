package com.mygdx.game;

import java.util.ArrayList;

public class Face {
        String[][] faceMatrix = new String[3][3];
        public Face(String piece){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    this.faceMatrix[i][j] = piece;
                }
            }
        }
}
