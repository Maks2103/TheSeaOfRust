package com.maks2103.seaofrust.tile;

import com.maks2103.seaofrust.fluid.ModFluids;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class TileEnergonRefinery extends TileEntity implements IFluidHandler {
    public static final List<ForgeDirection> inputDirections = Arrays.asList(ForgeDirection.UP);
    public static final List<ForgeDirection> outputDirections = Arrays.asList(ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.EAST);
    public static final List<ForgeDirection> wasteDirections = Arrays.asList(ForgeDirection.DOWN);
    public FluidTank inputTank = new FluidTank(ModFluids.ENERGON, 0, 16 * FluidContainerRegistry.BUCKET_VOLUME);
    public FluidTank outputTank = new FluidTank(ModFluids.REFINED_ENERGON, 0, 16 * FluidContainerRegistry.BUCKET_VOLUME);
    public FluidTank wasteTank = new FluidTank(ModFluids.ENERGON_REFINEMENT_WASTE, 0, 16 * FluidContainerRegistry.BUCKET_VOLUME);

    @Override
    public void updateEntity() {
        if (worldObj.isRemote) {
            return;
        }

        boolean active = false;
        if (inputTank.getFluidAmount() > 0 && inputTank.getFluidAmount() % 2 == 0) {
            FluidStack drained = inputTank.drain(FluidContainerRegistry.BUCKET_VOLUME, false);
            if (drained != null) {
                FluidStack output = new FluidStack(ModFluids.REFINED_ENERGON, drained.amount / 2);
                FluidStack waste = new FluidStack(ModFluids.ENERGON_REFINEMENT_WASTE, drained.amount / 2);
                if (outputTank.fill(output, false) == output.amount && wasteTank.fill(waste, false) == waste.amount) {
                    inputTank.drain(drained.amount, true);
                    outputTank.fill(output, true);
                    wasteTank.fill(waste, true);
                    active = true;
                }
            }
        }
        int oldMeta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        int newMeta = (active ? 4 : 0) + (oldMeta % 4);
        if (oldMeta != newMeta) {
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, newMeta, 2);
        }
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        if (inputDirections.contains(from)) {
            return (resource != null && resource.getFluid() == ModFluids.ENERGON) ? inputTank.fill(resource, doFill) : 0;
        }
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if (resource == null) {
            return null;
        }
        if (outputDirections.contains(from)) {
            return resource.getFluid() == ModFluids.REFINED_ENERGON ? outputTank.drain(resource.amount, doDrain) : null;
        }
        if (wasteDirections.contains(from)) {
            return resource.getFluid() == ModFluids.ENERGON_REFINEMENT_WASTE ? wasteTank.drain(resource.amount, doDrain) : null;
        }
        return null;
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        if (outputDirections.contains(from)) {
            return outputTank.drain(maxDrain, doDrain);
        }
        if (wasteDirections.contains(from)) {
            return wasteTank.drain(maxDrain, doDrain);
        }
        return null;
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        if (inputDirections.contains(from)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        if (outputDirections.contains(from)) {
            return true;
        }
        if (wasteDirections.contains(from)) {
            return true;
        }
        return false;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        if (inputDirections.contains(from)) {
            return new FluidTankInfo[]{inputTank.getInfo()};
        }
        if (outputDirections.contains(from)) {
            return new FluidTankInfo[]{outputTank.getInfo()};
        }
        if (wasteDirections.contains(from)) {
            return new FluidTankInfo[]{wasteTank.getInfo()};
        }
        return new FluidTankInfo[0];
    }
}
