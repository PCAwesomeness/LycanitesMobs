package com.lycanitesmobs.core.model.template;

import com.lycanitesmobs.core.entity.EntityCreatureBase;
import com.lycanitesmobs.core.model.ModelObj;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.MathHelper;

public class ModelTemplateInsect extends ModelObj {

    // ==================================================
    //                 Animate Part
    // ==================================================
    @Override
    public void animatePart(String partName, EntityLiving entity, float time, float distance, float loop, float lookY, float lookX, float scale) {
        super.animatePart(partName, entity, time, distance, loop, lookY, lookX, scale);
        float pi = (float)Math.PI;
        float posX = 0F;
        float posY = 0F;
        float posZ = 0F;
        float angleX = 0F;
        float angleY = 0F;
        float angleZ = 0F;
        float rotation = 0F;
        float rotX = 0F;
        float rotY = 0F;
        float rotZ = 0F;

        // Idle:
        if(partName.equals("mouthleft"))
            rotY += (float)-Math.toDegrees(MathHelper.cos(loop * 0.09F) * 0.1F - 0.05F);
        if(partName.equals("mouthright"))
            rotY -= (float)-Math.toDegrees(MathHelper.cos(loop * 0.09F) * 0.1F - 0.05F);
        if(partName.equals("tail")) {
            rotX = (float)-Math.toDegrees(MathHelper.cos(loop * 0.1F) * 0.05F - 0.05F);
            rotY = (float)-Math.toDegrees(MathHelper.cos(loop * 0.09F) * 0.05F - 0.05F);
        }
        if(partName.equals("wingleft")) {
            rotX = 20;
            rotX -= Math.toDegrees(MathHelper.sin(loop * 3.2F) * 0.6F);
            rotZ -= Math.toDegrees(MathHelper.sin(loop * 3.2F) * 0.6F);
        }
        if(partName.equals("wingright")) {
            rotX = 20;
            rotX -= Math.toDegrees(MathHelper.sin(loop * 3.2F) * 0.6F);
            rotZ -= Math.toDegrees(MathHelper.sin(loop * 3.2F + (float)Math.PI) * 0.6F);
        }

        // Walking:
        float walkSwing = 0.3F;
        if(partName.equals("legrightfront") || partName.equals("legleftmiddle") || partName.equals("legrightback")) {
            rotX += Math.toDegrees(MathHelper.cos(time * 0.3331F + (float)Math.PI) * walkSwing * distance);
            rotZ += Math.toDegrees(MathHelper.cos(time * 0.6662F + (float)Math.PI) * walkSwing * distance);
        }
        if(partName.equals("legleftfront") || partName.equals("legrightmiddle") || partName.equals("legleftback")) {
            rotX += Math.toDegrees(MathHelper.cos(time * 0.3331F) * walkSwing * distance);
            rotZ += Math.toDegrees(MathHelper.cos(time * 0.6662F) * walkSwing * distance);
        }

        // Flying:
        if(entity != null && !entity.onGround && !entity.isInWater()) {
            if(entity instanceof EntityCreatureBase) {
                EntityCreatureBase entityCreature = (EntityCreatureBase)entity;
                if(entityCreature.isFlying()) {
                    float bob = -MathHelper.sin(loop * 0.2F) * 0.3F;
                    if(bob < 0)
                        bob = -bob;
                    posY += bob;
                }
            }
        }

        // Attack:
        if(partName.equals("leftmouth"))
            rotY -= 15F * this.getAttackProgress();
        if(partName.equals("rightmouth"))
            rotY += 15F * this.getAttackProgress();
        if(partName.equals("tail"))
            rotX += 45 * this.getAttackProgress();

        // Apply Animations:
        this.angle(rotation, angleX, angleY, angleZ);
        this.rotate(rotX, rotY, rotZ);
        this.translate(posX, posY, posZ);
    }
}
