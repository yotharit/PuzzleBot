package project;

import java.util.Scanner;

public class Puzzle {

	private static double plotedCoX = 1;
	private static double plotedCoY = 1;

	public static void drawPuzzle(double size) {
		double length = 1 / size;
		double x = 1 / size;
		double y = 1 / size;
		while (x != 1) {
			while (y != 1) {
				StdDraw.square(x, y, length);
				y += length;
			}
			y = length;
			x += length;
		}
	}

	public static void plotPoint(double size) {
		double length = 1 / size;
		double plot = (length / 2);
		plotedCoX = plot;
		plotedCoY = plot;
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledSquare(plot, plot, (length / 2));
	}

	public static void drawLShapeLL(double xCo, double yCo, double size) {
		double length = (1 / size);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledSquare(xCo, yCo, (length / 2));
		StdDraw.filledSquare(xCo, yCo + length, (length / 2));
		StdDraw.filledSquare(xCo + length, yCo, (length / 2));
	}

	public static void drawLShapeLT(double xCo, double yCo, double size) {
		double length = (1 / size);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledSquare(xCo, yCo, (length / 2));
		StdDraw.filledSquare(xCo, yCo - length, (length / 2));
		StdDraw.filledSquare(xCo + length, yCo, (length / 2));
	}

	public static void drawLShapeRT(double xCo, double yCo, double size) {
		double length = (1 / size);
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.filledSquare(xCo, yCo, (length / 2));
		StdDraw.filledSquare(xCo, yCo - length, (length / 2));
		StdDraw.filledSquare(xCo - length, yCo, (length / 2));
	}

	public static void drawLShapeRL(double xCo, double yCo, double size) {
		double length = (1 / size);
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		StdDraw.filledSquare(xCo, yCo, (length / 2));
		StdDraw.filledSquare(xCo - length, yCo, (length / 2));
		StdDraw.filledSquare(xCo, yCo + length, (length / 2));
	}

	public static void filledPuzzle(double plotX, double plotY, double size, double halfX, double halfY, double count,
			double divide) {
		double length = 1 / size;
		double newXCo = 0;
		double newYCo = 0;
		//base case
		if (count == 2) {
			if (plotX < halfX && plotY < halfY) {
				newXCo = halfX + length / 2;
				newYCo = halfY + length / 2;
				drawLShapeRT(newXCo, newYCo, size);
			}
			else if (plotX > halfX && plotY > halfY) {
				newXCo = halfX - length / 2;
				newYCo = halfY - length / 2;
				drawLShapeLL(newXCo, newYCo, size);
			}
			else if (plotX < halfX && plotY > halfY) {
				newXCo = halfX + length / 2;
				newYCo = halfY - length / 2;
				drawLShapeRL(newXCo, newYCo, size);
			}
			else if (plotX > halfX && plotY < halfY) {
				newXCo = halfX - length / 2;
				newYCo = halfY + length / 2;
				drawLShapeLT(newXCo, newYCo, size);
			}
			return;
		} 
		//recursive
		else {
			if (plotX < halfX && plotY < halfY) {
				newXCo = halfX + length / 2;
				newYCo = halfY + length / 2;
				drawLShapeRT(newXCo, newYCo, size) ;
				filledPuzzle(newXCo, newYCo, size, halfX + 1/(2*divide), halfY + 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX - 1/(2*divide), halfY + 1/(2*divide), count / 2, divide*2);
				filledPuzzle(plotX, plotY, size, halfX - 1/(2*divide), halfY - 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX + 1/(2*divide), halfY - 1/(2*divide), count / 2, divide*2);
			}
			else if (plotX > halfX && plotY > halfY) {
				newXCo = halfX - length / 2;
				newYCo = halfY - length / 2;
				drawLShapeLL(newXCo, newYCo, size);		
				filledPuzzle(plotX, plotY, size, halfX + 1/(2*divide), halfY + 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX - 1/(2*divide), halfY + 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX - 1/(2*divide), halfY - 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX + 1/(2*divide), halfY - 1/(2*divide), count / 2, divide*2);

			}
			else if (plotX < halfX && plotY > halfY) {
				newXCo = halfX + length / 2;
				newYCo = halfY - length / 2;
				drawLShapeRL(newXCo, newYCo, size);
				filledPuzzle(newXCo, newYCo, size, halfX + 1/(2*divide), halfY + 1/(2*divide), count / 2, divide*2);
				filledPuzzle(plotX, plotY, size, halfX - 1/(2*divide), halfY + 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX - 1/(2*divide), halfY - 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX + 1/(2*divide), halfY - 1/(2*divide), count / 2, divide*2);

			}
			else if (plotX > halfX && plotY < halfY) {
				newXCo = halfX - length / 2;
				newYCo = halfY + length / 2;
				drawLShapeLT(newXCo, newYCo, size);
				filledPuzzle(newXCo, newYCo, size, halfX + 1/(2*divide), halfY + 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX - 1/(2*divide), halfY + 1/(2*divide), count / 2, divide*2);
				filledPuzzle(newXCo, newYCo, size, halfX - 1/(2*divide), halfY - 1/(2*divide), count / 2, divide*2);
				filledPuzzle(plotX, plotY, size, halfX + 1/(2*divide), halfY - 1/(2*divide), count / 2, divide*2);
			}
		}
	}
	
	public static void run(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please insert the Size of the Puzzle(2^n*2^n): ");
		double x = scan.nextDouble();
		drawPuzzle(x);
		plotPoint(x);
		filledPuzzle(plotedCoX, plotedCoY, x, 0.5, 0.5, x, 2);
	}

}
