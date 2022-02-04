package com.Feb2022;

class BST {
    class Node {
        int start;
        int end;
        Node leftChild;
        Node rightChild;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    public BST() {
        this.root = null;
    }

    public boolean insert(int start, int end) {

        if (this.root == null) {
            root = new Node(start, end);
            return true;
        }
        Node newNode = new Node(start, end);
        return addNode(this.root, newNode);
    }

    public boolean addNode(Node currentNode, Node newNode) {
        if (newNode.end <= currentNode.start) {
            if (currentNode.leftChild == null) {
                currentNode.leftChild = newNode;
                return true;
            } else return addNode(currentNode.leftChild, newNode);
        } else if (currentNode.end <= newNode.start) {
            if (currentNode.rightChild == null) {
                currentNode.rightChild = newNode;
                return true;
            } else return addNode(currentNode.rightChild, newNode);
        } else return false;
    }
}
public class CheckIfMeetingPossible {
    public static boolean checkMeeting(int[][] meetingTimes, int[] newMeeting){
        BST tree = new BST();
        for(int[] meeting: meetingTimes){
            tree.insert(meeting[0], meeting[1]);
        }
        return tree.insert(newMeeting[0], newMeeting[1]);
    }

    public static void main( String args[] ) {
        int[][] meetingTimes = {{1, 3}, {4, 6}, {8, 10}, {10, 12}, {13, 15}};
        int[] newMeeting = {7, 8};
        System.out.println(checkMeeting(meetingTimes, newMeeting));
        newMeeting = new int[] {9, 11};
        System.out.println(checkMeeting(meetingTimes, newMeeting));
    }

}

