package com.mygdx.game;

public class Moves {
    public static void Move(String moveName, Cube rubik){
        Cube tempCube = new Cube();
        setCube(tempCube, rubik);
        switch(moveName){
            case "U":
                rotateMatrix(true, rubik.Faces.get("WHITE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("GREEN").faceMatrix[1][i] = rubik.Faces.get("RED").faceMatrix[1][i];
                    tempCube.Faces.get("ORANGE").faceMatrix[1][i] = rubik.Faces.get("GREEN").faceMatrix[1][i];
                    tempCube.Faces.get("BLUE").faceMatrix[1][i] = rubik.Faces.get("ORANGE").faceMatrix[1][i];
                    tempCube.Faces.get("RED").faceMatrix[1][i] = rubik.Faces.get("BLUE").faceMatrix[1][i];
                }
            case "UI":
                rotateMatrix(false, rubik.Faces.get("WHITE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("BLUE").faceMatrix[1][i] = rubik.Faces.get("RED").faceMatrix[1][i];
                    tempCube.Faces.get("ORANGE").faceMatrix[1][i] = rubik.Faces.get("BLUE").faceMatrix[1][i];
                    tempCube.Faces.get("GREEN").faceMatrix[1][i] = rubik.Faces.get("ORANGE").faceMatrix[1][i];
                    tempCube.Faces.get("RED").faceMatrix[1][i] = rubik.Faces.get("GREEN").faceMatrix[1][i];
                }
            case "U2":
                rotateMatrix(true, rubik.Faces.get("WHITE").faceMatrix);
                rotateMatrix(true, rubik.Faces.get("WHITE").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("ORANGE").faceMatrix[1][i] = rubik.Faces.get("RED").faceMatrix[1][i];
                    tempCube.Faces.get("BLUE").faceMatrix[1][i] = rubik.Faces.get("GREEN").faceMatrix[1][i];
                    tempCube.Faces.get("RED").faceMatrix[1][i] = rubik.Faces.get("ORANGE").faceMatrix[1][i];
                    tempCube.Faces.get("GREEN").faceMatrix[1][i] = rubik.Faces.get("BLUE").faceMatrix[1][i];
                }
            case "D":
                rotateMatrix(true, rubik.Faces.get("YELLOW").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("GREEN").faceMatrix[3][i] = rubik.Faces.get("RED").faceMatrix[3][i];
                    tempCube.Faces.get("ORANGE").faceMatrix[3][i] = rubik.Faces.get("GREEN").faceMatrix[3][i];
                    tempCube.Faces.get("BLUE").faceMatrix[3][i] = rubik.Faces.get("ORANGE").faceMatrix[3][i];
                    tempCube.Faces.get("RED").faceMatrix[3][i] = rubik.Faces.get("BLUE").faceMatrix[3][i];
                }
            case "DI":
                rotateMatrix(false, rubik.Faces.get("YELLOW").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("BLUE").faceMatrix[3][i] = rubik.Faces.get("RED").faceMatrix[3][i];
                    tempCube.Faces.get("ORANGE").faceMatrix[3][i] = rubik.Faces.get("BLUE").faceMatrix[3][i];
                    tempCube.Faces.get("GREEN").faceMatrix[3][i] = rubik.Faces.get("ORANGE").faceMatrix[3][i];
                    tempCube.Faces.get("RED").faceMatrix[3][i] = rubik.Faces.get("GREEN").faceMatrix[3][i];
                }
            case "D2":
                rotateMatrix(true, rubik.Faces.get("YELLOW").faceMatrix);
                rotateMatrix(true, rubik.Faces.get("YELLOW").faceMatrix);
                for(int i = 0; i<3; i++){
                    tempCube.Faces.get("ORANGE").faceMatrix[3][i] = rubik.Faces.get("RED").faceMatrix[3][i];
                    tempCube.Faces.get("BLUE").faceMatrix[3][i] = rubik.Faces.get("GREEN").faceMatrix[3][i];
                    tempCube.Faces.get("RED").faceMatrix[3][i] = rubik.Faces.get("ORANGE").faceMatrix[3][i];
                    tempCube.Faces.get("GREEN").faceMatrix[3][i] = rubik.Faces.get("BLUE").faceMatrix[3][i];
                }
            case "R":

            case "RI":

            case "R2":

            case "L":

            case "LI":

            case "L2":

            case "F":

            case "FI":

            case "F2":

            case "B":

            case "BI":

            case "B2":

        }
    }
    public static void rotateMatrix(Boolean clockwise, String mat[][]) {
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
