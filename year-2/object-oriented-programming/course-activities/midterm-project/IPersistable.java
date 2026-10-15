/**
 * Describes an object that can be saved to and loaded from one line of text in a text file
 */
public interface IPersistable {
    /**
     * Turns this object into one line of text for the file.
     * 
     * @return a line of text
     */
    String toFileLine();

    /**
     * Fills this object in from one line of text read from the file.
     * 
     * @param line a line of string 
     */
    void fromFileLine(String line);
}