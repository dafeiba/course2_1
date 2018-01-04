package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.io.*;

/*Mississippi,helloworld*/
public class CrossRiverGuiController implements Initializable {
	
	   FarmerCrossRiver model = new FarmerCrossRiver();
	   String s = "HHHH"; 

	@FXML
	private GridPane vb1;
	
	
	
	@FXML
	private Button btn;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		  
		  /*  char[] initialNode = s.toCharArray();

		 
		    java.util.List<Integer> path =
		      model.getShortestPath(FarmerCrossRiver.getIndex(initialNode));

		    System.out.println("The steps to flip the coins are ");
		   
		    
		    for (int i = 0; i < path.size(); i++)
		      FarmerCrossRiver.printNode(
		        FarmerCrossRiver.getNode(path.get(i).intValue()));  */
	}
@FXML 
public void nextStep(ActionEvent e ){
	char[] initialNode = s.toCharArray();
	  java.util.List<Integer> path =
		      model.getShortestPath(FarmerCrossRiver.getIndex(initialNode));
	 
	  for (int i = 0; i < path.size(); i++)
	  {
		  FarmerCrossRiver.printNode(
			        FarmerCrossRiver.getNode(path.get(i).intValue()));
		  HBox hb0 = new HBox();
		  HBox hb1 = new HBox();
		  vb1.add(hb0, 0, i);
			vb1.add(hb1, 1, i);
		  for(int k = 0; k < FarmerCrossRiver.getNode(path.get(i).intValue()).length;k++) {
			  
			if(FarmerCrossRiver.getNode(path.get(i).intValue())[k] == 'H'&&k == 0) {
				
			  
				
		  hb0.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue())[k])));
		  hb0.getChildren().add(new Text("农夫"));
		  
				
		  			
			}
			else if(FarmerCrossRiver.getNode(path.get(i).intValue())[k] == 'H'&&k == 1) {
			
			/*	hb0.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue())[k])));*/
				 hb0.getChildren().add(new Text("狼  "));
				}
			else if(FarmerCrossRiver.getNode(path.get(i).intValue())[k] == 'H'&&k == 2) {
				
				/*hb0.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue())[k])));*/
				 hb0.getChildren().add(new Text("羊 "));
				}
else if(FarmerCrossRiver.getNode(path.get(i).intValue())[k] == 'H'&&k == 3) {
				
				/*hb0.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue())[k])));*/
				 hb0.getChildren().add(new Text("白菜 "));
				}
else if(FarmerCrossRiver.getNode(path.get(i).intValue())[k] == 'T'&&k == 0) {
	
	/*hb1.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue())[k])));*/
	 hb1.getChildren().add(new Text("农夫 "));
	}
else if(FarmerCrossRiver.getNode(path.get(i).intValue())[k] == 'T'&&k == 1) {
	
	/*hb1.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue())[k])));*/
	 hb1.getChildren().add(new Text("狼 "));
	}
else if(FarmerCrossRiver.getNode(path.get(i).intValue())[k] == 'T'&&k == 2) {
	
	/*hb1.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue())[k])));*/
	 hb1.getChildren().add(new Text("羊 "));
	}
else if(FarmerCrossRiver.getNode(path.get(i).intValue())[k] == 'T'&&k == 3) {
	
	/*hb1.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue())[k])));*/
	 hb1.getChildren().add(new Text("白菜 "));
	}
			
		 
		 /* TextField tf = new TextField(initialNode[count] + "");
			tf.setPrefColumnCount(1);// 长和宽相等
			tf.setAlignment(Pos.CENTER);// 字居中
			gridPane.add(tf, j, i);// 为gridPane设置内容
*/			  
	   /*   FarmerCrossRiver.printNode(
	        FarmerCrossRiver.getNode(path.get(i).intValue())); */
	
	  /* vb1.getChildren().add(new Text(String.valueOf(FarmerCrossRiver.getNode(path.get(i).intValue()))));*/
			/*  vb1.getChildren().add(FarmerCrossRiver.getNode(path.get(i).intValue())[k]);*/
			 /* System.out.print(FarmerCrossRiver.getNode(path.get(i).intValue())[k]);*/
			
		  }
	   
		  
	  }
	  
	
}
	
}