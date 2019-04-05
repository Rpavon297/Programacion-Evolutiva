package Comun.Selecciones;

class Pair<Left, Right>{
	
	  private final Left left;
	  private final Right right;

	  Pair(Left left, Right right) {
	    this.left = left;
	    this.right = right;
	  }

	  Left getLeft() { return left; }
	  Right getRight() { return right; }

	  @Override
	  public int hashCode() { return left.hashCode() ^ right.hashCode(); }

	}