package version1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class QueueController implements Initializable{
MyQueue mq = new MyQueue();

@FXML
private Button btn1;

@FXML
private Pane p;

TextField tf3 = new TextField();


@FXML
private TextField tf;

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	mq.enqueue(52);
	mq.enqueue("Tom");
	mq.enqueue("John");
	mq.enqueue("tomcat");
	
	String str = mq.toString();
	System.out.println(str);
	String str2 = str.replaceAll(" ", ""); 
	
	
	String[] s1 = str2.split("[\\[\\,\\]]");
	
	// TODO Auto-generated method stub
	Pane pane = new Pane();
	drawArrowLine(10, 20, 20, 50, pane);
	p.getChildren().add(pane);
	
	int count = 20;
	for (int j = 0; j < mq.getSize(); j++) {
		Rectangle r2 = new Rectangle(count, 50, 50, 20);
		r2.setFill(Color.WHITE);
		r2.setStroke(Color.BLACK);
		count = count + 50;
		p.getChildren().add(r2);

		Pane pane1 = new Pane();
		drawArrowLine(mq.getSize() * 50 + 40, 30, 20 + mq.getSize() * 50, 50, pane1);
		p.getChildren().add(pane1);
	}
	
	
	int count3 = 27;
	for (int i = 1; i <= mq.getSize(); i++) {
		Text t1 = new Text(count3, 65, 	s1[i] );
		p.getChildren().add(t1);
		count3 = count3 + 50;
	}
	
}

@FXML
public void Enqueue(ActionEvent e) {
	String s = tf.getText();
	mq.enqueue(s);
	p.getChildren().clear();
	
	
	String str = mq.toString();
	System.out.println(str);
	String str2 = str.replaceAll(" ", ""); 
	String[] s1 = str2.split("[\\[\\,\\]]");
	Pane pane = new Pane();
	drawArrowLine(10, 20, 20, 50, pane);
	p.getChildren().add(pane);
	
	int count = 20;
	for (int j = 0; j < mq.getSize(); j++) {
		Rectangle r2 = new Rectangle(count, 50, 50, 20);
		r2.setFill(Color.WHITE);
		r2.setStroke(Color.BLACK);
		count = count + 50;
		p.getChildren().add(r2);

		Pane pane1 = new Pane();
		drawArrowLine(mq.getSize() * 50 + 40, 30, 20 + mq.getSize() * 50, 50, pane1);
		p.getChildren().add(pane1);
	}
	
	
	int count3 = 27;
	for (int i = 1; i <= mq.getSize(); i++) {
		Text t1 = new Text(count3, 65, 	s1[i] );
		p.getChildren().add(t1);
		count3 = count3 + 50;
	}
	
	
}

@FXML 
public void Dequeue(ActionEvent e) {
	String s = tf.getText();
	mq.dequeue();
	p.getChildren().clear();
	
	
	String str = mq.toString();
	System.out.println(str);
	String str2 = str.replaceAll(" ", ""); 
	String[] s1 = str2.split("[\\[\\,\\]]");
	Pane pane = new Pane();
	drawArrowLine(10, 20, 20, 50, pane);
	p.getChildren().add(pane);
	
	int count = 20;
	for (int j = 0; j < mq.getSize(); j++) {
		Rectangle r2 = new Rectangle(count, 50, 50, 20);
		r2.setFill(Color.WHITE);
		r2.setStroke(Color.BLACK);
		count = count + 50;
		p.getChildren().add(r2);

		Pane pane1 = new Pane();
		drawArrowLine(mq.getSize() * 50 + 40, 30, 20 + mq.getSize() * 50, 50, pane1);
		p.getChildren().add(pane1);
	}
	
	
	int count3 = 27;
	for (int i = 1; i <= mq.getSize(); i++) {
		Text t1 = new Text(count3, 65, 	s1[i] );
		p.getChildren().add(t1);
		count3 = count3 + 50;
	}
	
	
}


public static void drawArrowLine(double x1, double y1, 
	      double x2, double y2, Pane pane) {
	    pane.getChildren().add(new Line(x1, y1, x2, y2));
	    
	    // find slope of this line
	    double slope = ((((double) y1) - (double) y2))
	      / (((double) x1) - (((double) x2)));

	    double arctan = Math.atan(slope);

	    // This will flip the arrow 45 off of a
	    // perpendicular line at pt x2
	    double set45 = 1.57 / 2;
	    
	    // arrows should always point towards i, not i+1
	    if (x1 < x2) {
	      // add 90 degrees to arrow lines
	      set45 = -1.57 * 1.5;
	    }

	    // set length of arrows
	    int arrlen = 15;

	    // draw arrows on line
	    pane.getChildren().add(new Line(x2, y2, (x2 + (Math.cos(arctan + set45) * arrlen)),
	      ((y2)) + (Math.sin(arctan + set45) * arrlen)));

	    pane.getChildren().add(new Line(x2, y2, (x2 + (Math.cos(arctan - set45) * arrlen)),
	      ((y2)) + (Math.sin(arctan - set45) * arrlen)));
	  }

}
