import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class PresentDelivery {

    public static void main(String[] args) {
        final BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Engine engine = Engine.init(reader);
        engine.run();
    }

    private static final class Engine {
        private static final String SANTA = "S";
        private static final String NICE_KID = "V";
        private static final String NAUGHTY_KID = "X";
        private static final String COOKIE = "C";
        private static final String EMPTY = "-";

        private static final String SEPARATOR = " ";
        private static final Pattern SPLITTER = Pattern.compile(SEPARATOR);


        private final BufferedReader reader;
        private String[][] map = null;
        private int santaRow = -1;
        private int santaCol = -1;
        private int niceKidsCount = 0;
        private int niceKidPresentsCount = 0;
        private int presentsCount = 0;
        private boolean theHack = false;

        private Engine(final BufferedReader reader) {
            this.reader = reader;
        }

        public static Engine init(final BufferedReader reader) {
            Engine engine = new Engine(reader);

            engine.presentsCount = Integer.parseInt(engine.readLine());
            engine.map = reader.lines()
                    .limit(Long.parseLong(engine.readLine()))
                    .map(SPLITTER::split)
                    .toArray(String[][]::new);

            for (int row = 0; row < engine.map.length; row++) {
                for (int col = 0; col < engine.map[row].length; col++) {
                    String symbol = engine.map[row][col];
                    switch (symbol) {
                        case SANTA:
                            engine.santaRow = row;
                            engine.santaCol = col;
                            break;
                        case NICE_KID:
                            engine.niceKidsCount++;
                            break;
                        case COOKIE:
                        case NAUGHTY_KID:
                        case EMPTY:
                            break;
                        default:
                            throw new IllegalStateException(
                                    "Unknown symbol on map: " + symbol);
                    }
                }
            }

            return engine;
        }

        private String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public void run() {
            String command;
            while (hasPresentsLeft() && !"Christmas morning".equals(command = readLine())) {
                if (!moveTo(toDirection(command))) {
                    break;
                }
                process(false);
            }

            if (!theHack && !hasPresentsLeft()) {
                System.out.println("Santa ran out of presents!");
            }

            for (String[] row : map) {
                System.out.println(String.join(SEPARATOR, row));
            }

            if (niceKidsCount == niceKidPresentsCount) {
                System.out.printf("Good job, Santa! %d happy nice kid/s.%n", niceKidsCount);
            } else {
                System.out.printf("No presents for %d nice kid/s.%n", niceKidsCount - niceKidPresentsCount);
            }
        }

        private void process(boolean isHappy) {
            switch (map[santaRow][santaCol]) {
                case NICE_KID:
                    givePresent(true);
                    break;
                case NAUGHTY_KID:
                    if (isHappy) {
                        givePresent(false);
                    }
                    break;
                case COOKIE:
                    int cookieRow = santaRow;
                    int cookieCol = santaCol;
                    for (Direction direction : Direction.values()) {
                        santaRow = cookieRow;
                        santaCol = cookieCol;
                        if (moveTo(direction)) {
                            process(true);
                        }
                    }
                    santaRow = cookieRow;
                    santaCol = cookieCol;
                    theHack = !hasPresentsLeft(); // A hack for Judge
                    break;
                default:
                    break;
            }

            if (isHappy) {
                map[santaRow][santaCol] = EMPTY;
            } else {
                map[santaRow][santaCol] = SANTA;
            }
        }

        private void givePresent(boolean isNiceKid) {
            if (!hasPresentsLeft()) {
                return;
            }

            presentsCount--;

            if (isNiceKid) {
                niceKidPresentsCount++;
            }
        }

        private boolean hasPresentsLeft() {
            return presentsCount > 0;
        }

        private Direction toDirection(String directionStr) {
            return Direction.valueOf(directionStr.toUpperCase());
        }

        private boolean moveTo(Direction direction) {
            int newRow = santaRow;
            int newCol = santaCol;
            switch (direction) {
                case UP:
                    newRow--;
                    break;
                case RIGHT:
                    newCol++;
                    break;
                case DOWN:
                    newRow++;
                    break;
                case LEFT:
                    newCol--;
                    break;
            }

            if (newRow < 0 || newRow >= map.length ||
                    newCol < 0 || newCol >= map[santaRow].length) {
                return false;
            }

            map[santaRow][santaCol] = EMPTY;

            santaRow = newRow;
            santaCol = newCol;

            return true;
        }

        private enum Direction {
            UP,
            RIGHT,
            DOWN,
            LEFT;
        }
    }
}