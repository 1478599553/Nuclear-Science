package nuclearscience.common.settings;

import electrodynamics.api.configuration.Configuration;
import electrodynamics.api.configuration.DoubleValue;
import electrodynamics.api.configuration.IntValue;

@Configuration(name = "Nuclear Science")
public class Constants {

	@DoubleValue(def = 120.0)
	public static double RADIOISOTOPEGENERATOR_VOLTAGE = 120.0;
	@DoubleValue(def = 0.2)
	public static double RADIOISOTOPEGENERATOR_OUTPUT_MULTIPLIER = 0.2f;
	@DoubleValue(def = 500000.0)
	public static double FISSIONREACTOR_MAXENERGYTARGET = 500000.0;
	@DoubleValue(def = 4000000.0)
	public static double FUSIONREACTOR_MAXENERGYTARGET = 4000000.0;
	@DoubleValue(def = 125000.0)
	public static double FUSIONREACTOR_USAGE_PER_TICK = 125000.0;
	@DoubleValue(def = 20000000.0)
	public static double PARTICLEINJECTOR_USAGE_PER_PARTICLE = 20000000.0;
	@IntValue(def = 1024)
	public static int FUSIONREACTOR_MAXSTORAGE = 1024;
	@IntValue(def = 2500)
	public static int REACTOR_RADIATION_PER_FUEL = 2500;
	@DoubleValue(def = 750)
	public static double CHEMICALBOILER_USAGE_PER_TICK = 750.0;
	@IntValue(def = 800)
	public static int CHEMICALBOILER_REQUIRED_TICKS = 800;
	@DoubleValue(def = 750)
	public static double CHEMICALEXTRACTOR_USAGE_PER_TICK = 750.0;
	@IntValue(def = 400)
	public static int CHEMICALEXTRACTOR_REQUIRED_TICKS = 400;
	@DoubleValue(def = 1500)
	public static double GASCENTRIFUGE_USAGE_PER_TICK = 1500.0;
	@IntValue(def = 20)
	public static int GASCENTRIFUGE_REQUIRED_TICKS_PER_PROCESSING = 20;
}
