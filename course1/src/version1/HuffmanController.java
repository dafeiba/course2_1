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
import version1.Huffman;
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

	public void showHuffmanTree(ActionEvent e) throws IOException {
		
		
		java.io.File file = new java.io.File("src/version1/codeFile.txt");
		File file1 = new File("src/version1/hfmtree.txt");
			
		
		
		PrintWriter  output = new PrintWriter(file);
		PrintWriter output1 = new PrintWriter(file1);
		p.getChildren().clear();
		String text = textField1.getText();

		int[] counts = hm.getCharacterFrequency(text);
		Tree tree = hm.getHuffmanTree(counts);
		
		StringBuffer sb = new StringBuffer();
		String[] codes = hm.getCode(tree.root);
		

		char[] ch = text.toCharArray();
		int[] as = new int[ch.length];
		/*String[] codes2 = new String[ch.length];*/
		
	/*	for(int i = 0; i < codes2.length; i++) {
			System.out.println(codes2[i]);
			output.print(codes2[i]);
			
			
		}*/
	
		for (int i = 0; i < ch.length; i++) {
			as[i] = ch[i];

		}
		
		

		for (int i = 0; i < ch.length; i++) {

			sb.append(codes[as[i]]);
			output.println(codes[as[i]]);
		
		}
		output.close();

		alert.setContentText(text + " is encoded to " + sb);
		alert.setTitle("Encode Text to Bits");

		alert.show();

		displayTree(tree.root, (int) p.getWidth() / 2, 30, (int) p.getWidth() / 4);

	}
	
	
	@FXML
	public void Decode(ActionEvent e) throws Exception {
	/*	File file = new File("src/version1/codeFile.txt");
		Scanner input = new Scanner(file);*/
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
		// Display the root
		String text = textField1.getText();
		int vGap = 50;
		int radius = 15;
		p.getChildren().add(new Text(x, y, root.weight + ""));
		p.getChildren().add(new Text(x, y + 25, root.element + ""));

		Circle c1 = new Circle(x, y, radius);

		c1.setStroke(Color.BLACK);
		c1.setFill(Color.WHITE);
		c1.setOpacity(0.5);// ÉèÖÃÍ¸Ã÷¶È
		p.getChildren().add(c1);

		if (root.left != null) {

			// Draw a line to the left node
			// Pane pane = new Pane();
			ConnectLeftChild(p, x - hGap, y + vGap, x, y);
			textL = textL / 2;
			// Draw the left subtree recursively
			/* p.getChildren().add(new Text(x - hGap, y + vGap, textL+"")); */

			displayTree(root.left, x - hGap, y + vGap, hGap / 2);

		}

		if (root.right != null) {
			// Draw a line to the right node
			// Pane pane1 = new Pane();
			ConnectRightChild(p, x + hGap, y + vGap, x, y);
			textL = textL - textL / 2;

			// Draw the right subtree recursively
			displayTree(root.right, x + hGap, y + vGap, hGap / 2);
			/* p.getChildren().add(new Text(x + hGap, y + vGap, root.weight+"")); */

		}
	}

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