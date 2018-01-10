package version1;

import java.net.URL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import version1.InfixInToSuffix;
/*10*(8-6)+4*/
public class version1Controller implements Initializable {
	 ArrayList<Integer> list = new ArrayList<Integer>();
	 InfixInToSuffix infixInToSuffix = new InfixInToSuffix();
	 Alert alert = new Alert(AlertType.INFORMATION);
	 
	@FXML
	private HBox hb;
   @FXML
   private Button myButton;
   @FXML
   private TextField tf;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
	   
	   for (int i = 1; i <= 52; i++) {
		      list.add(i);
		    }
	   
	    java.util.Collections.shuffle(list);
	    
	    
       // TODO (don't really need to do anything here).
	    hb.getChildren().add(new ImageView("file:card/" + list.get(0) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(1) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(2) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(3) + ".png"));
	    hb.setAlignment(Pos.CENTER);
	   

   }
   /**
    * 
    * 点击按钮btn1触发洗牌事件
    */
@FXML 
public void btn1(ActionEvent e){
	hb.getChildren().clear();
	 java.util.Collections.shuffle(list);
	  hb.getChildren().add(new ImageView("file:card/" + list.get(0) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(1) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(2) + ".png"));
	    hb.getChildren().add(new ImageView("file:card/" + list.get(3) + ".png"));
	  
}

/**
 * 点击按钮btn2触发洗牌事件计算表达式
 * 
 */
@FXML
public void btn2(ActionEvent e) {
	String text = tf.getText();
	  String a = infixInToSuffix.toSuffix(text);//传入 一串 算数公式  
	         
	          if(infixInToSuffix.dealEquation(a).equals("24.0") ) {
	        	  alert.setContentText("correct");
	          }
	          
	          else
	        	  alert.setContentText("incorrectNumbers");
	        	  
	           alert.show();
	           	           	        	
}



}