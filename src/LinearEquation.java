public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private boolean niceSlope;
    private boolean verticalLine;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        niceSlope = false;
        verticalLine = false;
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound*100)/100.0;
    }

    public boolean isVerticalLine() {
        return verticalLine;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public double slope() {
        double slopeReturn = roundedToHundredth((((double)y2-y1)/((double)x2-x1)));
        if (slopeReturn == (int) slopeReturn) {
            niceSlope = true;
        }
        return slopeReturn;
    }

    public double yIntercept() {
        return roundedToHundredth((y1-slope()*x1));
    }

    public String equation() {
        if (yIntercept()>0) {
            if (niceSlope&&slope()!=1&&slope()!=-1&&slope()!=0) {
                return "y = " + (int) (slope()) + "x + " + yIntercept();
            } else if (slope()==1) {
                return "y = " + "x + " + yIntercept();
            } else if (slope()==-1) {
                return "y = " + "-x + " + yIntercept();
            } else if (slope()==0) {
                return "y = " + (int) yIntercept();
            } else {
                if (y2-y1<0&&x2-x1<0) {
                    return "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x + " + yIntercept();
                } else if (x2-x1==0) {
                    verticalLine = true;
                    return "x = " + x1;
                } else {
                    if (y2-y1<0||x2-x1<0) {
                        return "y = -" + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x + " + Math.abs(yIntercept());
                    } else {
                        return "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x + " + Math.abs(yIntercept());
                    }
                }
            }
        } else if (yIntercept()<0) {
            if (niceSlope&&slope()!=1&&slope()!=-1&&slope()!=0) {
                return "y = " + (int) (slope()) + "x - " + Math.abs(yIntercept());
            } else if (slope()==1) {
                return "y = " + "x - " + Math.abs(yIntercept());
            } else if (slope()==-1) {
                return "y = " + "-x - " + Math.abs(yIntercept());
            } else if (slope()==0) {
                return "y = -" + (int) Math.abs(yIntercept());
            } else {
                if (y2-y1<0&&x2-x1<0) {
                    return "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x - " + Math.abs(yIntercept());
                } else if (x2-x1==0) {
                    verticalLine = true;
                    return "x = -" + Math.abs(x1);
                } else {
                    if (y2-y1<0||x2-x1<0) {
                        return "y = -" + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x - " + Math.abs(yIntercept());
                    } else {
                        return "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x - " + Math.abs(yIntercept());
                    }
                }
            }

        } else {
            if (niceSlope&&slope()!=1&&slope()!=-1&&slope()!=0) {
                return "y = " + (int) (slope()) + "x";
            } else if (slope()==1) {
                return "y = " + "x";
            } else if (slope()==-1) {
                return "y = " + "-x";
            } else if (slope()==0) {
                return "y = 0";
            } else {
                if (y2-y1<0&&x2-x1<0) {
                    return "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x";
                } else if (x2-x1==0) {
                    verticalLine = true;
                    return "x = 0";
                } else {
                    return "y = " + (y2-y1) + "/" + (x2-x1) + "x";
                }
            }
        }

    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2)));
    }

    public String coordinateForX(double x) {
        double yCord = (slope()*x) + yIntercept();
        return "(" + x + ", " + yCord + ")";
    }

}

