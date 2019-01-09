package com.androsa.nifty.compat;

import com.androsa.nifty.blocks.NiftyTrapDoor;
import com.androsa.nifty.util.BlockModelHelper;
import com.androsa.nifty.util.ModelUtil;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NiftyTFTrapDoor extends NiftyTrapDoor implements BlockModelHelper {

    public NiftyTFTrapDoor(Material material, MapColor color, SoundType sound, float hardness) {
        super(material, color, sound, hardness, 10.0F);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        if(Loader.isModLoaded("twilightforest")) {
            list.add(new ItemStack(this, 1, 0));
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModel() {
        ModelUtil.registerToState(this, 0, getDefaultState().withProperty(FACING, EnumFacing.NORTH));
    }
}