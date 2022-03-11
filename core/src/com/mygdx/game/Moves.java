package com.mygdx.game;

public class Moves {
    public static void Move(String movename, Cube rubik){
        Cube tempCube = new Cube();
        if(movename.equals("U")){
            rotateMatrix(rubik.Faces.get("WHITE").faceMatrix);
            for(int i = 0; i<3; i++){
                tempCube.Faces.get("GREEN").faceMatrix[1][i] = rubik.Faces.get("RED").faceMatrix[1][i];
                tempCube.Faces.get("ORANGE").faceMatrix[1][i] = rubik.Faces.get("GREEN").faceMatrix[1][i];
                tempCube.Faces.get("BLUE").faceMatrix[1][i] = rubik.Faces.get("ORANGE").faceMatrix[1][i];
                tempCube.Faces.get("RED").faceMatrix[1][i] = rubik.Faces.get("BLUE").faceMatrix[1][i];
            }
        }else if(movename.equals("UI")){

        }else if(movename.equals("U2")){

        }else if(movename.equals("D")){

        }else if(movename.equals("DI")){

        }else if(movename.equals("D2")){

        }else if(movename.equals("R")){

        }else if(movename.equals("RI")){

        }else if(movename.equals("R2")){

        }else if(movename.equals("L")){

        }else if(movename.equals("LI")){

        }else if(movename.equals("L2")){

        }else if(movename.equals("F")){

        }else if(movename.equals("FI")){

        }else if(movename.equals("F2")){

        }else if(movename.equals("B")){

        }else if(movename.equals("BI")){

        }else if(movename.equals("B2")){

        }
    }
    public static void rotateMatrix(String mat[][]) {
        for (int x = 0; x < 3 / 2; x++) {
            for (int y = x; y < 3 - x - 1; y++) {
                String temp = mat[x][y];
                mat[x][y] = mat[y][3 - 1 - x];

                mat[y][3 - 1 - x] = mat[3 - 1 - x][3 - 1 - y];

                mat[3 - 1 - x][3 - 1 - y] = mat[3 - 1 - y][x];

                mat[3 - 1 - y][x] = temp;
            }
        }
    }
    public static void setCube(Cube oldCube, Cube newCube){
        String[] faceNames = {"WHITE", "RED", "YELLOW", "ORANGE", "GREEN", "BLUE"};
        for(int faceIndex = 0; faceIndex < 6; faceIndex++){
            for(int i = 0; i<3; i++){
                for(int j=0;j<3;j++){
                    oldCube.Faces.get(faceNames[faceIndex]).faceMatrix[1][i] = newCube.Faces.get(faceNames[faceIndex]).faceMatrix[1][i];
                }
            }
        }
    }
}
