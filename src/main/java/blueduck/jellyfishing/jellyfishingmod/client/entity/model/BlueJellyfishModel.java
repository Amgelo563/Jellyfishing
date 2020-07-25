package blueduck.jellyfishing.jellyfishingmod.client.entity.model;


import blueduck.jellyfishing.jellyfishingmod.entities.BlueJellyfishEntity;
import blueduck.jellyfishing.jellyfishingmod.entities.JellyfishEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Jellyfish - Coda1552
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class BlueJellyfishModel extends EntityModel<BlueJellyfishEntity> {
    public ModelRenderer body;
    public ModelRenderer tentacle1;
    public ModelRenderer tentacle2;
    public ModelRenderer tentacle3;
    public ModelRenderer tentacle4;

    public BlueJellyfishModel() {
        this.textureWidth = 24;
        this.textureHeight = 12;
        this.tentacle3 = new ModelRenderer(this, 0, 0);
        this.tentacle3.setRotationPoint(-1.5F, 3.0F, -1.5F);
        this.tentacle3.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tentacle2 = new ModelRenderer(this, 0, 0);
        this.tentacle2.setRotationPoint(-1.5F, 3.0F, 1.5F);
        this.tentacle2.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.tentacle4 = new ModelRenderer(this, 0, 0);
        this.tentacle4.setRotationPoint(1.5F, 3.0F, -1.5F);
        this.tentacle4.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tentacle1 = new ModelRenderer(this, 0, 0);
        this.tentacle1.setRotationPoint(1.5F, 3.0F, 1.5F);
        this.tentacle1.addBox(-1.0F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.body.addChild(this.tentacle3);
        this.body.addChild(this.tentacle2);
        this.body.addChild(this.tentacle4);
        this.body.addChild(this.tentacle1);
    }

    @Override
    public void setRotationAngles(BlueJellyfishEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if  (!entityIn.isInWater()) {
            body.rotateAngleX = (float) (30 + MathHelper.sin(limbSwing) * 0.5);
        }
        else {
            body.rotateAngleX = 0;
        }

    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}