package designmodel.flyweight;


import java.util.HashMap;
import java.util.Map;

/**
 *  棋局定义。
 *
 *  每一个 棋子定义中引用一个享元。
 *
 */

public class ChessBord {

    private final Map<Integer, ChessPiece> chessPieces = new HashMap<>();

    public ChessBord() {

        ChessPieceUnit chessPiece = ChessPieceUnitFactory.getChessPiece(1);

    }

    private void init(){

    chessPieces.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0,0));
    chessPieces.put(2, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 1,0));
    //...省略摆放其他棋子的代码...


    }
}
