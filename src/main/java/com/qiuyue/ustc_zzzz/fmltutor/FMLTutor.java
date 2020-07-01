package com.qiuyue.ustc_zzzz.fmltutor;


import com.qiuyue.ustc_zzzz.fmltutor.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 */
@Mod(modid = FMLTutor.MODID, name = FMLTutor.NAME, version = FMLTutor.VERSION, acceptedMinecraftVersions = "1.8.9")
public class FMLTutor {

    public static final String MODID = "fmltutor";
    public static final String NAME = "FML Tutor";
    public static final String VERSION = "1.0.0";

    /**
     * Instance注解的作用是将生成的该Mod的实例，注册到对应的Mod的id，同时，也可以访问其他Mod的id对应的实例
     */
    @Instance(FMLTutor.MODID)
    public static FMLTutor instance;

    @SidedProxy(clientSide = "com.qiuyue.ustc_zzzz.fmltutor.client.ClientProxy",
            serverSide = "com.qiuyue.ustc_zzzz.fmltutor.common.CommonProxy")
    public static CommonProxy proxy;


    /**
     * 在所有Mod初始化之前调用，这时候应该加载配置文件，实例化物品和方块，并注册它们。
     * @param event
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    /**
     * 用于该Mod的初始化，这时候应该为Mod进行设置，如注册合成表和烧炼系统，并且向其他Mod发送交互信息。
     * @param event
     */
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    /**
     * 在所有Mod都初始化之后调用，这时候应该接收其他Mod发送的交互信息，并完成对Mod的设置。
     * @param event
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
