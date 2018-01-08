package version1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Huffman {
	private Map<Character, String> codesWithKey = new HashMap<>();//按照哈夫曼编码的长度依次保存编码及对应字符
  
  
  /**为字符获取霍夫曼编码
   * 此方法在生成哈夫曼树后调用一次
   */
  public Map<Character, String> getCodesWithKey() {
      return codesWithKey;
  }

  public void setCodesWithKey(Map<Character, String> codesWithKey) {
      this.codesWithKey = codesWithKey;
  }
  public static String[] getCode(Tree.Node root) {
    if (root == null) return null;    
    String[] codes = new String[2 * 128];
    assignCode(root, codes);
    return codes;
  }
  
  /* 递归的获取代码到叶子上 */
  private static void assignCode(Tree.Node root, String[] codes) {
    if (root.left != null) {
      root.left.code = root.code + "0";
      assignCode(root.left, codes);
      
      root.right.code = root.code + "1";
      assignCode(root.right, codes);
    }
    else {
      codes[(int)root.element] = root.code;
    }
  }
  public String decode(EncodeResult decodeResult) {  
      // 解码得到的字符串  
      StringBuffer decodeStr = new StringBuffer();  
      // 获得解码器  
      Map<String, Character> decodeMap = getDecoder(decodeResult  
              .getLetterCode());  
      // 解码器键集合  
      Set<String> keys = decodeMap.keySet();  
      // 待解码的（被编码的）字符串  
      String encode = decodeResult.getEncode();  
      // 从最短的开始匹配之所以能够成功，是因为哈夫曼编码的唯一前缀性质  
      // 临时的可能的键值  
      String temp = "";  
      // 改变temp值大小的游标  
      int i = 1;  
      while (encode.length() > 0) {  
          temp = encode.substring(0, i);  
          if (keys.contains(temp)) {  
              Character character = decodeMap.get(temp);  
              decodeStr.append(character);  
              encode = encode.substring(i);  
              i = 1;  
          } else {  
              i++;  
          }  
      }  
      return decodeStr.toString();  
  }  

  /** 
   * 获得解码器，也就是通过字母/编码对得到编码/字符对。 
   *  
   * @param letterCode 
   * @return 
   */  
  private Map<String, Character> getDecoder(Map<Character, String> letterCode) {  
      Map<String, Character> decodeMap = new HashMap<String, Character>();  
      Set<Character> keys = letterCode.keySet();  
      for (Character key : keys) {  
          String value = letterCode.get(key);  
          decodeMap.put(value, key);  
      }  
      return decodeMap;  
  }  
  /** 从代码得到一颗哈夫曼树 */  
  public static Tree getHuffmanTree(int[] counts) {
    // Create a heap to hold trees
    Heap<Tree> heap = new Heap<Tree>(); // Defined in Listing 24.10
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0)
        heap.add(new Tree(counts[i], (char)i)); // A leaf node tree
    }
    
    while (heap.getSize() > 1) { 
      Tree t1 = heap.remove(); // Remove the smallest weight tree
      Tree t2 = heap.remove(); // Remove the next smallest weight 
      heap.add(new Tree(t1, t2)); // Combine two trees
    }

    return heap.remove(); // The final tree
  }
  
  /** 得到字母出现的次数*/
  public static int[] getCharacterFrequency(String text) {
    int[] counts = new int[256]; // 256 ASCII characters
    
    for (int i = 0; i < text.length(); i++)
      counts[(int)text.charAt(i)]++; // Count the character in text
    
    return counts;
  }
  
  /** 定义赫夫曼编码树*/
  public static class Tree implements Comparable<Tree> {
    Node root; // The root of the tree

    /** 两个子树创建一棵树 */
    public Tree(Tree t1, Tree t2) {
      root = new Node();
      root.left = t1.root;
      root.right = t2.root;
      root.weight = t1.root.weight + t2.root.weight;
    }
    
    /**创建包含叶节点的树*/
    public Tree(int weight, char element) {
      root = new Node(weight, element);
    }
    
    /** 根据它们的权重比较树*/
    public int compareTo(Tree o) {
      if (root.weight < o.root.weight) // Purposely reverse the order
        return 1;
      else if (root.weight == o.root.weight)
        return 0;
      else
        return -1;
    }
    
  

    public class Node {
      char element; // 用于存储在叶节点A
      int weight; // 位于此节点的子树的权重
      Node left; // 引用左子树
      Node right; // 引用右子树
      String code = ""; // 这个节点的代码来自root用户

      /** 创建空节点 */
      public Node() {
      }
      
      /** 创建具有指定权重和字符的节点*/
      public Node(int weight, char element) {
        this.weight = weight;
        this.element = element;
      }
    }
  }  
}