/**
 * CS180 - HW 0
 * Description:
 *
 * @author Jackie Wu, wu891@purdue.edu, 821
 * @version November 14, 2015
 */
public class User {
    private String username;
    private String password;
    private SessionCookie cookie;

    public User(String username, String password, SessionCookie cookie) {
        this.username = username;
        this.password = password;
        this.cookie = cookie;
    }

    public String getName() {
        return username;
    }

    public boolean checkPassword(String password) {
        return (password.equals(this.password)) ? true: false;
    }

    public SessionCookie getCookie() {
        return cookie;
    }

    public void setCookie(SessionCookie cookie) {
        this.cookie = cookie;
    }
}
