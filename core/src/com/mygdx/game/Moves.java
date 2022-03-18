package com.mygdx.game;

import java.util.ArrayList;

public class Moves {
    public static void Move(String moveName, Cube rubik){
        Cube tempCube = new Cube();
        setCube(tempCube, rubik);
        switch(moveName){
            case "U":
                rotateMatrix(true, rubik.Faces.get("WHITE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("GREEN").faceMatrix[0][i] = rubik.Faces.get("RED").faceMatrix[0][i];
                    tempCube.Faces.get("ORANGE").faceMatrix[2][i] = rubik.Faces.get("GREEN").faceMatrix[0][i];
                    tempCube.Faces.get("BLUE").faceMatrix[0][i] = rubik.Faces.get("ORANGE").faceMatrix[2][i];
                    tempCube.Faces.get("RED").faceMatrix[0][i] = rubik.Faces.get("BLUE").faceMatrix[0][i];
                }
                break;
            case "UI":
                rotateMatrix(false, rubik.Faces.get("WHITE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("BLUE").faceMatrix[0][i] = rubik.Faces.get("RED").faceMatrix[0][i];
                    tempCube.Faces.get("ORANGE").faceMatrix[2][i] = rubik.Faces.get("BLUE").faceMatrix[0][i];
                    tempCube.Faces.get("GREEN").faceMatrix[0][i] = rubik.Faces.get("ORANGE").faceMatrix[2][i];
                    tempCube.Faces.get("RED").faceMatrix[0][i] = rubik.Faces.get("GREEN").faceMatrix[0][i];
                }
                break;
            case "U2":
                rotateMatrix(true, rubik.Faces.get("WHITE").faceMatrix);
                rotateMatrix(true, rubik.Faces.get("WHITE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("ORANGE").faceMatrix[2][i] = rubik.Faces.get("RED").faceMatrix[0][i];
                    tempCube.Faces.get("BLUE").faceMatrix[0][i] = rubik.Faces.get("GREEN").faceMatrix[0][i];
                    tempCube.Faces.get("RED").faceMatrix[0][i] = rubik.Faces.get("ORANGE").faceMatrix[2][i];
                    tempCube.Faces.get("GREEN").faceMatrix[0][i] = rubik.Faces.get("BLUE").faceMatrix[0][i];
                }
                break;
            case "D":
                rotateMatrix(true, rubik.Faces.get("YELLOW").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("GREEN").faceMatrix[2][i] = rubik.Faces.get("RED").faceMatrix[2][i];
                    tempCube.Faces.get("ORANGE").faceMatrix[0][i] = rubik.Faces.get("GREEN").faceMatrix[2][i];
                    tempCube.Faces.get("BLUE").faceMatrix[2][i] = rubik.Faces.get("ORANGE").faceMatrix[0][i];
                    tempCube.Faces.get("RED").faceMatrix[2][i] = rubik.Faces.get("BLUE").faceMatrix[2][i];
                }
                break;
            case "DI":
                rotateMatrix(false, rubik.Faces.get("YELLOW").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("BLUE").faceMatrix[2][i] = rubik.Faces.get("RED").faceMatrix[2][i];
                    tempCube.Faces.get("ORANGE").faceMatrix[0][i] = rubik.Faces.get("BLUE").faceMatrix[2][i];
                    tempCube.Faces.get("GREEN").faceMatrix[2][i] = rubik.Faces.get("ORANGE").faceMatrix[0][i];
                    tempCube.Faces.get("RED").faceMatrix[2][i] = rubik.Faces.get("GREEN").faceMatrix[2][i];
                }
                break;
            case "D2":
                rotateMatrix(true, rubik.Faces.get("YELLOW").faceMatrix);
                rotateMatrix(true, rubik.Faces.get("YELLOW").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("ORANGE").faceMatrix[0][i] = rubik.Faces.get("RED").faceMatrix[2][i];
                    tempCube.Faces.get("BLUE").faceMatrix[2][i] = rubik.Faces.get("GREEN").faceMatrix[2][i];
                    tempCube.Faces.get("RED").faceMatrix[2][i] = rubik.Faces.get("ORANGE").faceMatrix[0][i];
                    tempCube.Faces.get("GREEN").faceMatrix[2][i] = rubik.Faces.get("BLUE").faceMatrix[2][i];
                }
                break;
            case "R":
                rotateMatrix(true, rubik.Faces.get("BLUE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("WHITE").faceMatrix[i][2] = rubik.Faces.get("RED").faceMatrix[i][2];
                    tempCube.Faces.get("ORANGE").faceMatrix[i][2] = rubik.Faces.get("WHITE").faceMatrix[i][2];
                    tempCube.Faces.get("YELLOW").faceMatrix[i][2] = rubik.Faces.get("ORANGE").faceMatrix[i][2];
                    tempCube.Faces.get("RED").faceMatrix[i][2] = rubik.Faces.get("YELLOW").faceMatrix[i][2];
                }
                break;
            case "RI":
                rotateMatrix(false, rubik.Faces.get("BLUE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("YELLOW").faceMatrix[i][2] = rubik.Faces.get("RED").faceMatrix[i][2];
                    tempCube.Faces.get("RED").faceMatrix[i][2] = rubik.Faces.get("WHITE").faceMatrix[i][2];
                    tempCube.Faces.get("WHITE").faceMatrix[i][2] = rubik.Faces.get("ORANGE").faceMatrix[i][2];
                    tempCube.Faces.get("ORANGE").faceMatrix[i][2] = rubik.Faces.get("YELLOW").faceMatrix[i][2];
                }
                break;
            case "R2":
                rotateMatrix(true, rubik.Faces.get("BLUE").faceMatrix);
                rotateMatrix(true, rubik.Faces.get("BLUE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("ORANGE").faceMatrix[i][2] = rubik.Faces.get("RED").faceMatrix[i][2];
                    tempCube.Faces.get("YELLOW").faceMatrix[i][2] = rubik.Faces.get("WHITE").faceMatrix[i][2];
                    tempCube.Faces.get("RED").faceMatrix[i][2] = rubik.Faces.get("ORANGE").faceMatrix[i][2];
                    tempCube.Faces.get("WHITE").faceMatrix[i][2] = rubik.Faces.get("YELLOW").faceMatrix[i][2];
                }
                break;
            case "L":
                rotateMatrix(true, rubik.Faces.get("GREEN").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("YELLOW").faceMatrix[i][0] = rubik.Faces.get("RED").faceMatrix[i][0];
                    tempCube.Faces.get("RED").faceMatrix[i][0] = rubik.Faces.get("WHITE").faceMatrix[i][0];
                    tempCube.Faces.get("WHITE").faceMatrix[i][0] = rubik.Faces.get("ORANGE").faceMatrix[i][0];
                    tempCube.Faces.get("ORANGE").faceMatrix[i][0] = rubik.Faces.get("YELLOW").faceMatrix[i][0];
                }
                break;
            case "LI":
                rotateMatrix(false, rubik.Faces.get("GREEN").faceMatrix);
                for(int i = 0; i<3; i++) {
                    tempCube.Faces.get("WHITE").faceMatrix[i][0] = rubik.Faces.get("RED").faceMatrix[i][0];
                    tempCube.Faces.get("ORANGE").faceMatrix[i][0] = rubik.Faces.get("WHITE").faceMatrix[i][0];
                    tempCube.Faces.get("YELLOW").faceMatrix[i][0] = rubik.Faces.get("ORANGE").faceMatrix[i][0];
                    tempCube.Faces.get("RED").faceMatrix[i][0] = rubik.Faces.get("YELLOW").faceMatrix[i][0];
                }
                break;
            case "L2":
                rotateMatrix(true, rubik.Faces.get("GREEN").faceMatrix);
                rotateMatrix(true, rubik.Faces.get("GREEN").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("ORANGE").faceMatrix[i][0] = rubik.Faces.get("RED").faceMatrix[i][0];
                    tempCube.Faces.get("YELLOW").faceMatrix[i][0] = rubik.Faces.get("WHITE").faceMatrix[i][0];
                    tempCube.Faces.get("RED").faceMatrix[i][0] = rubik.Faces.get("ORANGE").faceMatrix[i][0];
                    tempCube.Faces.get("WHITE").faceMatrix[i][0] = rubik.Faces.get("YELLOW").faceMatrix[i][0];
                }
                break;
            case "F":
                rotateMatrix(true, rubik.Faces.get("RED").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("BLUE").faceMatrix[i][0] = rubik.Faces.get("WHITE").faceMatrix[2][i];
                    tempCube.Faces.get("YELLOW").faceMatrix[0][i] = rubik.Faces.get("BLUE").faceMatrix[i][0];
                    tempCube.Faces.get("GREEN").faceMatrix[i][2] = rubik.Faces.get("YELLOW").faceMatrix[0][i];
                    tempCube.Faces.get("WHITE").faceMatrix[2][i] = rubik.Faces.get("GREEN").faceMatrix[i][2];
                }
                break;
            case "FI":
                rotateMatrix(false, rubik.Faces.get("RED").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("GREEN").faceMatrix[i][2] = rubik.Faces.get("WHITE").faceMatrix[2][i];
                    tempCube.Faces.get("WHITE").faceMatrix[2][i] = rubik.Faces.get("BLUE").faceMatrix[i][0];
                    tempCube.Faces.get("BLUE").faceMatrix[i][0] = rubik.Faces.get("YELLOW").faceMatrix[0][i];
                    tempCube.Faces.get("YELLOW").faceMatrix[0][i] = rubik.Faces.get("GREEN").faceMatrix[i][2];
                }
                break;
            case "F2":
                rotateMatrix(true, rubik.Faces.get("RED").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("YELLOW").faceMatrix[0][i] = rubik.Faces.get("WHITE").faceMatrix[2][i];
                    tempCube.Faces.get("GREEN").faceMatrix[i][2] = rubik.Faces.get("BLUE").faceMatrix[i][0];
                    tempCube.Faces.get("WHITE").faceMatrix[2][i] = rubik.Faces.get("YELLOW").faceMatrix[0][i];
                    tempCube.Faces.get("BLUE").faceMatrix[i][0] = rubik.Faces.get("GREEN").faceMatrix[i][2];
                }
                break;
            case "B":
                rotateMatrix(true, rubik.Faces.get("ORANGE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("GREEN").faceMatrix[i][0] = rubik.Faces.get("WHITE").faceMatrix[0][i];
                    tempCube.Faces.get("YELLOW").faceMatrix[2][i] = rubik.Faces.get("GREEN").faceMatrix[i][0];
                    tempCube.Faces.get("BLUE").faceMatrix[i][2] = rubik.Faces.get("YELLOW").faceMatrix[2][i];
                    tempCube.Faces.get("WHITE").faceMatrix[0][i] = rubik.Faces.get("BLUE").faceMatrix[i][2];
                }
                break;
            case "BI":
                rotateMatrix(false, rubik.Faces.get("ORANGE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("BLUE").faceMatrix[i][2] = rubik.Faces.get("WHITE").faceMatrix[0][i];
                    tempCube.Faces.get("WHITE").faceMatrix[0][i] = rubik.Faces.get("GREEN").faceMatrix[i][0];
                    tempCube.Faces.get("GREEN").faceMatrix[i][0] = rubik.Faces.get("YELLOW").faceMatrix[2][i];
                    tempCube.Faces.get("YELLOW").faceMatrix[2][i] = rubik.Faces.get("BLUE").faceMatrix[i][2];
                }
                break;
            case "B2":
                rotateMatrix(true, rubik.Faces.get("ORANGE").faceMatrix);
                rotateMatrix(true, rubik.Faces.get("ORANGE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("YELLOW").faceMatrix[2][i] = rubik.Faces.get("WHITE").faceMatrix[0][i];
                    tempCube.Faces.get("BLUE").faceMatrix[i][2] = rubik.Faces.get("GREEN").faceMatrix[i][0];
                    tempCube.Faces.get("WHITE").faceMatrix[0][i] = rubik.Faces.get("YELLOW").faceMatrix[2][i];
                    tempCube.Faces.get("GREEN").faceMatrix[i][0] = rubik.Faces.get("BLUE").faceMatrix[i][2];
                }
                break;
        }
        setCube(rubik, tempCube);
    }
    public static void rotateMatrix(Boolean clockwise, String[][] mat) {
        int x,y;
        if(clockwise) {
            for (x = 0; x < 3 / 2; x++) {
                for (y = x; y < 3 - x - 1; y++) {
                    String temp = mat[x][y];
                    mat[x][y] = mat[3 - 1 - 1][y];
                    mat[3 - 1 - y][x] = mat[3 - 1 -x][3 - 1 - y];
                    mat[3 - 1 - y][3 - 1 - y] = mat[y][3 - 1 - x];
                    mat[y][3 - 1 - y] = temp;
                }
            }
        }else{
            for (x = 0; x < 3 / 2; x++) {
                for (y = x; y < 3 - x - 1; y++) {
                    for (x = 0; x < 3 / 2; x++) {
                        for (y = x; y < 3 - x - 1; y++) {
                            String temp = mat[x][y];
                            mat[x][y] = mat[y][3 - 1 - x];
                            mat[y][3 - 1 - x] = mat[3 - 1 - x][3 - 1 - y];
                            mat[3 - 1 - x][3 - 1 - y] = mat[3 - 1 - y][x];
                            mat[3 - 1 - y][x] = temp;
                        }
                    }
                }
            }
        }
    }
    public static String findSqaure(Boolean cornerPiece, Cube Rubik, String... face){
        String[] faceNames = {"WHITE", "RED", "YELLOW", "ORANGE", "GREEN", "BLUE"};
        ArrayList<String> possibleSquares = new ArrayList<String>();
        if(cornerPiece){
            for(int faceIndex=0;faceIndex<6;faceIndex++) {
                for (int i = 0; i < 3; i = i + 2) {
                    for (int j = 0; j < 3; j = j + 2) {
                        for(String square: face) {
                            if (Rubik.Faces.get(faceNames[faceIndex]).faceMatrix[i][j].equals(square)) {
                                possibleSquares.add(faceNames[faceIndex] + "-" + square + "-" + Integer.toString(i) + "-" + Integer.toString(j));
                            }
                        }
                    }
                }
            }
        }else{

        }
        return "e";
    }
    public static void setCube(Cube oldCube, Cube newCube){
        String[] faceNames = {"WHITE", "RED", "YELLOW", "ORANGE", "GREEN", "BLUE"};
        for(int faceIndex = 0; faceIndex < 6; faceIndex++){
            for(int i = 0; i<3; i++){
                for(int j=0;j<3;j++){
                    oldCube.Faces.get(faceNames[faceIndex]).faceMatrix[i][j] = newCube.Faces.get(faceNames[faceIndex]).faceMatrix[i][j];
                }
            }
        }
    }
}
