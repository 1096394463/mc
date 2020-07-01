package com.qiuyue.ustc_zzzz.fmltutor.item.other;

import com.qiuyue.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 *
 */
public class ItemGoldenEgg extends Item {

    public ItemGoldenEgg() {
        super();
        this.setUnlocalizedName("goldenEgg");
        System.out.println("实例化一个金蛋");

        //物品注册到物品栏
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
    }

}
