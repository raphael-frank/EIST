package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TutorGroup {
	private String id;
    private WeeklyTimeSlot timeSlot;
    private Person tutor;
    private Set<Student> students;
    private List<TutorGroupMeeting> meetings;

    public TutorGroup(String id, WeeklyTimeSlot timeSlot, Person tutor) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.tutor = tutor;

        students = new HashSet<>();
        meetings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public WeeklyTimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Person getTutor() {
        return tutor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    void addMeeting(TutorGroupMeeting meeting) {
        meetings.add(meeting);
    }

    public void register(Student student) {
        students.add(student);
    }
}
