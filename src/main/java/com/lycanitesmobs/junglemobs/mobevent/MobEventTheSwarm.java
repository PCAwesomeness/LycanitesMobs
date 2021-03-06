package com.lycanitesmobs.junglemobs.mobevent;

import com.lycanitesmobs.core.info.GroupInfo;
import com.lycanitesmobs.junglemobs.entity.EntityConba;
import com.lycanitesmobs.core.mobevent.MobEventBase;
import net.minecraft.entity.EntityLiving;

public class MobEventTheSwarm extends MobEventBase {

    // ==================================================
    //                     Constructor
    // ==================================================
	public MobEventTheSwarm(String name, GroupInfo group) {
		super(name, group);
	}
	
	
    // ==================================================
    //                   Spawn Effects
    // ==================================================
    @Override
	public void onSpawn(EntityLiving entity) {
		super.onSpawn(entity);
		if(entity instanceof EntityConba) {
			((EntityConba)entity).vespidInfection = true;
		}
	}
}
