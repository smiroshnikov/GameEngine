package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();		
		DisplayManager.createDisplay();

		float[] vertices = { 
							 // Left bottom triangle
							 -0.5f, 0.5f, 0f,
							 -0.5f, -0.5f, 0f, 
							 0.5f, -0.5f, 0f, 
							 // Right bottom triangle							 
							 0.5f, -0.5f, 0f, 
							 0.5f, 0.5f, 0f, 
							 -0.5f, 0.5f, 0f
		};
		
		RawModel model = loader.loadToVAO(vertices);
		
		while(!Display.isCloseRequested()){
			
			renderer.prepare();
			// game logic 
			renderer.render(model);
			DisplayManager.updateDisplay();	
		}
		
		loader.cleanUP();
		DisplayManager.closeDisplay();

	}

}
