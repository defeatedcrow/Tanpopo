package schr0.tanpopo.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import schr0.tanpopo.init.TanpopoTileEntitys;

public class ProxyServer
{

	public void preInitEventProxy(FMLPreInitializationEvent event)
	{
		// none
	}

	public void initEventProxy(FMLInitializationEvent event)
	{
		(new TanpopoTileEntitys()).init();
	}

	public void postInitEventProxy(FMLPostInitializationEvent event)
	{
		// none
	}

	public Minecraft getMinecraft()
	{
		return (Minecraft) null;
	}

	public void infoModLog(String format, Object... data)
	{
		// none
	}

}
