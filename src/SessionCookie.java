/**
 * CS180 - HW 0
 * Description:
 *
 * @author Jackie Wu, wu891@purdue.edu, 821
 * @version November 14, 2015
 */
public class SessionCookie {
    private long id;

    public SessionCookie(long id) {
        this.id = id;
    }
    public static int timeoutlength;

    public boolean hasTimedOut() {
        return false;
    }

    public void updateTimeOfActivity() {
        System.currentTimeMillis();
    }

    public long getID() {
        return id;
    }
}
