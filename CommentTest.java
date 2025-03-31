import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  mik
 * @version 0.1
 */
public class CommentTest
{
    private Comment comment;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        comment = new Comment("John Doe", "This is a comment text.", 4);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        comment = null;
    }

    /**
     * Test that the author is correctly set.
     */
    @Test
    public void testAuthor()
    {
        assertEquals("John Doe", comment.getAuthor());
    }

    /**
     * Test that the rating is correctly set.
     */
    @Test
    public void testRating()
    {
        assertEquals(4, comment.getRating());
    }

    /**
     * Test that the vote count is initially zero.
     */
    @Test
    public void testInitialVoteCount()
    {
        assertEquals(0, comment.getVoteCount());
    }

    /**
     * Test upvoting the comment.
     */
    @Test
    public void testUpvote()
    {
        comment.upvote();
        assertEquals(1, comment.getVoteCount());
    }

    /**
     * Test downvoting the comment.
     */
    @Test
    public void testDownvote()
    {
        comment.downvote();
        assertEquals(-1, comment.getVoteCount());
    }

    /**
     * Test the full details of the comment.
     */
    @Test
    public void testGetFullDetails()
    {
        String expected = "Rating: ****    By: John Doe\n    This is a comment text.\n(Voted as helpful: 0)\n";
        assertEquals(expected, comment.getFullDetails());
    }
}
