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
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class LinkedListController implements Initializable{

MyLinkedList<Integer> mlk = new   MyLinkedList<Integer>();
@FXML
private Pane p1;
@FXML
private TextField value;
@FXML
private VBox vb;
@FXML
private TextField index;





	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mlk.add(0, 225);
		mlk.add(1, 22);
		Pane pane = new Pane();

		drawArrowLine(10, 20, 20, 50, pane);
		p1.getChildren().add(pane);
		/*
		 * Rectangle r2 = new Rectangle(20, 50, 40, 20); r2.setFill(Color.WHITE);
		 * r2.setStroke(Color.BLACK); drawArrowLine(x1, y1, x2, y2, pane);
		 * p1.getChildren().add(pane); p1.getChildren().add(r2);
		 * 
		 * Pane pane1 = new Pane(); drawArrowLine(60,60,80,60,pane1);
		 * p1.getChildren().add(pane1); Rectangle r3 = new Rectangle(80, 50, 40, 20);
		 * p1.getChildren().add(r3); r3.setFill(Color.WHITE); r3.setStroke(Color.BLACK);
		 */
		int count = 20;
		for (int i = 0; i < mlk.size; i++) {
			Rectangle r2 = new Rectangle(count, 50, 30, 20);
			r2.setFill(Color.WHITE);
			r2.setStroke(Color.BLACK);
			count = count + 80;
			p1.getChildren().add(r2);

		}

		int count1 = 60;
		for (int i = 0; i < mlk.size - 1; i++) {

			Pane pane1 = new Pane();
			drawArrowLine(count1, 60, count1 + 40, 60, pane1);
			count1 = count1 + 80;
			p1.getChildren().add(pane1);

		}

		int count2 = 50;
		for (int i = 0; i < mlk.size; i++) {
			Rectangle r2 = new Rectangle(count2, 50, 15, 20);
			r2.setFill(Color.WHITE);
			r2.setStroke(Color.BLACK);
			count2 = count2 + 80;
			p1.getChildren().add(r2);

		}
		Pane pane1 = new Pane();
		drawArrowLine(60 + (mlk.size - 1) * 80, 20, 20 + (mlk.size - 1) * 80, 50, pane1);
		p1.getChildren().add(pane1);

		int count3 = 27;
		for (int i = 0; i < mlk.size; i++) {
			Text t1 = new Text(count3, 65, mlk.get(i) + "");
			p1.getChildren().add(t1);
			count3 = count3 + 80;
		}

		/*
		 * p1.getChildren().add(tf3);
		 */

	}

	@FXML
	public void Search(ActionEvent e) {
		if (value.getText().equals("") != true) {
			String va = value.getText();

			int v = Integer.parseInt(va);
			if (mlk.contains(v)) {
				Text t = new Text("true");
				vb.getChildren().add(t);

			} else {
				Text t3 = new Text("false");
				vb.getChildren().add(t3);
			}
		}

		else {
			
		Text t4 = new Text("请输入一个value：");
		vb.getChildren().add(t4);
		}
		
	}
	
	@FXML
	public void Insert(ActionEvent e) {
	
		p1.getChildren().clear();
		if (value.getText().equals("") != true && index.getText().equals("")!=true) {
			String va = value.getText();
			int v = Integer.parseInt(va);
			String in = index.getText();
			int i = Integer.parseInt(in);
		
			mlk.add(i, v);
		
			Pane pane = new Pane();
			double x1 = 10;
			double y1 = 20;
			double x2 = 20;
			double y2 = 50;
			drawArrowLine(x1, y1, x2, y2, pane);
			p1.getChildren().add(pane);
			
			int count = 20;
			for (int j = 0; j <  mlk.size; j++) {
				Rectangle r2 = new Rectangle(count, 50, 30, 20);
				r2.setFill(Color.WHITE);
				r2.setStroke(Color.BLACK);
				count = count + 80;
				p1.getChildren().add(r2);

			}

			int count1 = 60;
			for (int j = 0; j <  mlk.size - 1; j++) {

				Pane pane1 = new Pane();
				drawArrowLine(count1, 60, count1 + 40, 60, pane1);
				count1 = count1 + 80;
				p1.getChildren().add(pane1);

			}

			int count2 = 50;
			for (int j = 0; j < mlk.size; j++) {
				Rectangle r2 = new Rectangle(count2, 50, 15, 20);
				r2.setFill(Color.WHITE);
				r2.setStroke(Color.BLACK);
				count2 = count2 + 80;
				p1.getChildren().add(r2);
				
			}
			

			int count3 = 27;
			for (int j = 0; j < mlk.size; j++) {
				Text t1 = new Text(count3, 65, mlk.get(j) + "");
				p1.getChildren().add(t1);
				count3 = count3 + 80;
			}
			Pane pane1 = new Pane();
			drawArrowLine( 60 + (mlk.size - 1) * 80, 20,20 + (mlk.size - 1) * 80, 50 ,pane1);
			p1.getChildren().add(pane1);
		}
		else {
			Text t4 = new Text("请输入一个value 和一个Index：");
			vb.getChildren().add(t4);
		}
			
			
		}

@FXML
public void Delete(ActionEvent e) {
	p1.getChildren().clear();
	if ( index.getText().equals("")!=true) {		
		String in = index.getText();
		int i = Integer.parseInt(in);
	
		mlk.remove(i);
		System.out.println(mlk.get(i));
		Pane pane = new Pane();
		double x1 = 10;
		double y1 = 20;
		double x2 = 20;
		double y2 = 50;
		drawArrowLine(x1, y1, x2, y2, pane);
		p1.getChildren().add(pane);
		
		int count = 20;
		for (int j = 0; j < mlk.size; j++) {
			Rectangle r2 = new Rectangle(count, 50, 30, 20);
			r2.setFill(Color.WHITE);
			r2.setStroke(Color.BLACK);
			count = count + 80;
			p1.getChildren().add(r2);

		}

		int count1 = 60;
		for (int j = 0; j < mlk.size - 1; j++) {

			Pane pane1 = new Pane();
			drawArrowLine(count1, 60, count1 + 40, 60, pane1);
			count1 = count1 + 80;
			p1.getChildren().add(pane1);

		}

		int count2 = 50;
		for (int j = 0; j < mlk.size; j++) {
			Rectangle r2 = new Rectangle(count2, 50, 15, 20);
			r2.setFill(Color.WHITE);
			r2.setStroke(Color.BLACK);
			count2 = count2 + 80;
			p1.getChildren().add(r2);
		}
		

		int count3 = 27;
		for (int j = 0; j < mlk.size; j++) {
			Text t1 = new Text(count3, 65, mlk.get(j) + "");
			p1.getChildren().add(t1);
			count3 = count3 + 80;
		}
		Pane pane1 = new Pane();
		drawArrowLine( 60 + (mlk.size - 1) * 80, 20,20 + (mlk.size - 1) * 80, 50 ,pane1);
		p1.getChildren().add(pane1);
	}
	else {
		Text t4 = new Text("请输入一个value 和一个Index：");
		vb.getChildren().add(t4);
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
