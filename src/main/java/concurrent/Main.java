package concurrent;

import concurrent.examples.FastSerialization;

public class Main {

    /**
     * @param args
     */
    public static void main(String... args) {
        // new InitialSkipChecker().check();
        // new PrincipleSkipChecker().check();
        // new ShallowCopyChecker().check();
        // new HidePasswordChecker().check();
        new FastSerialization().check();
    }

}
