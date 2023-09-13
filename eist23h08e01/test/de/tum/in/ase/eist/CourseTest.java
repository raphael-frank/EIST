package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

class CourseTest {

	// TODO 1: Test getCourseTitle()
    @Test
    public void testGetCourseTitle() {
        String myTitle = "Very good title";
        Course course = new Course(myTitle);

        Assertions.assertEquals(course.getTitle(), myTitle);
    }

	// TODO 2: Test getNumberOfAttendees()
    @Test
    public void testNoAttendees() {
        Course course = new Course("Title");

        Assertions.assertEquals(0, course.getNumberOfAttendees());
    }

    @Test
    public void testThreeAttendees() {
        Course course = new Course("Title");
        course.addAttendee(new Student("FirstName", "Name", "BirthDate", "MajorSubject", "MinorSubject"));
        course.addAttendee(new Student("FirstName", "Name", "BirthDate", "MajorSubject", "MinorSubject"));
        course.addAttendee(new Student("FirstName", "Name", "BirthDate", "MajorSubject", "MinorSubject"));

        Assertions.assertEquals(3, course.getNumberOfAttendees());
    }

}
