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
 */
public class Greeting {

    /** The numeric locality identifier. */
    private final int localityID;

    /** The name of the locality. */
    private final String localityName;

    /** The ASCII greeting word (example: "Ni Hao"). */
    private final String asciiGreeting;

    /** The Unicode greeting word (example: "你好"). */
    private final String unicodeGreeting;

    /** The format string used to build the final greeting message. */
    private final String formatStr;

    /**
     * Creates a default greeting that produces "Hello, {name}!".
     *
     * Uses the default format "%s, %%s!".
     *
     * @param localityID the numeric locality identifier
     * @param localityName the name of the locality
     */
    public Greeting(int localityID, String localityName) {
        this(localityID, localityName, "Hello", "Hello", "%s, %%s!");
    }

    /**
     * Creates a greeting where ASCII and Unicode greetings are the same.
     *
     * @param localityID the numeric locality identifier
     * @param localityName the name of the locality
     * @param greeting the greeting word to use for both ASCII and Unicode
     */
    public Greeting(int localityID, String localityName, String greeting) {
        this(localityID, localityName, greeting, greeting, "%s, %%s!");
    }

    /**
     * Creates a fully customized greeting.
     *
     * @param localityID the numeric locality identifier
     * @param localityName the name of the locality
     * @param asciiGreeting the ASCII greeting word
     * @param unicodeGreeting the Unicode greeting word
     * @param formatStr the format string used to assemble the final greeting
     */
    public Greeting(int localityID, String localityName,
                    String asciiGreeting, String unicodeGreeting, String formatStr) {
        this.localityID = localityID;
        this.localityName = localityName;
        this.asciiGreeting = asciiGreeting;
        this.unicodeGreeting = unicodeGreeting;
        this.formatStr = formatStr;
    }

    /**
     * Returns the locality ID.
     *
     * @return the numeric locality identifier
     */
    public int getLocalityID() {
        return localityID;
    }

    /**
     * Returns the locality name.
     *
     * @return the name of the locality
     */
    public String getLocalityName() {
        return localityName;
    }

    /**
     * Returns the ASCII greeting word (without formatting).
     *
     * @return the ASCII greeting word
     */
    public String getAsciiGreeting() {
        return asciiGreeting;
    }

    /**
     * Returns the Unicode greeting word (without formatting).
     *
     * @return the Unicode greeting word
     */
    public String getUnicodeGreeting() {
        return unicodeGreeting;
    }

    /**
     * Returns the default (Unicode) format string.
     *
     * @return the formatted greeting pattern using the Unicode greeting
     */
    public String getFormatStr() {
        return getFormatStr(false);
    }

    /**
     * Returns the format string with the greeting inserted.
     *
     * @param asciiOnly if true use ASCII greeting; otherwise use Unicode greeting
     * @return the formatted greeting pattern ready to accept the person's name
     */
    public String getFormatStr(boolean asciiOnly) {
        String greeting = asciiOnly ? asciiGreeting : unicodeGreeting;
        return String.format(formatStr, greeting);
    }

    /**
     * Returns a debug string representation of this Greeting.
     *
     * @return a string showing all stored field values
     */
    @Override
    public String toString() {
        return String.format(
                "{localityID:%d, localityName:\"%s\", asciiGreeting:\"%s\", unicodeGreeting:\"%s\"}",
                localityID, localityName, asciiGreeting, unicodeGreeting
        );
    }
}

