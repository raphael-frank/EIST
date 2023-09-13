package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {

    @TestSubject
    private Discussion discussion = new Discussion();

    @Mock
    private Course courseMock;
    @Mock
    private Comment commentMock;

    // TODO implement the tests
    @Test
    public void testComment() {
        int expectedCommentNumber = discussion.getNumberOfComments() + 1;
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);

        discussion.addComment(commentMock);

        assertEquals(expectedCommentNumber, discussion.getNumberOfComments());
        verify(commentMock);
    }

    @Test
    public void testCommentIfSavingFails() {
        int expectedCommentNumber = discussion.getNumberOfComments();
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);

        discussion.addComment(commentMock);

        assertEquals(expectedCommentNumber, discussion.getNumberOfComments());
        verify(commentMock);
    }

    @Test
    public void testStartCourseDiscussion() {
        Person person = new Lecturer("Christian", "Karpfinger", LocalDate.EPOCH);
        String topic = "Meine erste Begegnung mit Frank Rosin";
        expect(courseMock.isDiscussionAllowed(person)).andReturn(true);
        replay(courseMock);

        boolean returnValue = discussion.startCourseDiscussion(courseMock, person, topic);

        assertTrue(returnValue);
        assertEquals(courseMock, discussion.getCourse());
        assertEquals(topic, discussion.getTopic());
        verify(courseMock);
    }
}
