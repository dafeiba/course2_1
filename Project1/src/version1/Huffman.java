package version1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Huffman {
	private Map<Character, String> codesWithKey = new HashMap<>();//���չ���������ĳ������α�����뼰��Ӧ�ַ�
  
  
  /**Ϊ�ַ���ȡ����������
   * �˷��������ɹ������������һ��
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
  
  /* �ݹ�Ļ�ȡ���뵽Ҷ���� */
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
      // ����õ����ַ���  
      StringBuffer decodeStr = new StringBuffer();  
      // ��ý�����  
      Map<String, Character> decodeMap = getDecoder(decodeResult  
              .getLetterCode());  
      // ������������  
      Set<String> keys = decodeMap.keySet();  
      // ������ģ�������ģ��ַ���  
      String encode = decodeResult.getEncode();  
      // ����̵Ŀ�ʼƥ��֮�����ܹ��ɹ�������Ϊ�����������Ψһǰ׺����  
      // ��ʱ�Ŀ��ܵļ�ֵ  
      String temp = "";  
      // �ı�tempֵ��С���α�  
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
   * ��ý�������Ҳ����ͨ����ĸ/����Եõ�����/�ַ��ԡ� 
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
  /** �Ӵ���õ�һ�Ź������� */  
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
  
  /** �õ���ĸ���ֵĴ���*/
  public static int[] getCharacterFrequency(String text) {
    int[] counts = new int[256]; // 256 ASCII characters
    
    for (int i = 0; i < text.length(); i++)
      counts[(int)text.charAt(i)]++; // Count the character in text
    
    return counts;
  }
  
  /** ����շ���������*/
  public static class Tree implements Comparable<Tree> {
    Node root; // The root of the tree

    /** ������������һ���� */
    public Tree(Tree t1, Tree t2) {
      root = new Node();
      root.left = t1.root;
      root.right = t2.root;
      root.weight = t1.root.weight + t2.root.weight;
    }
    
    /**��������Ҷ�ڵ����*/
    public Tree(int weight, char element) {
      root = new Node(weight, element);
    }
    
    /** �������ǵ�Ȩ�رȽ���*/
    public int compareTo(Tree o) {
      if (root.weight < o.root.weight) // Purposely reverse the order
        return 1;
      else if (root.weight == o.root.weight)
        return 0;
      else
        return -1;
    }
    
  

    public class Node {
      char element; // ���ڴ洢��Ҷ�ڵ�A
      int weight; // λ�ڴ˽ڵ��������Ȩ��
      Node left; // ����������
      Node right; // ����������
      String code = ""; // ����ڵ�Ĵ�������root�û�

      /** �����սڵ� */
      public Node() {
      }
      
      /** ��������ָ��Ȩ�غ��ַ��Ľڵ�*/
      public Node(int weight, char element) {
        this.weight = weight;
        this.element = element;
      }
    }
  }  
}