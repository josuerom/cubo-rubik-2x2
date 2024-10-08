package mundo;

import java.awt.Color;

public class Cube {
    private Color fro, der, pos, izq, sup, inf;

    public Cube() {
        fro = Color.BLUE;
        der = Color.ORANGE;
        pos = Color.GREEN;
        izq = Color.RED;
        sup = Color.WHITE;
        inf = Color.YELLOW;
    }

    public Color getFro() { return fro; }
    public void setFro(Color fro) { this.fro = fro; }
    public Color getDer() { return der; }
    public void setDer(Color der) { this.der = der; }
    public Color getPos() { return pos; }
    public void setPos(Color pos) { this.pos = pos; }
    public Color getIzq() { return izq; }
    public void setIzq(Color izq) { this.izq = izq; }
    public Color getSup() { return sup; }
    public void setSup(Color sup) { this.sup = sup; }
    public Color getInf() { return inf; }
    public void setInf(Color inf) { this.inf = inf; }

    public void hor() {
        Color aux = fro;
        fro = izq;
        izq = pos;
        pos = der;
        der = aux;
    }

    public void ver() {
        Color aux = fro;
        fro = sup;
        sup = pos;
        pos = inf;
        inf = aux;
    }

    public void tra() {
        Color aux = sup;
        sup = izq;
        izq = inf;
        inf = der;
        der = aux;
    }

    public Cube clone() {
        Cube cloneCube = new Cube();
        cloneCube.fro = this.fro;
        cloneCube.der = this.der;
        cloneCube.pos = this.pos;
        cloneCube.izq = this.izq;
        cloneCube.sup = this.sup;
        cloneCube.inf = this.inf;
        return cloneCube;
    }
}