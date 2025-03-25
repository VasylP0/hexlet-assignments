package exercise;

public interface Home extends Comparable<Home> {
    double getArea();

    @Override
    int compareTo(Home another);
}
