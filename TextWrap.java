
public class TextWrap {

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final int MAX_NUMBER_OF_CHARACTER = 13;

    public static void wrapTheText(String text) {

        StringBuilder builder = new StringBuilder(); // builder will hold the wrapped text

        String[] words = text.split(SPACE); // will hold the separated words into an array

        int room = MAX_NUMBER_OF_CHARACTER; // count how much room left in the line


        for (String word : words) {

            if (room == MAX_NUMBER_OF_CHARACTER) {  // the line is empty
                builder.append(word);
                room -= word.length();

            } else if (room < MAX_NUMBER_OF_CHARACTER) { // there is at least 1 word in the line

                if (word.length() < room) {             // there is enough room to add the word
                    builder.append(SPACE).append(word);
                    room -= (word.length() + 1);
                }

                else if (word.length() >= room) {           // there isn't enough room to add the word
                    builder.append(NEW_LINE).append(word);  // start a new line and append the word
                    room = MAX_NUMBER_OF_CHARACTER - word.length();
                }
            }
        }

        System.out.println(builder.toString());

    }

    public static void main(String[] args) {

        String string = "Four score and seven years ago our fathers brought forth upon this continent a new nation, " +
                "conceived in liberty and dedicated to the proposition that all men are created equal";

        wrapTheText(string);
    }
}
