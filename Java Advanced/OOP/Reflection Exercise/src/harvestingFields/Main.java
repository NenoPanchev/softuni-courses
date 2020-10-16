package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Class<RichSoilLand> reflectionTestClass = RichSoilLand.class;

		String input = scan.nextLine();
		while (!input.equals("HARVEST")) {
			Field[] fields = fillFieldsArrayByModifier(reflectionTestClass, input);
			Arrays.stream(fields).forEach(field -> System.out.printf("%s %s %s%n",
					Modifier.toString(field.getModifiers()),
					field.getType().getSimpleName(),
					field.getName()));
			input = scan.nextLine();
		}
	}

	private static Field[] fillFieldsArrayByModifier(Class<RichSoilLand> reflectionTestClass, String input) {
		Field[] fields;
		switch (input) {
			case "private":
				fields = Arrays.stream(reflectionTestClass.getDeclaredFields())
						.filter(field -> Modifier.isPrivate(field.getModifiers()))
						.toArray(Field[]::new);
				break;

			case "protected":
				fields = Arrays.stream(reflectionTestClass.getDeclaredFields())
						.filter(field -> Modifier.isProtected(field.getModifiers()))
						.toArray(Field[]::new);
				break;

			case "public":
				fields = Arrays.stream(reflectionTestClass.getFields())
						.toArray(Field[]::new);
				break;

			default:
				fields = Arrays.stream(reflectionTestClass.getDeclaredFields())
						.toArray(Field[]::new);
		}
		return fields;
	}
}
