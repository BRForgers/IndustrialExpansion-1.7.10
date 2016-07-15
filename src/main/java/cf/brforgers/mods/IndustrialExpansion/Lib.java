package cf.brforgers.mods.IndustrialExpansion;

public class Lib {
    //Mod Identity
    public static final String MODID = "IndustrialExpansion";
    public static final String VERSION = "BETA-v1.1.0-var1";
    public static final String MODNAME = "Industrial Expansion";
    public static final String DEPS = "required-after:BRCore@[1.0,);required-after:ThermalExpansion";// + ";required-after:MODID"; for Each other MOD

    //Little Helper, huh?
    public static final String RESOURCE_PATH = MODID + ":";
    public static final String UPDATEURL = "https://raw.githubusercontent.com/BRForgers/IndustrialExpansion/master/latest.txt";

    //Easter Eggs
    public static final String INITLOG = "Compressing...";

    //Proxy Identity
    public static final String COMMONPROXY = "cf.brforgers.mods.IndustrialExpansion.proxy.CommonProxy";
    public static final String CLIENT = "cf.brforgers.mods.IndustrialExpansion.proxy.ClientProxy";
}
