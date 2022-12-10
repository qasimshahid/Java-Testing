public class MiscTests {

    public static void main(String[] args) {
        //String search
        String s = new String("GarbageCollectionGarblolololGarblol\n\nIhateGarb");
        String a = new String("hry");

        StringBuilder lookl =  new StringBuilder(a);
        int size = 0;
        char array[] = s.toCharArray();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            out.append(array[i]);
            if (out.indexOf(a) != -1) {
                size = size + 1;
                out = new StringBuilder();
            }

        }

        System.out.println(size);
    }




}
