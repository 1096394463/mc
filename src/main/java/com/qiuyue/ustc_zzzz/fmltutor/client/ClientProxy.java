package com.qiuyue.ustc_zzzz.fmltutor.client;

import com.qiuyue.ustc_zzzz.fmltutor.common.CommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 * 客户端代理
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        new ItemRenderLoader();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
