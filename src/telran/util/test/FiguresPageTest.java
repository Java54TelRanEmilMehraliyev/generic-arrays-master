package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.figures.*;
import telran.figures.exceptions.ShapeAlreadyExistsException;
import telran.figures.exceptions.ShapeNotFoundException;

class FiguresPageTest {
    Page page;
    Shape shape1;
    Shape shape2;
    Canvas canvas1;

    @BeforeEach
    void setUp() {
        page = new Page();
        shape1 = new Rectangle(1, 10, 20); 
        shape2 = new Rectangle(2, 15, 25);
        canvas1 = new Canvas(3);
    }

    @Test
    void testAddShape() {
        page.addShape(shape1);
        assertThrows(ShapeAlreadyExistsException.class, () -> page.addShape(shape1));
    }

    @Test
    void testRemoveShape() {
        page.addShape(shape1);
        assertEquals(shape1, page.removeShape(shape1.getId()));
        assertThrows(ShapeNotFoundException.class, () -> page.removeShape(shape1.getId()));
    }

    @Test
    void testAddShapeToCanvas() {
        page.addShape(canvas1);
        page.addShape(new Long[]{canvas1.getId()}, shape2);
        assertThrows(ShapeAlreadyExistsException.class, () -> page.addShape(new Long[]{canvas1.getId()}, shape2));
    }

    @Test
    void testRemoveShapeFromCanvas() {
        page.addShape(canvas1);
        page.addShape(new Long[]{canvas1.getId()}, shape2);
        assertEquals(shape2, page.removeShape(new Long[]{canvas1.getId()}, shape2.getId()));
        assertThrows(ShapeNotFoundException.class, () -> page.removeShape(new Long[]{canvas1.getId()}, shape2.getId()));
    }
    @Test
	void testIterator() {
		page.addShape(shape1);
		page.addShape(shape2);
		page.addShape(canvas1);
		
		Iterator<Shape> iterator = page.iterator();
		assertTrue(iterator.hasNext());
		assertEquals(shape1,iterator.next());
		assertEquals(shape2,iterator.next());
		assertEquals(canvas1, iterator.next());
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> iterator.next());
	}
}