package version2;

import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import version1.SixteenTailModel;
    /*HHHHHHHHHHHTHHTT测试数据*/
public class version2Gui extends Application {
	
	Scanner input = new Scanner(System.in);
	String s;
	char[] initialNode;

	SixteenTailModel model = new SixteenTailModel();
	Label lb = new Label("请输入16个T或H:");
	TextField tf1 = new TextField();
	

	java.util.List<Integer> path;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			GridPane gp = new GridPane();
			GridPane gp2 = new GridPane();
			BorderPane root = new BorderPane();
			GridPane gridPane = new GridPane();
			HBox hBox = new HBox(50);

			Button btn = new Button();
			btn.setText("solve");
			Button btn1 = new Button();
			btn1.setText("start over");

	
		btn1.setOnAction(event->{
			tf1.setText("");

		});
			/*int count = 0;

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					TextField tf = new TextField(initialNode[count] + "");
					tf.setPrefColumnCount(1);// 长和宽相等
					tf.setAlignment(Pos.CENTER);// 字居中
					gridPane.add(tf, j, i);// 为gridPane设置内容
					count++;
					tf.setFont(new Font("",12));

				}
			}
			
			*/
			
		
			
			btn.setOnMouseClicked(e -> {
				
				s = tf1.getText();
				initialNode = s.toCharArray();//
				path = model.getShortestPath(SixteenTailModel.getIndex(initialNode));
				gp.getChildren().clear();
				
				for (int k = 0; k < path.size(); k++) {
					GridPane gp1 = new GridPane();
					gp1.setPadding(new Insets(20));
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							TextField tf = new TextField(
									SixteenTailModel.getNode(path.get(k).intValue())[4 * i + j] + "");
							tf.setPrefColumnCount(1);// 长和宽相等
							tf.setAlignment(Pos.CENTER);// 字居中
							gp1.add(tf, j, i);// 为gridPane设置内容

						}
					}
					gp.add(gp1, k % 4, k / 4);
					gridPane.setVisible(false);
				}

			});
	

			hBox.getChildren().addAll(btn, btn1, lb, tf1);
			
			
			root.setCenter(gridPane);
			root.setBottom(hBox);
			root.setLeft(gp);

			Scene scene = new Scene(root, 800, 400);
			/*
			 * scene.getStylesheets().add(getClass().getResource("application.css").
			 * toExternalForm());
			 */
			primaryStage.setScene(scene);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
