import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesItem = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesItem.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesItem.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesItem = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesItem.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesItem = new SalesItem("test name", 1000);
        assertEquals("test name", salesItem.getName());
        assertEquals(1000, salesItem.getPrice());
    }

    /**
     * Test that adding a comment from the same author returns false.
     */
    @Test
    public void testAddCommentSameAuthor()
    {
        SalesItem salesItem = new SalesItem("Brain surgery for Dummies", 21998);
        salesItem.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4);
        assertFalse(salesItem.addComment("James Duckling", "I changed my mind. Still good.", 5)); // Should return false
    }

    /**
     * Test negative rating boundaries (0 and 6).
     */
    @Test
    public void testInvalidRatingBoundaries()
    {
        SalesItem salesItem = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertFalse(salesItem.addComment("Joshua Black", "Not worth the money. The font is too small.", 0));  // Below lower boundary
        assertFalse(salesItem.addComment("Joshua Black", "Not worth the money. The font is too small.", 6));  // Above upper boundary
    }

    /**
     * Test that the most helpful comment is returned correctly.
     */
    @Test
    public void testFindMostHelpfulComment()
    {
        SalesItem salesItem = new SalesItem("Brain Surgery for Dummies", 21998);
        salesItem.addComment("John", "Great book!", 5);
        salesItem.addComment("James", "Not too bad", 3);
        salesItem.addComment("Emma", "Excellent", 4);
        salesItem.upvoteComment(0); // John has the most upvotes now
        salesItem.upvoteComment(0); // John has 2 upvotes
        Comment mostHelpful = salesItem.findMostHelpfulComment();
        assertEquals("John", mostHelpful.getAuthor()); // John should be the most helpful comment
    }
}
