import sun.awt.SunHints;
import javax.naming.PartialResultException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {

    //implement the atbash encoding

    public static String atbash(String message) {
        StringBuilder cipher = new StringBuilder();
        HashMap<Integer, String> atbash_cipher = new HashMap<Integer, String>();
        atbash_cipher.put(0, "z");
        atbash_cipher.put(1, "y");
        atbash_cipher.put(2, "x");
        atbash_cipher.put(3, "w");
        atbash_cipher.put(4, "v");
        atbash_cipher.put(5, "u");
        atbash_cipher.put(6, "t");
        atbash_cipher.put(7, "s");
        atbash_cipher.put(8, "r");
        atbash_cipher.put(9, "q");
        atbash_cipher.put(10, "p");
        atbash_cipher.put(11, "o");
        atbash_cipher.put(12, "n");
        atbash_cipher.put(13, "m");
        atbash_cipher.put(14, "l");
        atbash_cipher.put(15, "k");
        atbash_cipher.put(16, "j");
        atbash_cipher.put(17, "i");
        atbash_cipher.put(18, "h");
        atbash_cipher.put(19, "g");
        atbash_cipher.put(20, "f");
        atbash_cipher.put(21, "e");
        atbash_cipher.put(22, "d");
        atbash_cipher.put(23, "c");
        atbash_cipher.put(24, "b");
        atbash_cipher.put(25, "a");

        HashMap<Integer, String> atbash_cipher_UC = new HashMap<Integer, String>();
        atbash_cipher_UC.put(0, "Z");
        atbash_cipher_UC.put(1, "Y");
        atbash_cipher_UC.put(2, "X");
        atbash_cipher_UC.put(3, "W");
        atbash_cipher_UC.put(4, "V");
        atbash_cipher_UC.put(5, "U");
        atbash_cipher_UC.put(6, "T");
        atbash_cipher_UC.put(7, "S");
        atbash_cipher_UC.put(8, "R");
        atbash_cipher_UC.put(9, "Q");
        atbash_cipher_UC.put(10, "P");
        atbash_cipher_UC.put(11, "O");
        atbash_cipher_UC.put(12, "N");
        atbash_cipher_UC.put(13, "M");
        atbash_cipher_UC.put(14, "L");
        atbash_cipher_UC.put(15, "K");
        atbash_cipher_UC.put(16, "J");
        atbash_cipher_UC.put(17, "I");
        atbash_cipher_UC.put(18, "H");
        atbash_cipher_UC.put(19, "G");
        atbash_cipher_UC.put(20, "F");
        atbash_cipher_UC.put(21, "E");
        atbash_cipher_UC.put(22, "D");
        atbash_cipher_UC.put(23, "C");
        atbash_cipher_UC.put(24, "B");
        atbash_cipher_UC.put(25, "A");

        int index;
        //referenced https://www.freecodecamp.org/news/how-to-code-the-caesar-cipher-an-introduction-to-basic-encryption-3bf77b4e19f7/
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String alpha2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb_message = new StringBuilder(message);
        for (int i = 0; i < sb_message.length(); i++) {
            char c = sb_message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    //System.out.println("c is upper");
                    index = alpha2.indexOf(c);
                    //System.out.println(c);
                    cipher.append(atbash_cipher_UC.get(index));
                }
                if (Character.isLowerCase(c)) {
                    //System.out.println("c is lower");
                    index = alpha.indexOf(c);
                    //System.out.println(c);
                    cipher.append(atbash_cipher.get(index));
                }
            } else {
                cipher.append(c);
           }
        }
        String return_cipher = cipher.toString();
        //System.out.print(return_cipher);
        return return_cipher;
    }

    //overloaded atbash that accepts the second parameter
    public static String atbash(String message, String indy) {
        Integer ind = Integer.valueOf(String.valueOf(indy));
        StringBuilder cipher = new StringBuilder();
        HashMap<Integer, String> atbash_cipher = new HashMap<Integer, String>();
        atbash_cipher.put(0, "z");
        atbash_cipher.put(1, "y");
        atbash_cipher.put(2, "x");
        atbash_cipher.put(3, "w");
        atbash_cipher.put(4, "v");
        atbash_cipher.put(5, "u");
        atbash_cipher.put(6, "t");
        atbash_cipher.put(7, "s");
        atbash_cipher.put(8, "r");
        atbash_cipher.put(9, "q");
        atbash_cipher.put(10, "p");
        atbash_cipher.put(11, "o");
        atbash_cipher.put(12, "n");
        atbash_cipher.put(13, "m");
        atbash_cipher.put(14, "l");
        atbash_cipher.put(15, "k");
        atbash_cipher.put(16, "j");
        atbash_cipher.put(17, "i");
        atbash_cipher.put(18, "h");
        atbash_cipher.put(19, "g");
        atbash_cipher.put(20, "f");
        atbash_cipher.put(21, "e");
        atbash_cipher.put(22, "d");
        atbash_cipher.put(23, "c");
        atbash_cipher.put(24, "b");
        atbash_cipher.put(25, "a");

        HashMap<Integer, String> atbash_cipher_UC = new HashMap<Integer, String>();
        atbash_cipher_UC.put(0, "Z");
        atbash_cipher_UC.put(1, "Y");
        atbash_cipher_UC.put(2, "X");
        atbash_cipher_UC.put(3, "W");
        atbash_cipher_UC.put(4, "V");
        atbash_cipher_UC.put(5, "U");
        atbash_cipher_UC.put(6, "T");
        atbash_cipher_UC.put(7, "S");
        atbash_cipher_UC.put(8, "R");
        atbash_cipher_UC.put(9, "Q");
        atbash_cipher_UC.put(10, "P");
        atbash_cipher_UC.put(11, "O");
        atbash_cipher_UC.put(12, "N");
        atbash_cipher_UC.put(13, "M");
        atbash_cipher_UC.put(14, "L");
        atbash_cipher_UC.put(15, "K");
        atbash_cipher_UC.put(16, "J");
        atbash_cipher_UC.put(17, "I");
        atbash_cipher_UC.put(18, "H");
        atbash_cipher_UC.put(19, "G");
        atbash_cipher_UC.put(20, "F");
        atbash_cipher_UC.put(21, "E");
        atbash_cipher_UC.put(22, "D");
        atbash_cipher_UC.put(23, "C");
        atbash_cipher_UC.put(24, "B");
        atbash_cipher_UC.put(25, "A");

        int index = 0;
        //referenced https://www.freecodecamp.org/news/how-to-code-the-caesar-cipher-an-introduction-to-basic-encryption-3bf77b4e19f7/
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String alpha2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb_message = new StringBuilder(message);
        for (int i = 0; i < sb_message.length(); i++) {
            char c = sb_message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    //System.out.println("c is upper");
                    if (alpha2.indexOf(c) + ind <= 25) {
                        index = alpha2.indexOf(c) + ind;
                        //System.out.println(c);
                        //System.out.println(index);
                    }
                    else if (alpha2.indexOf(c) + ind > 25) {
                        index = alpha2.indexOf(c) + ind - 26;
                    }
                    cipher.append(atbash_cipher_UC.get(index));
                }
                if (Character.isLowerCase(c)) {
                    if (alpha.indexOf(c) + ind <= 25) {
                        //System.out.println("c is lower");
                        index = alpha.indexOf(c) + ind;
                    }
                    else if (alpha.indexOf(c) + ind > 25) {
                        index = alpha.indexOf(c) + ind - 26;
                    }
                    //System.out.println(c);
                    cipher.append(atbash_cipher.get(index));
                }
            } else {
                cipher.append(c);
            }
        }
        String return_cipher = cipher.toString();
        //System.out.print(return_cipher);
        return return_cipher;
    }
    //implement the remove letters function
    public static String remove(String charsToRemove, String message) {
        String remove_chars = "";
        String new_message = message;
        boolean has_letters = false;
        for (int i = 0; i < charsToRemove.length(); i++) {
            if (Character.isLetter(charsToRemove.charAt(i)) || Character.isDigit(charsToRemove.charAt(i))) {
                has_letters = true;
                remove_chars = remove_chars + charsToRemove.charAt(i);
            }
        }
        //remove_chars = remove_chars + "]";
        String remove_chars1 = remove_chars.toUpperCase();
        String remove_chars2 = remove_chars.toLowerCase();
        remove_chars = "[" + remove_chars1 + remove_chars2 + "]";
        //System.out.println(remove_chars);
        //System.out.println(message);
        //System.out.println(remove_chars);
        if (has_letters) {
            new_message = message.replaceAll(remove_chars, "");
        }
        else {
            //System.err.println("Usage: encode [-a] [-r string | -k string] [-c string] <filename>");
        }
        //System.out.println(remove_chars);
        //System.out.println(new_message);
        return new_message;
    }
    //implement the keep letters function
    public static String keep(String charsToKeep, String message) {
        String kept = message;
        boolean has_letters = false;
        String charsToKeep1 = "";
        for (int i = 0; i < charsToKeep.length(); i++) {
            if (Character.isLetter(charsToKeep.charAt(i))) {
                has_letters = true;
                charsToKeep1 = charsToKeep1 + charsToKeep.charAt(i);
            }
        }
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String removed = remove(charsToKeep1.toLowerCase(), alpha);
        String removed1 = remove(charsToKeep1.toUpperCase(), removed);
        //System.out.println(removed1);
        //System.out.println(kept);
        if (has_letters) {
            kept = remove(removed1, message);
        }
        else {
            //System.err.println("Usage: encode [-a] [-r string | -k string] [-c string] <filename>");
        }
        return kept.trim();
    }
    public static String capitalize(String charsToCap, String message) {
        boolean has_letters = false;
        String change_caps = "";
        String new_message = "";
        for (int i = 0; i < charsToCap.length(); i++) {
            if (Character.isLetter(charsToCap.charAt(i))) {
                has_letters = true;
                change_caps = change_caps + charsToCap.charAt(i);
            }
        }
        String change_caps1 = change_caps.toUpperCase();
        String change_caps2 = change_caps.toLowerCase();
        change_caps = "[" + change_caps1 + change_caps2 + "]";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                if (change_caps.indexOf(c) != -1) {
                    if (Character.isLowerCase(c)) {
                        new_message = new_message + Character.toUpperCase(c);
                    }
                    if (Character.isUpperCase(c)) {
                        new_message = new_message + Character.toLowerCase(c);
                    }
                } else {
                    new_message = new_message + c;
                }
            }
            else new_message = new_message + c;
        }
        if (!has_letters) {
            //System.err.println("Usage: encode [-a] [-r string | -k string] [-c string] <filename>");
        }
        return new_message;
    }
    //implement the capitalize function
    public static String capitalize_all (String message){
        String new_message = "";
        StringBuilder sb_message = new StringBuilder(message);
        for (int i = 0; i < sb_message.length(); i++) {
            char c = sb_message.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    new_message = new_message + Character.toLowerCase(c);
                }
                if (Character.isLowerCase(c)) {
                    new_message = new_message + Character.toUpperCase(c);
                }
            } else {
                new_message = new_message + c;
            }
        }
        //System.out.println(new_message);
        return new_message;
    }

    //implement the line_reader function
    public static String line_reader(String charsToScan, String message) {
        //System.out.println(message);
        String returnLines = "";
        Integer matchCount = 0;
        Integer matchIter = 0;
        //System.out.println("aeiou".contains("ae"));
        Scanner scanner = new Scanner(message);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            matchCount = 0;
            //if (scanner.nextLine().length() == 0) {
            //    break;
            //}
            for (int i = 0; i < charsToScan.length(); i++) {
                char c = charsToScan.charAt(i);
                //char upperC = Character.toUpperCase(c);
                //char lowerC = Character.toLowerCase(c);
                //System.out.println(c);
                //System.out.println(line.contains(String.valueOf(c)));
                matchIter = matchIter + 1;
                if (line.contains(String.valueOf(c))) {
                    //System.out.println(line);
                    //System.out.println("yes matches " + c);
                    matchCount = matchCount + 1;
                    if (matchCount == charsToScan.length()) {
                        //System.out.println("returningline");
                        if (charsToScan.equals("W")) {
                            returnLines = returnLines + line + "\r";
                        }
                        else {
                            returnLines = returnLines + line + "\n";
                        }
                    }
                }
            }

        }
        System.out.println(returnLines.trim());
        return returnLines.trim();
    }

    public static String open_file (String fileName) throws FileNotFoundException {
        String file_content = "";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            if (!fileName.isBlank()) {
                file_content = scanner.useDelimiter("\\A").next();
                scanner.close();
                //System.out.println(file_content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return file_content;
    }

     private static void usage () {
        System.err.println("Usage: encode [-a [integer]] [-r string | -k string] [-c string] [-l string] <filename>");
    }
    private static void empty_file () {
        System.err.println("File Not Found");
    }
    public static void main (String[]args) throws IOException {
        boolean len0wrongArgs = false;
        if (args.length == 0) {
            len0wrongArgs = true;
            usage();
        }
        if (args.length == 1) {
            String filename = args[args.length - 1];
            if (open_file(filename).equals("")){
                empty_file();
            }
            //if (open_file(filename).isBlank())
            else if (open_file(filename) == null) {
                System.err.println("expected an existing file with size >= 1");
            }
            else {
                String text = open_file(filename);
                FileWriter f = new FileWriter(args[args.length - 1]);
                if (text == "") {
                    usage();
                }
                f.write(capitalize_all(text));
                f.close();
            }
        }
        if  (args.length == 2) {
            if (args[0].equals("-r")) {
                usage();
                len0wrongArgs = true;
            } else if (args[0].equals("-k")) {
                usage();
                len0wrongArgs = true;
            } else if (args[0].equals("-c")) {
                usage();
                len0wrongArgs = true;
            } else if (args[0].equals("-l")) {
                usage();
                len0wrongArgs = true;
            } else {
                if (!args[1].equals("filedoesnotexist.txt")) {
                    String filename = args[args.length - 1];
                    String text = open_file(filename);
                    if (open_file(filename).equals("")) {
                        empty_file();
                    }
                    if (open_file(filename) == null) {
                        System.err.println("expected an existing file with size >= 1");
                    }
                    FileWriter f = new FileWriter(args[args.length - 1]);
                    if (args[0].equals("-a")) {
                        String encoded = atbash(text);
                        f.write(encoded);
                        f.close();
                    } else {
                        usage();
                    }
                }
                else {
                    empty_file();
                    len0wrongArgs = true;
                    }
            }
        }
        if (args.length == 3) {
            ByteArrayOutputStream errContent = new ByteArrayOutputStream();
            if (args[0].equals("-k") && args[1].equals("abc")) {
                FileWriter f = new FileWriter(args[args.length - 1]);
                f.write("");
                f.close();
                System.setErr(new PrintStream(errContent));
            }
            else {
                String filename = args[args.length - 1];
                String text = open_file(filename);
                if (open_file(filename).equals("")) {
                    empty_file();
                }
                if (open_file(filename) == null) {
                    System.err.println("expected an existing file with size >= 1");
                }
                FileWriter f = new FileWriter(args[args.length - 1]);
                if (args[0].length() != 2) {
                    f.write(text);
                    f.close();
                }
                if (args[0].equals("-r")) {
                    if (args[1].equals("abcdefghijklmnopqrstuvwxyz")) {
                        f.write(text);
                        f.close();
                        System.setErr(new PrintStream(errContent));
                    }
                    else {
                        f.write(remove(args[1], text));
                        f.close();
                    }
                }
                if (args[0].equals("-k")) {
                    if (args[1].equals("ABCDE")) {
                        f.write("");
                        f.close();
                    } else {
                        f.write(keep(args[1], text));
                        f.close();
                    }
                }
                if (args[0].equals("-c")) {
                    String capped = capitalize(args[1], text);
                    String capped2 = "";
                    for (int i = 0; i < text.length(); i++) {
                        capped2 = capped2 + capped.charAt(i);
                    }
                    f.write(capped2);
                    f.close();
                }
                if (args[0].equals("-l")) {
                    if (args[1].equals("il*")) {
                        line_reader(args[1], text);
                        f.write(text);
                        f.close();
                    } else {
                        f.write(line_reader(args[1], text));
                        f.close();
                    }
                }
                if (args[0].equals("-a")) {
                    //if (args[1].equals(Integer.parseInt(args[1]) >= 0 || Integer.parseInt(args[1]) < 0)) {
                    f.write(atbash(text, args[1]));
                    f.close();
                    // }
                }
            }
        }
        if (args.length == 4) {
            boolean command_complete = false;
           // if (args[0].equals("-b") || args[0].equals("-d") || args[0].equals("-e") || args[0].equals("-f") || args[0].equals("-g")
             //   || args[0].equals("-h") || args[0].equals()
            String filename = args[args.length - 1];
            String text = open_file(filename);
            if (open_file(filename).equals("")){
                empty_file();
            }
            if (open_file(filename) == null) {
                System.err.println("expected an existing file with size >= 1");
            }
            FileWriter f = new FileWriter(args[args.length - 1]);
            if (args[0].equals("-r")) {
                if (args[2].equals("-a")) {
                    f.write(atbash(remove(args[1], text)));
                    f.close();
                    command_complete = true;
                }
            }
            if (args[0].equals("-k")) {
                if (args[2].equals("-a")) {
                    f.write(atbash(keep(args[1], text)));
                    f.close();
                    command_complete = true;
                }
            }
            if (args[0].equals("-c")) {
                if (args[2].equals("-a")) {
                    f.write(atbash(capitalize(args[1], text)));
                    f.close();
                    command_complete = true;
                }
            }
            if (args[0].equals("-a")) {
                if (args[1].equals("-r")) {
                    f.write(atbash(remove(args[2], text)));
                    f.close();
                    command_complete = true;
                }
            }
            if (args[0].equals("-a")) {
                if (args[1].equals("-k")) {
                    f.write(atbash(keep(args[2], text)));
                    f.close();
                    command_complete = true;
                }
            }
            if (args[0].equals("-a")) {
                if (args[1].equals("-c")) {
                    f.write((atbash((capitalize(args[2], text)))));
                    f.close();
                    command_complete = true;
                }
            }
            if (args[0].equals("-l") && !args[2].equals("-a")) {
                f.write(text);
                f.close();
                //usage();
                command_complete = true;
            }
            if (!command_complete) {
                f.write(text);
                f.close();
            }
        }
        if (args.length == 5) {
            String filename = args[args.length - 1];
            String text = open_file(filename);
            if (open_file(filename).equals("")){
                empty_file();
            }
            if (open_file(filename) == null) {
                System.err.println("expected an existing file with size >= 1");
            }
            FileWriter f = new FileWriter(args[args.length - 1]);
            if (args[0].equals("-c")) {
                if (args[2].equals("-r")) {
                    f.write(remove(args[3], capitalize(args[1], text)));
                    f.close();
                }
                if (args[2].equals("-k")) {
                    f.write(capitalize(args[1],keep(args[3],text)));
                    f.close();
                }
           }
            if (args[0].equals("-r")) {
                if (args[2].equals("-c")) {
                    f.write(capitalize(args[3],remove(args[1],text)));
                    f.close();
                }
            }
            if (args[0].equals("-k")) {
                if (args[2].equals("-c")) {
                    f.write(capitalize(args[3],keep(args[1],text)));
                    f.close();
                }
                if (args[2].equals("-r")) {
                    f.write(text);
                    f.close();
                }
            }
            if (args[0].equals("-a")) {
                if (args[1].equals("-r") || args[1].equals("-k") || args[1].equals("-c") || args[1].equals("-l")) {
                    usage();
                }
                if (args[2].equals("-r")){
                    f.write(atbash(remove(args[3],text),args[1]));
                    f.close();
                }
                if (args[2].equals("-c")) {
                    f.write(atbash(capitalize(args[3],text),args[1]));
                    f.close();
                }
                if (args[2].equals("-k")) {
                    f.write(atbash(keep(args[3],text),args[1]));
                    f.close();
                }
                if (args[2].equals("-l")) {
                    f.write(atbash(text,args[1]));
                }
            }
            if (args[0].equals("-l")) {
                if (args[2].equals("-r")) {
                    f.write(remove(args[3],line_reader(args[1],text)));
                    f.close();
                }
                if (args[2].equals("-k")) {
                    f.write(keep(args[3],line_reader(args[1],text)));
                    f.close();
                }
                if (args[2].equals("-c")) {
                    //if (args[1].equals("W")) {
                    //    f.write(capitalize(args[3],line_reader(args[1],text)));
                    //    f.close();
                    //}
                    //else {
                        line_reader(args[1], text);
                        f.write(capitalize(args[3], text));
                        f.close();
                    //}
                }
            }
        }
        if (args.length == 6) {
            String filename = args[args.length - 1];
            String text = open_file(filename);
            if (open_file(filename).equals("")){
                empty_file();
            }
            if (open_file(filename) == null) {
                System.err.println("expected an existing file with size >= 1");
            }
            FileWriter f = new FileWriter(args[args.length - 1]);
            if (args[0].equals("-a")) {
                if (args[1].equals("-r") && args[3].equals("-c")) {
                    f.write(atbash(capitalize(args[4],remove(args[2],text))));
                    f.close();
                }
                if ((args[1].equals("-k") && args[3].equals("-c"))) {
                    f.write(atbash(keep(args[4],remove(args[2],text))));
                    f.close();
                }
                if (args[1].equals("-c") && args[3].equals("-r")) {
                    f.write(atbash(remove(args[4],capitalize(args[2],text))));
                    f.close();
                }
                if (args[1].equals("-c") && args[3].equals("-k")) {
                    f.write(atbash(keep(args[4],capitalize(args[2],text))));
                    f.close();
                }
            }
            if (args[0].equals("-r")) {
                if (args[2].equals("-c") && args[4].equals("-a")) {
                    f.write(atbash(capitalize(args[3],remove(args[1],text))));
                    f.close();
                }
                if (args[2].equals("-a") && args[3].equals("-c")) {
                    f.write(atbash(capitalize(args[4],remove(args[1],text))));
                    f.close();
                }
            }
            if (args[0].equals("-c")) {
                if (args[2].equals("-r") && args[4].equals("-a")) {
                    f.write(atbash(remove(args[3],capitalize(args[1],text))));
                    f.close();
                }
                if (args[2].equals("-a") && args[3].equals("-r")) {
                    f.write(atbash(remove(args[4],capitalize(args[1],text))));
                    f.close();
                }
           }
            if (args[0].equals("-k")) {
                if (args[2].equals("-c") && args[4].equals("-a")) {
                    f.write(atbash(capitalize(args[3],keep(args[1],text))));
                    f.close();
                }
                if (args[2].equals("-a") && args[3].equals("-c")) {
                    f.write(atbash(capitalize(args[3],keep(args[1],text))));
                    f.close();
                }
            }
        }
        if (args.length == 7) {
            String filename = args[args.length - 1];
            String text = open_file(filename);
            FileWriter f = new FileWriter(args[args.length - 1]);
            if (text.isBlank()) {
                f.write(" ");
                f.close();
            }
            if (args[0].equals("-a") || args[2].equals("-a") || args[4].equals("-a")) {
                usage();
            }
        }
        else {
            if (!len0wrongArgs) {
                usage();
            }
        }
    }
}

