//N Queen Problem

import java.util.Scanner;

class NQueenProblem {
	//printing of chase board
    public static void printChaseBord(char[][] board)
    {
    	int n=board.length;
    	System.out.println("----------------------------------------");
    	for(int i=0; i<n; i++)
    	{
    		for(int j=0; j<n; j++)
    		{
    			System.out.print(" | "+board[i][j]+" | ");
    		}
    		System.out.println();
    		System.out.println();
    	}
    	System.out.println("----------------------------------------");
    	
    }
    public static void nQueen(char[][] board, int row)
    {
    	if(row==board.length)
    	{
    		printChaseBord(board);
    		return;
    	}
    	int n=board.length;
    	for(int j=0; j<n; j++)
    	{
    		if(isSafe(board,row,j))
    		{
    			board[row][j]='Q';
    			nQueen(board, row+1);//recursion
    			board[row][j]=' ';//backTracking
    		}
    	}
    	
    }
    public static boolean isSafe(char[][] board,int rows,int cols)
    {
    	//in row chake
    	int n=board.length;
    	for(int i=0; i<n; i++)
    	{
    		if(board[i][cols]=='Q')
    		{
    			return false;
    		}
    	}
    	//in col chake
    	for(int j=0; j<n; j++)
    	{
    		if(board[rows][j]=='Q')
    		{
    			return false;
    		}
    	}
    	//upper left chake
    	int i=rows;
    	int j=cols;
    	while(i>=0 && j>=0)
    	{
    		if(board[i][j]=='Q')
    		{
    			return false;
    		}
    		i--;
    		j--;
    	}
    	//upper right chake
    	i=rows;
    	j=cols;
    	while(i>=0 && j<n)
    	{
    		if(board[i][j]=='Q')
    		{
    			return false;
    		}
    		i--;
    		j++;
    	}
    	//lower left chake
    	i=rows;
    	j=cols;
    	while(i<n && j>=0)
    	{
    		if(board[i][j]=='Q')
    		{
    			return false;
    		}
    		i++;
    		j--;
    	}
    	//lower right chake
    	i=rows;
    	j=cols;
    	while(i<n && j<n)
    	{
    		if(board[i][j]=='Q')
    		{
    			return false;
    		}
    		i++;
    		j++;
    	}
    	return true;
    }
	public static void main(String[] args) {
		   Scanner sc=new Scanner(System.in);
		   System.out.println("Enter the length of the board");
		   int n=sc.nextInt();
	       char[][] board=new char[n][n];
	       for(int i=0; i<n; i++)
	    	{
	    		for(int j=0; j<n; j++)
	    		{
	    			board[i][j]=' ';
	    		}
	    	}
	       nQueen(board,0);	       
	}

}
