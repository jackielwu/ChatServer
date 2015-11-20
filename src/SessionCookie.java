/**
 * CS180 - HW 0
 * Description:
 *
 * @author Jackie Wu, wu891@purdue.edu, 821
 * @version November 14, 2015
 */
public class SessionCookie {
    private long id;
    private long initialTime;

    public SessionCookie() {
        this.id = 0000 + (int) (Math.random() * 9999);
    }
    public SessionCookie(long id) {
        this.id = id;
        initialTime = System.currentTimeMillis();
    }
    public static int timeoutlength = 300;

    public boolean hasTimedOut() {
        return (initialTime - System.currentTimeMillis()) >= timeoutlength;
    }

    public void updateTimeOfActivity() {
        initialTime = System.currentTimeMillis();
    }

    public long getID() {
        return id;
    }
}
