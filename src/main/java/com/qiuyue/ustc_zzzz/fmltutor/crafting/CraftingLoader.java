package com.qiuyue.ustc_zzzz.fmltutor.crafting;

import com.qiuyue.ustc_zzzz.fmltutor.block.BlockLoader;
import com.qiuyue.ustc_zzzz.fmltutor.common.ConfigLoader;
import com.qiuyue.ustc_zzzz.fmltutor.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/7/1
 */
public class CraftingLoader {
    public CraftingLoader() {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    /**
     * 合成表
     */
    private static void registerRecipe() {
        //添加有序合成表
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.goldenEgg), new Object[]
                {
                        "###", "#*#", "###", '#', Items.gold_ingot, '*', Items.egg
                });
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.grassBlock), new Object[]
                {
                        "##", "##", '#', Blocks.vine
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstonePickaxe), new Object[]
                {
                        "###", " * ", " * ", '#', Items.redstone, '*', Items.stick
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneApple), new Object[]
                {
                        "###", "#*#", "###", '#', Items.redstone, '*', Items.apple
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneHelmet), new Object[]
                {
                        "###", "# #", '#', Items.redstone
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneChestplate), new Object[]
                {
                        "# #", "###", "###", '#', Items.redstone
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneLeggings), new Object[]
                {
                        "###", "# #", "# #", '#', Items.redstone
                });
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.redstoneBoots), new Object[]
                {
                        "# #", "# #", '#', Items.redstone
                });
        //添加无序合成表
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.vine, 4), BlockLoader.grassBlock);

    }

    /**
     * 烧炼规则
     */
    private static void registerSmelting() {

        //第一个参数是待烧炼的物品，第二个参数是烧炼后的物品，第三个参数是烧炼后玩家可以得到的经验。
        GameRegistry.addSmelting(BlockLoader.grassBlock, new ItemStack(Items.coal), 0.5F);


    }

    /**
     * 燃料
     */
    private static void registerFuel() {

        //注册燃料需要实现IFuelHandler接口
        GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            //getBurnTime方法，该方法判断物品的烧炼时间，如果返回0，则为不能判断物品的烧炼时间。
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                //这里的烧炼时间为gametick，一秒为20个gametick，下面列出一些常见的烧炼时间数据：
                //树苗　　100
                //木板　　200
                //煤炭　　1600
                //烈焰棒　2400
                //煤炭块　16000
                //岩浆桶　20000
                return Items.diamond != fuel.getItem() ? 0 : Math.max(0, ConfigLoader.diamondBurnTime) * 20;
            }
        });

    }
}
