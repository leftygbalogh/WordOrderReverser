/*
 * Code is prose.
 * 
 * Lefty G Balogh
 */
package redrodrow;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lefty G Balogh
 */
public class Redrodrow {

    public static String changeWordOrder(String text) {
        List<String> wordsInOriginalOrder = new ArrayList<String>();
        String reversedWords = "";
        String pat = "([a-z0-9-_.?!]*)( |$|\\n)";

        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            wordsInOriginalOrder.add(matcher.group(1));
        }

        for (int i = wordsInOriginalOrder.size() - 1; i > 0; i--) {
            reversedWords = reversedWords + wordsInOriginalOrder.get(i) + " ";
        }
        reversedWords = reversedWords + wordsInOriginalOrder.get(0);

        return reversedWords;
    }

    public static void main(String[] args) {
        System.out.println(changeWordOrder("meg nyilnak a ketrben"));
        
        String lipsumDotCom = "Mauris cursus sem semper nunc feugiat dapibus. "
                + "Nunc non efficitur sapien. Quisque tempus ante tempor turpis blandit dapibus. "
                + "Proin in porttitor lectus. "
                + "Praesent suscipit arcu est, eu consectetur nulla tempus id. "
                + "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; "
                + "Fusce euismod felis a erat eleifend, et fringilla lectus eleifend. Donec iaculis rhoncus sagittis. "
                + "Cras sapien nisi, tincidunt id lacinia ac, varius a tellus.";

        String juhaszGyula = "A nappal fényében, zajában\n"
                + "Elődöng árva egymagában\n"
                + "A lelkem, tévedt jövevény,\n"
                + "Oly idegen nekem a hajsza,\n"
                + "A szívemet dalokra ajzva\n"
                + "Oly inkognitó megyek én.\n"
                + "\n"
                + "De ha az alkonyat leszállott,\n"
                + "Olyan kedves, kámzsás barátok\n"
                + "A barna árnyékok nekem,\n"
                + "A messze menteket idézik,\n"
                + "A múlt szelíden iderémlik\n"
                + "És földereng az életem.";

        String canterburyTales = "Whan that Aprill, with his shoures soote\n"
                + "The droghte of March hath perced to the roote\n"
                + "And bathed every veyne in swich licour,\n"
                + "Of which vertu engendred is the flour;\n"
                + "5	Whan Zephirus eek with his sweete breeth\n"
                + "Inspired hath in every holt and heeth\n"
                + "The tendre croppes, and the yonge sonne\n"
                + "Hath in the Ram his halfe cours yronne,\n"
                + "And smale foweles maken melodye,\n"
                + "10	That slepen al the nyght with open eye-\n"
                + "(So priketh hem Nature in hir corages);\n"
                + "Thanne longen folk to goon on pilgrimages";
        System.out.println(changeWordOrder(lipsumDotCom));
        System.out.println(changeWordOrder(juhaszGyula));
        System.out.println(changeWordOrder(canterburyTales));
    }

}
