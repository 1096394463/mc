package com.qiuyue.ustc_zzzz.fmltutor.item;

import com.qiuyue.ustc_zzzz.fmltutor.item.equipment.ItemRedstoneArmor;
import com.qiuyue.ustc_zzzz.fmltutor.item.food.ItemRedstoneApple;
import com.qiuyue.ustc_zzzz.fmltutor.item.other.ItemGoldenEgg;
import com.qiuyue.ustc_zzzz.fmltutor.item.tool.ItemRedstonePickaxe;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 * 物品注册加载
 */

public class ItemLoader {
    public static Item goldenEgg = new ItemGoldenEgg();
    public static Item redstonePickaxe = new ItemRedstonePickaxe();
    public static Item redstoneApple = new ItemRedstoneApple();

    public static Item redstoneHelmet = new ItemRedstoneArmor.Helmet();
    public static Item redstoneChestplate = new ItemRedstoneArmor.Chestplate();
    public static Item redstoneLeggings = new ItemRedstoneArmor.Leggings();
    public static Item redstoneBoots = new ItemRedstoneArmor.Boots();

    public ItemLoader(FMLPreInitializationEvent event) {

        register(goldenEgg, "golden_egg");
        register(redstonePickaxe, "redstone_pickaxe");
        register(redstoneApple, "redstone_apple");

        register(redstoneHelmet, "redstone_helmet");
        register(redstoneChestplate, "redstone_chestplate");
        register(redstoneLeggings, "redstone_leggings");
        register(redstoneBoots, "redstone_boots");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {

        registerRender(goldenEgg);
        registerRender(redstonePickaxe);
        registerRender(redstoneApple);

        registerRender(redstoneHelmet);
        registerRender(redstoneChestplate);
        registerRender(redstoneLeggings);
        registerRender(redstoneBoots);

    }

    private static void register(Item item, String name) {
        //GameRegistry是Forge提供的一个用来注册物品、方块、合成表、烧炼规则等各种常见内容的类
        //registerBlock方法用于注册方块
        //registerFuelHandler方法用于注册燃料
        //registerItem方法用于注册物品
        //registerTileEntity方法用于注册TileEntity（后面会讲到什么是TileEntity）
        //registerWorldGenerator方法用于注册世界生成器以生成不同的世界
        //addRecipe方法和addShapedRecipe方法用于注册合成表
        //addSmelting方法用于注册物品烧炼规则
        GameRegistry.registerItem(item.setRegistryName(name));


    }

    /**
     * SideOnly注解的作用是注解这一方法、类等只作用于客户端或服务端。
     *
     * @param item
     */
    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item) {

        System.out.println("寻找模型资源");
        //ModelResourceLocation被用于标注模型的位置，通常为由冒号（:）和井号（#）分隔的三个字符串组成，对于我们这里构造的ModelResourceLocation，它的一部分通过调用物品的getRegistryName方法得到，第二部分由我们指定，为inventory，是一个固定的字符串，代表作为一个物品的渲染模型。
        //在这里，第一部分为fmltutor:golden_egg，第二部分为inventory，组合后的ModelResourceLocation就是fmltutor:golden_egg#inventory。Minecraft便会去相应的目录下寻找相应的资源：
        //fmltutor指示游戏应该在assets.fmltutor包下找到这个资源
        //inventory指示游戏应该在assets.fmltutor.models.item包下找到这个资源
        //golden_egg指示这个资源就是assets.fmltutor.models.item.golden_egg.json，对应到源代码，就是src/main/resources/assets/fmltutor/models/item/golden_egg.json这一文件

        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");


        System.out.println("加载模型资源");

        //Forge提供了ModelLoader类用于加载和处理模型，其setCustomModelResourceLocation方法有三个参数：
        //第一个参数是要被注册的物品。
        //第二个参数是这个物品的Metadata。Metadata是一个用于区分同一个物品或方块的不同状态的数据，比如钟表的十六种状态、羊毛的十六种颜色，在3.2.1节会讲到Metadata，默认为零就好了。
        //第三个参数就是这个物品模型的资源位置了，资源位置是类ModelResourceLocation的一个实例，它用于描述一个模型，在后面我们还会比较常用到这个类的。
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }

}
