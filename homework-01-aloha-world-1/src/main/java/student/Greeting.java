package student;

/**
 * Greeting stores info about how to greet someone for a specific locality.
 *
 * It does NOT print anything.
 * Other code can use this class to build a greeting like:
 *
 *   Greeting g = new Greeting(2, "USA");
 *   String msg = String.format(g.getFormatStr(false), "John");
 *   // msg -> "Hello, John!"
 *
 * It keeps track of:
 * - localityID (number)
 * - localityName (string)
 * - asciiGreeting (ex: "Ni Hao")
 * - unicodeGreeting (ex: "你好")
 * - formatStr (pattern that decides where the greeting + name go)
 */
public class Greeting {

    private final int localityID;
    private final String localityName;
    private final String asciiGreeting;
    private final String unicodeGreeting;
    private final String formatStr;

    /**
     * Default greeting that creates "Hello, {name}!".
     *
     * Uses the default format "%s, %%s!"
     * Explanation:
     * - first %s is the greeting word (Hello)
     * - %%s becomes a literal "%s" so later you can insert the person's name
     */
    public Greeting(int localityID, String localityName) {
        this(localityID, localityName, "Hello", "Hello", "%s, %%s!");
    }

    /**
     * Greeting where ascii and unicode are the same.
     * Example: new Greeting(1, "Hawaii", "Aloha")
     * becomes "Aloha, {name}!"
     */
    public Greeting(int localityID, String localityName, String greeting) {
        this(localityID, localityName, greeting, greeting, "%s, %%s!");
    }

    /**
     * Fully customized greeting.
     *
     * Example:
     * new Greeting(3, "China", "Ni Hao", "你好", "%%s, %s!")
     * - unicode format becomes "%s, 你好!"   (name first)
     * - ascii format becomes   "%s, Ni Hao!"
     */
    public Greeting(int localityID, String localityName,
                    String asciiGreeting, String unicodeGreeting, String formatStr) {
        this.localityID = localityID;
        this.localityName = localityName;
        this.asciiGreeting = asciiGreeting;
        this.unicodeGreeting = unicodeGreeting;
        this.formatStr = formatStr;
    }

    /** Returns the locality id number. */
    public int getLocalityID() {
        return localityID;
    }

    /** Returns the locality name. */
    public String getLocalityName() {
        return localityName;
    }

    /** Returns the ascii greeting word only (no name formatting). */
    public String getAsciiGreeting() {
        return asciiGreeting;
    }

    /** Returns the unicode greeting word only (no name formatting). */
    public String getUnicodeGreeting() {
        return unicodeGreeting;
    }

    /**
     * Gets the unicode format string (default).
     * This returns a string that still has a %s for the name.
     * Example: "Hello, %s!"
     */
    public String getFormatStr() {
        return getFormatStr(false);
    }

    /**
     * Returns the format string with the greeting inserted.
     *
     * If asciiOnly is true, use asciiGreeting.
     * If asciiOnly is false, use unicodeGreeting.
     *
     * Example:
     * formatStr = "%s, %%s!"
     * greeting  = "Hello"
     * result    = "Hello, %s!"
     */
    public String getFormatStr(boolean asciiOnly) {
        String greeting = asciiOnly ? asciiGreeting : unicodeGreeting;
        return String.format(formatStr, greeting);
    }

    /**
     * Debug string showing all stored fields.
     * Format must match the tests exactly.
     */
    @Override
    public String toString() {
        return String.format(
                "{localityID:%d, localityName:\"%s\", asciiGreeting:\"%s\", unicodeGreeting:\"%s\"}",
                localityID, localityName, asciiGreeting, unicodeGreeting
        );
    }
}
