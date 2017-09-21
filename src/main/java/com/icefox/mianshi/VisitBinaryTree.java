package com.icefox.mianshi;

import java.util.LinkedList;
import java.util.Queue;

public class VisitBinaryTree {
	
	
	public static void main(String[] args) {
	    BinaryTree node = new BinaryTree('A');    
        BinaryTree root = node;    
        BinaryTree nodeL1;  
        BinaryTree nodeL;  
        BinaryTree nodeR;  
        node.setLeftChild(new BinaryTree('B'));    
        node.setRightChild(new BinaryTree('C'));    
            
        nodeL1 = node.getLeftChild();    
        nodeL1.setLeftChild(new BinaryTree('D'));    
        nodeL1.setRightChild(new BinaryTree('E'));   
          
        nodeL = nodeL1.getLeftChild();    
        nodeL.setLeftChild(new BinaryTree('F'));  
          
        node = node.getRightChild();    
        node.setLeftChild(new BinaryTree('G'));    
        node.setRightChild(new BinaryTree('H'));    
          
        nodeR = node.getLeftChild();    
        nodeR.setLeftChild(new BinaryTree('I'));    
        nodeR.setRightChild(new BinaryTree('J'));   
          
        //先序
//        preOrderRecursion(root);
        
        //中序
//        OrderRecursion(root);
        
        //后序
//        postOrderRecursion(root);
        
        //层次遍历
        levelRecursion(root);
	}
	
	//先序遍历递归算法  
    public static void preOrderRecursion(BinaryTree root) {  
        if(root!=null) {  
            root.visit();  
            preOrderRecursion(root.getLeftChild());  
            preOrderRecursion(root.getRightChild());  
        }  
    }
	
    //中序遍历
    public static void OrderRecursion(BinaryTree root) {  
        if(root!=null) {  
            OrderRecursion(root.getLeftChild()); 
            root.visit();   
            OrderRecursion(root.getRightChild());  
        }  
    }

    //后序遍历
    public static void postOrderRecursion(BinaryTree root) {  
        if(root!=null) {  
            OrderRecursion(root.getLeftChild());   
            OrderRecursion(root.getRightChild());  
            root.visit(); 
        }  
    }
    
    //层次遍历
    public static void levelRecursion(BinaryTree root){
    	if(root==null) {  
    		return;
    	}
    	LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();  
    	BinaryTree current = null;
    	queue.offer(root);
    	 while(!queue.isEmpty())  
         {  
    		 current = queue.poll();//出队队头元素并访问  
    		 current.visit();
    		 if(current.getLeftChild() != null)//如果当前节点的左节点不为空入队  
             {  
                 queue.offer(current.getLeftChild());  
             } 
    		 if(current.getRightChild()!=null){
    			 queue.offer(current.getRightChild());
    		 }
         }
    }
    
}
