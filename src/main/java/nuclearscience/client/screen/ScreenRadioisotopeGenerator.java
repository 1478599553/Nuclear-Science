package nuclearscience.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;

import electrodynamics.api.formatting.ElectricUnit;
import electrodynamics.api.utilities.ElectricityChatFormatter;
import electrodynamics.api.utilities.TransferPack;
import electrodynamics.client.screen.generic.GenericContainerScreen;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import nuclearscience.References;
import nuclearscience.api.radiation.IRadioactiveObject;
import nuclearscience.api.radiation.RadiationRegister;
import nuclearscience.common.inventory.container.ContainerRadioisotopeGenerator;
import nuclearscience.common.settings.Constants;

@OnlyIn(Dist.CLIENT)
public class ScreenRadioisotopeGenerator extends GenericContainerScreen<ContainerRadioisotopeGenerator> implements IHasContainer<ContainerRadioisotopeGenerator> {
	public static final ResourceLocation SCREEN_BACKGROUND = new ResourceLocation(References.ID + ":textures/gui/radioisotopegenerator.png");

	public ScreenRadioisotopeGenerator(ContainerRadioisotopeGenerator container, PlayerInventory playerInventory, ITextComponent title) {
		super(container, playerInventory, title);
	}

	@Override
	public ResourceLocation getScreenBackground() {
		return SCREEN_BACKGROUND;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(matrixStack, mouseX, mouseY);
		ItemStack in = container.getSlot(0).getStack();
		IRadioactiveObject rad = RadiationRegister.get(in.getItem());
		double currentOutput = in.getCount() * Constants.RADIOISOTOPEGENERATOR_OUTPUT_MULTIPLIER * rad.getRadiationStrength();
		TransferPack transfer = TransferPack.ampsVoltage(currentOutput / Constants.RADIOISOTOPEGENERATOR_VOLTAGE, Constants.RADIOISOTOPEGENERATOR_VOLTAGE);
		font.func_243248_b(matrixStack, new TranslationTextComponent("gui.radioisotopegenerator.current", ElectricityChatFormatter.getDisplayShort(transfer.getAmps(), ElectricUnit.AMPERE)),
				(float) playerInventoryTitleX + 60, (float) playerInventoryTitleY - 48, 4210752);
		font.func_243248_b(matrixStack, new TranslationTextComponent("gui.radioisotopegenerator.output", ElectricityChatFormatter.getDisplayShort(transfer.getWatts(), ElectricUnit.WATT)),
				(float) playerInventoryTitleX + 60, (float) playerInventoryTitleY - 35, 4210752);
		font.func_243248_b(matrixStack, new TranslationTextComponent("gui.radioisotopegenerator.voltage", ElectricityChatFormatter.getDisplayShort(transfer.getVoltage(), ElectricUnit.VOLTAGE)),
				(float) playerInventoryTitleX + 60, (float) playerInventoryTitleY - 22, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack stack, float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(stack, partialTicks, mouseX, mouseY);
		ItemStack in = container.getSlot(0).getStack();
		IRadioactiveObject rad = RadiationRegister.get(in.getItem());
		double currentOutput = in.getCount() * Constants.RADIOISOTOPEGENERATOR_OUTPUT_MULTIPLIER * rad.getRadiationStrength();
		if (currentOutput > 0) {
			blit(stack, guiLeft + 25, guiTop + 24, 212, -1, 14, 14);
		}
	}
}