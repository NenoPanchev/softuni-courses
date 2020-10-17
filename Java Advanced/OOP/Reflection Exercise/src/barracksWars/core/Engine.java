package barracksWars.core;

import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		String COMMANDS_PACKAGE_NAME = "barracksWars.core.commands.";
		StringBuilder commandCorrectName = new StringBuilder(commandName);
		commandCorrectName.replace(0, 1, String.valueOf(Character.toUpperCase(commandCorrectName.charAt(0))));
		Class<?> clazz = Class.forName(COMMANDS_PACKAGE_NAME + commandCorrectName.toString());
		Constructor<?> constructor = clazz.getConstructor(String[].class);
		Executable command = (Executable) constructor.newInstance((Object) data);
		this.injectFields(command);
		Method method = command.getClass().getMethod("execute");
		String result = (String) method.invoke(command);
		return result;
	}

	private void injectFields(Executable executable) throws IllegalAccessException, NoSuchFieldException {
		Field[] thisFields = this.getClass().getDeclaredFields();
		Field[] commandFields = Arrays.stream(executable.getClass().getDeclaredFields())
				.filter(field -> field.getAnnotations()[0].toString().contains("Inject"))
				.toArray(Field[]::new);

		for (Field commandField : commandFields) {
			for (Field thisField : thisFields) {
				if (commandField.getName().equals(thisField.getName())) {
					commandField.setAccessible(true);
					commandField.set(executable, thisField.get(this));
				}
			}
		}
	}
}
