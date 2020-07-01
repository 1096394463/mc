package com.qiuyue.ustc_zzzz.fmltutor.item.tool;

import com.qiuyue.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/7/1
 */
public class ItemRedstonePickaxe extends ItemPickaxe {
    //harvestLevel参数表示制作出的工具等级
    //maxUses参数表示制作出的工具对应耐久
    //efficiency参数表示制作出的工具使用效率
    //damageVsEntity参数表示攻击伤害力度
    //enchantability参数与附魔等级相关
    public static final Item.ToolMaterial REDSTONE = EnumHelper.addToolMaterial("REDSTONE", 3, 16, 16.0F, 0.0F, 10);


    public ItemRedstonePickaxe() {
        super(REDSTONE);
        this.setUnlocalizedName("redstonePickaxe");
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
    }
}
