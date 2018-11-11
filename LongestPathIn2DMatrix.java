package test;

import java.util.ArrayList;
import java.util.List;

public class LongestPathIn2DMatrix {

	public static List<String> visitedlist = new ArrayList<>();
	public static int max = 0;
	
	public static void main(String[] args) {

		int[][] grid = {{4,2,4},{0,3,1},{3,7,9}};

		List<List<String>> listlist = new ArrayList<>();

		for(int i = 0; i< grid.length; i++) {
			for(int j = 0; j <grid[0].length; j++) {
				String s = i+","+j;
				visitedlist = new ArrayList<>();
				visitedlist.add(s);
				while(s != null) {
					String[] arr = s.split(",");
					s = nextValue(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), grid, visitedlist);
				}
				listlist.add(visitedlist);
			}
		}

		listlist.forEach(l ->{
			max = Math.max(l.size(), max);			
		});

		System.out.println(max);
	}
	
	public static String nextValue(int i, int j, int[][] grid, List<String> visitedlist) {

		String s = null;;

		int maxrow = grid.length-1;
		int maxcol = grid[0].length-1;

		if(Math.abs(grid[i][j] - grid[i][Math.min(j+1, maxcol)])>3) {
			if(!visitedlist.contains(i+","+Math.min(j+1, maxcol)))
				s = (i+","+Math.min(j+1, maxcol));
		}
		if(Math.abs(grid[i][j] - grid[Math.min(i+1, maxrow)][Math.min(j+1, maxcol)])>3) {
			if(!visitedlist.contains(Math.min(i+1, maxrow)+","+ Math.min(j+1, maxcol)))
				s = (Math.min(i+1, maxrow)+","+ Math.min(j+1, maxcol));
		}
		if(Math.abs(grid[i][j] - grid[Math.min(i+1, maxrow)][Math.min(j, maxcol)])>3) {
			if(!visitedlist.contains( Math.min(i+1, maxrow)+","+Math.min(j, maxcol)))
				s = ( Math.min(i+1, maxrow)+","+Math.min(j, maxcol));
		}
		if(Math.abs(grid[i][j] - grid[Math.min(i+1, maxrow)][Math.max(j-1, 0)])>3) {
			if(!visitedlist.contains(Math.min(i+1, maxrow)+","+ Math.max(j-1, 0)))
				s = (Math.min(i+1, maxrow)+","+ Math.max(j-1, 0));
		}
		if(Math.abs(grid[i][j] - grid[Math.min(i, maxrow)][Math.max(j-1, 0)])>3) {
			if(!visitedlist.contains(Math.min(i, maxrow)+","+ Math.max(j-1, 0)))
				s = (Math.min(i, maxrow)+","+ Math.max(j-1, 0));
		}
		if(Math.abs(grid[i][j] - grid[Math.max(i-1, 0)][Math.max(j-1, 0)])>3) {
			if(!visitedlist.contains( Math.max(i-1, 0)+","+Math.max(j-1, 0)))
				s = ( Math.max(i-1, 0)+","+Math.max(j-1, 0));
		}
		if(Math.abs(grid[i][j] - grid[Math.max(i-1, 0)][Math.min(j, maxcol)])>3) {
			if(!visitedlist.contains( Math.max(i-1, 0)+","+Math.min(j, maxcol)))
				s = ( Math.max(i-1, 0)+","+Math.min(j, maxcol));
		}
		if(Math.abs(grid[i][j] - grid[Math.max(i-1, 0)][Math.min(j+1, maxcol)])>3) {
			if(!visitedlist.contains( Math.max(i-1, 0)+","+Math.min(j+1, maxcol)))
				s = ( Math.max(i-1, 0)+","+Math.min(j+1, maxcol));
		}

		if(!visitedlist.contains(s) && s != null) {
			visitedlist.add(s);
		}else {
			s = null;
		}


		return s;
	}	
}
