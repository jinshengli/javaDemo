package designmodel.flyweight;

public class ChessPiece {

    ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit chessPieceUnit, int positionX, int positionY) {
        this.chessPieceUnit = chessPieceUnit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY(){
        return positionY;
    }

    public void setPositionX(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
