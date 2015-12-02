package brazillianforgers.mods.IndustrialExpansion;

public class Lib {
    //Mod Identity
    public static final String MODID = "IndustrialExpansion";
    public static final String VERSION = "1.0d";
    public static final String MODNAME = "Industrial Expansion";
    public static final String DEPS = "required-after:BRForgersCore@[1.2,);required-after:ThermalExpansion";// + ";required-after:MODID"; for Each other MOD

    //Little Helper, huh?
    public static final String TEXTURE_PATH = MODID + ":";
    public static final String UPDATEURL = "https://raw.githubusercontent.com/TheBrazillianForgersTeam/IndustrialExpansion/master/latest.txt";

    //Easter Eggs
    public static final String INITLOG = "Compressing...";

    //Proxy Identity
    public static final String COMMONPROXY = "brazillianforgers.mods.IndustrialExpansion.proxy.CommonProxy";
    public static final String CLIENT = "brazillianforgers.mods.IndustrialExpansion.proxy.ClientProxy";
}
