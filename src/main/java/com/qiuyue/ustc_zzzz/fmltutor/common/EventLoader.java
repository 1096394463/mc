package com.qiuyue.ustc_zzzz.fmltutor.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/7/1
 * 事件
 */
public class EventLoader {

    public static final EventBus EVENT_BUS = new EventBus();


    public EventLoader()
    {
        //事件注册
        MinecraftForge.EVENT_BUS.register(this);

        EventLoader.EVENT_BUS.register(this);
        //使用EventBus的register方法，注册了所有我们想要注册的事件。
        //除此之外，Forge还提供了需要在MinecraftForge.TERRAIN_GEN_BUS上注册的地形生成事件，
        //需要在MinecraftForge.ORE_GEN_BUS上注册的矿物生成事件等等
    }

    /**
     * 物品即将被捡起的时候触发
     * @param event
     * SubscribeEvent注解有两个参数，其中一个是receiveCanceled，与是否取消该事件相关，默认为false，这个参数不太常用，我们不去管它。还有一个参数是priority，比较常用，表示事件的优先级
     */
    @SubscribeEvent
    public void onPlayerItemPickup(PlayerEvent.ItemPickupEvent event)
    {
        //event.player.isServerWorld()用于检测调用该事件的游戏到底是客户端还是服务端，往往我们只希望服务端调用代码，
        // 这是因为服务端产生的变化，客户端往往都会同步，比如这里的向玩家输出游戏控制台信息
        if (event.player.isServerWorld())
        {
            String info = String.format("%s picks up: %s", event.player.getName(), event.pickedUp.getEntityItem());
            ConfigLoader.logger().info(info);
        }
    }

    /**
     * 玩家在和物品或方块互动的时候触发的事件
     * @param event
     */
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if (!event.world.isRemote)
        {
            String info = String.format("%s interacts with: %s", event.entityPlayer.getName(), event.pos);
            ConfigLoader.logger().info(info);
        }
    }

    /**
     * 自定义新的事件类
     */

    @Cancelable
    public static class PlayerRightClickGrassBlockEvent extends net.minecraftforge.event.entity.player.PlayerEvent
    {

        public final BlockPos pos;
        public final World world;

        public PlayerRightClickGrassBlockEvent(EntityPlayer player, BlockPos pos, World world)
        {
            super(player);
            this.pos = pos;
            this.world = world;
        }


    }

    @SubscribeEvent
    public void onPlayerClickGrassBlock(PlayerRightClickGrassBlockEvent event)
    {
        if (!event.world.isRemote)
        {
            BlockPos pos = event.pos;
            Entity tnt = new EntityTNTPrimed(event.world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, null);
            event.world.spawnEntityInWorld(tnt);
        }
    }

    @SubscribeEvent
    public void onEntityInteract(EntityInteractEvent event)
    {
        EntityPlayer player = event.entityPlayer;
        if (player.isServerWorld() && event.target instanceof EntityPig)
        {
            EntityPig pig = (EntityPig) event.target;
            //获取手上的物品
            ItemStack stack = player.getCurrentEquippedItem();
            //如果物品是小麦或小麦种子
            if (stack != null && (stack.getItem() == Items.wheat || stack.getItem() == Items.wheat_seeds))
            {
                //当希望对实体产生对应伤害时，就可以通过调用实体的attackEntityFrom
                //setDefficultyScaled方法设置的属性表示受到的伤害随着难度的变化而变化。
                //setExplosion方法设置的属性表示该伤害由爆炸造成，爆炸保护附魔会起到作用。
                player.attackEntityFrom((new DamageSource("byPig")).setDifficultyScaled().setExplosion(), 8.0F);
                player.worldObj.createExplosion(pig, pig.posX, pig.posY, pig.posZ, 2.0F, false);
                pig.setDead();
            }
        }
    }


}
