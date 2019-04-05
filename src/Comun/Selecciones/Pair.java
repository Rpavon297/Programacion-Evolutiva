package Comun.Selecciones;

public class Pair<Left, Right>{
	
	  private final Left left;
	  private final Right right;

	  public Pair(Left left, Right right) {
	    this.left = left;
	    this.right = right;
	  }

	  public Left getLeft() { return left; }
	  public Right getRight() { return right; }

	  @Override
	  public int hashCode() { return left.hashCode() ^ right.hashCode(); }

	}