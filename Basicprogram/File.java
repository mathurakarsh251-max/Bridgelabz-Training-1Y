class File {
    void write(String data) { /* logic to write */ }
}

class ReadOnlyFile extends File {
    @Override
    void write(String data) {
        throw new UnsupportedOperationException("Cannot write to read-only file!");
    }
}
interface Readable { void read(); }
interface Writable { void write(String data); }

class NormalFile implements Readable, Writable { ... }
class ReadOnlyFile implements Readable { ... }