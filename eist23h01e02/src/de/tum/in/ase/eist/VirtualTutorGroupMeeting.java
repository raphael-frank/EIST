package de.tum.in.ase.eist;

public class VirtualTutorGroupMeeting extends TutorGroupMeeting {
	private String url;

    public VirtualTutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractise, String url) {
        super(timeSlot, tutorGroup, skillToPractise);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void practise() {
        getTutorGroup().getTutor().say("Thank you for joining using "+url+" today.");
        getTutorGroup().getStudents().forEach(s -> s.learnSkill(getSkillToPractise()));
        getTutorGroup().getTutor().say("See you next time!");
    }
}
