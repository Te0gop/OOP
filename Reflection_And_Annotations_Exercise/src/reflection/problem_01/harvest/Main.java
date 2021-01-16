package reflection.problem_01.harvest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Class<RichSoilLand> reflection = RichSoilLand.class;
		Scanner scanner = new Scanner(System.in);

		String modifier;

		while(!(modifier = scanner.nextLine()).equals("HARVEST")) {
			Field[] fields = reflection.getDeclaredFields();
			System.out.print(getModifierFields(fields, modifier));
		}
	}
	public static String getModifierFields(Field[] fields, String modifier) {
		StringBuilder sb = new StringBuilder();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (Modifier.toString(mod).equals(modifier) || modifier.equals("all")) {
				sb.append(Modifier.toString(mod)).append(" ").append(field.getType().getSimpleName())
						.append(" ").append(field.getName()).append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
}
