package mundo;

import gfutria.Logic;
import java.awt.Color;

public class Rubik extends Logic {
    private Cube[][][] rubik;

    public Rubik() {
        rubik = new Cube[2][2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    rubik[i][j][k] = new Cube();
            }
        }
    }

    public void h0() {
        Cube aux = rubik[0][0][0];
        rubik[0][0][0] = rubik[0][1][0];
        rubik[0][1][0] = rubik[0][1][1];
        rubik[0][1][1] = rubik[0][0][1];
        rubik[0][0][1] = aux;

        rubik[0][0][0].hor();
        rubik[0][1][0].hor();
        rubik[0][1][1].hor();
        rubik[0][0][1].hor();
    }

    public void h1() {
        Cube aux = rubik[1][0][0];
        rubik[1][0][0] = rubik[1][1][0];
        rubik[1][1][0] = rubik[1][1][1];
        rubik[1][1][1] = rubik[1][0][1];
        rubik[1][0][1] = aux;

        rubik[1][0][0].hor();
        rubik[1][1][0].hor();
        rubik[1][1][1].hor();
        rubik[1][0][1].hor();
    }

    public void v0() {
        Cube aux = rubik[0][0][0];
        rubik[0][0][0] = rubik[0][0][1];
        rubik[0][0][1] = rubik[1][0][1];
        rubik[1][0][1] = rubik[1][0][0];
        rubik[1][0][0] = aux;

        rubik[0][0][0].ver();
        rubik[0][0][1].ver();
        rubik[1][0][1].ver();
        rubik[1][0][0].ver();
    }

    public void v1() {
        Cube aux = rubik[0][1][0];
        rubik[0][1][0] = rubik[0][1][1];
        rubik[0][1][1] = rubik[1][1][1];
        rubik[1][1][1] = rubik[1][1][0];
        rubik[1][1][0] = aux;

        rubik[0][1][0].ver();
        rubik[0][1][1].ver();
        rubik[1][1][1].ver();
        rubik[1][1][0].ver();
    }

    public void t0() {
        Cube aux = rubik[0][0][0];
        rubik[0][0][0] = rubik[0][0][1];
        rubik[0][0][1] = rubik[1][0][1];
        rubik[1][0][1] = rubik[1][1][1];
        rubik[1][1][1] = aux;

        rubik[0][0][0].tra();
        rubik[0][0][1].tra();
        rubik[1][0][1].tra();
        rubik[1][1][1].tra();
    }

    public void t1() {
        Cube aux = rubik[0][1][0];
        rubik[0][1][0] = rubik[0][1][1];
        rubik[0][1][1] = rubik[1][1][1];
        rubik[1][1][1] = rubik[1][1][0];
        rubik[1][1][0] = aux;

        rubik[0][1][0].tra();
        rubik[0][1][1].tra();
        rubik[1][1][1].tra();
        rubik[1][1][0].tra();
    }

    public static String colorCube(Color c) {
        if (c == Color.BLUE)   return "B";
        if (c == Color.ORANGE) return "O";
        if (c == Color.GREEN)  return "G";
        if (c == Color.RED)    return "R";
        if (c == Color.WHITE)  return "W";
        return "Y";
    }

    @Override
    public Logic cloneObject(Logic logic) {
        Rubik objRubik = (Rubik) logic;
        Rubik cloneObjRubik = new Rubik();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    cloneObjRubik.rubik[i][j][k] = objRubik.rubik[i][j][k].clone();
            }
        }
        return cloneObjRubik;
    }

    @Override
    public String state() {
        // System.out.println(
        //     colorCube(rubik[0][0][1].getSup()) + colorCube(rubik[0][1][1].getSup()) + "\n" +
        //     colorCube(rubik[0][0][0].getSup()) + colorCube(rubik[0][1][0].getSup()) + "\n" +
        //     colorCube(rubik[0][0][1].getIzq()) + colorCube(rubik[0][0][0].getIzq()) + "-" + colorCube(rubik[0][0][0].getFro()) + colorCube(rubik[0][1][0].getFro()) + "-" + colorCube(rubik[0][1][0].getDer()) + colorCube(rubik[0][1][1].getDer()) + "-" + colorCube(rubik[0][1][1].getPos()) + colorCube(rubik[0][0][1].getPos()) + "\n" +
        //     colorCube(rubik[1][0][1].getIzq()) + colorCube(rubik[1][0][0].getIzq()) + "-" + colorCube(rubik[1][0][0].getFro()) + colorCube(rubik[1][1][0].getFro()) + "-" + colorCube(rubik[1][1][0].getDer()) + colorCube(rubik[1][1][1].getDer()) + "-" + colorCube(rubik[1][1][1].getPos()) + colorCube(rubik[1][0][1].getPos()) + "\n" +
        //     colorCube(rubik[1][0][0].getInf()) + colorCube(rubik[1][1][0].getInf()) + "\n" +
        //     colorCube(rubik[1][0][1].getInf()) + colorCube(rubik[1][1][1].getInf()) + "\n" +
        //     "-----------"
        // );
        return
            colorCube(rubik[0][0][1].getSup()) + colorCube(rubik[0][1][1].getSup()) +
            colorCube(rubik[0][0][0].getSup()) + colorCube(rubik[0][1][0].getSup()) +
            colorCube(rubik[0][0][1].getIzq()) + colorCube(rubik[0][0][0].getIzq()) + colorCube(rubik[0][0][0].getFro()) + colorCube(rubik[0][1][0].getFro()) + colorCube(rubik[0][1][0].getDer()) + colorCube(rubik[0][1][1].getDer()) +  colorCube(rubik[0][1][1].getPos()) + colorCube(rubik[0][0][1].getPos()) +
            colorCube(rubik[1][0][1].getIzq()) + colorCube(rubik[1][0][0].getIzq()) + colorCube(rubik[1][0][0].getFro()) + colorCube(rubik[1][1][0].getFro()) + colorCube(rubik[1][1][0].getDer()) + colorCube(rubik[1][1][1].getDer()) +  colorCube(rubik[1][1][1].getPos()) + colorCube(rubik[1][0][1].getPos()) +
            colorCube(rubik[1][0][0].getInf()) + colorCube(rubik[1][1][0].getInf()) +
            colorCube(rubik[1][0][1].getInf()) + colorCube(rubik[1][1][1].getInf());
    }

    @Override
    public void action(int i) {
        switch (i) {
            case 1 -> h0();
            case 2 -> h1();
            case 3 -> v0();
            case 4 -> v1();
            case 5 -> t0();
            case 6 -> t1();
        }
    }
}