package telran.figures.exceptions;

@SuppressWarnings("serial")
public class ShapeAlreadyExistsException extends IllegalStateException {
   public ShapeAlreadyExistsException(long id) {
	   super(String.format("Shape with id %d already exist",id));
   }
}
