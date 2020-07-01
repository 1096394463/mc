package com.qiuyue.ustc_zzzz.fmltutor.client;

import com.qiuyue.ustc_zzzz.fmltutor.block.BlockLoader;
import com.qiuyue.ustc_zzzz.fmltutor.item.ItemLoader;

/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/6/30
 * 物品方块统一注册管理
 */
public class ItemRenderLoader {
    public ItemRenderLoader()
    {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }
}
