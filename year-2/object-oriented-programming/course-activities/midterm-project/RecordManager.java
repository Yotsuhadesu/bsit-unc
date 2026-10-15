/**
 * Describes a class that holds create, read, update, and delete operations for a record.
 * Any class that implements this must say how it creates, reads, updates, and deletes a record.
 */
public interface RecordManager {
    void addRecord();
    void updateRecord();
    void deleteRecord();
    void viewRecord();
    void viewList();
    int findRecord();
    void findRecord(String searchKey);
}