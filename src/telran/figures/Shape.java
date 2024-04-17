package telran.figures;

import java.util.Objects;

public abstract class Shape {
   protected long id;
   public abstract int square();
   public abstract int perimeter();
   public Shape(long id) {
	   this.id = id;
	   }
   public long getId() {
	   return id;
   }
   @Override 
   public int hashCode() {
	   return Objects.hash(id);
   }
   @Override
   public boolean equals(Object obj) {
       if (this == obj) {
           return true;
       }
       if (obj == null || getClass() != obj.getClass()) {
           return false;
       }
       Shape shape = (Shape) obj;
       return id == shape.id;
   }
}
