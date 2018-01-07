package main;



import java.util.LinkedList;


public class MyStack<E> {
    private LinkedList<E> list = new LinkedList<>();

    /**
     * 灏嗛」鐩帹閫佸埌姝ゅ爢鏍堢殑椤堕儴
     * @param e
     * @return
     */
    public E push(E e){
        list.add(e);
        return e;
    }

    /**
     * 鍒犻櫎姝ゅ爢鏍堥《閮ㄧ殑瀵硅薄锛屽苟灏嗚瀵硅薄浣滀负姝ゅ嚱鏁扮殑鍊艰繑鍥�
     * @return
     */
    public E pop(){
        return list.removeLast();
    }

    /**
     * 鏌ョ湅姝ゅ爢鏍堥《閮ㄧ殑瀵硅薄锛岃�屼笉浠庡爢鏍堜腑鍒犻櫎瀹�
     * @return
     */
    public E peek(){
        return list.getLast();
    }

    /**
     * 鑾峰彇鏍堢殑澶у皬
     * @return 鏍堢殑澶у皬
     */
    public int getSize(){
        return list.size();
    }

    /**
     * 鍒ゆ柇鏍堟槸鍚︿负绌�
     * @return 鏍堟槸鍚︿负绌�
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }


}
