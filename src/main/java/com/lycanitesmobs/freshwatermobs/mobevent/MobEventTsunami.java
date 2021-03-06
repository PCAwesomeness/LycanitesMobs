package com.lycanitesmobs.freshwatermobs.mobevent;

import com.lycanitesmobs.core.info.GroupInfo;
import com.lycanitesmobs.core.mobevent.MobEventBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class MobEventTsunami extends MobEventBase {


    // ==================================================
    //                     Constructor
    // ==================================================
	public MobEventTsunami(String name, GroupInfo group) {
		super(name, group);
	}


    // ==================================================
    //                       Start
    // ==================================================
    @Override
    public void onStart(World world) {
        super.onStart(world);
        if(canAffectWeather) {
            world.getWorldInfo().setRaining(true);
            world.getWorldInfo().setThundering(true);
        }
    }
	
	
    // ==================================================
    //                   Spawn Effects
    // ==================================================
    @Override
	public void onSpawn(EntityLiving entity) {
		super.onSpawn(entity);
	}
}
