package consts;

public enum NamesOfCourses {
    JAVA("Java"), RUBY("Ruby"), NET(".NET"), PYTHON("Python");

    private final String course;

    NamesOfCourses(String course) {
        this.course = course;
    }

    public String getCourse(){
        return course;
    }
}
