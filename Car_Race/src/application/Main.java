package application; 
import javafx.animation.AnimationTimer; 
import javafx.application.Application; 
import javafx.stage.Stage; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.canvas.Canvas; 
import javafx.scene.canvas.GraphicsContext; 
import javafx.scene.image.Image; 



	public class Main extends Application { 
		public static void main(String[] args) 
		{ 
			launch(args); 
		} 

		@Override 

		public void start(Stage theStage) 

		{ 

			theStage.setTitle( "AnimatedImage Example" ); 
			Group root = new Group(); 
			Scene theScene = new Scene( root ); 
			theStage.setScene( theScene ); 

			Canvas canvas = new Canvas( 500, 600 ); 
			root.getChildren().add( canvas ); 

			GraphicsContext gc = canvas.getGraphicsContext2D(); 

			Image car = new Image( "car.jpg" ); 

			AnimatedImage road = new AnimatedImage(); 
			Image[] imageArray = new Image[18]; 
			for(int i=1;i<5;i++) { 
				imageArray[i] = new Image("road"+i+".png"); 
			} 
			road.frames = imageArray; 
			road.duration = 1; 
			
			final long startNanoTime = System.nanoTime(); 
			new AnimationTimer() 
			{ 
				public void handle(long currentNanoTime) 
				{ 
					double t = (currentNanoTime - startNanoTime) / 100000000.0; 
					
					gc.drawImage(road.getFrame(t), 0, 0); 
					gc.drawImage( car, 150, 240); 

					

				} 
			}.start(); 
			theStage.show(); 
		} 

}