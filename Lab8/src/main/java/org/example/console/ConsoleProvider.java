package org.example.console;

import org.example.resources.UIResources;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class ConsoleProvider {
    private final Map<Class, Supplier<Object>> keyboardParseInputs;

    private final Scanner keyboard = new Scanner(System.in);

    public ConsoleProvider() {
        this.keyboardParseInputs = new HashMap<>() {{
            put(Integer.class, keyboard::nextInt);
            put(Double.class, keyboard::nextDouble);
            put(String.class, keyboard::nextLine);
            put(Byte.class, keyboard::nextByte);
            put(BigDecimal.class, keyboard::nextBigDecimal);
            put(BigInteger.class, keyboard::nextBigInteger);
            put(Boolean.class, keyboard::nextBoolean);
            put(Float.class, keyboard::nextFloat);
            put(Long.class, keyboard::nextLong);
            put(Short.class, keyboard::nextShort);
        }};
    }

    public void print(Object o) {
        System.out.print(o);
    }

    public void println(Object o) {
        System.out.println(o);
    }

    public void println() {
        System.out.println();
    }

    public <T> T prompt(String message, Class<T> expectedClass) {
        boolean isValid = false;
        Object input = null;
        T output = null;
        this.print(message);

        while (!isValid) {
            try {
                input = keyboardParseInputs.get(expectedClass).get();

                output = expectedClass.cast(input);
                isValid = output.toString().length() != 0;
            } catch (InputMismatchException ignored) {
            } finally {
                if (expectedClass != String.class) {
                    keyboard.nextLine();
                }
                if (!isValid) {
                    this.print(UIResources.INPUT_ERROR_MESSAGE);
                }
            }
        }

        return output;
    }
}
