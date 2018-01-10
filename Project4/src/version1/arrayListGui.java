package version1;
	


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class arrayListGui extends Application {
	String ArrayListString;

	@Override
	public void start(Stage primaryStage) {

		try {
			// Read file fxml and draw interface.
			/*
			 * Parent root = FXMLLoader.load(getClass()
			 * .getResource("/version1/MainScene.fxml"));
			 * 
			 * primaryStage.setTitle("My version1"); primaryStage.setScene(new Scene(root));
			 * primaryStage.show();
			 */
			MyArrayList<Integer> ma = new MyArrayList<Integer>();
			BorderPane bp = new BorderPane();
			ma.add(1);
			ma.add(2);
			ma.add(9);
			ma.add(4);

			HBox hb1 = new HBox();
       
			HBox hb3 = new HBox();
			Pane p2 = new Pane();
			VBox  v4 = new VBox();

			Label lb1 = new Label("array list empty   size = ");
			TextField tf1 = new TextField();
			tf1.setMaxSize(40, 20);

			Label lb2 = new Label(" and capacity is ");
			TextField tf2 = new TextField();
			tf2.setMaxSize(40, 20);
			hb1.getChildren().addAll(lb1, tf1, lb2, tf2);
			int count = 20;

			tf1.setText(ma.size + "");

			tf2.setText(ma.INITIAL_CAPACITY + "");

			for (int i = 0; i < ma.INITIAL_CAPACITY; i++) {

				/*
				 * TextField tf3 = new TextField(); tf1.setMaxSize(40, 20);
				 */

				Rectangle r2 = new Rectangle(count, 30, 40, 20);

				r2.setFill(Color.WHITE);
				r2.setStroke(Color.BLACK);
				p2.getChildren().add(r2);
				count = count + 40;

			}
			
			int count2 = 180;
			for (int i = ma.size; i < ma.INITIAL_CAPACITY; i++) {
				Line l1 = new Line(count2, 30, count2 + 40, 50);
				p2.getChildren().add(l1);
				count2 = count2 + 40;
			}

			int index = 40;
			for (int i = 0; i < ma.size; i++) {
				Text text = new Text(index, 44, ma.get(i) + "");

				p2.getChildren().addAll(text);
				index = index + 40;
			}

			p2.setPadding(new Insets(50));

			Button btn1 = new Button("Search");
			Button btn2 = new Button("Insert");
			Button btn3 = new Button("Delete");
			Button btn4 = new Button("TrimToSize");

			Label lb3 = new Label("Enter a value:");
			TextField tf3 = new TextField();
			tf3.setMaxSize(40, 20);

			Label lb4 = new Label("Enter an index:");
			TextField tf4 = new TextField();
			tf4.setMaxSize(40, 20);
			/* int index2 = Integer.parseInt(tf3.getText()); */
			hb3.getChildren().addAll(lb3, tf3, lb4, tf4, btn1, btn2, btn3, btn4);

			btn1.setOnAction(e1 -> {
				String value;
				
				value = tf3.getText();
				
				int v = Integer.parseInt(value);
			

				if (ma.contains(v))
/*					System.out.println("YES,this value is in my arrayList");
*/		v4.getChildren().add(new Text("YES,this value is in my arrayList."));
					else 
				/*	System.out.println("error!!!");*/
						v4.getChildren().add(new Text("Please check the number you entered."));
			});
			
			
			btn2.setOnAction(e2->{
				p2.getChildren().clear();
				String value;
				String index2 ;
				value = tf3.getText();
				index2 = tf4.getText();
				
				int v = Integer.parseInt(value);
				int i = Integer.parseInt(index2);
				ma.add(i ,v);
				
				int count5 = 20;
				for (int j = 0; j < ma.INITIAL_CAPACITY; j++) {

					/*
					 * TextField tf3 = new TextField(); tf1.setMaxSize(40, 20);
					 */

					Rectangle r2 = new Rectangle(count5, 30, 40, 20);

					r2.setFill(Color.WHITE);
					r2.setStroke(Color.BLACK);
					p2.getChildren().add(r2);

					count5 = count5 + 40;

				}
				int count3 = 20 + ma.size * 40;
				for (int k = ma.size; k < ma.INITIAL_CAPACITY; k++) {
					Line l1 = new Line(count3, 30, count3 + 40, 50);
					p2.getChildren().add(l1);
					count3 = count3 + 40;
				}

				int index3 = 40;
				for (int a = 0; a < ma.size; a++) {
					Text text = new Text(index3, 44, ma.get(a) + "");

					p2.getChildren().addAll(text);
					index3 = index3 + 40;
				}
				
				tf1.setText(ma.size + "");
				tf2.setText(ma.INITIAL_CAPACITY + "");
				ma.trimToSize();
			});
			
			
			btn3.setOnAction(e3->{
				
				p2.getChildren().clear();
			
				String index2 ;
				
				index2 = tf4.getText();
				
			
				int i = Integer.parseInt(index2);
				ma.remove(i);
				
				
				int count5 = 20;
				for (int j = 0; j < ma.INITIAL_CAPACITY; j++) {

					/*
					 * TextField tf3 = new TextField(); tf1.setMaxSize(40, 20);
					 */

					Rectangle r2 = new Rectangle(count5, 30, 40, 20);

					r2.setFill(Color.WHITE);
					r2.setStroke(Color.BLACK);
					p2.getChildren().add(r2);

					count5 = count5 + 40;

				}
				int count3 = 20 + ma.size * 40;
				for (int k = ma.size; k < ma.INITIAL_CAPACITY; k++) {
					Line l1 = new Line(count3, 30, count3 + 40, 50);
					p2.getChildren().add(l1);
					count3 = count3 + 40;
				}

				int index3 = 40;
				for (int a = 0; a < ma.size; a++) {
					Text text = new Text(index3, 44, ma.get(a) + "");

					p2.getChildren().addAll(text);
					index3 = index3 + 40;
				}
				
				tf1.setText(ma.size + "");
				tf2.setText(ma.INITIAL_CAPACITY + "");
				
				
				
				
			});
			
			btn4.setOnAction(e4->{
				
p2.getChildren().clear();
				
			
				int count5 = 20;
				for (int j = 0; j < ma.size; j++) {

					/*
					 * TextField tf3 = new TextField(); tf1.setMaxSize(40, 20);
					 */

					Rectangle r2 = new Rectangle(count5, 30, 40, 20);

					r2.setFill(Color.WHITE);
					r2.setStroke(Color.BLACK);
					p2.getChildren().add(r2);

					count5 = count5 + 40;

				}
				/*int count3 = 20 + ma.size * 40;
				for (int k = ma.size; k < ma.INITIAL_CAPACITY; k++) {
					Line l1 = new Line(count3, 30, count3 + 40, 50);
					p2.getChildren().add(l1);
					count3 = count3 + 40;
				}*/

				int index3 = 40;
				for (int a = 0; a < ma.size; a++) {
					Text text = new Text(index3, 44, ma.get(a) + "");

					p2.getChildren().addAll(text);
					index3 = index3 + 40;
				}
				
				tf1.setText(ma.size + "");
				tf2.setText(ma.size + "");
				
								
			});

			bp.setTop(hb1);
			bp.setCenter(v4);
			bp.setBottom(hb3);
			bp.setLeft(p2);
			primaryStage.setTitle("My version1");
			primaryStage.setScene(new Scene(bp, 1000, 400));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
