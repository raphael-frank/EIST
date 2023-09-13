package de.tum.in.ase.eist;

import java.util.HashSet;
import java.util.Set;

public class Student extends Person {
    private String matriculationNumber;
    private StudyLevel studyLevel;
    private int semester;
    private Set<String> knowledge;
    private Set<Skill> skills;

    public Student(String name, int age, String tumId, String matriculationNumber, StudyLevel studyLevel, int semester) {
        super(name, age, tumId);
        this.matriculationNumber = matriculationNumber;
        this.studyLevel = studyLevel;
        this.semester = semester;

        knowledge = new HashSet<>();
        skills = new HashSet<>();
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public StudyLevel getStudyLevel() {
        return studyLevel;
    }

    public int getSemester() {
        return semester;
    }

    public Set<String> getKnowledge() {
        return knowledge;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void learnSkill(Skill skill) {
        skills.add(skill);
    }

    public void acquireKnowledge(String newThings) {
        knowledge.add(newThings);
    }
}
