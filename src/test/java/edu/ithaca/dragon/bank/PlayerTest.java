public class PlayerTest {

    @Test
    void validateArgumentsTest() {
        Player myPlayer = new Player("Adam", "1234", 9.0, 5.5);
        //valid name tests
        assertTrue(validateArguments("Adam", "1234", 9.0, 5.5));
        assertFalse(validateArguments("", "1234", 9.0, 5.5));

        //valid ID tests
        assertTrue(validateArguments("Adam", "1234", 9.0, 5.5));
        assertFalse(validateArguments("Adam", "123", 9.0, 5.5));

        //valid start time tests
        assertTrue(validateArguments("Adam", "1234", 9.0, 5.5));
        assertFalse(validateArguments("Adam", "1234", -1, 5.5));

        //valid end time tests
        assertTrue(validateArguments("Adam", "1234", 9.0, 5.5));
        assertFalse(validateArguments("Adam", "1234", 9.0, 24.5));
    }

    @Test
    void getNameTest() {
        Player myPlayer = new Player("Adam", "1234", 9.0, 5.5);
        assertEquals(myPlayer.getName(), "Adam");
    }

    @Test
    void getIDTest() {
        Player myPlayer = new Player("Adam", "1234", 9.0, 5.5);
        assertEquals(myPlayer.getID(), "1234");
    }

    @Test
    void getScheduleTest() {
        Player myPlayer = new Player("Adam", "1234", 9.0, 17.5);
        assertEquals(myPlayer.getSchedule().getKey(), 9.0);
        assertEquals(myPlayer.getSchedule().getValue(), 17.5);
    }

}