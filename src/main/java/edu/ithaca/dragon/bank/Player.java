import jdk.internal.net.http.common.Pair;

public class Player {
    private String name;
    private String ID;
    private Pair<Double, Double> schedule;

    /**
     * Constructor for the Player class
     * @param name must be a name consisting of at least 1 character, number, or symbol
     * @param ID must be a string of 4 numbers
     * @param startTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @param endTime must be a double greater than 0 and less than 24, using increments of 0.25 for 15 minute blocks of time
     * @throws IllegalArgumentException for any arguments that violate the above rules
     */
    public Player(String name, String ID, double startTime, double endTime) throws IllegalArgumentException {
        ;
    }

    public static boolean validateArguments(String name, String ID, double startTime, double endTime) {
        ;   
    }

    public String getName() {
        ;
    }

    public String getID() {
        ;
    }

    public Pair<Double, Double> getSchedule() {
        ;
    }
}