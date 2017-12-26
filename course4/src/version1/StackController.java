package version1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class StackController implements Initializable{
	@FXML
	private Pane p;
	@FXML
	private  TextField textField;
	MyStack ms = new MyStack();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	    ms.push(84);
		ms.push(4);
		ms.push(3);
		ms.push(7);
	
		
		String s = ms.toString();
		String str2 = s.replaceAll(" ", ""); 
		
	
		String[] s1 = str2.split("[\\[\\,\\]]");
		int[] s2 = new int[s1.length ];
	
		
		
		for(int i =0;i < s1.length; i++) {
			s1[i].trim();
			if(s1[i].trim().length() != 0)
			s2[i] = Integer.parseInt(s1[i]);
			
		}
		
		
		
		
	
		
		
		
		int count = 50;
		Pane pane = new Pane();
		Text lb = new Text(100,60,"Top");
		drawArrowLine(130,60,180,60,pane);
		p.getChildren().addAll(lb,pane);
		int j = ms.getSize();
		for(int i = 0; i < ms.getSize(); i++) {								
			Rectangle r2 = new Rectangle(180, count, 40, 20);
			p.getChildren().add(r2);
			r2.setFill(Color.WHITE);
			r2.setStroke(Color.BLACK);
			
			Text t = new Text(200,count +10,s2[j]+ "");
			p.getChildren().add(t);
			count = count + 20;
			
			j = j - 1;
			
		}
		
	}
	@FXML
	public void push(ActionEvent e) {
		String tf = textField.getText();
		int text = Integer.parseInt(tf);
		ms.push(text);
		p.getChildren().clear();
		
		String s = ms.toString();
		String str2 = s.replaceAll(" ", ""); 
		
	
		String[] s1 = str2.split("[\\[\\,\\]]");
		int[] s2 = new int[s1.length ];
	
		
	
		
		for(int i =0;i < s1.length; i++) {
			s1[i].trim();
			if(s1[i].trim().length() != 0)
			s2[i] = Integer.parseInt(s1[i]);
			
		}
		
		
		
		
	
		
		
		
		int count = 50;
		Pane pane = new Pane();
		Text lb = new Text(100,60,"Top");
		drawArrowLine(130,60,180,60,pane);
		p.getChildren().addAll(lb,pane);
		int j = ms.getSize();
		for(int i = 0; i < ms.getSize(); i++) {								
			Rectangle r2 = new Rectangle(180, count, 40, 20);
			p.getChildren().add(r2);
			r2.setFill(Color.WHITE);
			r2.setStroke(Color.BLACK);
			
			Text t = new Text(200,count +10,s2[j]+ "");
			p.getChildren().add(t);
			count = count + 20;
			
			j = j - 1;
			
		}
		
	
	}
	
	@FXML
	public void pop(ActionEvent e) {
		
		ms.pop();
		p.getChildren().clear();
		
		String s = ms.toString();
		String str2 = s.replaceAll(" ", ""); 
		
	
		String[] s1 = str2.split("[\\[\\,\\]]");
		int[] s2 = new int[s1.length ];
	
		
		for(int i = 0;i <s1.length; i++)
			System.out.println(s1[i]);
		
		for(int i =0;i < s1.length; i++) {
			s1[i].trim();
			if(s1[i].trim().length() != 0)
			s2[i] = Integer.parseInt(s1[i]);
			
		}
		
		
		
		
	
		
		
		
		int count = 50;
		Pane pane = new Pane();
		Text lb = new Text(100,60,"Top");
		drawArrowLine(130,60,180,60,pane);
		p.getChildren().addAll(lb,pane);
		int j =  ms.getSize();
		for(int i = 0; i < ms.getSize(); i++) {								
			Rectangle r2 = new Rectangle(180, count, 40, 20);
			p.getChildren().add(r2);
			r2.setFill(Color.WHITE);
			r2.setStroke(Color.BLACK);
			
			Text t = new Text(200,count +10,s2[j]+ "");
			p.getChildren().add(t);
			count = count + 20;
			
			j = j - 1;
			
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
