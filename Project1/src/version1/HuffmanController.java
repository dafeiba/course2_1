package version1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import version1.Huffman.Tree;

import java.io.*;

/*Mississippi,helloworld*/
public class HuffmanController implements Initializable {
	Huffman hm = new Huffman();
	Alert alert = new Alert(AlertType.INFORMATION);

	@FXML
	private Button showHuffmanTree;

	@FXML
	private Pane p;

	@FXML
	private TextField textField1;

	@FXML
	private TextField tf2;
	int textL;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
//
	public void showHuffmanTree(ActionEvent e) throws IOException {
		
		

		p.getChildren().clear();
		String text = textField1.getText();

		int[] counts = hm.getCharacterFrequency(text);
		Tree tree = hm.getHuffmanTree(counts);
		
		StringBuffer sb = new StringBuffer();
		String[] codes = hm.getCode(tree.root);
		

		char[] ch = text.toCharArray();
		int[] as = new int[ch.length];
		
	
		for (int i = 0; i < ch.length; i++) {
			as[i] = ch[i];

		}
		
		


		alert.setContentText(text + " is encoded to " + sb);
		alert.setTitle("Encode Text to Bits");

		alert.show();

		displayTree(tree.root, (int) p.getWidth() / 2, 30, (int) p.getWidth() / 4);

	}
	
	/**
	 * 
	 * 译码
	 * 
	 */
	@FXML
	public void Decode(ActionEvent e) throws Exception {
	
		 String temp = "";
		 temp = tf2.getText();
		  temp = hm.decode(new EncodeResult(temp, hm.getCodesWithKey()));
		  System.out.println(temp);
		p.getChildren().clear();
		
		
		String text = tf2.getText();
		

		int[] counts = hm.getCharacterFrequency(text);
		Tree tree = hm.getHuffmanTree(counts);
		StringBuffer sb = new StringBuffer();
		String[] codes = hm.getCode(tree.root);
		
	}

	private void displayTree(Tree.Node root, int x, int y, int hGap) {
		// 	显示根
		String text = textField1.getText();
		int vGap = 50;
		int radius = 15;
		p.getChildren().add(new Text(x, y, root.weight + ""));
		p.getChildren().add(new Text(x, y + 25, root.element + ""));

		Circle c1 = new Circle(x, y, radius);

		c1.setStroke(Color.BLACK);
		c1.setFill(Color.WHITE);
		c1.setOpacity(0.5);// 脡猫脰脙脥赂脙梅露脠
		p.getChildren().add(c1);

		if (root.left != null) {

			// 向左节点画一条直线
		
			ConnectLeftChild(p, x - hGap, y + vGap, x, y);
			textL = textL / 2;
			// 递归地绘制左子树
			

			displayTree(root.left, x - hGap, y + vGap, hGap / 2);

		}

		if (root.right != null) {
			// 向右节点画一条直线
		
			ConnectRightChild(p, x + hGap, y + vGap, x, y);
			textL = textL - textL / 2;

			// 递归地绘制正确的子树
			displayTree(root.right, x + hGap, y + vGap, hGap / 2);
		

		}
	}

/*连接坐标为（x2,y2）的父节点和
 * 坐标为（x1,y1）的左子节点
*/
	public void ConnectLeftChild(Pane pane, int x1, int y1, int x2, int y2) {
		int radius = 15;
		int vGap = 50;
		double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
		int x11 = (int) (x1 + radius * (x2 - x1) / d);
		int y11 = (int) (y1 - radius * vGap / d);
		int x21 = (int) (x2 - radius * (x2 - x1) / d);
		int y21 = (int) (y2 + radius * vGap / d);
		pane.getChildren().add(new Line(x11, y11, x21, y21));
		pane.getChildren().add(new Text((x11 + x21) / 2 - 2, (y11 + y21) / 2 - 2, "0"));
	}
	/*连接坐标为（x2,y2）的父节点和
	 * 坐标为（x1,y1）的右子节点
	*/
	public void ConnectRightChild(Pane pane, int x1, int y1, int x2, int y2) {
		int radius = 15;
		int vGap = 50;
		double d = Math.sqrt(vGap * vGap + (x2 - x1) * (x2 - x1));
		int x11 = (int) (x1 - radius * (x1 - x2) / d);
		int y11 = (int) (y1 - radius * vGap / d);
		int x21 = (int) (x2 + radius * (x1 - x2) / d);
		int y21 = (int) (y2 + radius * vGap / d);
		pane.getChildren().add(new Line(x11, y11, x21, y21));
		pane.getChildren().add(new Text((x11 + x21) / 2, (y11 + y21) / 2, "1"));

	}

}