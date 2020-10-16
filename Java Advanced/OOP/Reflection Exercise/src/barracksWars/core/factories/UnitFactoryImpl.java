package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.lang.reflect.InvocationTargetException;


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
		return (Unit) Class.forName(UNITS_PACKAGE_NAME + unitType).getConstructor().newInstance();
//		for (Class<?> aClass : classes) {
//			if (aClass.getSimpleName().equals(unitType)) {
//				return (Unit) Class.forName(unitType).getConstructor().newInstance();
//			}
//		}
//		throw new ExecutionControl.NotImplementedException("message");
	}
}
