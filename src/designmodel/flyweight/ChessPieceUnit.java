package designmodel.flyweight;


/**
 *  象棋的共同属性，每一个子都是不改变的。
 */

public class ChessPieceUnit {

    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color){

        this.id = id;
        this.text = text;
        this.color = color;
    }


    public static enum Color {
        RED,
        BLACK
    }

}
