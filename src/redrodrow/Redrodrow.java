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

    private static String kalevala = "Mieleni minun tekevi, aivoni ajattelevi \n"
            + "lähteäni laulamahan, saa'ani sanelemahan, \n"
            + "sukuvirttä suoltamahan, lajivirttä laulamahan. \n"
            + "Sanat suussani sulavat, puhe'et putoelevat, \n"
            + "kielelleni kerkiävät, hampahilleni hajoovat.";

    private static String lipsumDotCom = "Mauris cursus sem semper nunc feugiat dapibus. "
            + "Nunc non efficitur sapien. Quisque tempus ante tempor turpis blandit dapibus. "
            + "Proin in porttitor lectus. "
            + "Praesent suscipit arcu est, eu consectetur nulla tempus id. "
            + "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; "
            + "Fusce euismod felis a erat eleifend, et fringilla lectus eleifend. Donec iaculis rhoncus sagittis. "
            + "Cras sapien nisi, tincidunt id lacinia ac, varius a tellus.";

    private static String juhaszGyula = "A nappal fényében, zajában\n"
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

    private static String canterburyTales = "Whan that Aprill, with his shoures soote\n"
            + "The droghte of March hath perced to the roote\n"
            + "And bathed every veyne in swich licour,\n"
            + "Of which vertu engendred is the flour;\n"
            + "Whan Zephirus eek with his sweete breeth\n"
            + "Inspired hath in every holt and heeth\n"
            + "The tendre croppes, and the yonge sonne\n"
            + "Hath in the Ram his halfe cours yronne,\n"
            + "And smale foweles maken melodye,\n"
            + "That slepen al the nyght with open eye-\n"
            + "(So priketh hem Nature in hir corages);\n"
            + "Thanne longen folk to goon on pilgrimages";

    public static List<String> splitWordsIntoList(String text) {
        List<String> wordsInOriginalOrder = new ArrayList<String>();

        String pat = "([A-Za-z0-9-_.?!,;'\"&@></\\ÖÜÓŐÚÉÁŰÍöüóőúéáűíä]*)( |$|\\n)";

        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            wordsInOriginalOrder.add(matcher.group(1));
        }

        return wordsInOriginalOrder;

    }

    public static String recursiveChangeOrder(List<String> wordsInOriginalOrder) {
        if (wordsInOriginalOrder.size() == 1) {
            return wordsInOriginalOrder.get(0).toString();
        }

        int lastIndex = wordsInOriginalOrder.size() - 1;

        String lastWord = wordsInOriginalOrder.get(lastIndex).toString();
        List<String> previousWords = wordsInOriginalOrder.subList(0, lastIndex);

        return lastWord + " " + recursiveChangeOrder(previousWords).toString();

    }

    public static String forChangeOrder(List<String> wordsInOriginalOrder) {
        String reversedWords = "";

        for (int i = wordsInOriginalOrder.size() - 1; i > 0; i--) {
            reversedWords = reversedWords + wordsInOriginalOrder.get(i) + " ";
        }
        reversedWords = reversedWords + wordsInOriginalOrder.get(0);

        return reversedWords;
    }

    public static void printBothVersions(List<String> words, String title) {
        String forVersion = forChangeOrder(words);
        String recursiveVersion = recursiveChangeOrder(words);

        System.out.println(title);
        System.out.println(forVersion);
        System.out.println(recursiveVersion);
        
        System.out.println("\n----------------------\n");

    }

    public static void main(String[] args) {

        List<String> words = splitWordsIntoList("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        printBothVersions(words, "Number Sequence");
        
        words = splitWordsIntoList(kalevala);
        printBothVersions(words, "Kalevala");

        words = splitWordsIntoList(canterburyTales);
        printBothVersions(words, "Canterbury Tales");
        
        words = splitWordsIntoList(juhaszGyula);
        printBothVersions(words, "Juhasz Gyula");
        
        words = splitWordsIntoList(lipsumDotCom);
        printBothVersions(words, "Lorem Ipsum");
    }

}
