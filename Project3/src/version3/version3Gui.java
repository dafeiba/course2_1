package version3;
/*测试数据一HTHTTHTTTHTHTHHT*//*测试数据二HHHHHHHHHHHHHHHH*/
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import version3.SixteenTailModel;

public class version3Gui extends Application {
	Scanner input = new Scanner(System.in);
	String s;
	char[] initialNode;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Button btn = new Button();
			btn.setText("solve");
			Button btn1 = new Button();
			btn1.setText("start over");
			BorderPane root = new BorderPane();
			GridPane gridPane = new GridPane();
			HBox hBox = new HBox(50);
			GridPane gp = new GridPane();
			
			
			System.out.println("请输入16个T或H");		
			 s = input.nextLine();
			 initialNode = s.toCharArray();
			
			btn1.setOnAction(event->{
				gp.getChildren().clear();
			System.out.print("请输入16个T或H");		
			 s = input.nextLine();
			 initialNode = s.toCharArray();			 
			});
			
			
root.setOnKeyPressed(event2->{
	gp.getChildren().clear();
		
	
	if(event2.getCode() == KeyCode.ENTER) {
	int count = 0;

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {

			TextField tf = new TextField(initialNode[count] + "");
			tf.setPrefColumnCount(1);// 长和宽相等
			tf.setAlignment(Pos.CENTER);// 字居中
			gridPane.add(tf, j, i);// 为gridPane设置内容
			count++;
		}

		}
	}
	
	
});
			

			/*int count = 0;

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {

					TextField tf = new TextField(initialNode[count] + "");
					tf.setPrefColumnCount(1/2);// 长和宽相等
					tf.setAlignment(Pos.CENTER);// 字居中
					gridPane.add(tf, j, i);// 为gridPane设置内容
					count++;

				}
			}
			
			root.setCenter(gridPane);*/
			
			
			
			
			btn.setOnMouseClicked(e -> {
				gp.getChildren().clear();
				gridPane.getChildren().clear();
				SixteenTailModel model = new SixteenTailModel();

				java.util.List<Integer> path = model.getShortestPath(SixteenTailModel.getIndex(initialNode));
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
					
				}

			});
		

			hBox.getChildren().addAll(btn, btn1);

			root.setBottom(hBox);
			root.setLeft(gp);
			root.setCenter(gridPane);

			Scene scene = new Scene(root, 400, 400);
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
