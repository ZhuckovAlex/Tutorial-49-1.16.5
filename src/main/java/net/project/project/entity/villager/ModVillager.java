package net.project.project.entity.villager;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.project.project.Project;
import net.project.project.block.ModBlocks;
import net.project.project.item.ModItems;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

public class ModVillager {
    public static final DeferredRegister<PointOfInterestType> POINT_OF_INTEREST_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Project.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Project.MOD_ID);

    public static final RegistryObject<PointOfInterestType> WITCHER_POI = POINT_OF_INTEREST_TYPES.register("witcher",
            ()->new PointOfInterestType("witcher",PointOfInterestType.getAllStates(Blocks.PUMPKIN),1,1));

    public static final RegistryObject<VillagerProfession> WITHER_PROF = VILLAGER_PROFESSIONS.register("witcher",
            ()->new VillagerProfession("witcher",WITCHER_POI.get(), ImmutableSet.of(),ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CLERIC));

    public static void registerPOI(){
        try{
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null,WITCHER_POI.get());
        }catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void fillTradeData(){
        VillagerTrades.ITrade[] level1 =
                new VillagerTrades.ITrade[]{new VillagerTrades.EmeraldForItemsTrade(Items.GLASS_BOTTLE,1,20,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.WATER_BUCKET,5,1,15,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.FLOWER_POT,5,1,15,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.GLASS,5,1,15,2)};

        VillagerTrades.ITrade[] level2 =
                new VillagerTrades.ITrade[]{new VillagerTrades.ItemsForEmeraldsTrade(Items.ACACIA_FENCE,5,1,15,3),
                new VillagerTrades.EmeraldForItemsTrade(Items.ANDESITE_STAIRS,1,20,2),
                new VillagerTrades.EmeraldForItemsTrade(ModItems.TEST_SWORD.get(),1,20,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.ARROW,5,1,15,3),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.BAMBOO,5,1,15,4),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.ANDESITE_WALL,5,1,15,4),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.NETHER_WART,5,1,15,4)};

        VillagerTrades.ITrade[] level3 = new VillagerTrades.ITrade[]{new VillagerTrades.ItemsForEmeraldsTrade(Items.EMERALD,10,1,10,6),
                new VillagerTrades.EmeraldForItemsTrade(Items.BEACON,1,20,2),
                new VillagerTrades.EmeraldForItemsTrade(Items.NETHER_WART,1,20,2),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.BOOKSHELF,10,1,10,6),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,5,1,15,5),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.NETHER_WART,5,1,15,5),
                new VillagerTrades.ItemsForEmeraldsTrade(ModBlocks.ALLIUM,15,1,15,10)};

        VillagerTrades.ITrade[] level4 = new VillagerTrades.ITrade[]{new VillagerTrades.ItemsForEmeraldsTrade(Blocks.ACACIA_LOG,4,1,24,8),
                new VillagerTrades.ItemsForEmeraldsTrade(Blocks.ACACIA_LOG,4,1,24,8),
                new VillagerTrades.ItemsForEmeraldsTrade(Blocks.ACACIA_LOG,4,1,24,8),
                new VillagerTrades.ItemsForEmeraldsTrade(Blocks.ACACIA_LOG,4,1,24,8),
                new VillagerTrades.ItemsForEmeraldsTrade(Blocks.ACACIA_LOG,4,1,24,8),
                new VillagerTrades.EmeraldForItemsTrade(Items.OAK_STAIRS,2,20,8),
                new VillagerTrades.EmeraldForItemsTrade(Items.OAK_STAIRS,2,20,8),
                new VillagerTrades.EmeraldForItemsTrade(Items.OAK_STAIRS,2,20,8),
                new VillagerTrades.EmeraldForItemsTrade(Items.OAK_STAIRS,2,20,8),
                new VillagerTrades.EmeraldForItemsTrade(Items.OAK_STAIRS,2,20,8)};

        VillagerTrades.ITrade[] level5 = new VillagerTrades.ITrade[]{new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,8,1,24,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,8,1,24,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,8,1,24,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,8,1,24,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,8,1,24,10),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,15,1,24,15),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,20,1,24,20),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,30,1,24,20),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,40,1,24,20),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,10,1,24,12),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,20,1,24,12),
                new VillagerTrades.ItemsForEmeraldsTrade(Items.OAK_STAIRS,30,1,24,12)};
        VillagerTrades.VILLAGER_DEFAULT_TRADES.put(WITHER_PROF.get(), gatAsIntMap(ImmutableMap.of(1,level1,2,level2,3,level3,4,level4,5,level5)));
    }
    private static Int2ObjectMap<VillagerTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> p_221238_0_) {
        return new Int2ObjectOpenHashMap<>(p_221238_0_);
    }
    public static class WitcherItem implements VillagerTrades.ITrade {

        private final List<Item> items;
        private final List<Integer> amountOfItems;
        private final List<Integer> amountOfEmeralds;
        private final int uses;
        private final int villagerExp;

        public WitcherItem(List<Item> items, List<Integer> amountOfItems, List<Integer> amountOfEmeralds, int uses, int villagerExp){
            this.items=items;
            this.amountOfItems=amountOfItems;
            this.amountOfEmeralds=amountOfEmeralds;
            this.uses=uses;
            this.villagerExp=villagerExp;

        }
        @Nullable
        @Override
        public MerchantOffer getOffer(@Nonnull Entity entity, Random random) {
            int choose = (int) (random.nextFloat() * items.size());
            return new MerchantOffer(new ItemStack(Items.EMERALD, amountOfEmeralds.get(choose)),new ItemStack(items.get(choose),amountOfItems.get(0)),this.uses,this.villagerExp,0.5f);
        }
    }
}
