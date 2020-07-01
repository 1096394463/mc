package com.qiuyue.ustc_zzzz.fmltutor.block;

import com.qiuyue.ustc_zzzz.fmltutor.common.EventLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 */
public class BlockGrassBlock extends Block {
    public BlockGrassBlock()
    {
        //setBlockUnbreakable方法用于设定方块的硬度为-1，即不能损坏。
        //setHardness方法用于设定方块的硬度，如黑曜石是50，铁块5，金块3，圆石2，石头1.5，南瓜1，泥土0.5，甘蔗0，基岩-1。
        //setHarvestLevel方法用于设定方块的可挖掘等级，如钻石镐是3，铁2，石1，木金0。
        //setLightLevel方法用于设定方块的光照，其周围的光照为设定值x15，如岩浆1.0，对应15，红石火把0.5，对应7.5。
        //setLightOpacity方法用于设定方块的透光率，数值越大透光率越低，如树叶和蜘蛛网是1，水和冰3。
        //setResistance方法用于设定方块的爆炸抗性，如木头的抗性为4，石头为10，黑曜石为2000，基岩为6000000。
        //setStepSound方法用于设定走在方块上的响声。
        //setTickRandomly方法用于设定方块是否会接受随机Tick（如农作物）。
        super(Material.ground);
        this.setUnlocalizedName("grassBlock");
        this.setHardness(0.5F);
        this.setStepSound(soundTypeGrass);

        //创造模式加载此物品
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * 草块右击事件
     * @param worldIn
     * @param pos
     * @param state
     * @param playerIn
     * @param side
     * @param hitX
     * @param hitY
     * @param hitZ
     * @return
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumFacing side, float hitX, float hitY, float hitZ)
    {
        EventLoader.PlayerRightClickGrassBlockEvent event;
        event = new EventLoader.PlayerRightClickGrassBlockEvent(playerIn, pos, worldIn);
        EventLoader.EVENT_BUS.post(event);
        if (!event.isCanceled() && !worldIn.isRemote)
        {
            worldIn.setBlockToAir(pos);
            return true;
        }
        return false;
    }
}
