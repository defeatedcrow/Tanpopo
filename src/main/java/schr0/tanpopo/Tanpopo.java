package schr0.tanpopo;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import schr0.tanpopo.init.TanpopoBehaviorsDispenser;
import schr0.tanpopo.init.TanpopoBehaviorsEssenceCauldron;
import schr0.tanpopo.init.TanpopoBlocks;
import schr0.tanpopo.init.TanpopoConfig;
import schr0.tanpopo.init.TanpopoEvent;
import schr0.tanpopo.init.TanpopoFluids;
import schr0.tanpopo.init.TanpopoFuelHandler;
import schr0.tanpopo.init.TanpopoItems;
import schr0.tanpopo.init.TanpopoRecipe;
import schr0.tanpopo.proxy.ProxyServer;

@Mod(modid = Tanpopo.MOD_ID, name = Tanpopo.MOD_NAME, version = Tanpopo.MOD_VERSION, dependencies = Tanpopo.MOD_DEPENDENCIES, guiFactory = Tanpopo.MOD_GUI_FACTORY)
public class Tanpopo
{
	/**
	 * ModのID.
	 */
	public static final String MOD_ID = "schr0tanpopo";

	/**
	 * Modの名前.
	 */
	public static final String MOD_NAME = "Tanpopo";

	/**
	 * Modのバージョン.
	 */
	public static final String MOD_VERSION = "1.1.1";

	/**
	 * Forgeのバージョン.
	 */
	public static final String MOD_DEPENDENCIES = "required-after:Forge@[1.10.2-12.18.3.2185,)";

	/**
	 * ModのGuiFactory.
	 */
	public static final String MOD_GUI_FACTORY = "schr0.tanpopo.init.TanpopoConfigGuiFactory";

	/**
	 * ResourceLocationのDomain.
	 */
	public static final String MOD_RESOURCE_DOMAIN = MOD_ID + ":";

	@Mod.Instance(Tanpopo.MOD_ID)
	public static Tanpopo instance;

	@SidedProxy(clientSide = "schr0.tanpopo.proxy.ProxyClient", serverSide = "schr0.tanpopo.proxy.ProxyServer")
	public static ProxyServer proxy;

	/**
	 * Modの構築時イベント.
	 */
	@Mod.EventHandler
	public void constructionEvent(FMLConstructionEvent event)
	{
		FluidRegistry.enableUniversalBucket();
	}

	/**
	 * Modの事前・初期設定時イベント.
	 */
	@Mod.EventHandler
	public void preInitEvent(FMLPreInitializationEvent event)
	{
		TanpopoConfig.syncConfig();

		(new TanpopoFluids()).init();

		(new TanpopoItems()).init();

		(new TanpopoBlocks()).init();

		this.proxy.preInitEventProxy(event);
	}

	/**
	 * Modの事中・初期設定時イベント.
	 */
	@Mod.EventHandler
	public void initEvent(FMLInitializationEvent event)
	{
		(new TanpopoBehaviorsDispenser()).init();

		(new TanpopoBehaviorsEssenceCauldron()).init();

		(new TanpopoRecipe()).init();

		(new TanpopoFuelHandler()).init();

		(new TanpopoEvent()).init();

		this.proxy.initEventProxy(event);
	}

	/**
	 * Modの事後・初期設定時イベント.
	 */
	@Mod.EventHandler
	public void postInitEvent(FMLPostInitializationEvent event)
	{
		this.proxy.postInitEventProxy(event);
	}

}
