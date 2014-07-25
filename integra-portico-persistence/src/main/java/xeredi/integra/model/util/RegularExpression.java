package xeredi.integra.model.util;

import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class RegularExpression.
 */
public final class RegularExpression {

    /**
     * Test.
     */
    public void test() {
        // http://stackoverflow.com/questions/3373885/splitting-a-simple-maths-expression-with-regex
        // http://www.redalyc.org/articulo.oa?id=81690111

        String regex = "(?<=op)|(?=op)".replace("op", "[-|+|*|/|(|)|(NOT)|(AND)|(OR)]");

        final Pattern pattern = Pattern.compile(regex);

        System.out.println(java.util.Arrays.toString("-1.5+4.2*(5+2)/10-4 NOT 6".split(regex)));
    }

    /**
     * The main method.
     *
     * @param args
     *            the args
     */
    public static void main(final String[] args) {
        final RegularExpression expression = new RegularExpression();

        expression.test();
    }
}
