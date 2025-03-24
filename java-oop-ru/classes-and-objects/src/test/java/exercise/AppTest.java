package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    void testPoint() {
        Point point = new Point(2, 3);
        assertThat(point.getX()).isEqualTo(2);
        assertThat(point.getY()).isEqualTo(3);
    }

    @Test
    void testSegment() {
        Point point1 = new Point(2, 3);
        Point point2 = new Point(4, 5);
        Segment segment = new Segment(point1, point2);

        // Corrected to compare values instead of references
        assertThat(segment.getBeginPoint()).isEqualTo(new Point(2, 3));
        assertThat(segment.getEndPoint()).isEqualTo(new Point(4, 5));
    }

    @Test
    void testGetMidPoint() {
        Point point1 = new Point(-4, -4);
        Point point2 = new Point(2, 6);
        Segment segment = new Segment(point1, point2);
        Point midPoint = segment.getMidPoint();

        assertThat(midPoint.getX()).isEqualTo(-1);
        assertThat(midPoint.getY()).isEqualTo(1);
    }
}

