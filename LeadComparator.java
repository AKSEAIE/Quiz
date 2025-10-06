import java.util.Comparator;

public class LeadComparator implements Comparator<String>{
    /**
     * Comparator that compares the scores, and if the scores are equal, will compare the time.
     */
    @Override
    public int compare(String o1, String o2) {
        String[] test1 = o1.split(": ");
        Integer scored = Integer.parseInt(test1[1]);
        Integer timed = Integer.parseInt(test1[3]);

        String[] test2 = o2.split(": ");
        Integer scored2 = Integer.parseInt(test2[1]);
        Integer timed2 = Integer.parseInt(test2[3]);

    if(scored == scored2){
        return timed.compareTo(timed2);
    }

    else{

        return scored2.compareTo(scored);//reason its switch is because it ranks in descending order/
    }

    

    

  
}
}
