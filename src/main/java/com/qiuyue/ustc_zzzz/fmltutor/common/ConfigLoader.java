package com.qiuyue.ustc_zzzz.fmltutor.common;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
/**
 * @author QiuYue
 * @version 1.0
 * @date 2020/7/1
 * 配置文件管理
 */
public class ConfigLoader {

    private static Configuration config;

    private static Logger logger;

    public static int diamondBurnTime;

    public ConfigLoader(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        //event.getSuggestedConfigurationFile()，就是Forge推荐的配置文件位置。
        // 这个位置在游戏根目录的config文件夹下，名为“<Mod id>.cfg”，这里就是“fmltutor.cfg”
        config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();
        load();
    }

    public static void load() {
        logger.info("Started loading config. ");
        String comment;
        //配置钻石燃烧时间
        comment = "How many seconds can a diamond burn in a furnace. ";
        diamondBurnTime = config.get(Configuration.CATEGORY_GENERAL, "diamondBurnTime", 640, comment).getInt();

        config.save();
        logger.info("Finished loading config. ");
    }

    public static Logger logger() {
        return logger;
    }
}
