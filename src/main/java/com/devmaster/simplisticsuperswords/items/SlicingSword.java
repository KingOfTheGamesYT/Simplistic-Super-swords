package com.devmaster.simplisticsuperswords.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class SlicingSword extends SwordItem {
    private static IItemTier iItemTier = new IItemTier() {

        public int getMaxUses() {
            return (Integer) 500;
        }

        public float getEfficiency() {
            return (Integer) 6;
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

    public SlicingSword() {
        super(iItemTier, (Integer)10, -(float)2.4, (new Properties()).group(ItemGroup.COMBAT));
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
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantments.SWEEPING,2);
            //change the Enchantments.SILK_TOUCH to whatever you desire for both of statements
// Enchantments module by Alchemy
        }
    }
}
