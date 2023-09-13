package de.tum.in.ase.eist;

public class LocalTutorGroupMeeting extends TutorGroupMeeting {
	private String room;

    public LocalTutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractise, String room) {
        super(timeSlot, tutorGroup, skillToPractise);
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    @Override
    public void practise() {
        getTutorGroup().getTutor().say("Thank you for coming to "+room+" today.");
        getTutorGroup().getStudents().forEach(s -> s.learnSkill(getSkillToPractise()));
        getTutorGroup().getTutor().say("See you next time!");
    }
}
