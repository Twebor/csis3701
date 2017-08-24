import nimgame.NimGame;
import nimgame.exceptions.TooManyRowsException;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class NimGameTest {

    // Tests a legal, simple accessor call of getRow(0);
    @Test
    public void getRowTest1() {
        // create test instance of NimGame
        NimGame nim = null;
        try {
            nim = new NimGame(new int[] {3, 5, 7});
        } catch (TooManyRowsException e) {
            e.printStackTrace();
        }

        // obtain first row and assert that it equals the first supplied row length.
        assert nim.getRow(0) == 3;
    }

    // Tests a legal play() call in NimGame.
    @Test
    public void playTest1() {
        // create test instance of NimGame
        NimGame nim = null;
        try {
            nim = new NimGame(new int[] {3, 3, 3});
        } catch (TooManyRowsException e) {
            e.printStackTrace();
        }

        // desired answer.
        String answer = "|\n| | |\n| | |\n";

        try {
            nim.play(0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(answer, nim.toString());
    }

    // Tests the illegal row case for NimGame's play() method.
    @Test
    public void playTest2() {
        // create test instance of NimGame
        NimGame nim = null;
        try {
            nim = new NimGame(new int[] {3, 3, 3});
        } catch (TooManyRowsException e) {
            e.printStackTrace();
        }

        // Save original representation to compare.
        String original = nim.toString();

        try {
            // test illegal row case of 4.
            nim.play(4, 2);

            // should fail
            fail();
        } catch (Exception e) {
            // compare state to original again to make sure it's unchanged.
            Assert.assertEquals(original, nim.toString());
        }
    }
}
