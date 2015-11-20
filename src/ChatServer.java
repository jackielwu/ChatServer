import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <b> CS 180 - Project 4 - Chat Server Skeleton </b>
 * <p>
 *
 * This is a private chat server for you and your friends to communicate.
 *
 * @author Jackie Wu, wu891@purdue.edu
 * @lab 821
 * @version November 14, 2015
 */
public class ChatServer {
    private User[] users;
    private int maxMessages;
    public final String SUCCESS = "SUCCESS\r\n";

    public ChatServer(User[] users, int maxMessages) {
        this.users = users;
        this.maxMessages = maxMessages;
    }

    /**
     * This method begins server execution.
     */
    public void run() {
        boolean verbose = false;
        System.out.printf("The VERBOSE option is off.\n\n");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.printf("Input Server Request: ");
            String command = in.nextLine();

            // this allows students to manually place "\r\n" at end of command
            // in prompt
            command = replaceEscapeChars(command);

            if (command.startsWith("kill"))
                break;

            if (command.startsWith("verbose")) {
                verbose = !verbose;
                System.out.printf("VERBOSE has been turned %s.\n\n", verbose ? "on" : "off");
                continue;
            }

            String response = null;
            try {
                response = parseRequest(command);
            } catch (Exception ex) {
                response = MessageFactory.makeErrorMessage(MessageFactory.UNKNOWN_ERROR,
                        String.format("An exception of %s occurred.", ex.getMessage()));
            }

            // change the formatting of the server response so it prints well on
            // the terminal (for testing purposes only)
            if (response.startsWith("SUCCESS\t"))
                response = response.replace("\t", "\n");

            // print the server response
            if (verbose)
                System.out.printf("response:\n");
            System.out.printf("\"%s\"\n\n", response);
        }

        in.close();
    }

    /**
     * Replaces "poorly formatted" escape characters with their proper values.
     * For some terminals, when escaped characters are entered, the terminal
     * includes the "\" as a character instead of entering the escape character.
     * This function replaces the incorrectly inputed characters with their
     * proper escaped characters.
     *
     * @param str
     *            - the string to be edited
     * @return the properly escaped string
     */
    private static String replaceEscapeChars(String str) {
        str = str.replace("\\r", "\r");
        str = str.replace("\\n", "\n");
        str = str.replace("\\t", "\t");

        return str;
    }

    /**
     * Determines which client command the request is using and calls the
     * function associated with that command.
     *
     * @param request
     *            - the full line of the client request (CRLF included)
     * @return the server response
     */
    public String parseRequest(String request) {

        String[] args = request.split("\t");

        if (args[0].equals("ADD-USER")) return addUser(args);
        if (args[0].equals("USER-LOGIN")) return userLogin(args);
        if (args[0].equals("POST-MESSAGE")) return postMessage(args, args[1]);
        if (args[0].equals("GET-MESSAGES")) return getMessages(args);

        return SUCCESS;
    }

    public String addUser(String[] args) {
        if (args[1].matches("^.*[a-zA-Z0-9].*$") && args[1].length() >= 1 &&
                args[1].length() <= 20) {
            if (args[2].matches("^.*[a-zA-Z0-9].*$") && args[2].length() >= 4
                    && args[2].length() <= 40) {
                return SUCCESS;
            }
            else {
                return MessageFactory.makeErrorMessage(24, "Passwords must be between 1" +
                        " and 20 characters in length (inclusive) and can only contain" +
                        "alphanumerical values " +
                        "[A-Za-z0-9].");
            }
        }
        else {
            return MessageFactory.makeErrorMessage(24, "Usernames must be between 1" +
                    " and 20 characters in length (inclusive) and can only contain" +
                    "alphanumerical values " +
                    "[A-Za-z0-9].");
        }

    }

    public String userLogin(String[] args) {
        return SUCCESS;
    }

    public String postMessage(String[] args, String name) {
        //TODO: Post message to the chat server

        //CircularBuffer.put()


        return SUCCESS;
    }

    public String getMessages(String[] args) {
        return SUCCESS;
    }

}
