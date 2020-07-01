package com.qiuyue.ustc_zzzz.fmltutor.item.food;

import com.qiuyue.ustc_zzzz.fmltutor.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/7/1
 */
public class ItemRedstoneApple extends ItemFood {

    public ItemRedstoneApple()
    {
        //ItemFood类的构造方法一共有三个参数：
        //第一个参数amount表示该食物所能回复的饥饿值，这里被设定成和苹果相同，即4。
        //第二个参数saturation表示该食物所能添加的相对饱和度，其正比于饱和度和饥饿值的比值，这里设定为0.6F。
        //最后一个参数isWolfFood表示该食物能否被狼食用，这里简单地设置为false就可以了。
        //饱和度的计算：2 * amount * saturation。如面包的amount为5，其saturation为0.6F，对应的饱和度为2 5 0.6 = 6
        super(4, 0.6F, false);

        //setAlwaysEdible表示该食物何时何地都可以被食用，即便玩家不需要回复饥饿度和饱和值。
        this.setAlwaysEdible();
        this.setUnlocalizedName("redstoneApple");
        this.setCreativeTab(CreativeTabsLoader.tabFMLTutor);

        //添加药水效果
        //第一个参数表示对应药水效果的potionId，读者可以去net.minecraft.potion.Potion类中查看MC提供的二十四种药水效果，这里为伤害吸收。
        //第二个参数表示对应药水效果的持续时间，以秒计数，这里为十秒。
        //第三个参数表示对应药水效果的等级，很明显，0为一级，1为二级，2为三级，以此类推，这里为二级。
        //最后一个参数表示产生该药水效果的概率，这里为100%。
        this.setPotionEffect(Potion.absorption.id, 10, 1, 1.0F);
    }

    /**
     * 产生多种药水效果
     * @param stack
     * @param worldIn
     * @param player
     */
    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
            //10s饱和2
            player.addPotionEffect(new PotionEffect(Potion.saturation.id, 200, 1));
            //获得两点经验
            player.addExperience(10);
        }
        super.onFoodEaten(stack, worldIn, player);
    }
}
