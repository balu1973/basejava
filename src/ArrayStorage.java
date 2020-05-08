import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                storage[i] = null;
            }
            size = 0;
        }
    }

    void save(Resume r) {
        if (r.uuid == null || r.uuid.isEmpty()) return;
        if (size < storage.length) {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(r.uuid)) return;
            }
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        if (uuid == null || uuid.isEmpty()) return null;
        Resume resume = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        if (uuid == null || uuid.isEmpty()) return;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                int numMoved = size - i - 1;
                if (numMoved > 0)
                    System.arraycopy(storage, i+1, storage, i, numMoved);
                storage[--size] = null;
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
