package com.qiuyue.ustc_zzzz.fmltutor.creativetab;

import com.qiuyue.ustc_zzzz.fmltutor.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 */
public class CreativeTabsFMLTutor extends CreativeTabs {
    public CreativeTabsFMLTutor()
    {
        super("fmltutor");
        this.setBackgroundImageName("fmltutor.png");

    }


    /**
     * 返回的是创造模式物品栏上显示的物品
     * @return
     */
    @Override
    public Item getTabIconItem()
    {
        return ItemLoader.goldenEgg;
    }


    /**
     * 设置有搜索框
     * @return
     */
    @Override
    public boolean hasSearchBar()
    {
        return true;
    }
}
