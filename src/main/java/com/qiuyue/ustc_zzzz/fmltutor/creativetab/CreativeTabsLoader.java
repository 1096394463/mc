package com.qiuyue.ustc_zzzz.fmltutor.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 */
public class CreativeTabsLoader{
        public static CreativeTabs tabFMLTutor;

        public CreativeTabsLoader(FMLPreInitializationEvent event)
        {
            tabFMLTutor = new CreativeTabsFMLTutor();
        }
}
