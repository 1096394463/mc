package com.qiuyue.ustc_zzzz.fmltutor.common;

import com.qiuyue.ustc_zzzz.fmltutor.block.BlockLoader;
import com.qiuyue.ustc_zzzz.fmltutor.crafting.CraftingLoader;
import com.qiuyue.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import com.qiuyue.ustc_zzzz.fmltutor.item.ItemLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 * 服务端代理
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {

        new ConfigLoader(event);
        //创造模式物品栏的初始化一定要在物品和方块的初始化之前
        new CreativeTabsLoader(event);

        new ItemLoader(event);

        new BlockLoader(event);

    }

    public void init(FMLInitializationEvent event) {
        //注册燃料
        new CraftingLoader();

        //事件
        new EventLoader();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
