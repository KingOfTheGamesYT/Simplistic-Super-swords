package com.devmaster.simplisticsuperswords.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class EmeraldSword extends SwordItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) 1058;
        }

        public float getEfficiency() {
            return (Integer) 10;
        }

        public float getAttackDamage() {
            return -1F;
        }

        public int getHarvestLevel() {
            return (Integer) 2;
        }

        public int getEnchantability() {
            return (Integer) 4;
        }

        public Ingredient getRepairMaterial() {
            return null;
        }
    };

    public EmeraldSword() {
        super(iItemTier, (Integer)14, -(float)2.4, (new Properties()).group(ItemGroup.COMBAT));
    }

    public void unlockDestroyACH(PlayerEntity entity, World world) {
        if (world instanceof ServerWorld) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
        }
    }


    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem((Integer)1, attacker, (playerEntity) -> {
            if (attacker instanceof PlayerEntity) {
                this.unlockDestroyACH((PlayerEntity)attacker, attacker.getEntityWorld());
            }

            playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }
}
