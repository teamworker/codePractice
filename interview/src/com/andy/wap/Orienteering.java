package com.andy.wap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @date May 24, 2014--10:10:54 PM
 * @author Andy
 */
public class Orienteering {
	enum State {
		Unvisited, Visited, Visiting;
	} 
	
	public static void main(String[] args) {
		//TODO: Implement your program
		char[][] map = Utils.readMap();
	}
	
	/**
	 * �������·��
	 * 
	 * ����������ж��ظ����ֱ���ж�ʮ�ֺ�ʱ������һ������ϣ�����Ż�ʱ�临�Ӷȡ� ��֤��������������ĸ�������֮ǰ����������һЩ��Լ򵥵Ĺ���
	 * ���������㷨��ͼG =(V,E)֮�ϵ�����ʱ�䡣
	 * �ڳ�ʼ������û���κν���ֱ���Ϊ��ɫ����˵�12�еĲ��Ա�֤ÿ���������ֻ�ܽ������һ�Σ��������ֻ�ܵ�������һ�� ����Ӻͳ��Ӳ�����ҪO
	 * (1)��ʱ�䣬��˶��в�����ռ�õ�ȫ��ʱ��ΪO(V)����Ϊֻ�е�ÿ�����㽫����������ʱ�Ż�������ڽӱ?���ÿ��������ڽӱ����౻ɨ��һ��
	 * ����Ϊ�����ڽӱ�ĳ��Ⱥ�ΪQ
	 * (E)������ɨ�������ڽӱ����ʱ������ΪO(E)����ʼ�������Ŀ���ΪO(V)����˹��BFS��ȫ������ʱ��ΪO(V+E
	 * )���ɴ˿ɼ�����������������ʱ����ͼ���ڽӱ��С��һ�����Ժ���
	 * 
	 * @return
	 */
	private static int shortestPath(char[][] map) {

		Node node = new Node(0, 0, 0);
		int[][] visit = null;
		int[][] stepArr = null;
		int[][] mazeArr = null;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node newNode = queue.poll();

			visit[newNode.x][newNode.y] = 1;
			for (int i = 0; i < 4; i++) {

				int x = newNode.x + stepArr[i][0];
				int y = newNode.y + stepArr[i][1];
				int n = 0;
				if (x == n - 1 && y == n - 1) {
					return newNode.step + 1;
				}

				if (x >= 0 && y >= 0 && x < n && y < n && visit[x][y] == 0
						&& mazeArr[x][y] == 0) {
					Node next = new Node(x, y, newNode.step + 1);
					queue.add(next);
				}
			}
		}
		return -1;
	}

	private static class Node {
		private int x;
		private int y;
		private int step;

		public Node(int x, int y, int step) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
		}

	}
}
