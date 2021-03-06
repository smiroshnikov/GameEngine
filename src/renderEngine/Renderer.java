package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer {
	
	/** 
	 * Prepares the screen ? Color?  
	 */
	public void prepare(){	
		// TODO read about alpha channel ? 
		GL11.glClearColor(1, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); 	
	}
	
	public void render(RawModel model){
		
		//Binding VAO that we want to use 
		GL30.glBindVertexArray(model.getVaoID());

		// Activating attribute list for the VAO in which our data is stored , index 0 
		// Remember Loader line 31 - storeDataInAttributeList(0,positions); that our 0 position of attribute list
		GL20.glEnableVertexAttribArray(0);
		
		// OpenGL rendering , we are rendering triangular polygons ,where to start and vertex count in model  
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0 , model.getVertexCount());
		
		// Disabling attribute list 
		GL20.glDisableVertexAttribArray(0);

		// Un-binding VAO  
		GL30.glBindVertexArray(0);
		
	}
	
	

}
