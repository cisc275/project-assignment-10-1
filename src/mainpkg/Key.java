package mainpkg;

public class Key {
	
	public boolean isDown;
	public static Key enter = new Key();
	public static Key up = new Key();
	public static Key left = new Key();
	public static Key right = new Key();
	public static Key down = new Key();
	public static Key space = new Key();
	
	public void toggle() {
		isDown = !isDown;
	}
}