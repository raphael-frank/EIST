package de.tum.in.ase.eist;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TutorGroupStatistics {

	private TutorGroupStatistics() {

	}

	public static double averageDuration(Stream<TutorGroupMeeting> meetingStream) {
		return meetingStream.mapToLong(s -> s.getTutorGroup().getTimeSlot().getDuration().getSeconds())
				.average()
				.orElse(0);
	}

	public static Set<Skill> repeatedSkills(Stream<TutorGroupMeeting> meetings) {
		List<Skill> skillList = meetings.map(TutorGroupMeeting::getSkillToPractise).toList();

		Set<Skill> doubleSkills = new HashSet<>();
		for (Skill skill : skillList) {
			if(Collections.frequency(skillList,skill) > 1) doubleSkills.add(skill);
		}

		return doubleSkills;
	}
}
