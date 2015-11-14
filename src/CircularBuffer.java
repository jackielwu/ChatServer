/**
 * Created by jackiewu on 11/14/15.
 */
public class CircularBuffer {
    private final int size;
    private String[] buffer;
    private int current;

    public CircularBuffer(int size) {
        this.size = size;
        current = 0000;
        buffer = new String[size];

    }

    public void put(String message) {
        if (current < 1000) {
            buffer[current] = "0" + current + ")" + message;
            current++;
        }
        else if (current < 100) {
            buffer[current] = "00" + current + ")" + message;
            current++;
        }
        else if (current < 10) {
            buffer[current] = "000" + current + ")" + message;
            current++;
        }

    }

    public String[] getNewest(int numMessages) {

    }


}
