package org.diamond;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DiamondKataTest {
    private DiamondKata diamondKata = new DiamondKata();

    @Test
    public void testLetterAMinimum() {
        String expected = "A";

        generateUserInput("A");
        String actual = diamondKata.diamondGenerator();

        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
        assertEquals(expected.indexOf("A"), actual.indexOf("A"));
        int index = expected.indexOf("A");
        assertEquals(expected.charAt(index), actual.charAt(index));
    }

    @Test
    public void testLetterBUppercase(){
        String expected =
                " A \n" +
                "B B\n" +
                " A ";

        generateUserInput("B");
        String actual = diamondKata.diamondGenerator();

        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
        assertEquals(expected.indexOf("B"), actual.indexOf("B"));
        int index = expected.indexOf("B");
        assertEquals(expected.charAt(index), actual.charAt(index));
    }

    @Test
    public void testLetterBLowercase(){
        String expected =
                        " A \n" +
                        "B B\n" +
                        " A ";

        generateUserInput("b");

        String actual = diamondKata.diamondGenerator();

        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
        assertEquals(expected.indexOf("B"), actual.indexOf("B"));
        int index = expected.indexOf("B");
        assertEquals(expected.charAt(index), actual.charAt(index));
    }

    @Test
    public void testLetterM() {
        String expected =
                "            A            \n" +
                "           B B           \n" +
                "          C   C          \n" +
                "         D     D         \n" +
                "        E       E        \n" +
                "       F         F       \n" +
                "      G           G      \n" +
                "     H             H     \n" +
                "    I               I    \n" +
                "   J                 J   \n" +
                "  K                   K  \n" +
                " L                     L \n" +
                "M                       M\n" +
                " L                     L \n" +
                "  K                   K  \n" +
                "   J                 J   \n" +
                "    I               I    \n" +
                "     H             H     \n" +
                "      G           G      \n" +
                "       F         F       \n" +
                "        E       E        \n" +
                "         D     D         \n" +
                "          C   C          \n" +
                "           B B           \n" +
                "            A            ";

        generateUserInput("m");
        String actual = diamondKata.diamondGenerator();

        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
    }

    @Test
    public void testLetterZMaximum() {
        String expected =
                        "                         A                         \n" +
                        "                        B B                        \n" +
                        "                       C   C                       \n" +
                        "                      D     D                      \n" +
                        "                     E       E                     \n" +
                        "                    F         F                    \n" +
                        "                   G           G                   \n" +
                        "                  H             H                  \n" +
                        "                 I               I                 \n" +
                        "                J                 J                \n" +
                        "               K                   K               \n" +
                        "              L                     L              \n" +
                        "             M                       M             \n" +
                        "            N                         N            \n" +
                        "           O                           O           \n" +
                        "          P                             P          \n" +
                        "         Q                               Q         \n" +
                        "        R                                 R        \n" +
                        "       S                                   S       \n" +
                        "      T                                     T      \n" +
                        "     U                                       U     \n" +
                        "    V                                         V    \n" +
                        "   W                                           W   \n" +
                        "  X                                             X  \n" +
                        " Y                                               Y \n" +
                        "Z                                                 Z\n" +
                        " Y                                               Y \n" +
                        "  X                                             X  \n" +
                        "   W                                           W   \n" +
                        "    V                                         V    \n" +
                        "     U                                       U     \n" +
                        "      T                                     T      \n" +
                        "       S                                   S       \n" +
                        "        R                                 R        \n" +
                        "         Q                               Q         \n" +
                        "          P                             P          \n" +
                        "           O                           O           \n" +
                        "            N                         N            \n" +
                        "             M                       M             \n" +
                        "              L                     L              \n" +
                        "               K                   K               \n" +
                        "                J                 J                \n" +
                        "                 I               I                 \n" +
                        "                  H             H                  \n" +
                        "                   G           G                   \n" +
                        "                    F         F                    \n" +
                        "                     E       E                     \n" +
                        "                      D     D                      \n" +
                        "                       C   C                       \n" +
                        "                        B B                        \n" +
                        "                         A                         ";

        generateUserInput("z");
        String actual = diamondKata.diamondGenerator();

        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
    }

    @Test
    public void testEmptyInput() {
        String expected = "";

        generateUserInput("");
        ByteArrayOutputStream outputContent = recordOutput();
        String actual = diamondKata.diamondGenerator();

        assertTrue(outputContent.toString().contains("Please enter a single letter"));
        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
    }

    @Test
    public void testIncorrectInputMultipleValues() {
        String expected = "";

        generateUserInput(String.format("aaa", System.lineSeparator()));
        ByteArrayOutputStream outputContent = recordOutput();
        String actual = diamondKata.diamondGenerator();

        assertTrue(outputContent.toString().contains("Please enter a single letter"));
        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
    }

    @Test
    public void testIncorrectInputSymbols() {
        String expected = "";

        generateUserInput(String.format("?", System.lineSeparator()));
        ByteArrayOutputStream outputContent = recordOutput();
        String actual = diamondKata.diamondGenerator();

        assertTrue(outputContent.toString().contains("Please only enter letters"));
        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
    }

    @Test
    public void testIncorrectInputInts() {
        String expected = "";

        generateUserInput(String.format("1", System.lineSeparator()));
        ByteArrayOutputStream outputContent = recordOutput();
        String actual = diamondKata.diamondGenerator();

        assertTrue(outputContent.toString().contains("Please only enter letters"));
        assertEquals(expected, actual);
        assertEquals(expected.length(), actual.length());
    }

    public void generateUserInput(String userInput){
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
    }

    public ByteArrayOutputStream recordOutput(){
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        return outputContent;
    }

}