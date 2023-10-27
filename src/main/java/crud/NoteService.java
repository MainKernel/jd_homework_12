package crud;

import entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    private static final Random RANDOM = new Random();

    private final Map<Long, Note> notes = new HashMap<>();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = RANDOM.nextLong();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        notes.remove(id);
    }

    public void update(Note note) {
        Note existingNote = notes.get(note.getId());
        if (existingNote == null) {
            System.out.println("note with id" + note.getId() + "not found");
        }
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
    }

    public Note getById(long id) {
        Note note = notes.get(id);
        if (note == null) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
        return note;
    }
}