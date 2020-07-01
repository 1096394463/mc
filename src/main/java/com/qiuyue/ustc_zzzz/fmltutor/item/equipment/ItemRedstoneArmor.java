package com.qiuyue.ustc_zzzz.fmltutor.item.equipment;

import com.qiuyue.ustc_zzzz.fmltutor.FMLTutor;
import com.qiuyue.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/7/1
 */
public class ItemRedstoneArmor extends ItemArmor {
    //name参数与该ArmorMaterial的材质所在位置有关，这一部分的稍后面会讲到。这里是“fmltutor:redstone”。
    //maxDamage参数和该ArmorMaterial对应的盔甲的耐久成正比。这里刻意降低了大小，为10。
    //reductionAmounts参数的四个元素表示对应盔甲的头盔、胸甲、护腿、和靴子抵御伤害的能力，如皮甲分别为1，3，2，1，和为7，钻石甲分别为3，8，6，3，和为20，请不要让四个元素值的和超过这个值。这里为2，6，4，2，和为14。
    //enchantability参数和ToolMaterial一样，和对应盔甲的附魔能力正相关，同样，金盔甲的附魔能力最高。这里为10。
    public static final ItemArmor.ArmorMaterial REDSTONE_ARMOR = EnumHelper.addArmorMaterial("REDSTONE",
            FMLTutor.MODID + ":" + "redstone", 10, new int[]
                    {2, 6, 4, 2}, 10);

    public ItemRedstoneArmor(int armorType) {
        super(REDSTONE_ARMOR, REDSTONE_ARMOR.ordinal(), armorType);
    }



    public static class Helmet extends ItemRedstoneArmor
    {
        public Helmet()
        {
            super(0);
            this.setUnlocalizedName("redstoneHelmet");
            this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        }
    }

    public static class Chestplate extends ItemRedstoneArmor
    {
        public Chestplate()
        {
            super(1);
            this.setUnlocalizedName("redstoneChestplate");
            this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        }
    }

    public static class Leggings extends ItemRedstoneArmor
    {
        public Leggings()
        {
            super(2);
            this.setUnlocalizedName("redstoneLeggings");
            this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        }
    }

    public static class Boots extends ItemRedstoneArmor
    {
        public Boots()
        {
            super(3);
            this.setUnlocalizedName("redstoneBoots");
            this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);
        }
    }
}
