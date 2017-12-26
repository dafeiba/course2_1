package version2;

import java.net.URL;
import java.util.ResourceBundle;

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
import version2.BinaryTree.TreeNode;

public class BinaryTreeController implements Initializable {

	@FXML
	TextField Key;
	@FXML
	private Pane p;

	Alert alert = new Alert(AlertType.INFORMATION);

	BinaryTree<Integer> bt = new BinaryTree<Integer>();
	// TreeNode<Integer> root = new TreeNode<Integer>(new Integer(3));

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		bt.insert(3);
		bt.insert(4);
		bt.insert(5);
		bt.insert(2); 

	

	}

	@FXML
	public void Insert(ActionEvent e) {
		try {
			p.getChildren().clear();

			bt.insert(Integer.parseInt(Key.getText()));
			displayTree(bt.getRoot(), (int)p.getWidth() / 2, 30,  (int)p.getWidth() / 4);
		} catch (NumberFormatException e1) {

			alert.setContentText("输入不合法");
			alert.show();
		}

	}

	@FXML
	public void Search(ActionEvent e) {

		boolean s = bt.search(Integer.parseInt(Key.getText()));
		if (s) {
			alert.setContentText("搜索成功");
			alert.show();
		} else {
			alert.setContentText("搜索失败");
			alert.show();
		}

	}

	@FXML
	public void Remove(ActionEvent e) {
		try {

			if (bt.delete(Integer.parseInt(Key.getText()))) {
				p.getChildren().clear();
				alert.setContentText("删除成功");
				alert.show();
			} else {
				alert.setContentText("不在树中");
				alert.show();
			}

			displayTree(bt.getRoot(), (int)p.getWidth() / 2, 30,  (int)p.getWidth() / 4);		} catch (NumberFormatException e1) {

			alert.setContentText("输入不合法");
			alert.show();
		}

	}

	private void displayTree(BinaryTree.TreeNode root, int x, int y, int hGap) {
		// Display the root

		
		int vGap = 50;
		int radius = 15;

		Circle c1 = new Circle(x , y , radius);
		p.getChildren().add(new Text(x , y , root.element + ""));
		
		c1.setStroke(Color.BLACK);
		c1.setFill(Color.WHITE);
		c1.setOpacity(0.5);//设置透明度
		p.getChildren().add(c1);

		if (root.left != null) {
			
			// Draw a line to the left node
			// Pane pane = new Pane();
			ConnectLeftChild(p, x - hGap, y + vGap, x, y);
			// Draw the left subtree recursively

			displayTree(root.left, x - hGap, y + vGap, hGap / 2);

		}

		if (root.right != null) {
			// Draw a line to the right node
			// Pane pane1 = new Pane();
			ConnectRightChild(p, x + hGap, y + vGap, x, y);
			// Draw the right subtree recursively
			displayTree(root.right, x + hGap, y + vGap, hGap / 2);
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

	}

}
