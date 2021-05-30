//20558940

import java.util.LinkedList;
import java.util.List;

/**
 * This class is about the game invitonment object.
 * Its actually a collection of the objects that can be collided in the game.
 */
public class GameEnvironment {
    //fields
   private List<Collidable> collidables = new LinkedList<>();

    /**
     * counstructor. its initializing a list and assining it into this.
     */
   public GameEnvironment() {
       List<Collidable> col = new LinkedList<Collidable>();
       this.collidables = collidables;
   }

    /**
     * This method adding collidable into the collection.
     * @param c A collidable object.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * This method removes collidable from the gameEnviroment.
     * @param c - the collidable.
     */
    public void removeCollidble(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * This method getting the collidale object closest intesectoin point with a given line.
     * @param trajectory our line,kind of a vector.
     * @return a collisionInfo object about the collision. if there isnt collision return null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //some counters.
       int count = 0, wantedObject = 0, i = 0;
       //inputting the trajector end point into a variable Point type.
       Point closest = new Point(trajectory.end().getX(), trajectory.end().getY());
       //goes over all the collidables in the array
       for (Collidable c : collidables) {
           //counts the loop repetition
           i++;
           Rectangle r = c.getCollisionRectangle();
           //finding the closest intecstion of the rectangle
           Point p = trajectory.closestIntersectionToStartOfLine(r);
           if (p == null) {
               //if returns null for all the collidables,there isnt intersection at all.
               count++;
               if (count == collidables.size()) {
                   return null;
               }
               continue;
           }
           //if there is,updating the point and the index of the closest collision point.
           if (p.distance(trajectory.start()) <= closest.distance(trajectory.start())) {
               wantedObject = i - 1;
               closest = p;
           }

        }
       //return the closest collision point
         return new CollisionInfo(closest , collidables.get(wantedObject));
    }
}