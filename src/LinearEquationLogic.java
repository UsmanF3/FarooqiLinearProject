import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    private LinearEquation line;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
        line = null;
    }

    private void getPoints() {
        System.out.print("Please enter coordinate one: ");
        String pointOne = scan.nextLine();
        System.out.print("Please enter coordinate two: ");
        String pointTwo = scan.nextLine();
        System.out.println();
        int x1 = Integer.parseInt(pointOne.substring(1, pointOne.indexOf(",")));
        int y1 = Integer.parseInt(pointOne.substring(pointOne.indexOf(" ")+1, pointOne.length()-1));
        int x2 = Integer.parseInt(pointTwo.substring(1, pointTwo.indexOf(",")));
        int y2 = Integer.parseInt(pointTwo.substring(pointTwo.indexOf(" ")+1, pointTwo.length()-1));
        line = new LinearEquation(x1, y1, x2, y2);
    }

    private void displayInfo() {
        line.equation();
        if (!line.isVerticalLine()) {
            System.out.println("The two points are: (" + line.getX1() + ", " + line.getY1() + ") and (" + line.getX2() + ", " + line.getY2() + ")");
            System.out.println("The equation of the line between these points is: " + line.equation());
            System.out.println("The slope of this line is: " + line.slope());
            System.out.println("The y-intercept of the line is: " + line.yIntercept());
            System.out.println("The distance between the two points is: " + line.distance());
        } else {
            System.out.println("These points are on a vertical line: " + line.equation());
        }

    }

    private void askX() {
        System.out.println();
        System.out.print("Enter a value for x: ");
        double valueForX = scan.nextDouble();
        scan.nextLine();
        System.out.println("The point on the line is: " + line.coordinateForX(valueForX));
    }

    public void run() {
        System.out.println("Welcome to the Linear Equation Calculator!");
        boolean notDone = true;
        while (notDone) {
            getPoints();
            displayInfo();
            askX();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            String inp = scan.nextLine();
            if (inp.equals("n")) {
                notDone = false;
            }
        }
    }

}

