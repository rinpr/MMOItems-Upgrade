package com.rin.itemupgrade.handler;

import com.rin.itemupgrade.misc.RefSimulator;
import io.lumine.mythic.lib.api.item.NBTItem;
import io.lumine.mythic.lib.api.util.ui.PlusMinusPercent;
import io.lumine.mythic.lib.api.util.ui.SilentNumbers;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.item.mmoitem.LiveMMOItem;
import net.Indyuce.mmoitems.api.item.mmoitem.VolatileMMOItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class itemhandler {
    protected ItemStack item;
    //public void NBTItem(ItemStack item) {this.item = item; }
    public static VolatileMMOItem VolatileFromNBT(@NotNull NBTItem items) {
        return new VolatileMMOItem(items);
    }
    public static @NotNull LiveMMOItem LiveFromNBT(@NotNull NBTItem items) {
        return new LiveMMOItem(items);
    }

    public ItemStack getItem() {
        return this.item;
    }
    public static boolean IsMMO(ItemStack item) {
        return NBTItem.get(item).hasType();
    }
    public static @Nullable ItemStack GetMMOItem(@Nullable String Type, @Nullable String ID) {
        return MMOItems.plugin.getItem(Type, ID); // from MMOItems.class line 479
    }
//    public static ItemStack UpgradeMMOItem(@NotNull ItemStack item){
//        NBTItem var0 = NBTItem.get(item);
//        VolatileMMOItem var1 = VolatileFromNBT(var0);
//        LiveMMOItem var2 = LiveFromNBT(var0);
//        if (var1.hasUpgradeTemplate()) { // check if item has upgrade template of not
////            int var3 = var2.getUpgradeLevel();
//            var2.getUpgradeTemplate().upgrade(var2);
//        }
//        return var2.newBuilder().build();
//    }
public static @Nullable ItemStack UpgradeMMOItem(@Nullable ItemStack var0, @Nullable PlusMinusPercent var1, boolean var2, @Nullable RefSimulator<Integer> var3, @Nullable RefSimulator<String> var4) {
    if (Objects.requireNonNull(var0).getType() != Material.AIR) {
        Bukkit.getConsoleSender().sendMessage("Cant upgrade air! ");
        return null;
    } else {
        NBTItem var5 = NBTItem.get(var0);
        if (!var5.hasType()) {
            Bukkit.getConsoleSender().sendMessage("Only MMOItems can be upgraded. ");
            return null;
        } else {
            VolatileMMOItem var6 = VolatileFromNBT(var5);
            if (!var6.hasUpgradeTemplate()) {
                Bukkit.getConsoleSender().sendMessage("This MMOItem has no Upgrade Template (§cItem not upgradable§7). ");
                return null;
            } else {
                LiveMMOItem var7 = LiveFromNBT(var5);
                int var8 = var7.getUpgradeLevel();
                if (var1 == null) {
                    if (var3 != null) {
                        var3.setValue(var8);
                    }

                    return var0;
                } else {
                    int var9 = SilentNumbers.floor(var1.apply(var8));
                    boolean var10 = false;
                    if (!var2 && var9 > var7.getMaxUpgradeLevel() && var7.getMaxUpgradeLevel() > 0) {
                        var9 = var7.getMaxUpgradeLevel();
                        var10 = true;
                    }

                    var7.getUpgradeTemplate().upgradeTo(var7, var9);
                    if (var3 != null) {
                        var3.setValue(var9);
                    }

                    if (var10) {
                        Bukkit.getConsoleSender().sendMessage("Upgraded " + Objects.requireNonNull(Objects.requireNonNull(var0).getItemMeta()).getDisplayName() + "§7 to maximum level §b" + var9 + "§7. ");
                    } else {
                        Bukkit.getConsoleSender().sendMessage("Upgraded " + Objects.requireNonNull(Objects.requireNonNull(var0).getItemMeta()).getDisplayName() + "§7 to level §b" + var9 + "§7. ");
                    }

                    return var7.newBuilder().build();
                }
            }
        }
    }
}
}
