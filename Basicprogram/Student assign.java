class Student {
    String name;
    public boolean equals(Student other) {
        return this.name.equals(other.name);
    }
}
class Student {
    String name;

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Student)) return false;
        return this.name.equals(((Student)other).name);
    }
}
interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle...");
    }
}