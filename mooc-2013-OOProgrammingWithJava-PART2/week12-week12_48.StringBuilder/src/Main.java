
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
               
        /*
        The curly brackets are on their own lines. There are up to four values 
        in each line of the table, and the first value requires an initial space. 
        Before each number, and after the comma there must be exactly one space.
        */
        
        StringBuilder thing = new StringBuilder();
        thing.append("{ \n");
        
        int things_on_line = 0;
        for (int i = 0; i < t.length; i++) {
            if(things_on_line == 0) {
                thing.append(" ");
            }
            thing.append(t[i]);
            things_on_line++;
            if(i != t.length - 1) {
                thing.append(", ");
            }
            
            if(i == t.length - 1) {
                thing.append("\n");
            }
            else if(things_on_line == 4) {
                thing.append("\n");
                things_on_line = 0;
            }          
        }
        
        thing.append("} ");
        
        return thing.toString();
  
        
        
    }
}
