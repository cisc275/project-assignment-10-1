package mainpkg;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public enum Scenes implements java.io.Serializable{
	SCENE1,
	SCENE2,
	SCENE3;
	
	ArrayList<BufferedImage> gameOneImages = new ArrayList<BufferedImage>();
	ArrayList<BufferedImage> gameTwoImages = new ArrayList<BufferedImage>();
	ArrayList<BufferedImage> gameThreeImages = new ArrayList<BufferedImage>();
	
}


