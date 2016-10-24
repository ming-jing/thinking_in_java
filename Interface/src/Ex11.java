/**
 * Created by belows on 2016/10/19.
 */
interface Processor {
    String name();
    Object process(Object input);
}

class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s =
            "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args) {
        process(new Filter(new Swap()),"I like you");
    }
}

class Filter implements Processor {
    Swap swap;

    Filter(Swap swap) {
        this.swap = swap;
    }
    @Override
    public String name() {
        return "Filter";
    }

    @Override
    public String process(Object input) {
        return swap.process(input);
    }
}
class Swap {

    public String process(Object input) {
        String s = (String) input;
        char[] cs = s.toCharArray();
        for (int i=0,size=cs.length;i+1<size; i+=2) {
            char c = cs[i];
            char c1 = cs[i+1];
            cs[i] = c1;
            cs[i+1] = c;
        }
        return new String(cs);
    }
}

public class Ex11 {
    public static void main(String[] args) {
        Apply.main(args);
    }
}
