package edu.cg.models.Car;

import com.jogamp.opengl.GL2;

import edu.cg.models.IRenderable;
import edu.cg.models.SkewedBox;

public class Front implements IRenderable {
	// TODO: The front of the car is build from the following elements:
	private SkewedBox hoodBox1 = new SkewedBox(Specification.F_HOOD_LENGTH_1,Specification.F_HOOD_HEIGHT_1,Specification.F_HOOD_HEIGHT_2,Specification.F_HOOD_DEPTH_1,Specification.F_HOOD_DEPTH_2);
	private SkewedBox hoodBox2 = new SkewedBox(Specification.F_HOOD_LENGTH_2,Specification.F_HOOD_HEIGHT_2,Specification.F_BUMPER_HEIGHT_1,Specification.F_HOOD_DEPTH_2,Specification.F_HOOD_DEPTH_3);
	private SkewedBox bumperBox = new SkewedBox(Specification.F_BUMPER_LENGTH,Specification.F_BUMPER_HEIGHT_1,Specification.F_BUMPER_HEIGHT_2,Specification.F_BUMPER_DEPTH,Specification.F_BUMPER_DEPTH);
	private SkewedBox bumperWingsBox = new SkewedBox(Specification.F_BUMPER_LENGTH,Specification.F_BUMPER_WINGS_HEIGHT,Specification.F_BUMPER_HEIGHT_2,Specification.F_BUMPER_WINGS_DEPTH,Specification.F_BUMPER_WINGS_DEPTH);
	private PairOfWheels wheels = new PairOfWheels();


	@Override
	public void render(GL2 gl) {
		
		// definition of head position
		gl.glPushMatrix();
		gl.glTranslated(-Specification.F_HOOD_LENGTH_1 / 2, 0, 0);
		
		// hoodBox1 and hoodBox2
		Materials.SetRedMetalMaterial(gl);
		hoodBox1.render(gl);
		gl.glTranslated((Specification.F_HOOD_LENGTH_1 + Specification.F_HOOD_LENGTH_2) / 2, 0, 0);
		hoodBox2.render(gl);
		
		// bumper
		gl.glTranslated((Specification.F_HOOD_LENGTH_1) / 2 - 0.015, 0, 0);
		Materials.SetDarkRedMetalMaterial(gl);
		bumperBox.render(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		
		// wheels
		gl.glTranslated((Specification.F_HOOD_LENGTH_2 / 2 + Specification.F_HOOD_LENGTH_1) / 4, 
									Specification.TIRE_RADIUS / 2, 0);
		wheels.render(gl);
		gl.glPopMatrix();
		gl.glPushMatrix();
		
		// left wing
		Materials.SetRedMetalMaterial(gl);
		gl.glPushMatrix();
		gl.glTranslated((Specification.F_FRONT_LENGTH) / 2 - Specification.F_BUMPER_WINGS_DEPTH - 0.025, 
						0, -(Specification.F_BUMPER_DEPTH + Specification.F_BUMPER_WINGS_DEPTH) / 2);
		bumperWingsBox.render(gl);
		gl.glPopMatrix();	
		
		// right wing
		gl.glTranslated((Specification.F_FRONT_LENGTH) / 2 - Specification.F_BUMPER_WINGS_DEPTH - 0.025, 
							0, (Specification.F_BUMPER_DEPTH + Specification.F_BUMPER_WINGS_DEPTH) / 2);
		bumperWingsBox.render(gl);
		gl.glPopMatrix();
		
	}

	@Override
	public void init(GL2 gl) {
		// TODO Auto-generated method stub

	}

}
