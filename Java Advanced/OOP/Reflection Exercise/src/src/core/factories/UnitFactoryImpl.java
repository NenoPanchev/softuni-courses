package core.factories;

import interfaces.Unit;
import interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;
import models.units.AbstractUnit;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		// TODO: implement for problem 3
//		Class<Package> pa = Package.class;
//
//		Class<AbstractUnit> abstractUnit = AbstractUnit.class;
//		Class<Unit> unit = Unit.class;
//		Class<? extends AbstractUnit>[] classes = (Class<? extends AbstractUnit>[]) pa.getClasses();
//		Class<? extends Unit>[] classez = (Class<? extends Unit>[]) unit.getDeclaredClasses();
		Unit unit1 = (Unit) Class.forName("models.units." + unitType).getConstructor().newInstance();
		return unit1;
//		for (Class<?> aClass : classes) {
//			if (aClass.getSimpleName().equals(unitType)) {
//				return (Unit) Class.forName(unitType).getConstructor().newInstance();
//			}
//		}
//		throw new ExecutionControl.NotImplementedException("message");
	}
}
