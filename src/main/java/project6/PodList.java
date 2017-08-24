package project6;

/**
 * Represents a group/list of pods in the simple "pod chase" game.
 * @author tthenshaw
 */

import java.util.ArrayList;
import java.util.List;

public class PodList {

    /** Represents the game board's width. */
    private int width;
    /** Represents the game board's height. */
    private int height;
    /** Represents all the currently active pods. */
    private List<Pod> pods;


    /**
     * Creates an initial list of pods containing 4 pods with the game bounds supplied in width & height.
     * @param width The game board's width.
     * @param height The game board's height.
     */
    public PodList(int width, int height) {
        this.width = width;
        this.height = height;

        pods = new ArrayList<>();

        // starting pods.
        pods.add(new Pod(1, 5, "NE", width, height));
        pods.add(new Pod(2, 1, "SW", width, height));
        pods.add(new Pod(12, 2, "NW", width, height));
        pods.add(new Pod(13, 6, "SE", width, height));
    }


    /**
     * Makes all the active pods (all in list) move.
     */
    public void moveAll() {
        for (Pod pod : pods) {
            pod.move();
        }
    }

    /**
     * Generates a pod with a 10% chance with a random location and direction.
     */
    public void generate() {
        // 10% chance
        double chance = 0.10;
        double roll = Math.random();

        if (roll <= chance) {
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);

            String direction = null;
            switch ((int) (Math.random() * 4)) {
                case 0:
                    direction = "NE";
                    break;
                case 1:
                    direction = "NW";
                    break;
                case 2:
                    direction = "SE";
                    break;
                case 3:
                    direction = "SW";
                    break;
                default:
                    // do nothing
            }

            // add to active pods.
            pods.add(new Pod(x, y, direction, width, height));
        }
    }

    /**
     * Checks if there's a pod at the supplied player coordinates.
     * @param playerX The player's x-coordinate.
     * @param playerY The player's y-coordinate.
     */
    public void playerAt(int playerX, int playerY) {
        pods.remove(new Pod(playerX, playerY, "NE", width, height));
    }

    /**
     * Checks if there's a pod at a given pair of coordinates.
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return A boolean representing if there's a pod at the pair of coordinates.
     */
    public boolean isPod(int x, int y) {
        return pods.contains(new Pod(x, y, "NE", width, height));
    }


}
