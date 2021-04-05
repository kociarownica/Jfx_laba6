package org.example.classes;

public class Library {
    private Student student;
    private boolean free;

    Library(){
        this.free = true;
    }

    public void setStudent(Student st){
        student = st;
        free = false;
    }

    public void removeStudent(){
        free = true;
        student = null;
    }

    public boolean isFree() {
        return free;
    }

    public Student getStudent() {
        return student;
    }
}