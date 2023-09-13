package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;
import java.net.MalformedURLException;

class OnlineCourseTest {

	// TODO 3: Test setOnlineCourseUrl()
    @Test
    public void testSetOnlineCourseUrlWithValidUrl() {
        OnlineCourse onlineCourse = new OnlineCourse("Title");

        String myUrl = "http://schnittiges-schiffchen.de/";
        try {
            onlineCourse.setUrl(myUrl);
        } catch (MalformedURLException e) {
            Assertions.fail();
        }

        Assertions.assertEquals(onlineCourse.getUrl().toString(), myUrl);
    }

    @Test
    public void testSetOnlineCourseUrlWithInvalidUrl() {
        OnlineCourse onlineCourse = new OnlineCourse("Title");

        String myUrl = "doch nicht so schnittig :(";
        Assertions.assertThrows(MalformedURLException.class, () -> onlineCourse.setUrl(myUrl));
    }
}
