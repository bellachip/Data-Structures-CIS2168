package rabbithunt;

public class Rabbit extends Animal {

    // Used to maneuver rabbit relative to current back direction from fox
    private static final int LEFT_45 = -1;
    private static final int RIGHT_45 = 1;
    private static final int LEFT_90 = -2;
    private static final int RIGHT_90 = 2;
    private static final int LEFT_135 = -3;
    private static final int RIGHT_135 = 3;
    private static final int ABOUT_FACE = 4;

    // Used to determine when rabbit needs to move away from walls
    // Best value for this determined by trial and error
    private static final int TO_CLOSE_TO_WALL = 2;

    // This is used when looking for walls, the primary intercardinal directions are unnecessary here
    private static final int NUM_CARDINAL_DIRECTIONS = 4;

    // Provided constructor
    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    // Provided method declaration
    int decideMove() {

        // Declaration of method variables
        int tempDecision; // Holds result from chooseLeftOrRight()
        int[] distanceToWalls = new int[NUM_CARDINAL_DIRECTIONS]; // Used to store distance to possible walls for all cardinal directions
        int currentDirection = Model.STAY; // Cannot leave uninitialized because of "may not have been initialized" warning
        boolean seenFox = false; // Reset seenFox every turn, rabbit does not need to remember where fox was

        // Look for fox
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {

            if (look(i) == Model.FOX) {
                currentDirection = Model.turn(i, ABOUT_FACE); // If found, face away from fox
                seenFox = true;
            }
        }

        // If seen, evade the fox
        if (seenFox) {
            // First choice is to turn 45 degrees off of fox's path
            // This provides the single most significant boost to survivability, at least 35%
            // Combining this with staying put when out of sight of fox gets survivability to about 75%
            tempDecision = chooseLeftOrRight(LEFT_45, RIGHT_45, currentDirection);
            if (tempDecision != -1) {
                return (tempDecision);
            }

            // Second choice is to turn 90 degrees off of fox's path, combined with 135 degrees provides 2% survivability
            tempDecision = chooseLeftOrRight(LEFT_90, RIGHT_90, currentDirection);
            if (tempDecision != -1) {
                return (tempDecision);
            }

            // Third choice is to run directly away from fox
            // Negligible impact on survivability when combined with 45 and 90 degree turns
            if (canMove(currentDirection)) {
                return currentDirection;
            }

            // Forth choice is to turn 135 degrees off of fox's path, combined with 90 degrees provides 2% survivability
            tempDecision = chooseLeftOrRight(LEFT_135, RIGHT_135, currentDirection);
            if (tempDecision != -1) {
                return (tempDecision);
            }

            // Last choice is to run toward fox and hope to find a way out of the dead end next turn, negligible impact on survivability
            return Model.turn(currentDirection, ABOUT_FACE);

        } else { // (!seenFox)

            // When location of fox is unknown focus on staying away from walls
            // Adds about 2% survivability

            // Find walls and distance
            for (int i = 0; i < distanceToWalls.length; i++) {

                // Only looking in cardinal directions, represented by even numbers, so use 2 * index for direction
                if (look(2 * i) == Model.EDGE) {
                    distanceToWalls[i] = distance(2 * i);
                } else {
                    distanceToWalls[i] = 100;
                }
            }

            // Get away from walls
            for (int i = 0; i < distanceToWalls.length; i++) {

                if (distanceToWalls[i] <= TO_CLOSE_TO_WALL) {

                    // Move directly away from walls, again, represented by even directions
                    if (canMove(Model.turn(2 * i, ABOUT_FACE))) {
                        return (Model.turn(2 * i, ABOUT_FACE));

                    } else { // (!canMove(away from wall))
                        do { // Move in any other direction looking for a route to freedom
                            currentDirection = Model.random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
                        } while (!canMove(currentDirection));
                        return currentDirection;
                    }
                }
            }
        } // End of seenFox if/else decision

        // Safest action is to stay put, fox tends to move along walls and by now rabbit should be off walls
        // Adds about 35% survivability
        // This combined with turning 45 degrees off fox's path to rabbit provides the bulk of survivability
        return Model.STAY;

    }

    // chooseLeftOrRight() is used to wisely choose direction to turn
    // Returns -1 if unable to move in either direction
    private int chooseLeftOrRight(int left, int right, int current) {

        // If only one of the two best options are available
        if (canMove(Model.turn(current, left)) ^ canMove(Model.turn(current, right))) {

            // Take that action
            if (canMove(Model.turn(current, left))) {
                return Model.turn(current, left);
            }
            if (canMove(Model.turn(current, right))) {
                return Model.turn(current, right);
            }
        }

        // If both best options available
        if (canMove(Model.turn(current, left)) && canMove(Model.turn(current, right))) {

            // Find distance to nearest object in both directions
            int lookLeft = distance(Model.turn(current, left));
            int lookRight = distance(Model.turn(current, right));

            // Turn toward the longer distance in hopes of more freedom of movement
            // Adds about 4% survivability when use in conjunction with each turn choice
            if (lookLeft > lookRight) {
                return Model.turn(current, left);
            } else if (lookLeft < lookRight) {
                return Model.turn(current, right);
            }

            // If still unable to decide, finally just pick a direction at random
            int dodge = Model.random(1, 2);
            if (dodge == 1) {
                return Model.turn(current, left);
            }
            if (dodge == 2) {
                return Model.turn(current, right);
            }
        }

        return -1; // Unable to turn left or right
    }
}