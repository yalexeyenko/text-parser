package service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static service.TextService.changeFirstAndLastWordInSentences;

public class TextServiceTest {
    private String sourceString = "Today, however, they were not playing. Uncle Henry sat upon the doorstep and looked " +
            "anxiously at the sky, which was even grayer than usual. Dorothy stood in the door with Toto " +
            "in her arms, and looked at the sky too. Aunt Em was washing the dishes.\n" +
            "From the far north they heard a low wail of the wind, and Uncle Henry and Dorothy could see " +
            "where the long grass bowed in waves before the coming storm. There now came a sharp whistling " +
            "in the air from the south, and as they turned their eyes that way they saw ripples in the grass " +
            "coming from that direction also.";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testChangeFirstAndLastWordInSentences() throws Exception {
        String resultString = "playing, however, they were not Today. usual Henry sat upon the doorstep and looked " +
                "anxiously at the sky, which was even grayer than Uncle. too stood in the door with Toto " +
                "in her arms, and looked at the sky Dorothy. dishes Em was washing the Aunt.\n" +
                "storm the far north they heard a low wail of the wind, and Uncle Henry and Dorothy could see " +
                "where the long grass bowed in waves before the coming From. also now came a sharp whistling " +
                "in the air from the south, and as they turned their eyes that way they saw ripples in the grass " +
                "coming from that direction There.";
        String res = changeFirstAndLastWordInSentences(sourceString);
        assertEquals(resultString, res);
    }


}