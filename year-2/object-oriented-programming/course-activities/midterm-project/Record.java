import java.util.ArrayList;

/**
 * Describes a record.
 * Any class that implements this must say how it returns its unique ID and data stored.
 */
public interface Record {
    int getRecordID();
    ArrayList<Object> getRecordData();
}
